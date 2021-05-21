import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.event.ActionEvent;

public class Controller
{
  @FXML private Button updatePlayers;
  @FXML private Button savePlayer;
  @FXML private Button savePosition;
  @FXML private Button createPlayer;
  @FXML private Button changeShirtNumber;
  @FXML private Button createMatch;
  @FXML private Button upcomingMatchesUpdate;
  @FXML private Button previousMatchesUpdate;
  @FXML private Button addInjury;
  @FXML private Button removeInjury;
  @FXML private Button addSuspension;
  @FXML private Button removeSuspension;
  @FXML private TextArea allPlayersName;
  @FXML private TextArea allPlayersPosition;
  @FXML private TextArea allPlayersShirtNumber;
  @FXML private ComboBox<Player> comboBoxShirtNo;
  @FXML private Spinner spinnerShirtNo;
  @FXML private ComboBox<Player> comboBoxPosition;
  @FXML private TextField textFieldPosition;
  @FXML private TextField createPlayerFirstName;
  @FXML private TextField createPlayerLastName;
  @FXML private TextField createPlayerPosition;
  @FXML private Spinner createPlayerShirtNumber;
  @FXML private TextField createPlayerDay;
  @FXML private TextField createPlayerMonth;
  @FXML private TextField createPlayerYear;
  @FXML private TextArea upcomingMatchesOpponents;
  @FXML private TextArea upcomingMatchesDates;
  @FXML private TextArea upcomingMatchesTimes;
  @FXML private TextArea previousMatchesTextArea;
  @FXML private DatePicker createMatchDate;
  @FXML private TextField createMatchOpponent;
  @FXML private RadioButton createMatchHome;
  @FXML private RadioButton createMatchAway;
  @FXML private RadioButton createMatchLeague;
  @FXML private RadioButton createMatchCup;
  @FXML private RadioButton createMatchFriendly;
  @FXML private Spinner createMatchHour;
  @FXML private Spinner createMatchMinute;
  @FXML private TextArea allInjuryName;
  @FXML private TextArea allInjuryInjuredDate;
  @FXML private TextArea allInjuryExpectedReturnDate;
  @FXML private DatePicker addInjuryInjuryDate;
  @FXML private DatePicker addInjuryExpectedReturnDate;
  @FXML private ComboBox<Player> addInjuryChoosePlayer;
  @FXML private ComboBox<Player> removeInjuryChoosePlayer;
  @FXML private TextField changeShirtNumberFirstName;
  @FXML private TextField changeShirtNumberLastName;
  @FXML private TextField changePositionFirstName;
  @FXML private TextField changePositionLastName;
  private ModelManager modelManager;

public void initialize()
{
  modelManager = new ModelManager("Matches.bin", "Players.bin");
  spinnerShirtNo.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,99));

}

  public void updatePlayersArea()
  {

    PlayerList players = modelManager.getAllPlayers();
    allPlayersName.setText(players.toString());
    allPlayersShirtNumber.setText(players.getShirtNumbers());
    allPlayersPosition.setText(players.getAllPositions());

  }

  private void updateAllPlayersBox()
  {
    int currentIndex = comboBoxShirtNo.getSelectionModel().getSelectedIndex();

    comboBoxShirtNo.getItems().clear();

    PlayerList players = modelManager.getAllPlayers();
    for (int i = 0; i < players.size(); i++)
    {
      comboBoxShirtNo.getItems().add(players.get(i));
    }

    if (currentIndex == -1 && comboBoxShirtNo.getItems().size() > 0)
    {
      comboBoxShirtNo.getSelectionModel().select(0);
    }
    else
    {
      comboBoxShirtNo.getSelectionModel().select(currentIndex);
    }
  }

  public void changeShirtNumber()
  {
    String firstName = changeShirtNumberFirstName.getText();
    String lastName = changeShirtNumberLastName.getText();
    int shirtNumber = (Integer) spinnerShirtNo.getValue();
    modelManager.changeShirtNumber(firstName, lastName, shirtNumber);
    updatePlayersArea();

  }

  public void changePosition()
  {
    String firstName = changePositionFirstName.getText();
    String lastName = changePositionLastName.getText();
    String position = textFieldPosition.getText();
    modelManager.changePosition(firstName, lastName, position);
    updatePlayersArea();
    changePositionFirstName.setText("");
    changePositionLastName.setText("");

  }

  public void createPlayer()
  {
    String firstName = createPlayerFirstName.getText();
    String lastName = createPlayerLastName.getText();
    String position = createPlayerPosition.getText();
    // cannot figure out how to get date ;
  }

  public void updateMatchesArea()
  {
    MatchList matches = modelManager.getAllMatches();
    upcomingMatchesOpponents.setText(matches.getAllOpponents());
    upcomingMatchesTimes.setText(matches.getAllTimes());
    upcomingMatchesDates.setText(matches.getAllDates());
  }

  public void handler(ActionEvent e)
  {
    if (e.getSource() == updatePlayers)
    {
      updatePlayersArea();
    }
    if (e.getSource()==changeShirtNumber)
    {
      changeShirtNumber();

    }
    if (e.getSource()==savePosition)
    {
      changePosition();
      updatePlayersArea();
    }
    if (e.getSource()==upcomingMatchesUpdate)
    {
      updateMatchesArea();
    }
  }
}
