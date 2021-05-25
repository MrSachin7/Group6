import java.io.Serializable;

/**
 * @author Emil Vassilev
 * @version 1.0
 */
public class Suspension implements Serializable
{
  private int numberOfGamesSuspended;

  /**
   * A construtcor that creates a Suspension
   * @param numberOfGamesSuspended the number of games suspended
   */
  public Suspension(int numberOfGamesSuspended)
  {
    this.numberOfGamesSuspended=numberOfGamesSuspended;

  }

  /**
   * A No-argument constructor that initializes the Suspension object without no of games suspended.
   */
  public Suspension()
  {
    numberOfGamesSuspended=0;
  }

  /**
   * Gets the number of games suspended.
   * @return the number of games suspended
   */
  public int getNumberOfGamesSuspended()
  {
    return numberOfGamesSuspended;
  }

  /**
   * Compares given object with the Match
   * @param obj the object to compare with the match
   * @return boolean (true if the given object is a Suspension object with all equal attributes), else false
   */
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

  /**
   * A method for returning the information of Object in String
   * @return the attributes in String
   */
  public String toString()
  {
    return "Number Of Game Suspended :"+numberOfGamesSuspended;
  }
}
