package org.col.tasks.old.neo;

import org.gbif.checklistbank.cli.model.NameUsageNode;
import org.gbif.checklistbank.cli.model.RankedName;
import org.gbif.checklistbank.logging.LogContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 *
 */
public class ImportDb {

  private static final Logger LOG = LoggerFactory.getLogger(ImportDb.class);

  protected final int datasetKey;
  protected final UsageDao dao;

  public ImportDb(int datasetKey, UsageDao dao) {
    this.datasetKey = datasetKey;
    this.dao = dao;
    LogContext.startDataset(datasetKey);
  }


  public UUID getDatasetKey() {
    return datasetKey;
  }
}
