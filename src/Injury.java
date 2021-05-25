import java.io.Serializable;

/**
 * @author Cristian-Marian Radu
 */
public class Injury implements Serializable
{
  private Date injuryDate;
  private Date expectedReturnDate;

  /**
   * A constructor that initializes/ creates an Injury object
   * @param injuryDate the date when injury happened
   * @param expectedReturnDate the expected return date
   */
  public Injury(Date injuryDate, Date expectedReturnDate)
  {
    if (expectedReturnDate.isBefore(injuryDate))
    {
      throw new IllegalDateException(
          " because return date cannot be before injured date");
    }
    else if (Date.today().isBefore(injuryDate))
    {
      throw new IllegalDateException(" because injury date cannot be a date from future.");
    }
    else
    {
      this.injuryDate = injuryDate;
      this.expectedReturnDate = expectedReturnDate;
    }
  }

  /**
   * A constructor that creates an Injury object without return date
   * @param injuryDate the date when the injury happened
   */
  public Injury(Date injuryDate)
  {
    this.injuryDate = injuryDate;
    expectedReturnDate = null;
  }

  /**
   * Gets the injury date
   * @return Date object storing the date of injury
   */
  public Date getInjuryDate()
  {
    return injuryDate;
  }

  /**
   * Gets expected return date
   * @return Date object storing expected return date
   */
  public Date getExpectedReturnDate()
  {
    return expectedReturnDate;
  }
  /**
   * Compares a provided object to a Player object
   * @param obj an object to be compared with the Player object
   * @return return true if the given object is Player object that has all the attributes equal to the Player , else returns false
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Injury))
    {
      return false;
    }
    else
    {
      Injury temp = (Injury) obj;
      if (expectedReturnDate == null && temp.expectedReturnDate == null)
      {
        return temp.injuryDate.equals(injuryDate);
      }
      else
      {
        return temp.injuryDate.equals(injuryDate) && temp.expectedReturnDate.equals(expectedReturnDate);
      }
    }
  }/**
 * A method for returning the information of the Injury object in String.
 * @return all the important attributes in readable String format
 */
 public String toString()
 {
   return "InjuryDate :"+injuryDate+"\n Expected Return Date :"+expectedReturnDate;
  }
}
