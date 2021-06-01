import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Sachin Baral
 */
public class ModelManager
{
  private String matchFileName;
  private String playerFileName;

  /**
   * A constructor that creates/initilaizes the model manager
   *
   * @param matchFileName  the name of file where the information on MatchList object is stored.
   * @param playerFileName the name of file where the information on PlayerList object is stored.
   */
  public ModelManager(String matchFileName, String playerFileName)
  {
    this.matchFileName = matchFileName;
    this.playerFileName = playerFileName;
  }

  /**
   * Gets all the matches stored in a file
   *
   * @return MatchList Object stored in a file.
   */

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

  /**
   * Saves/Writes matches to the files
   *
   * @param matches the MatchList object to write/save on the file
   */

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

  /**
   * Adds and saves a League Match to a MatchList
   *
   * @param match a League Match object to add and save on the MatchList
   */

  public void addLeagueMatch(LeagueMatch match)
  {
    MatchList allMatches = getAllMatches();
    allMatches.addMatch(match);
    saveMatches(allMatches);
  }

  /**
   * Adds and saves a Cup Match to a MatchList
   *
   * @param match a Cup Match object to add and save on the MatchList
   */
  public void addCupMatch(CupMatch match)
  {
    MatchList allMatches = getAllMatches();
    allMatches.addMatch(match);
    saveMatches(allMatches);
  }

  /**
   * Adds and saves a Friendly Match to a MatchList
   *
   * @param match a Friendly Match object to add and save on the MatchList
   */
  public void addFriendlyMatch(FriendlyMatch match)
  {
    MatchList allMatches = getAllMatches();
    allMatches.addMatch(match);
    saveMatches(allMatches);
  }

  //For Players

  /**
   * Gets all the players stored in a file
   *
   * @return PlayerList Object stored in a file.
   */
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

  /**
   * Saves/Writes players to the files
   *
   * @param players the PlayerList object to write/save on the file
   */
  public void savePlayers(PlayerList players)
  {
    players.sortPlayers();
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

  /**
   * Removes a player and save it to file
   *
   * @param firstName the first name of a player to remove from file
   * @param lastName  the last name of a player to remove from file
   */
  public void removePlayer(String firstName, String lastName)
  {
    PlayerList allPlayers = getAllPlayers();
    for (int i = 0; i < allPlayers.size(); i++)
    {
      Player player = allPlayers.get(i);
      if (player.getFirstName().equals(firstName) && player.getLastName()
          .equals(lastName))
      {
        allPlayers.removePlayer(player);
      }
    }
    savePlayers(allPlayers);
  }

  /**
   * Gets all the injured players from the file
   *
   * @return the PlayerList object with all the Players Object (if the Injury object in it is not null)
   */
  public PlayerList getAllInjuredPlayers()
  {
    PlayerList allPlayers = getAllPlayers();
    PlayerList injuredPlayers = new PlayerList();

    for (int i = 0; i < allPlayers.size(); i++)
    {
      if (!(allPlayers.get(i).getInjury() == null))
      {
        injuredPlayers.add(allPlayers.get(i));
      }
    }
    return injuredPlayers;
  }

  /**
   * Gets all the available players to play a match from the file
   *
   * @return the PlayerList object with all the Players Object (if the Injury object and the Suspension in it is not null)
   */
  public PlayerList getAllAvailablePlayers()
  {
    PlayerList allPlayers = getAllPlayers();
    PlayerList availablePlayers = new PlayerList();

    for (int i = 0; i < allPlayers.size(); i++)
    {
      if ((allPlayers.get(i).getInjury() == null) && (
          allPlayers.get(i).getSuspension() == null))
      {
        availablePlayers.add(allPlayers.get(i));
      }
    }
    return availablePlayers;
  }

  /**
   * Gets all the suspension players from the file
   *
   * @return the PlayerList object with all the Players Object (if the Suspension object in it is not null)
   */

  public PlayerList getAllSuspendedPlayers()
  {
    PlayerList allPlayers = getAllPlayers();
    PlayerList suspendedPlayers = new PlayerList();

    for (int i = 0; i < allPlayers.size(); i++)
    {
      if (!(allPlayers.get(i).getSuspension() == null))
      {
        suspendedPlayers.add(allPlayers.get(i));
      }
    }
    return suspendedPlayers;
  }

  /**
   * Adds and saves a Player to a file
   *
   * @param player a Player Object to add on the file
   */
  public void addPlayer(Player player)
  {
    PlayerList allPlayers = getAllPlayers();
    allPlayers.add(player);
    savePlayers(allPlayers);
  }

  /**
   * Changes a player's shirt number and saves it to the file
   *
   * @param firstName   the firstName of a player to change shirt number
   * @param lastName    the lastName of a player to change shirt number
   * @param shirtNumber the new shirtNumber to change to of  a player
   */
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

  /**
   * Changes a player's position and saves it to the file
   *
   * @param firstName the firstName of a player to change shirt number
   * @param lastName  the lastName of a player to change shirt number
   * @param position  the new position to change to of  a player
   */

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

  /**
   * Adds an Injury object to a player and saves it
   *
   * @param firstName the first name of a player to add injury
   * @param lastName  the last name of a player to add injuury
   * @param injury    the Injury object to add
   */
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

  /**
   * Removes an Injury object from a Player i.e sets it to null
   *
   * @param firstName the first name of a player to remove injury
   * @param lastName  the last name of a player to remove injury
   */

  public void removeInjury(String firstName, String lastName)
  {
    PlayerList allPlayers = getAllPlayers();
    for (int i = 0; i < allPlayers.size(); i++)
    {
      Player player = allPlayers.get(i);
      if (player.getFirstName().equals(firstName) && player.getLastName()
          .equals(lastName))
      {
        player.removeInjury();
      }
    }
    savePlayers(allPlayers);
  }

  /**
   * Adds and saves a Suspension object to a Player object
   *
   * @param firstName  the first name of a player to add suspension
   * @param lastName   the last name of a player to add suspension
   * @param suspension the Suspension object to add to the player
   */

  public void addSuspension(String firstName, String lastName,
      Suspension suspension)
  {
    PlayerList allPlayers = getAllPlayers();
    for (int i = 0; i < allPlayers.size(); i++)
    {
      Player player = allPlayers.get(i);
      if (player.getFirstName().equals(firstName) && player.getLastName()
          .equals(lastName))
      {
        player.setSuspension(suspension);
      }
    }
    savePlayers(allPlayers);
  }

  /**
   * Removes a Suspension object from a Player and saves it (i.e set it to null)
   *
   * @param firstName the first name of the player to remove Suspension
   * @param lastName  the last name of a player to remove Suspension
   */
  public void removeSuspension(String firstName, String lastName)
  {
    PlayerList allPlayers = getAllPlayers();
    for (int i = 0; i < allPlayers.size(); i++)
    {
      Player player = allPlayers.get(i);
      if (player.getFirstName().equals(firstName) && player.getLastName()
          .equals(lastName))
      {
        player.removeSuspension();
      }
    }
    savePlayers(allPlayers);
  }

  /**
   * Gets all the players that are starting in a match
   *
   * @return a PlayerList object with all the players that are starting
   */
  public PlayerList getAllStartingPlayers()
  {
    PlayerList allPlayers = getAllPlayers();
    PlayerList startingPlayers = new PlayerList();

    for (int i = 0; i < allPlayers.size(); i++)
    {
      if ((allPlayers.get(i).getStartingOrNot().equals("Starting")))
      {
        startingPlayers.add(allPlayers.get(i));
      }
    }
    return startingPlayers;
  }

  /**
   * Adds a Player's status to starting
   *
   * @param firstName the first name of a player to add as starting
   * @param lastName  the last name of a player to add as starting
   */
  public void addStartingPlayers(String firstName, String lastName)
  {
    PlayerList allPlayers = getAllPlayers();
    PlayerList allStartingPlayers = getAllStartingPlayers();
    if (allStartingPlayers.size() < 11)
    {
      for (int i = 0; i < allPlayers.size(); i++)
      {
        Player player = allPlayers.get(i);
        if (player.getFirstName().equals(firstName) && player.getLastName()
            .equals(lastName))
        {
          player.setStartingOrNot("Starting");
        }
      }
      savePlayers(allPlayers);
    }
  }

  /**
   * Removes a player from starting players of a match
   *
   * @param firstName the first name of a player to remove from starting players
   * @param lastName  the last name of a player to remove from starting players
   */
  public void removeStartingPlayers(String firstName, String lastName)
  {
    PlayerList allPlayers = getAllPlayers();
    PlayerList allStartingPlayers = getAllStartingPlayers();

    for (int i = 0; i < allStartingPlayers.size(); i++)
    {
      Player player = allStartingPlayers.get(i);
      if (player.getFirstName().equals(firstName) && player.getLastName()
          .equals(lastName))
      {
        player.setStartingOrNot(" ");
      }
    }
    savePlayers(allPlayers);
  }

  /**
   * Gets all the players that are substitute in a match
   *
   * @return a PlayerList object with all the players that are substitute in a match
   */
  public PlayerList getAllSubstitutePlayers()
  {
    PlayerList allPlayers = getAllPlayers();
    PlayerList startingPlayers = new PlayerList();

    for (int i = 0; i < allPlayers.size(); i++)
    {
      if ((allPlayers.get(i).getStartingOrNot().equals("Substitute")))
      {
        startingPlayers.add(allPlayers.get(i));
      }
    }
    return startingPlayers;
  }

  /**
   * Adds a Player's status to substitute
   *
   * @param firstName the first name of a player to add as substitute
   * @param lastName  the last name of a player to add as substitue
   */
  public void addSubstitutePlayers(String firstName, String lastName)
  {
    PlayerList allPlayers = getAllPlayers();
    for (int i = 0; i < allPlayers.size(); i++)
    {
      Player player = allPlayers.get(i);
      if (player.getFirstName().equals(firstName) && player.getLastName()
          .equals(lastName))
      {
        player.setStartingOrNot("Substitute");
      }
    }
    savePlayers(allPlayers);
  }

  /**
   * Removes a player from substitute players of a match
   *
   * @param firstName the first name of a player to remove from substitute players
   * @param lastName  the last name of a player to remove from substitute players
   */
  public void removeSubstitutePlayers(String firstName, String lastName)
  {
    PlayerList allPlayers = getAllPlayers();
    for (int i = 0; i < allPlayers.size(); i++)
    {
      Player player = allPlayers.get(i);
      if (player.getFirstName().equals(firstName) && player.getLastName()
          .equals(lastName))
      {
        player.setStartingOrNot("");
      }
    }
    savePlayers(allPlayers);
  }

  /**
   * Gets all the matches before the current date
   *
   * @return a MatchList object with all the Matches object before the current Date
   */
  public MatchList getALlPreviousMatches()
  {
    MatchList allMatches = getAllMatches();
    MatchList allPreviousMatches = new MatchList();
    Date today = Date.today();
    for (int i = 0; i < allMatches.size(); i++)
    {
      Match match = allMatches.get(i);
      if (match.getMatchDate().isBefore(today))
      {
        allPreviousMatches.addMatch(match);
      }
    }
    return allPreviousMatches;
  }

  /**
   * Gets all the matches after the current date
   *
   * @return a MatchList object with all the Matches object after the current Date
   */
  public MatchList getALlUpcomingMatches()
  {
    MatchList allMatches = getAllMatches();
    MatchList allUpcomingMatches = new MatchList();
    Date today = Date.today();
    for (int i = 0; i < allMatches.size(); i++)
    {
      Match match = allMatches.get(i);
      if (!(match.getMatchDate().isBefore(today)))
      {
        allUpcomingMatches.addMatch(match);
      }
    }
    return allUpcomingMatches;
  }

  /**
   * Removes a match from the list
   *
   * @param opponentTeam the opponent team of the match to remove
   */
  public void removeMatch(String opponentTeam, Date startDate)
  {
    MatchList allMatches = getAllMatches();
    allMatches.removeMatch(opponentTeam, startDate);
    saveMatches(allMatches);
  }

  /**
   * Sets a result for a match
   *
   * @param opponentTeam the result of a match to change/set
   * @param startDate    the starting date of the match to set result
   * @param result       the result to set to a match
   */
  public void setResult(String opponentTeam, Date startDate, String result)
  {
    MatchList allMatches = getAllMatches();
    for (int i = 0; i < allMatches.size(); i++)
    {
      Match match = allMatches.get(i);
      if (match.getOpponentTeam().equals(opponentTeam) && match.getMatchDate()
          .equals(startDate))
      {
        if (match.getMatchDate().isBefore(Date.today()))
        {
          match.setResult(result);
        }
      }
    }
    saveMatches(allMatches);
  }

  public void exportPlayersToXml()
  {
    String fileName = ".\\Finalassignment\\Xml\\Players.xml";
    String appendPlayer = "";
    PlayerList allPlayers = getAllPlayers();
    allPlayers.sortPlayers();
    try
    {
      FileHandlerXML.writeToTextFile(fileName,
          "<?xml version=\"1.0\" encoding =\"UTF-8\"?>");
      FileHandlerXML.appendToTextFile(fileName, "<playerList>");
      for (int i = 0; i < allPlayers.size(); i++)
      {
        Player player = allPlayers.get(i);
        appendPlayer += "\n<player>\n   <name>" + player.getFirstName()+" "+player.getLastName() + "</name>"
            + "\n   <shirtNumber>" + player.getShirtNumber() + "</shirtNumber>"
            + "\n   <birthDate>" + player.getBirthDate() + "</birthDate>"
            + "\n    <position>" + player.getPosition() + "</position>\n</player>";
      }
      FileHandlerXML.appendToTextFile(fileName, appendPlayer);
      FileHandlerXML.appendToTextFile(fileName, "</playerList>");
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
  }

  public void exportUpcomingMatchesToXml()
  {
    String fileName = "Finalassignment/Xml/upcomingMatches.xml";
    String appendMatch = "";
    MatchList upcomingMatches = getALlUpcomingMatches();
    try
    {
      FileHandlerXML.writeToTextFile(fileName,
          "<?xml version=\"1.0\" encoding =\"UTF-8\"?>");
      FileHandlerXML.appendToTextFile(fileName, "<matchList>");
      for (int i = 0; i < upcomingMatches.size(); i++)
      {
        Match match = upcomingMatches.get(i);
        appendMatch +=
            "\n<match>\n   <opponentTeam>  " + match.getOpponentTeam() + "</opponentTeam>"
                + "\n   <matchDate>  " + match.getMatchDate()   + "</matchDate>"
                + "\n   <matchTime>  " + match.getStartTime() + "</matchTime>"
                + "\n   <matchType>  " + match.matchType() + "</matchType>"
                +"\n   <venue>  "+match.homeOrAway()+"</venue>"
                + "\n</match>  ";
      }
      FileHandlerXML.appendToTextFile(fileName, appendMatch);
      FileHandlerXML.appendToTextFile(fileName, "</matchList>");
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File Not Found");
    }
  }
  public void exportPreviousMatchesToXml()
  {
    String fileName = "Finalassignment/Xml/previousMatches.xml";
    String appendMatch = "";
    MatchList previousMatches = getALlPreviousMatches();
    try
    {
      FileHandlerXML.writeToTextFile(fileName,
          "<?xml version=\"1.0\" encoding =\"UTF-8\"?>");
      FileHandlerXML.appendToTextFile(fileName, "<matchList>");
      for (int i = 0; i < previousMatches.size(); i++)
      {
        Match match = previousMatches.get(i);
        appendMatch +=
            "\n<match>\n   <opponentTeam>  " + match.getOpponentTeam() + "</opponentTeam>"
                + "\n   <matchDate>  " + match.getMatchDate() + "</matchDate>"
                + "\n   <matchTime>  " + match.getStartTime() + "</matchTime>"
                + "\n   <matchType>  " + match.matchType() + "</matchType>"
        +"\n   <result>  "+match.getResult()+"</result>"
                +"\n   <venue> "+match.homeOrAway()+"</venue>"+"</match>";
      }
      FileHandlerXML.appendToTextFile(fileName, appendMatch);
      FileHandlerXML.appendToTextFile(fileName, "</matchList>");
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File Not Found");
    }
  }
}
