package org.col.tasks.importer;

import com.google.common.collect.ImmutableMultimap;
import io.dropwizard.servlets.tasks.Task;
import org.col.config.ImporterConfig;
import org.col.db.mapper.DatasetMetricsMapper;
import org.col.tasks.TaskParams;

import java.io.PrintWriter;

public class ImporterTask extends Task {

  private ImporterConfig cfg;
  private DatasetMetricsMapper datasetMetricsMapper;

  public ImporterTask() {
    super("importer");
  }

  @Override
  public void execute(ImmutableMultimap<String, String> params, PrintWriter out) throws Exception {
    final int datasetKey = TaskParams.getKey(params);

    out.format("Normalizing %s!\n", datasetKey);
    //Normalizer normalizer = Normalizer.create(cfg, datasetKey, lookup);
    //normalizer.run();

    out.format("Importing %s into Postgres!\n", datasetKey);
    //Importer importer = Importer.create(cfg, datasetKey, nameUsageService, usageService, sqlService);
    //importer.run();

    out.format("Analyzing %s!\n", datasetKey);
    Analyser analyser = Analyser.create(datasetKey, datasetMetricsMapper);
    analyser.run();

    out.format("Import %s completed!\n", datasetKey);
  }
}
