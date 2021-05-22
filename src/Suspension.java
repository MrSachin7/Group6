import java.io.Serializable;

public class Suspension implements Serializable
{
  private int numberOfGamesSuspended;
  public Suspension(int numberOfGamesSuspended)
  {
    this.numberOfGamesSuspended=numberOfGamesSuspended;

  }
  public Suspension()
  {
    numberOfGamesSuspended=0;
  }
  public void setNumberOfGamesSuspended(int numberOfGamesSuspended)
  {
    this.numberOfGamesSuspended=numberOfGamesSuspended;
  }

  public int getNumberOfGamesSuspended()
  {
    return numberOfGamesSuspended;
  }


  public Suspension copy()
  {
    return new Suspension(numberOfGamesSuspended);
  }
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Suspension))
    {
      return false;
    }
    else
    {
      Suspension temp = (Suspension)obj;
      return temp.numberOfGamesSuspended==getNumberOfGamesSuspended();
    }
  }
  public String toString()
  {
    return "Number Of Game Suspended :"+numberOfGamesSuspended;
  }
}
