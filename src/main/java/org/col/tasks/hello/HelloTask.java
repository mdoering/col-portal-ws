package org.col.tasks.hello;

import com.google.common.collect.ImmutableMultimap;
import io.dropwizard.servlets.tasks.Task;

import java.io.PrintWriter;

/**
 * Basic task to showcase hello world
 */
public class HelloTask extends Task {
  private static final String NAME_PARAM = "name";

  public HelloTask() {
    super("hello");
  }

  @Override
  public void execute(ImmutableMultimap<String, String> parameters, PrintWriter output) throws Exception {
    output.format("Hello %s!\n", parameters.containsKey(NAME_PARAM) ? parameters.get(NAME_PARAM) : "stranger");
  }
}
