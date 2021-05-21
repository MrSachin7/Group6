import java.io.Serializable;

public class IllegalTimeException extends RuntimeException implements
    Serializable
{
  public IllegalTimeException()
  {
    super("Please enter time between 0-24");
  }
}
