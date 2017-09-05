package org.col.tasks.neoshell;

import com.google.common.collect.ImmutableMultimap;
import io.dropwizard.servlets.tasks.Task;
import org.col.tasks.TaskParams;

import java.io.PrintWriter;

/**
 * Basic task to showcase hello world
 */
public class ShellTask extends Task {
  private static final int PORT = 1337;

        public ShellTask() {
            super("shell");
        }

        @Override
        public void execute(ImmutableMultimap<String, String> parameters, PrintWriter output) throws Exception {
          final int key =TaskParams.getKey(parameters);
          output.format("Opening neo4j shell on port %s to dataset %s.\n" +
              "Open another dataset or post with key=null to close the shell.\n",
              PORT, key);

        }
}
