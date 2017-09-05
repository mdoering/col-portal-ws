package org.col.tasks.importer.neo.printer;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Throwables;
import com.google.common.collect.Sets;
import org.col.tasks.importer.neo.model.Labels;
import org.col.tasks.importer.neo.model.NeoProperties;
import org.col.tasks.importer.neo.model.RelType;
import org.gbif.api.vocabulary.Rank;
import org.gbif.api.vocabulary.TaxonomicStatus;
import org.gbif.io.TabWriter;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

import java.io.IOException;
import java.io.Writer;
import java.util.Set;

/**
 * Dumps a neo db in a simple tab delimited format used by the nub integration tests.
 * Expects no pro parte relations in the walker!
 */
public class TabPrinter implements TreePrinter {
  private final Function<Node, String> getTitle;
  private final TabWriter writer;
  private static final Joiner ID_CONCAT = Joiner.on(";").skipNulls();

  public TabPrinter(Writer writer, Function<Node, String> getTitle) {
    this.writer = new TabWriter(writer);
    this.getTitle = getTitle;
  }

  @Override
  public void close() {
  }

  @Override
  public void start(Node n) {
    try {
      String[] row = new String[7];
      row[0] = String.valueOf(n.getId());
      if (n.hasLabel(Labels.SYNONYM)) {
        // we can have multiple accepted parents for pro parte synonyms
        Set<Long> parentKeys = Sets.newHashSet();
        for (Relationship synRel : n.getRelationships(RelType.SYNONYM_OF, Direction.OUTGOING)) {
          parentKeys.add(synRel.getOtherNode(n).getId());
        }
        for (Relationship synRel : n.getRelationships(RelType.PROPARTE_SYNONYM_OF, Direction.OUTGOING)) {
          parentKeys.add(synRel.getOtherNode(n).getId());
        }
        row[1] = ID_CONCAT.join(parentKeys);
      } else {
        if (n.hasRelationship(RelType.PARENT_OF, Direction.INCOMING)) {
          row[1] = String.valueOf(n.getSingleRelationship(RelType.PARENT_OF, Direction.INCOMING).getOtherNode(n).getId());
        }
      }
      if (n.hasRelationship(RelType.BASIONYM_OF, Direction.INCOMING)) {
        row[2] = String.valueOf(n.getSingleRelationship(RelType.BASIONYM_OF, Direction.INCOMING).getOtherNode(n).getId());
      }
      if (n.hasProperty(NeoProperties.RANK)) {
        row[3] = Rank.values()[(Integer) n.getProperty(NeoProperties.RANK)].name();
      }
      row[4] = n.hasLabel(Labels.SYNONYM) ? TaxonomicStatus.SYNONYM.name() : TaxonomicStatus.ACCEPTED.name();
      row[6] = getTitle.apply(n);
      writer.write(row);
    } catch (IOException e) {
      Throwables.propagate(e);
    }
  }

  @Override
  public void end(Node n) {

  }
}
