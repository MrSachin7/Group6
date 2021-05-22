import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.event.ActionEvent;

import java.time.LocalDate;

public class Controller
{
  @FXML private Button updatePlayers;
  @FXML private Button savePosition;
  @FXML private Button createPlayer;
  @FXML private Button changeShirtNumber;
  @FXML private Button createMatch;
  @FXML private Button upcomingMatchesUpdate;
  @FXML private Button previousMatchesUpdate;
  @FXML private Button addInjury;
  @FXML private Button removeInjury;
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
  @FXML private Button addSuspension;
  @FXML private TextArea suspendedPlayerNames;
  @FXML private TextArea suspendedPlayerNoOfGames;
  @FXML private Button suspendedUpdate;
  @FXML private TextField addSuspendedFirstName;
  @FXML private TextField addSuspendedLastName;
  @FXML private Spinner addSuspendedNumberOfGamesSuspended;
  @FXML private ComboBox<Player> addSuspendedComboBox;
  @FXML private TextField removeSuspensionFirstName;
  @FXML private TextField removeSuspensionLastName;
  @FXML private ComboBox<Player> removeSuspensionComboBox;
  @FXML private Button removeSuspension;
  @FXML private TextArea allStartersPlayers;
  @FXML private TextArea allStartersPosition;
  @FXML private TextField addStarterFirstName;
  @FXML private TextField addStarterLastName;
  @FXML private ComboBox<Player> addStarterComboBox;
  @FXML private Button addStarter;
  @FXML private TextField removeStarterFirstName;
  @FXML private TextField removeStarterLastName;
  @FXML private ComboBox<Player> removeStarterComboBox;
  @FXML private Button removeStarter;
  @FXML private TextArea allSubstitutePlayers;
  @FXML private TextArea allSubstitutePosition;
  @FXML private TextField addSubstituteFirstName;
  @FXML private TextField addSubstituteLastName;
  @FXML private ComboBox<Player> addSubstituteComboBox;
  @FXML private Button addSubstitute;
  @FXML private TextField removeSubstituteFirstName;
  @FXML private TextField removeSubstituteLastName;
  @FXML private ComboBox<Player> removeSubstituteComboBox;
  @FXML private Button removeSubstitute;
  @FXML private TextArea allStartersShirtNumber;
  @FXML private TextArea allSubstituteShirtNumber;


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
    addSuspendedNumberOfGamesSuspended.setValueFactory(
        new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10));
    updatePlayersArea();
    updateAllPlayersBox();
    allStarters();
    allInjuries();
    allSuspension();
    allSubstitutes();
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
    changeShirtNumberFirstName.setText("");
    changeShirtNumberLastName.setText("");
    updatePlayersArea(); updateAllPlayersBox();
  }

  private void changePosition()
  {
    String firstName = changePositionFirstName.getText();
    String lastName = changePositionLastName.getText();
    String position = textFieldPosition.getText();
    modelManager.changePosition(firstName, lastName, position);
    changePositionFirstName.setText("");
    changePositionLastName.setText("");
    updatePlayersArea();
    updateAllPlayersBox();
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
    int shirtNumber = (int) createPlayerShirtNumber.getValue();
    modelManager.addPlayer(new Player(firstName, lastName, newDate, position));
    modelManager.changeShirtNumber(firstName, lastName, shirtNumber);
    createPlayerFirstName.setText("");
    createPlayerLastName.setText("");
    createPlayerPosition.setText("");
    updatePlayersArea(); updateAllPlayersBox();
  }

  private void updateMatchesArea()
  {
    MatchList matches = modelManager.getAllMatches();
    upcomingMatchesOpponents.setText(matches.getAllOpponents());
    upcomingMatchesTimes.setText(matches.getAllTimes());
    upcomingMatchesDates.setText(matches.getAllDates()); updateAllPlayersBox();
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
    if (createMatchAway.isSelected())
    {
      isHomeMatch = false;
    }
    if (createMatchLeague.isSelected())
    {
      modelManager.addLeagueMatch(
          new LeagueMatch(opponent, newDate, newTime, isHomeMatch));
    }
    if (createMatchCup.isSelected())
    {
      modelManager
          .addCupMatch(new CupMatch(opponent, newDate, newTime, isHomeMatch));
    }
    if (createMatchFriendly.isSelected())
    {
      modelManager.addFriendlyMatch(
          new FriendlyMatch(opponent, newDate, newTime, isHomeMatch));
    }
    createMatchOpponent.setText("");
    updateMatchesArea(); updateAllPlayersBox();
  }

  private void allInjuries()
  {
    PlayerList allInjuries = modelManager.getAllInjuredPlayers();
    allInjuryName.setText(allInjuries.toString());
    allInjuryInjuredDate.setText(allInjuries.getInjuredDate());
    allInjuryExpectedReturnDate.setText(allInjuries.getExpectedReturnDate()); updateAllPlayersBox();
  }

  private void addInjury()
  {
    String firstName = addInjuryFirstName.getText();
    String lastName = addInjuryLastName.getText();

    LocalDate temp1 = addInjuryInjuryDate.getValue();
    int d1 = temp1.getDayOfMonth();
    int m1 = temp1.getMonthValue();
    int y1 = temp1.getYear();
    Date injuredDate = new Date(d1, m1, y1);

    LocalDate temp2 = addInjuryExpectedReturnDate.getValue();
    int d2 = temp2.getDayOfMonth();
    int m2 = temp2.getMonthValue();
    int y2 = temp2.getYear();
    Date expectedReturnDate = new Date(d2, m2, y2);

    Injury injury = new Injury(injuredDate, expectedReturnDate);
    modelManager.addInjury(firstName, lastName, injury);
    addInjuryFirstName.setText("");
    addInjuryLastName.setText("");
    allInjuries(); updateAllPlayersBox();
  }

  private void allSuspension()
  {
    PlayerList allSuspendedPlayers = modelManager.getAllSuspendedPlayers();
    suspendedPlayerNames.setText(allSuspendedPlayers.toString());
    suspendedPlayerNoOfGames
        .setText(allSuspendedPlayers.getNoOfGamesSuspended());
    updateAllPlayersBox();
  }

  private void removeInjury()
  {
    String firstName = removeInjuryFirstName.getText();
    String lastName = removeInjuryLastName.getText();

    modelManager.removeInjury(firstName, lastName);
    removeInjuryLastName.setText("");
    removeInjuryFirstName.setText("");
    allInjuries(); updateAllPlayersBox();
  }

  private void addSuspension()
  {
    String firstName = addSuspendedFirstName.getText();
    String lastName = addSuspendedLastName.getText();
    int noOfGamesSuspended = (int) addSuspendedNumberOfGamesSuspended
        .getValue();
    Suspension suspension = new Suspension(noOfGamesSuspended);
    modelManager.addSuspension(firstName, lastName, suspension);
    addSuspendedFirstName.setText("");
    addSuspendedLastName.setText("");
    allSuspension();
    updateAllPlayersBox();
  }

  private void removeSuspension()
  {
    String firstName = removeSuspensionFirstName.getText();
    String lastName = removeSuspensionLastName.getText();
    modelManager.removeSuspension(firstName, lastName);
    removeSuspensionFirstName.setText("");
    removeSuspensionLastName.setText("");
    allSuspension(); updateAllPlayersBox();
  }

  private void allStarters()
  {
    PlayerList allStarters = modelManager.getAllStartingPlayers();
    allStartersPlayers.setText(allStarters.toString());
    allStartersShirtNumber.setText(allStarters.getShirtNumbers());
    allStartersPosition.setText(allStarters.getAllPositions()); updateAllPlayersBox();
  }
  private void addStarter()
  {
    String firstName = addStarterFirstName.getText();
    String lastName = addStarterLastName.getText();
    modelManager.addStartingPlayers(firstName,lastName);
    addStarterFirstName.setText("");
    addStarterLastName.setText("");
    allStarters(); updateAllPlayersBox();
  }
  private void removeStarter()
  {
    String firstName = removeStarterFirstName.getText();
    String lastName = removeStarterLastName.getText();
    modelManager.removeStartingPlayers(firstName,lastName);
    removeStarterFirstName.setText("");
    removeStarterLastName.setText("");
    allStarters(); updateAllPlayersBox();
  }
  private void allSubstitutes()
  {
    PlayerList allSubstitutes = modelManager.getAllSubstitutePlayers();
    allSubstitutePlayers.setText(allSubstitutes.toString());
    allSubstituteShirtNumber.setText(allSubstitutes.getShirtNumbers());
    allSubstitutePosition.setText(allSubstitutes.getAllPositions());
    updateAllPlayersBox();
  }
  private void addSubstitute()
  {
    String firstName = addSubstituteFirstName.getText();
    String lastName= addSubstituteLastName.getText();
    modelManager.addSubstitutePlayers(firstName,lastName);
    addSubstituteFirstName.setText("");
    addStarterLastName.setText("");
    allSubstitutes();
    updateAllPlayersBox();
  }
  private void removeSubstitute()
  {
    String firstName = removeSubstituteFirstName.getText();
    String lastName = removeSubstituteLastName.getText();
    modelManager.removeSubstitutePlayers(firstName,lastName);
    removeSubstituteFirstName.setText("");
    removeStarterLastName.setText("");
    allSubstitutes();
    updateAllPlayersBox();
  }
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
    if (e.getSource() == createMatch)
    {
      createMatch();
    }
    if (e.getSource() == allInjuryUpdate)
    {
      allInjuries();
    }
    if (e.getSource() == addInjury)
    {
      addInjury();
    }
    if (e.getSource() == removeInjury)
    {
      removeInjury();
    }
    if (e.getSource() == suspendedUpdate)
    {
      allSuspension();
    }
    if (e.getSource() == addSuspension)
    {
      addSuspension();
    }
    if (e.getSource() == removeSuspension)
    {
      removeSuspension();
    }
    if (e.getSource() == comboBoxShirtNo)
    {
      Player temp = comboBoxShirtNo.getSelectionModel().getSelectedItem();

      if (temp != null)
      {
        changeShirtNumberFirstName.setText(temp.getFirstName());
        changeShirtNumberLastName.setText(temp.getLastName());
        changeShirtNumberFirstName.setEditable(false);
        changeShirtNumberLastName.setEditable(false);
      }
    }
    if (e.getSource()==addStarter)
    {
      addStarter();
    }
    if (e.getSource()==removeStarter)
    {
      removeStarter();
    }
    if (e.getSource()==addSubstitute)
    {
      addSubstitute();
    }
    if (e.getSource()==removeSubstitute)
    {
      removeSubstitute();
    }
  }
}
