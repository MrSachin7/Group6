public class Test
{
  public static void main(String[] args)
  {
    Date date1= new Date(25,9,2002);
    Player player1 = new Player("Sachin",date1,"FW","Nepal");
    Player player2 = new Player("Cristiano",date1,"MF","Portugal");

    PlayerList playerList = new PlayerList();
    playerList.addPlayer(player1);
    playerList.addPlayer(player2);
    playerList.setShirtNumber(player1,7);

    System.out.println(playerList.searchPlayer(7));

  }

}
