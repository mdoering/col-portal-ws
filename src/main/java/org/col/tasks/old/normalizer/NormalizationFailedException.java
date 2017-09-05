package org.col.tasks.old.normalizer;

/**
 *
 */
public class NormalizationFailedException extends RuntimeException {

  public NormalizationFailedException(String message) {
    super(message);
  }

  public NormalizationFailedException(String message, Throwable cause) {
    super(message, cause);
  }
}
