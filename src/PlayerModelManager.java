import java.io.FileNotFoundException;
import java.io.IOException;

public class PlayerModelManager
{
  private String fileName;

  public PlayerModelManager(String fileName)
  {
    this.fileName = fileName;
  }

  public PlayerList getAllPlayers()
  {
    PlayerList allPlayers = new PlayerList();
    try
    {
      allPlayers = (PlayerList) MyFileHandler.readFromBinaryFile(fileName);

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
      MyFileHandler.writeToBinaryFile(fileName, players);
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
