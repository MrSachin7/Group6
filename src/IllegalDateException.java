public class IllegalDateException extends RuntimeException
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