package org.col.tasks.importer.neo.traverse;

import com.google.common.collect.Lists;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.ResourceIterable;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.traversal.TraversalDescription;

import java.util.List;

/**
 * Path iterator that traverses multiple start nodes in a given traversal description.
 */
public class MultiRootNodeIterator extends MultiRooIterator<Node> {

  private final TraversalDescription td;

  private MultiRootNodeIterator(List<Node> roots, TraversalDescription td) {
    super(roots);
    this.td = td;
    prefetch();
  }

  public static ResourceIterable<Node> create(final Node root, final TraversalDescription td) {
    return create(Lists.newArrayList(root), td);
  }

  public static ResourceIterable<Node> create(final List<Node> roots, final TraversalDescription td) {
    return new ResourceIterable<Node>() {
      @Override
      public ResourceIterator<Node> iterator() {
        return new MultiRootNodeIterator(roots, td);
      }
    };
  }

  @Override
  ResourceIterator<Node> iterateRoot(Node root) {
    return td.traverse(root).nodes().iterator();
  }

}
