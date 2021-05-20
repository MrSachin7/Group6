import com.sun.glass.ui.Pixels;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MatchModelManager
{
  private String fileName;

  public MatchModelManager(String fileName)
  {
    this.fileName = fileName;
  }

  public MatchList getAllMatches()
  {
    MatchList allMatches = new MatchList();

    try
    {
      allMatches = (MatchList) MyFileHandler.readFromBinaryFile(fileName);
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
}

