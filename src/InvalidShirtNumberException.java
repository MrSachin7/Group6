public class InvalidShirtNumberException extends RuntimeException
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