import java.io.FileNotFoundException;
import java.io.IOException;

public class MatchModelManager
{
  private String fileName;
  public MatchModelManager(String fileName)
  {
    this.fileName=fileName;
  }

  public MatchList getAllMatches()
  {
    MatchList allStudents = new MatchList();

    try
    {
      allStudents = (MatchList) MyFileHandler.readFromBinaryFile(fileName);
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
    return allStudents;
  }

}
