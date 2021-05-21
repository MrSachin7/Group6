import java.io.Serializable;

public class IllegalShirtNumberException extends RuntimeException implements
    Serializable
{
  public IllegalShirtNumberException()
  {
    super("The shirt number is already occupied");
  }
}
