import java.io.IOException;

public class Test
{

  public static void main(String[] args) throws IOException
  {
    Time time = new Time(4, 5, 2);

    Date date1 = new Date(25, 9, 2002);
    CupMatch match1 = new CupMatch("Levante", date1, time, true);
    Player sachin = new Player("Sachin ", "Baral", date1, "ads", "da");
    PlayerList players = new PlayerList();
    players.addPlayer(sachin);
    players.setShirtNumber(sachin,7);
    ModelManager modelManager = new ModelManager("Matches.bin","Players.bin");
    MyFileHandler.writeToBinaryFile("Players.bin",players);

   MatchList matches= new MatchList();
   matches.addMatch(match1);
modelManager.changePosition("Sachin","Baral","Forward");
    System.out.println(sachin.getPosition());

  }
}
