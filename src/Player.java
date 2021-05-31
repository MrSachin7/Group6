import java.io.Serializable;


/**
 * A class that creates and manages Player Object
 * @author Himal Sharma
 * @version 1.0
 */

public class Player implements Serializable
{
  private String firstName;
  private String lastName;
  private Date birthDate;
  private Injury injury;
  private Suspension suspension;
  private String position;
  private String startingOrNot;
  private int shirtNumber;

  /**
   * A constructor that creates a Player object.
   * @param firstName fist name of a player that is being created
   * @param lastName last name of a player that is being created
   * @param birthDate A Date object that is the birthdate of a player that is being created
   * @param position position of a player that is being created
   */
  public Player(String firstName, String lastName, Date birthDate, String position)
  {

    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.position = position;
    injury = null;
    suspension = null;
    startingOrNot="Not set";
  }
  /**
   * Sets/changes the shirtNumber of a Player object.
   * @param shirtNumber the shirtnumber to change or add
   */
  public void setShirtNumber(int shirtNumber)
  {
    this.shirtNumber = shirtNumber;
  }
  /**
   * Sets/changes the position of a Player object.
   * @param position the position to change or add
   */
  public void setPosition(String position)
  {
    this.position = position;
  }
  /**
   * Sets the status of a player in active squad.
   * @param startingOrNot the status of player in active squad
   */
  public void setStartingOrNot(String startingOrNot)
  {
    this.startingOrNot = startingOrNot;
  }
  /**
   * Adds/changes Injury object to Player object
   * @param injury Injury object to add on the Player object
   */
  public void setInjury(Injury injury)
  {
    this.injury = injury;
  }
  /**
   * Adds/changes Suspension object to Player object
   * @param suspension Suspension object to add on the Player object
   */
  public void setSuspension(Suspension suspension)
  {
    this.suspension = suspension;
  }

  /**
   * Gets either a player's status in active squad at a moment.
   * @return the status of player in active squad
   */
  public String getStartingOrNot()
  {
    return startingOrNot;
  }


  /**
   * Gets the first name from a Player Object.
   * @return the first name of a Player.
   */
  public String getFirstName()
  {
    return firstName;
  }

  /**
   * Gets the last name from a Player object.
   * @return the last name of a Player
   */
  public String getLastName()
  {
    return lastName;
  }
  /**
   * Gets the shirt number from a Player object.
   * @return the shirt number of a Player
   */
  public int getShirtNumber()
  {
    return shirtNumber;
  }
  /**
   * Gets the Date object storing the birth date from a Player object.
   * @return  Date object storing birth date of a Player
   */
  public Date getBirthDate()
  {
    return birthDate;
  }

  public Injury getInjury()
  {
    return injury;
  }

  public String getPosition()
  {
    return position;
  }
  public Suspension getSuspension()
  {
    return suspension;
  }

  public void removeInjury()
  {
    injury = null;
  }
  public void removeSuspension()
  {
    suspension=null;
  }

  /**
   * Compares a provided object to a Player object
   * @param obj an object to be compared with the Player object
   * @return return true if the given object is Player object that has all the attributes equal to the Player , else returns false
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Player))
    {
      return false;
    }
    else
    {
      Player temp = (Player) obj;
      return  temp.firstName.equals(firstName) && temp.lastName.equals(lastName)
          && temp.birthDate.equals(birthDate) && temp.position.equals(position);
    }
  }

  /**
   * Gets first and last name of a Player object in String.
   * @return  first and last name of a Player object in String
   */

  public String toString()
  {
    return firstName + " " + lastName;
  }
}
