package org.col.tasks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMultimap;

/**
 * Parameter key enumeration used for all tasks.
 */
public class TaskParams {
  private final static ObjectMapper MAPPER = new ObjectMapper();

  public static int getKey(ImmutableMultimap<String, String> params) {
    return Integer.parseInt(singleValue(params, "key"));
  }

  /**
   * @return the single parameter value
   * @throws IllegalArgumentException if none or more than one key exists
   */
  public static String singleValue(ImmutableMultimap<String, String> params, String parameter) {
    try {
      return params.get(parameter).iterator().next();
    } catch (Exception e) {
      throw new IllegalArgumentException(e.getMessage());
    }
  }

  public static <T> T toConfig(Class<T> configClazz, ImmutableMultimap<String, String> params) {
    return MAPPER.convertValue(params, configClazz);
  }
}
