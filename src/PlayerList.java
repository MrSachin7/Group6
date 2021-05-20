import java.util.ArrayList;

public class PlayerList
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
  public Player searchPlayerByName(String firstName, String lastName)
  {
    Player temp = null;
    for (int i = 0; i < playerList.size(); i++)
    {
      if ((playerList.get(i).getFirstName().equals(firstName))&& playerList.get(i).getLastName().equals(lastName))
      {
        temp= playerList.get(i);
      }
    }
    return temp;
  }

  public Player searchPlayer(Player player)
  {
   Player temp =null;
    for (int i = 0; i < playerList.size(); i++)
    {
      if (playerList.get(i).equals(player))
      {
        temp = playerList.get(i);
      }
    }
    return temp;
  }

  public Player searchPlayer(int shirtNumber)
  {
    Player temp = null;
    for (int i = 0; i < playerList.size(); i++)
    {
      if (playerList.get(i).getShirtNumber() == shirtNumber)
      {
        temp = playerList.get(i);
      }
    }
    return temp;
  }

  public ArrayList<Player> getPlayerList()
  {
    return playerList;
  }

  public String toString()
  {
    String temp = "Players :+\n";
    for (int i = 0; i < playerList.size(); i++)
    {
      temp += playerList.get(i) + "\n";
    }
    return temp;
  }
}
