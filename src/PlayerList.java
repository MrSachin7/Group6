import java.io.Serializable;
import java.util.ArrayList;

public class PlayerList implements Serializable
{
  private ArrayList<Player> playerList;

  public PlayerList()
  {
    playerList = new ArrayList<Player>();
  }

  public void addPlayer(Player player)
  {
    playerList.add(player);
  }

  public void addPlayers(Player[] players)
  {
    for (int i = 0; i < players.length; i++)
    {
      playerList.add(players[i]);
    }
  }
  public void setShirtNumber(Player player, int shirtNumber)
  {
    boolean isShirtNumberOccupied = false;
    for (int i = 0; i < playerList.size(); i++)
    {
      if (playerList.get(i).getShirtNumber() == shirtNumber)
      {
        isShirtNumberOccupied = true;
        break;
      }
    }
    if (isShirtNumberOccupied == true)
    {
      throw new IllegalShirtNumberException();
    }
    else
    {
      for (int i = 0; i < playerList.size(); i++)
      {
        if (playerList.get(i).equals(player))
        {
          playerList.get(i).setShirtNumber(shirtNumber);
        }
      }
    }
  }


  public  void add(Player player)
  {
    playerList.add(player);
  }
  public void set(Player player,int index)
  {
    playerList.set(index,player);
  }
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

  public Player get(String firstName, String lastName)
  {
    for (int i=0; i<playerList.size();i++)
    {
      Player temp =playerList.get(i);
      if (temp.getFirstName().equals(firstName) && temp.getLastName().equals(lastName))
      {
        return temp;
      }
    }
    return null;
  }
  public int getIndex(String firstName, String lastName)
  {
    for(int i = 0; i<playerList.size(); i++)
    {
     Player temp = playerList.get(i);

      if(temp.getFirstName().equals(firstName) && temp.getLastName().equals(lastName))
      {
        return i;
      }
    }
    return -1;
  }


  public void removePlayer(Player player)
  {
    ArrayList<Player> temp = new ArrayList<>();
    for (int i=0; i<playerList.size();i++)
    {
      if (!playerList.get(i).equals(player))
      {
        temp.add(player);
      }
        playerList= temp;
    }
  }

  public ArrayList<Player> getPlayerList()
  {
    return playerList;
  }

  public String toString()
  {
    String temp = "";
    for (int i = 0; i < playerList.size(); i++)
    {
      temp += playerList.get(i) + "\n";
    }
    return temp;
  }
  public String getShirtNumbers()
  {
    String temp = "";
    for (int i = 0; i < playerList.size(); i++)
    {
      temp += playerList.get(i).getShirtNumber();
    }
    return temp;
  }
  public String getAllPositions()
  {
    String temp = "";
    for (int i = 0; i < playerList.size(); i++)
    {
      temp += playerList.get(i).getPosition();
    }
    return temp;
  }

  public int size()
  {
    return playerList.size();
  }


}
