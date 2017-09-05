package org.col.tasks.importer.neo.model;

import org.col.api.vocab.Rank;
import org.neo4j.graphdb.Node;

public class RankedName {
  public String name;
  public Rank rank;
  public Node node;

  public RankedName() {
  }

  public RankedName(String name, Rank rank) {
    this.name = name;
    this.rank = rank;
  }

  public int getId() {
    return (int) node.getId();
  }

  @Override
  public String toString() {
    return name + '[' + rank + ']';
  }
}
