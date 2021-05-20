import com.sun.webkit.Timer;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ModelManager
{
  private String fileName;
  public ModelManager(String fileName)
  {
    this.fileName = fileName;
  }

  public MatchList getALlMatches()
  {
    MatchList allMatches = new MatchList();

    try
    {
     allMatches= (MatchList)MyFileHandler.readFromBinaryFile(fileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File Not Found");
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

  public PlayerList getALlPlayers()
  {
    PlayerList allPlayers = new PlayerList();

    try
    {
      allPlayers= (PlayerList)MyFileHandler.readFromBinaryFile(fileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File Not Found");
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
  public void saveMatches(MatchList matches)
  {
    try
    {
      MyFileHandler.writeToBinaryFile(fileName, matches);
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
}
