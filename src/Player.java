import java.io.Serializable;

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

  public String getStartingOrNot()
  {
    return startingOrNot;
  }

  public void setStartingOrNot(String startingOrNot)
  {
    this.startingOrNot = startingOrNot;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public void setBirthDate(Date birthDate)
  {
    this.birthDate = birthDate;
  }

  public void setShirtNumber(int shirtNumber)
  {
    this.shirtNumber = shirtNumber;
  }

  public void setPosition(String position)
  {
    this.position = position;
  }



  public void setInjury(Injury injury)
  {
    this.injury = injury;
  }

  public void setSuspension(Suspension suspension)
  {
    this.suspension = suspension;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public int getShirtNumber()
  {
    return shirtNumber;
  }

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

  public boolean isAvailable(Player player)
  {
    if (player.getInjury() == null
        || player.getSuspension().getNumberOfGamesSuspended() >= 1)
    {
      return false;
    }
    else
      return true;
  }

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

  public Player copy()
  {
    return new Player(firstName, lastName, birthDate, position);
  }

  public String toString()
  {
    return firstName + " " + lastName;
  }
}
