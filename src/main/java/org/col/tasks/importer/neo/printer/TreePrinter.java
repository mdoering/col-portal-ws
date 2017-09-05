package org.col.tasks.importer.neo.printer;

import org.col.tasks.importer.neo.traverse.StartEndHandler;

/**
 *
 */
public interface TreePrinter extends StartEndHandler, AutoCloseable {

  /**
   * We prefer no exceptions in close()
   */
  @Override
  void close();

}
