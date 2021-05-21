import java.io.Serializable;

public class IllegalDateException extends RuntimeException implements
    Serializable
{
  public IllegalDateException()
  {
    super("Invalid date");
  }
  public  IllegalDateException(String message)
  {
    super("InvLid date"+message);
  }
}