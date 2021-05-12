public class Suspension
{
  private int numberOfGamesSuspended;
  private int numberOfYellowCards;
  private int numberOfRedCards;
  public Suspension(int numberOfGamesSuspended, int numberOfYellowCards,int numberOfRedCards)
  {
    this.numberOfRedCards=numberOfRedCards;
    this.numberOfYellowCards=numberOfYellowCards;
    this.numberOfGamesSuspended=numberOfGamesSuspended;
  }

  public Suspension(int numberOfGamesSuspended)
  {
    this.numberOfGamesSuspended=numberOfGamesSuspended;
    numberOfRedCards=0;
    numberOfYellowCards=0;
  }
  public Suspension()
  {
    numberOfYellowCards=0;
    numberOfRedCards=0;
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
  public void addYellowCard()
  {
    numberOfYellowCards++;
  }
  public void addYellowCards(int numberOfYellowCards)
  {
    for (int i =0; i<numberOfYellowCards; i++)
    {
      addYellowCard();
    }
  }
  public void addRedCard()
  {
    numberOfRedCards++;
  }

  public int getNumberOfYellowCards()
  {
    return numberOfYellowCards;
  }

  public int getNumberOfRedCards()
  {
    return numberOfRedCards;
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
      return temp.numberOfGamesSuspended==getNumberOfGamesSuspended() && temp.numberOfYellowCards==numberOfYellowCards && temp.numberOfRedCards==numberOfRedCards;
    }
  }
  public String toString()
  {
    return "Number Of Game Suspended :"+numberOfGamesSuspended+"\n Number of Yellow Card"+numberOfYellowCards+"          Number of Red Cards :"+numberOfRedCards;
  }
}
