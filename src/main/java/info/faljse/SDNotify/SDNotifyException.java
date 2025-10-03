package info.faljse.SDNotify;

public class SDNotifyException extends Exception {

  public SDNotifyException(String errorMessage) {
    super(errorMessage);
  }

  public SDNotifyException(String errorMessage, Throwable error) {
    super(errorMessage, error);
  }
}
