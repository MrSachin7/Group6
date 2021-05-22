import java.io.FileNotFoundException;
import java.io.IOException;

public class ModelManager
{
  private String matchFileName;
  private String playerFileName;

  public ModelManager(String matchFileName, String playerFileName)
  {
    this.matchFileName = matchFileName;
    this.playerFileName = playerFileName;
  }

  public MatchList getAllMatches()
  {
    MatchList allMatches = new MatchList();

    try
    {
      allMatches = (MatchList) MyFileHandler.readFromBinaryFile(matchFileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return allMatches;
  }

  public void saveMatches(MatchList matches)
  {
    try
    {
      MyFileHandler.writeToBinaryFile(matchFileName, matches);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file");
    }
  }

  public void addLeagueMatch(LeagueMatch match)
  {
    MatchList allMatches = getAllMatches();
    allMatches.addMatch(match);
    saveMatches(allMatches);
  }

  public void addCupMatch(CupMatch match)
  {
    MatchList allMatches = getAllMatches();
    allMatches.addMatch(match);
    saveMatches(allMatches);
  }

  public void addFriendlyMatch(FriendlyMatch match)
  {
    MatchList allMatches = getAllMatches();
    allMatches.addMatch(match);
    saveMatches(allMatches);
  }

  public void removeMatch(Match match)
  {
    MatchList allMatches = getAllMatches();
    allMatches.removeMatch(match);

    saveMatches(allMatches);
  }

  //For Players

  public PlayerList getAllPlayers()
  {
    PlayerList allPlayers = new PlayerList();
    try
    {
      allPlayers = (PlayerList) MyFileHandler
          .readFromBinaryFile(playerFileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return allPlayers;
  }

  public void savePlayers(PlayerList players)
  {
    try
    {
      MyFileHandler.writeToBinaryFile(playerFileName, players);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file");
    }
  }

  public PlayerList getAllInjuredPlayers()
  {
    PlayerList allPlayers = getAllPlayers();
    PlayerList injuredPlayers = new PlayerList();

    for (int i=0; i<allPlayers.size();i++)
    {
      if (!(allPlayers.get(i).getInjury()==null))
      {
        injuredPlayers.addPlayer(allPlayers.get(i));
      }
    }
    return injuredPlayers;
  }

public void addInjuryToPlayer(String firstName, String lastName, Injury injury)
{
  PlayerList allPlayers = getAllPlayers();
  for (int i = 0; i < allPlayers.size(); i++)
  {
    Player player = allPlayers.get(i);
    if (player.getFirstName().equals(firstName) && player.getLastName()
        .equals(lastName))
    {
      player.setInjury(injury);
    }
  }
  savePlayers(allPlayers);
}
  public void removeInjuryFromPlayer(String firstName, String lastName)
  {
    PlayerList allPlayers = getAllPlayers();
    for (int i = 0; i < allPlayers.size(); i++)
    {
      Player player = allPlayers.get(i);
      if (player.getFirstName().equals(firstName) && player.getLastName()
          .equals(lastName))
      {
        player.setInjury(null);
      }
    }
    savePlayers(allPlayers);
  }

  public void addPlayer(Player player)
  {
    PlayerList allPlayers = getAllPlayers();
    allPlayers.addPlayer(player);
    savePlayers(allPlayers);
  }

  public void removePlayer(Player player)
  {
    PlayerList allPlayers = getAllPlayers();
    allPlayers.removePlayer(player);
    savePlayers(allPlayers);
  }

  public void changeShirtNumber(String firstName, String lastName,
      int shirtNumber)
  {
    PlayerList allPlayers = getAllPlayers();
    for (int i = 0; i < allPlayers.size(); i++)
    {
      Player player = allPlayers.get(i);
      if (player.getFirstName().equals(firstName) && player.getLastName()
          .equals(lastName))
      {
        player.setShirtNumber(shirtNumber);
      }
    }
    savePlayers(allPlayers);

  }

  public void changePosition(String firstName, String lastName, String position)
  {
    PlayerList allPlayers = getAllPlayers();
    for (int i = 0; i < allPlayers.size(); i++)
    {
      Player player = allPlayers.get(i);
      if (player.getFirstName().equals(firstName) && player.getLastName()
          .equals(lastName))
      {
        player.setPosition(position);
      }
    }
    savePlayers(allPlayers);
  }

  public void addInjury(String firstName, String lastName, Injury injury)
  {
    PlayerList allPlayers = getAllPlayers();
    for (int i = 0; i < allPlayers.size(); i++)
    {
      Player player = allPlayers.get(i);
      if (player.getFirstName().equals(firstName) && player.getLastName()
          .equals(lastName))
      {
        player.setInjury(injury);
      }
    }
    savePlayers(allPlayers);
  }

  public void removeInjury(String firstName, String lastName)
  {
    PlayerList allPlayers = getAllPlayers();
    for (int i = 0; i < allPlayers.size(); i++)
    {
      Player player = allPlayers.get(i);
      if (player.getFirstName().equals(firstName) && player.getLastName()
          .equals(lastName))
      {
        player.setInjury(null);
      }
    }
    savePlayers(allPlayers);
  }

}

