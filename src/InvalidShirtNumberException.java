import java.io.Serializable;

public class InvalidShirtNumberException extends RuntimeException implements
    Serializable
{
  public InvalidShirtNumberException()
  {
    super("Invalid Shirt Number");
  }
  public InvalidShirtNumberException(String message)
  {
    super("Invalid shirt number"+message);
  }
}