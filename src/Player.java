import java.io.Serializable;

public class Player implements Serializable
{
  private String firstName;
  private String lastName;
  private Date birthDate;
  private Injury injury;
  private Suspension suspension;
  private String position;
  private String nationality;
  private int shirtNumber;
  private boolean isAvailable;

  public Player(String firstName, String lastName, Date birthDate, String position,
      String nationality)
  {

    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate.copy();
    this.position = position;
    this.nationality = nationality;
    injury = null;
    suspension = null;
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
    this.birthDate = birthDate.copy();
  }

  public void setShirtNumber(int shirtNumber)
  {
    this.shirtNumber = shirtNumber;
  }

  public void setPosition(String position)
  {
    this.position = position;
  }

  public void setNationality(String nationality)
  {
    this.nationality = nationality;
  }

  public void setInjury(Injury injury)
  {
    this.injury = injury.copy();
  }

  public void setSuspension(Suspension suspension)
  {
    this.suspension = suspension.copy();
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
    return birthDate.copy();
  }

  public Injury getInjury()
  {
    return injury.copy();
  }

  public String getPosition()
  {
    return position;
  }

  public String getNationality()
  {
    return nationality;
  }

  public Suspension getSuspension()
  {
    return suspension.copy();
  }

  public void removeInjury()
  {
    injury = null;
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
      return temp.nationality.equals(nationality) && temp.firstName.equals(firstName) && temp.lastName.equals(lastName)
          && temp.birthDate.equals(birthDate) && temp.position.equals(position);
    }
  }

  public Player copy()
  {
    return new Player(firstName, lastName, birthDate, position, nationality);
  }

  public String toString()
  {
    return "Name :" + firstName + " " + lastName;
  }
}
