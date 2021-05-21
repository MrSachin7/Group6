import java.io.Serializable;
import java.util.ArrayList;

public class Formation implements Serializable
{
  private ArrayList<Player> startingPlayers;
  private ArrayList<Player> substitutePlayers;

  public Formation()
  {
    startingPlayers = new ArrayList<>();
    substitutePlayers = new ArrayList<>();
  }

  public void addStartingPlayer(Player player)
  {
    if ((startingPlayers.size() < 11) && player.getInjury().equals(null) )
    {
      startingPlayers.add(player);
    }
    else
    {
      throw new IllegalFormationException(
          " because starting players cannot be more than 11 or the player is injured");
    }
  }

  public void addStartingPlayers(Player[] players)
  {
    if ((players.length + startingPlayers.size()) <= 11)
    {
      for (int i = 0; i < players.length; i++)
      {
        startingPlayers.add(players[i]);
      }
    }
    else
      throw new IllegalFormationException(
          " because you are trying to add amount of players that makes starting players more than 11");
  }

  public void addSubstitutePlayers(Player[] players)
  {
    for (int i = 0; i < players.length; i++)
    {
      substitutePlayers.add(players[i]);
    }
  }

  public void addSubstitutePlayer(Player substitutePlayer)
  {
    substitutePlayers.add(substitutePlayer);
  }

  public String toString()
  {
    String temp = "Starting players:\n";
    {
      for (int i = 0; i < startingPlayers.size(); i++)
      {
        temp += startingPlayers.get(i) + "\n";
      }
    }
    temp += " Substitute Players:";
    {
      for (int i = 0; i < substitutePlayers.size(); i++)
      {
        temp += substitutePlayers.get(i) + "\n";
      }
    }
    return temp;
  }
}
