public class Player
{
  private String name;
  private Date birthDate;
  private Injury injury;
  private Suspension suspension;
  private String position;
  private String nationality;
  private int shirtNumber;

  public Player(String name, Date birthDate, String position,
      String nationality)
  {
    this.name = name;
    this.birthDate = birthDate.copy();
    this.position = position;
    this.nationality = nationality;
    injury = null;
    suspension = null;
  }

  public void setName(String name)
  {
    this.name = name;
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

  public String getName()
  {
    return name;
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

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Player))
    {
      return false;
    }
    else
    {
      Player temp = (Player) obj;
      return temp.nationality.equals(nationality) && temp.name.equals(name)
          && temp.birthDate.equals(birthDate) && temp.position.equals(position);
    }
  }

  public Player copy()
  {
    return new Player(name, birthDate, position, nationality);
  }

  public String toString()
  {
    return "Name :" + name + "Date of Birth : " + birthDate + "\n Nationality :"
        + nationality + "\n Position" + position;
  }
}
