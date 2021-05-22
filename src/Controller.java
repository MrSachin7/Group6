import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.event.ActionEvent;

import java.time.LocalDate;

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
  @FXML private Button allInjuryUpdate;
  @FXML private TextArea allInjuryInjuredDate;
  @FXML private TextArea allInjuryExpectedReturnDate;
  @FXML private DatePicker addInjuryInjuryDate;
  @FXML private DatePicker addInjuryExpectedReturnDate;
  @FXML private ComboBox<Player> addInjuryChoosePlayer;
  @FXML private TextField addInjuryFirstName;
  @FXML private TextField addInjuryLastName;
  @FXML private ComboBox<Player> removeInjuryChoosePlayer;
  @FXML private TextField removeInjuryFirstName;
  @FXML private TextField removeInjuryLastName;
  @FXML private TextField changeShirtNumberFirstName;
  @FXML private TextField changeShirtNumberLastName;
  @FXML private TextField changePositionFirstName;
  @FXML private TextField changePositionLastName;
  @FXML private DatePicker createPlayerDatePicker;
  private ModelManager modelManager;

  public void initialize()
  {
    modelManager = new ModelManager("Matches.bin", "Players.bin");
    spinnerShirtNo.setValueFactory(
        new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 99));
    createPlayerShirtNumber.setValueFactory(
        new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 99));
    createMatchHour.setValueFactory(
        new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23));
    createMatchMinute.setValueFactory(
        new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59));
  }

  private void updatePlayersArea()
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


  private void changeShirtNo()
  {
    String firstName = changeShirtNumberFirstName.getText();
    String lastName = changeShirtNumberLastName.getText();
    int shirtNumber = (int) spinnerShirtNo.getValue();
    modelManager.changeShirtNumber(firstName, lastName, shirtNumber);
    updatePlayersArea();

  }

  private void changePosition()
  {
    String firstName = changePositionFirstName.getText();
    String lastName = changePositionLastName.getText();
    String position = textFieldPosition.getText();
    modelManager.changePosition(firstName, lastName, position);
    changePositionFirstName.setText("");
    changePositionLastName.setText("");

  }

  private void createPlayer()
  {
    String firstName = createPlayerFirstName.getText();
    String lastName = createPlayerLastName.getText();
    String position = createPlayerPosition.getText();
    LocalDate temp = createPlayerDatePicker.getValue();
    int day = temp.getDayOfMonth();
    int month = temp.getMonthValue();
    int year = temp.getYear();
    Date newDate = new Date(day, month, year);
    modelManager.addPlayer(new Player(firstName, lastName, newDate, position));
    createPlayerFirstName.setText("");
    createPlayerLastName.setText("");
    createPlayerPosition.setText("");
  }

  private void updateMatchesArea()
  {
    MatchList matches = modelManager.getAllMatches();
    upcomingMatchesOpponents.setText(matches.getAllOpponents());
    upcomingMatchesTimes.setText(matches.getAllTimes());
    upcomingMatchesDates.setText(matches.getAllDates());
  }

  private void createMatch()
  {
    LocalDate temp = createMatchDate.getValue();
    int day = temp.getDayOfMonth();
    int month = temp.getMonthValue();
    int year = temp.getYear();
    Date newDate = new Date(day, month, year);
    String opponent = createMatchOpponent.getText();
    int hour = (int) createMatchHour.getValue();
    int minute = (int) createMatchMinute.getValue();
    int second = 0;
    Time newTime = new Time(hour, minute, second);
    boolean isHomeMatch = false;
    if (createMatchHome.isSelected())
    {
      isHomeMatch = true;
    }
    if (createMatchLeague.isSelected())
    {
      modelManager.addLeagueMatch(
          new LeagueMatch(opponent, newDate, newTime, isHomeMatch));
    }
    if (createMatchCup.isSelected())
    {
      modelManager.addCupMatch(
          new CupMatch(opponent, newDate, newTime, isHomeMatch));
    }
    if (createMatchFriendly.isSelected())
    {
      modelManager.addFriendlyMatch(
          new FriendlyMatch(opponent, newDate, newTime, isHomeMatch));
    }
createMatchOpponent.setText("");

  }
  private void allInjuries()
  {
    PlayerList allInjuries = modelManager.getAllInjuredPlayers();
    allInjuryName.setText(allInjuries.toString());
    allInjuryInjuredDate.setText(allInjuries.getInjuredDate());
    allInjuryExpectedReturnDate.setText(allInjuries.getExpectedReturnDate());
  }
  private void addInjury()

  public void handler(ActionEvent e)
  {
    if (e.getSource() == updatePlayers)
    {
      updatePlayersArea();
    }
    if (e.getSource() == changeShirtNumber)
    {
      changeShirtNo();
    }
    if (e.getSource() == savePosition)
    {
      changePosition();
      updatePlayersArea();
    }
    if (e.getSource() == upcomingMatchesUpdate)
    {
      updateMatchesArea();
    }
    if (e.getSource() == createPlayer)
    {
      createPlayer();
    }
    if (e.getSource()==createMatch)
    {
      createMatch();
    }
    if (e.getSource()==allInjuryUpdate)
    {
      allInjuries();
    }
  }
}
