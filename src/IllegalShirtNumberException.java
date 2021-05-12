public class IllegalShirtNumberException extends RuntimeException
{
  public IllegalShirtNumberException()
  {
    super("The shirt number is already occupied");
  }
}
