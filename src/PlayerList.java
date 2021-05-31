import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * A class containing a list of Player objects.
 * @author Sachin Baral
 * @verrsion 1.0
 */
public class PlayerList implements Serializable
{
  private ArrayList<Player> playerList;

  /**
   * No-argument constructor initializing the PlayerList.
   */
  public PlayerList()
  {
    playerList = new ArrayList<Player>();
  }

  /**
   * Calculates the size of size.
   * @return the size of the List.
   */
  public int size()
  {
    return playerList.size();
  }
  /**
   * Adds a Player to the List.
   * @param player the player to add to the List.
   */
  public  void add(Player player)
  {
    playerList.add(player);
  }

  /**
   * Gets a player object from position index from the list.
   * @param index the position in the list of the Player object
   * @return the Player at index if one exists , else null
   */
  public Player get(int index)
  {
   if (index<playerList.size())
   {
     return playerList.get(index);
   }
   else
   {
     return null;
   }
  }

  /**
   * Removes a Player object equal to given Player object if one exists.
   * @param player the Player in the list to remove
   */

  public void removePlayer(Player player)
  {
    ArrayList<Player> temp = new ArrayList<>();
    for (int i=0; i<playerList.size();i++)
    {
      if (!playerList.get(i).equals(player))
      {
        temp.add(playerList.get(i));
      }

    }
    playerList= temp;
  }

  /**
   * Gets Shirt Numbers of all Player object in the list as a String.
   * @return all the Shirt numbers of all Player object in the list
   */
  public String getShirtNumbers()
  {
    String temp = "";
    for (int i = 0; i < playerList.size(); i++)
    {
      temp += playerList.get(i).getShirtNumber()+"\n";
    }
    return temp;


  }
  /**
   * Gets Positions of all Player object in the list as a String.
   * @return all the Positions of all Player object in the list
   */
  public String getAllPositions()
  {
    String temp = "";
    for (int i = 0; i < playerList.size(); i++)
    {
      temp += playerList.get(i).getPosition()+"\n";
    }
    return temp;
  }
  /**
   * Gets Injury date of all Player object in the list as a String.
   * @return all the Injury Date of all Player object in the list
   */

  public String getInjuredDate()
  {
    String temp = "";
    for (int i = 0; i < playerList.size(); i++)
    {
      temp += playerList.get(i).getInjury().getInjuryDate()+"\n";
    }
    return temp;
  }
  /**
   * Gets Expected return Date of all Player object in the list as a String.
   * @return all the expected return date of all Player object in the list
   */
  public String getExpectedReturnDate()
  {
    String temp = "";
    for (int i = 0; i < playerList.size(); i++)
    {
      temp += playerList.get(i).getInjury().getExpectedReturnDate()+"\n";
    }
    return temp;
  }
  /**
   * Gets no of games suspended of all Player object in the list as a String.
   * @return no of games suspended of all Player object in the list
   */
  public String getNoOfGamesSuspended()
  {
    String temp = "";
    for (int i = 0; i < playerList.size(); i++)
    {
      temp += playerList.get(i).getSuspension().getNumberOfGamesSuspended()+"\n";
    }
    return temp;
  }
  /**
   * Gets Birth Date of all Player object in the list as a String.
   * @return Birth Date of all Player object in the list
   */
  public String getBirthDate()
  {
    String temp = "";
    for (int i = 0; i < playerList.size(); i++)
    {
      temp += playerList.get(i).getBirthDate()+"\n";
    }
    return temp;
  }
  public ArrayList<Player> getAllPlayers()
  {
    return playerList;
  }

  /**
   * Arranges players by alphabetical order
   */
  public void sortPlayers()
  {
      Collections.sort(playerList,new Comparator<Player>()
      {
        public int compare(Player p1,Player p2)
        {
          return p1.getFirstName().compareTo(p2.getFirstName());
        }
      });
    }


  /**
   * Gets all the Player object as a String.
   * @return all the Player object as a String
   */
  public String toString()
  {
    String temp = "";
    for (int i = 0; i < playerList.size(); i++)
    {
      temp += playerList.get(i) + "\n";
    }

    return temp;
  }
}


