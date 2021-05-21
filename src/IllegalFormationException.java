import java.io.Serializable;

public class IllegalFormationException extends RuntimeException implements
    Serializable
{
  public IllegalFormationException()
  {
    super("Illegal Formation");
  }
  public  IllegalFormationException(String message)
  {
    super("Illegal Formation"+message);
  }
}
