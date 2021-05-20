public class Test
{

  public static void main(String[] args)
  {
    Time time = new Time(4, 5, 2);

    Date date1 = new Date(25, 9, 2002);
    CupMatch match1 = new CupMatch("Levamte", date1, time, true);
    Player sachin = new Player("SAchin ", "dad", date1, "ads", "da");
    PlayerList playerList = new PlayerList();
    playerList.addPlayer(sachin);
    playerList.removePlayer(sachin);
    System.out.println(playerList);
  }
}
