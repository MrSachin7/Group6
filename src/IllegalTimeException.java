public class IllegalTimeException extends RuntimeException
{
  public IllegalTimeException()
  {
    super("Please enter time between 0-24");
  }
}
