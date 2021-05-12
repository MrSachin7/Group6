public class IllegalFormationException extends RuntimeException
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
