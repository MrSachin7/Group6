import java.io.FileNotFoundException;
import java.io.IOException;

public class ModelManager
{
  private String matchFileName;
  private String playerFileName;
  public ModelManager(String matchFileName,String playerFileName)
  {
    this.matchFileName=matchFileName;
    this.playerFileName=playerFileName;
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

  public void addMatch(Match match)
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
      allPlayers = (PlayerList) MyFileHandler.readFromBinaryFile(playerFileName);

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
    allPlayers.searchPlayerByName(firstName, lastName)
        .setShirtNumber(shirtNumber);

    savePlayers(allPlayers);
  }

  public void changePosition(String firstName, String lastName, String position)
  {
    PlayerList allPlayers = getAllPlayers();
    allPlayers.searchPlayerByName(firstName, lastName).setPosition(position);

    savePlayers(allPlayers);
  }

  public void addInjury(String firstName, String lastName, Injury injury)
  {
    PlayerList allPlayers = getAllPlayers();
    allPlayers.searchPlayerByName(firstName,lastName).setInjury(injury);

    savePlayers(allPlayers);
  }

  public void removeInjury(String firstName, String lastName)
  {
    PlayerList allPlayers = getAllPlayers();
    allPlayers.searchPlayerByName(firstName,lastName).removeInjury();

    savePlayers(allPlayers);
  }
}

