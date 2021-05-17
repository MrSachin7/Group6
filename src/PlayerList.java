import java.util.ArrayList;

public class PlayerList
{
  private ArrayList<Player> playerList;

  public PlayerList()
  {
    playerList = new ArrayList<>();
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

  public String searchPlayer(Player player)
  {
    String temp = "";
    for (int i = 0; i < playerList.size(); i++)
    {
      if (playerList.get(i).equals(player))
      {
        temp = playerList.get(i).toString();
      }
      else
        temp = "No player Found";
    }
    return temp;
  }

  public String searchPlayer(int shirtNumber)
  {
    String temp = "";
    for (int i = 0; i < playerList.size(); i++)
    {
      if (playerList.get(i).getShirtNumber() == shirtNumber)
      {
        temp = playerList.get(i).toString();
      }
      else
      {
        temp ="No Player Found";
      }
    }
    return temp;
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
