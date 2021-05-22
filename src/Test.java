import java.io.IOException;

public class Test
{

  public static void main(String[] args) throws IOException
  {
    ModelManager modelManager = new ModelManager("Matches.bin","Players.bin");
    PlayerList playerList= new PlayerList();
    MyFileHandler.writeToBinaryFile("Players.bin",playerList);
    MatchList matchList = new MatchList();
    MyFileHandler.writeToBinaryFile("Matches.bin",matchList);
  }
}
