public class Injury
{
  private Date injuryDate;
  private Date expectedReturnDate;
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

  public Injury(Date injuryDate)
  {
    this.injuryDate = injuryDate;
    expectedReturnDate = null;
  }


  public void setInjuryDate(Date injuryDate)
  {
    this.injuryDate = injuryDate;
  }

  public Date getInjuryDate()
  {
    return injuryDate;
  }

  public void setExpectedReturnDate(Date expectedReturnDate)
  {
    this.expectedReturnDate = expectedReturnDate;
  }

  public Date getExpectedReturnDate()
  {
    return expectedReturnDate;
  }

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
  }

  public Injury copy()
  {
    if (expectedReturnDate == null)
    {
      return new Injury(injuryDate);
    }
    else
    {
      return new Injury(injuryDate, expectedReturnDate);
    }
  }

 public String toString()
 {
   return "InjuryDate :"+injuryDate+"\n Expected Return Date :"+expectedReturnDate;
  }
}
