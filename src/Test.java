import java.io.IOException;

public class Test
{

  public static void main(String[] args) throws IOException
  {
    Time time = new Time(4, 5, 2);

    Date date1 = new Date(25, 9, 2002);
    CupMatch match1 = new CupMatch("Levamte", date1, time, true);
    Player sachin = new Player("SAchin ", "dad", date1, "ads", "da");
    PlayerList playerList = new PlayerList();
    playerList.addPlayer(sachin);
    ModelManager modelManager = new ModelManager("aabc","aabc.bin");
    MyFileHandler.writeToBinaryFile("aabc.bin",playerList);
    PlayerList players = modelManager.getAllPlayers();
    System.out.println(players);

  }
}
