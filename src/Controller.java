import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.event.ActionEvent;

import java.time.LocalDate;


/**
 * @author Sachin Baral
 */
public class Controller
{
  @FXML private TextArea allPlayersBirthdate;
  @FXML private Button updatePlayers;
  @FXML private Button savePosition;
  @FXML private Button createPlayer;
  @FXML private Button changeShirtNumber;
  @FXML private Button createMatch;
  @FXML private Button upcomingMatchesUpdate;
  @FXML private Button addInjury;
  @FXML private Button removeInjury;
  @FXML private TextField deletePlayerFirstName;
  @FXML private TextField deletePlayerLastName;
  @FXML private ComboBox<Player> deletePlayerChoosePlayer;
  @FXML private Button deletePlayer;
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
  @FXML private TextArea upcomingMatchesMatchType;
  @FXML private TextArea previousMatchesOpponents;
  @FXML private TextArea previousMatchesDates;
  @FXML private TextArea previousMatchesTimes;
  @FXML private TextArea previousMatchesMatchType;
  @FXML private Button previousMatchesUpdate;
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
  @FXML private TextField deleteMatchOpponent;
  @FXML private DatePicker deleteMatchDate;
  @FXML private Button deleteMatch;
  @FXML private TextArea previousMatchesResult;
  @FXML private TextField setResultOpponent;
 @FXML private DatePicker setResultDate;
  @FXML private TextField setResultResult;
  @FXML private Button setResult;

  private ModelManager modelManager;

  /**
   * A list of methods to run when the program starts
   */
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
    updateEveryBox();
    allStarters();
    allSubstitutes();
    allInjuries();
    allSuspension();
    allSubstitutes();
    updatePreviousMatchesArea();
    updateUpcomingMatchesArea();


  }

  private void updatePlayersArea()
  {

    PlayerList players = modelManager.getAllPlayers();
    allPlayersName.setText(players.toString());
    allPlayersShirtNumber.setText(players.getShirtNumbers());
    allPlayersPosition.setText(players.getAllPositions());
    allPlayersBirthdate.setText(players.getBirthDate());
    allPlayersShirtNumber.setEditable(false);
    allPlayersName.setEditable(false);
    allPlayersBirthdate.setEditable(false);
    allPlayersPosition.setEditable(false);
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

  private void updateChangePositionBox()
  {
    int currentIndex = comboBoxPosition.getSelectionModel().getSelectedIndex();

    comboBoxPosition.getItems().clear();

    PlayerList players = modelManager.getAllPlayers();
    for (int i = 0; i < players.size(); i++)
    {
      comboBoxPosition.getItems().add(players.get(i));
    }

    if (currentIndex == -1 && comboBoxPosition.getItems().size() > 0)
    {
      comboBoxPosition.getSelectionModel().select(0);
    }
    else
    {
      comboBoxPosition.getSelectionModel().select(currentIndex);
    }

  }

  private void updateDeletePlayerComboBox()
  {
    int currentIndex = deletePlayerChoosePlayer.getSelectionModel()
        .getSelectedIndex();

    deletePlayerChoosePlayer.getItems().clear();

    PlayerList players = modelManager.getAllPlayers();
    for (int i = 0; i < players.size(); i++)
    {
      deletePlayerChoosePlayer.getItems().add(players.get(i));
    }

    if (currentIndex == -1 && deletePlayerChoosePlayer.getItems().size() > 0)
    {
      deletePlayerChoosePlayer.getSelectionModel().select(0);
    }
    else
    {
      deletePlayerChoosePlayer.getSelectionModel().select(currentIndex);
    }
  }

  private void updateAddSuspendedComboBox()
  {
    int currentIndex = addSuspendedComboBox.getSelectionModel()
        .getSelectedIndex();

    addSuspendedComboBox.getItems().clear();

    PlayerList players = modelManager.getAllPlayers();
    for (int i = 0; i < players.size(); i++)
    {
      addSuspendedComboBox.getItems().add(players.get(i));
    }

    if (currentIndex == -1 && addSuspendedComboBox.getItems().size() > 0)
    {
      addSuspendedComboBox.getSelectionModel().select(0);
    }
    else
    {
      addSuspendedComboBox.getSelectionModel().select(currentIndex);
    }
  }

  private void updateAddInjuryComboBox()
  {
    int currentIndex = addInjuryChoosePlayer.getSelectionModel()
        .getSelectedIndex();

    addInjuryChoosePlayer.getItems().clear();

    PlayerList players = modelManager.getAllPlayers();
    for (int i = 0; i < players.size(); i++)
    {
      addInjuryChoosePlayer.getItems().add(players.get(i));
    }

    if (currentIndex == -1 && addInjuryChoosePlayer.getItems().size() > 0)
    {
      addInjuryChoosePlayer.getSelectionModel().select(0);
    }
    else
    {
      addInjuryChoosePlayer.getSelectionModel().select(currentIndex);
    }
  }

  private void updateRemoveInjuryComboBox()
  {
    int currentIndex = removeInjuryChoosePlayer.getSelectionModel()
        .getSelectedIndex();

    removeInjuryChoosePlayer.getItems().clear();

    PlayerList players = modelManager.getAllInjuredPlayers();
    for (int i = 0; i < players.size(); i++)
    {
      removeInjuryChoosePlayer.getItems().add(players.get(i));
    }

    if (currentIndex == -1 && removeInjuryChoosePlayer.getItems().size() > 0)
    {
      removeInjuryChoosePlayer.getSelectionModel().select(0);
    }
    else
    {
      removeInjuryChoosePlayer.getSelectionModel().select(currentIndex);
    }
  }

  private void updateRemoveSuspendedComboBox()
  {
    int currentIndex = removeSuspensionComboBox.getSelectionModel()
        .getSelectedIndex();

    removeSuspensionComboBox.getItems().clear();

    PlayerList players = modelManager.getAllSuspendedPlayers();
    for (int i = 0; i < players.size(); i++)
    {
      removeSuspensionComboBox.getItems().add(players.get(i));
    }

    if (currentIndex == -1 && removeSuspensionComboBox.getItems().size() > 0)
    {
      removeSuspensionComboBox.getSelectionModel().select(0);
    }
    else
    {
      removeSuspensionComboBox.getSelectionModel().select(currentIndex);
    }
  }

  private void updateAddStarterComboBox()
  {
    int currentIndex = addStarterComboBox.getSelectionModel()
        .getSelectedIndex();

    addStarterComboBox.getItems().clear();

    PlayerList players = modelManager.getAllAvailablePlayers();
    for (int i = 0; i < players.size(); i++)
    {
      addStarterComboBox.getItems().add(players.get(i));
    }

    if (currentIndex == -1 && addStarterComboBox.getItems().size() > 0)
    {
      addStarterComboBox.getSelectionModel().select(0);
    }
    else
    {
      addStarterComboBox.getSelectionModel().select(currentIndex);
    }
  }

  private void updateRemoveStarterComboBox()
  {
    int currentIndex = removeStarterComboBox.getSelectionModel()
        .getSelectedIndex();

    removeStarterComboBox.getItems().clear();

    PlayerList players = modelManager.getAllStartingPlayers();
    for (int i = 0; i < players.size(); i++)
    {
      removeStarterComboBox.getItems().add(players.get(i));
    }

    if (currentIndex == -1 && removeStarterComboBox.getItems().size() > 0)
    {
      removeStarterComboBox.getSelectionModel().select(0);
    }
    else
    {
      removeStarterComboBox.getSelectionModel().select(currentIndex);
    }
  }

  private void updateAddSubstituteComboBox()
  {
    int currentIndex = addSubstituteComboBox.getSelectionModel()
        .getSelectedIndex();

    addSubstituteComboBox.getItems().clear();

    PlayerList players = modelManager.getAllAvailablePlayers();
    for (int i = 0; i < players.size(); i++)
    {
      addSubstituteComboBox.getItems().add(players.get(i));
    }

    if (currentIndex == -1 && addSubstituteComboBox.getItems().size() > 0)
    {
      addSubstituteComboBox.getSelectionModel().select(0);
    }
    else
    {
      addSubstituteComboBox.getSelectionModel().select(currentIndex);
    }
  }

  private void updateRemoveSubstituteComboBox()
  {
    int currentIndex = removeSubstituteComboBox.getSelectionModel()
        .getSelectedIndex();

    removeSubstituteComboBox.getItems().clear();

    PlayerList players = modelManager.getAllSubstitutePlayers();
    for (int i = 0; i < players.size(); i++)
    {
      removeSubstituteComboBox.getItems().add(players.get(i));
    }

    if (currentIndex == -1 && removeSubstituteComboBox.getItems().size() > 0)
    {
      removeSubstituteComboBox.getSelectionModel().select(0);
    }
    else
    {
      removeSubstituteComboBox.getSelectionModel().select(currentIndex);
    }
  }



  private void updateEveryBox()
  {
    updateAllPlayersBox();
    updateChangePositionBox();
    updateAddInjuryComboBox();
    updateAddStarterComboBox();
    updateAddSubstituteComboBox();
    updateAddSuspendedComboBox();
    updateRemoveInjuryComboBox();
    updateRemoveStarterComboBox();
    updateRemoveStarterComboBox();
    updateRemoveSubstituteComboBox();
    updateRemoveSuspendedComboBox();
    updateDeletePlayerComboBox();

  }

  private void changeShirtNo()
  {
    String firstName = changeShirtNumberFirstName.getText();
    String lastName = changeShirtNumberLastName.getText();
    int shirtNumber = (int) spinnerShirtNo.getValue();
    modelManager.changeShirtNumber(firstName, lastName, shirtNumber);
    changeShirtNumberFirstName.clear();
    changeShirtNumberLastName.clear();
    updateEveryBox();
    updatePlayersArea();
  }

  private void changePosition()
  {
    String firstName = changePositionFirstName.getText();
    String lastName = changePositionLastName.getText();
    String position = textFieldPosition.getText();
    modelManager.changePosition(firstName, lastName, position);
    changePositionFirstName.clear();
    changePositionLastName.clear();
    updateEveryBox();
    updatePlayersArea();
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
    createPlayerFirstName.clear();
    createPlayerLastName.clear();
    createPlayerPosition.clear();
    updateEveryBox();
    updatePlayersArea();
  }

  private void deletePlayer()
  {
    String firstName = deletePlayerFirstName.getText();
    String lastName = deletePlayerLastName.getText();
    modelManager.removePlayer(firstName, lastName);
    deletePlayerFirstName.clear();
    deletePlayerLastName.clear();
    updatePlayersArea();
    updateEveryBox();
  }

  private void updateUpcomingMatchesArea()
  {
    MatchList matches = modelManager.getALlUpcomingMatches();
    upcomingMatchesOpponents.setText(matches.getAllOpponents());
    upcomingMatchesTimes.setText(matches.getAllTimes());
    upcomingMatchesDates.setText(matches.getAllDates());
    upcomingMatchesMatchType.setText(matches.getAllMatchesTypes());

  }

  private void updatePreviousMatchesArea()
  {
    MatchList matches = modelManager.getALlPreviousMatches();
    previousMatchesOpponents.setText(matches.getAllOpponents());
    previousMatchesTimes.setText(matches.getAllTimes());
    previousMatchesDates.setText(matches.getAllDates());
    previousMatchesMatchType.setText(matches.getAllMatchesTypes());
    previousMatchesResult.setText(matches.getAllResults());
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
    createMatchOpponent.clear();
    updateUpcomingMatchesArea();
    updatePreviousMatchesArea();
    updateEveryBox();
  }

  private void removeMatch()
  {
    LocalDate temp = deleteMatchDate.getValue();
    int day = temp.getDayOfMonth();
    int month = temp.getMonthValue();
    int year = temp.getYear();
    Date tempDate = new Date(day,month,year);
    String opponentTeam = deleteMatchOpponent.getText();
    modelManager.removeMatch(opponentTeam,tempDate);
    deleteMatchOpponent.clear();
    updateUpcomingMatchesArea();
    updatePreviousMatchesArea();
    updateEveryBox();
  }
  private void setResult()
  {
    LocalDate temp = setResultDate.getValue();
    int day = temp.getDayOfMonth();
    int month = temp.getMonthValue();
    int year = temp.getYear();
    Date tempDate = new Date(day,month,year);
    String opponentTeam = setResultOpponent.getText();
    String result = setResultResult.getText();
    modelManager.setResult(opponentTeam,tempDate,result);
    setResultOpponent.clear();
    setResultResult.clear();
    updatePreviousMatchesArea();
    updateEveryBox();
  }


  private void allInjuries()
  {
    PlayerList allInjuries = modelManager.getAllInjuredPlayers();
    allInjuryName.setText(allInjuries.toString());
    allInjuryInjuredDate.setText(allInjuries.getInjuredDate());
    allInjuryExpectedReturnDate.setText(allInjuries.getExpectedReturnDate());
    updateAllPlayersBox();
    updateEveryBox();
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
    addInjuryFirstName.clear();
    addInjuryLastName.clear();
    allInjuries();
    updateAllPlayersBox();
    updateEveryBox();
  }

  private void allSuspension()
  {
    PlayerList allSuspendedPlayers = modelManager.getAllSuspendedPlayers();
    suspendedPlayerNames.setText(allSuspendedPlayers.toString());
    suspendedPlayerNoOfGames
        .setText(allSuspendedPlayers.getNoOfGamesSuspended());
    updateAllPlayersBox();
    updateEveryBox();
  }

  private void removeInjury()
  {
    String firstName = removeInjuryFirstName.getText();
    String lastName = removeInjuryLastName.getText();

    modelManager.removeInjury(firstName, lastName);
    removeInjuryLastName.clear();
    removeInjuryFirstName.clear();
    allInjuries();
    updateAllPlayersBox();
    updateEveryBox();
  }

  private void addSuspension()
  {
    String firstName = addSuspendedFirstName.getText();
    String lastName = addSuspendedLastName.getText();
    int noOfGamesSuspended = (int) addSuspendedNumberOfGamesSuspended
        .getValue();
    Suspension suspension = new Suspension(noOfGamesSuspended);
    modelManager.addSuspension(firstName, lastName, suspension);
    addSuspendedFirstName.clear();
    addSuspendedLastName.clear();
    allSuspension();
    updateAllPlayersBox();
    updateEveryBox();
  }

  private void removeSuspension()
  {
    String firstName = removeSuspensionFirstName.getText();
    String lastName = removeSuspensionLastName.getText();
    modelManager.removeSuspension(firstName, lastName);
    removeSuspensionFirstName.clear();
    removeSuspensionLastName.clear();
    allSuspension();
    updateAllPlayersBox();
    updateEveryBox();
  }

  private void allStarters()
  {
    PlayerList allStarters = modelManager.getAllStartingPlayers();
    allStartersPlayers.setText(allStarters.toString());
    allStartersShirtNumber.setText(allStarters.getShirtNumbers());
    allStartersPosition.setText(allStarters.getAllPositions());
    updateAllPlayersBox();
  }

  private void addStarter()
  {
    String firstName = addStarterFirstName.getText();
    String lastName = addStarterLastName.getText();
    modelManager.addStartingPlayers(firstName, lastName);
    addStarterFirstName.clear();
    addStarterLastName.clear();
    allStarters();
    allSubstitutes();
    updateEveryBox();
  }

  private void removeStarter()
  {
    String firstName = removeStarterFirstName.getText();
    String lastName = removeStarterLastName.getText();
    modelManager.removeStartingPlayers(firstName, lastName);
    removeStarterFirstName.clear();
    removeStarterLastName.clear();
    allStarters();
    updateAllPlayersBox();
    updateEveryBox();
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
    String lastName = addSubstituteLastName.getText();
    modelManager.addSubstitutePlayers(firstName, lastName);
    addSubstituteFirstName.clear();
    addStarterLastName.clear();
    allSubstitutes();
    allStarters();
    updateEveryBox();
  }

  private void removeSubstitute()
  {
    String firstName = removeSubstituteFirstName.getText();
    String lastName = removeSubstituteLastName.getText();
    modelManager.removeSubstitutePlayers(firstName, lastName);
    removeSubstituteFirstName.clear();
    removeStarterLastName.clear();
    allSubstitutes();
    updateAllPlayersBox();
    updateEveryBox();
  }


  /**
   * A handler that handles all the buttons and responsive functions in the GUI.
   *
   * @param e the action event
   */
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
      updateUpcomingMatchesArea();
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
    if (e.getSource() == comboBoxPosition)
    {
      Player temp = comboBoxPosition.getSelectionModel().getSelectedItem();

      if (temp != null)
      {
        changePositionFirstName.setText(temp.getFirstName());
        changePositionLastName.setText(temp.getLastName());
        changePositionFirstName.setEditable(false);
        changePositionLastName.setEditable(false);
      }
    }
    if (e.getSource() == deletePlayerChoosePlayer)
    {
      Player temp = deletePlayerChoosePlayer.getSelectionModel()
          .getSelectedItem();

      if (temp != null)
      {
        deletePlayerFirstName.setText(temp.getFirstName());
        deletePlayerLastName.setText(temp.getLastName());
        deletePlayerFirstName.setEditable(false);
        changePositionLastName.setEditable(false);
      }
    }
    if (e.getSource() == addInjuryChoosePlayer)
    {
      Player temp = addInjuryChoosePlayer.getSelectionModel().getSelectedItem();

      if (temp != null)
      {
        addInjuryFirstName.setText(temp.getFirstName());
        addInjuryLastName.setText(temp.getLastName());
        addInjuryFirstName.setEditable(false);
        addInjuryLastName.setEditable(false);
      }
    }
    if (e.getSource() == removeInjuryChoosePlayer)
    {
      Player temp = removeInjuryChoosePlayer.getSelectionModel()
          .getSelectedItem();

      if (temp != null)
      {
        removeInjuryFirstName.setText(temp.getFirstName());
        removeInjuryLastName.setText(temp.getLastName());
        removeInjuryFirstName.setEditable(false);
        removeInjuryLastName.setEditable(false);
      }
    }
    if (e.getSource() == addSuspendedComboBox)
    {
      Player temp = addSuspendedComboBox.getSelectionModel().getSelectedItem();

      if (temp != null)
      {
        addSuspendedFirstName.setText(temp.getFirstName());
        addSuspendedLastName.setText(temp.getLastName());
        addSuspendedFirstName.setEditable(false);
        addSuspendedLastName.setEditable(false);
      }
    }
    if (e.getSource() == removeSuspensionComboBox)
    {
      Player temp = removeSuspensionComboBox.getSelectionModel()
          .getSelectedItem();

      if (temp != null)
      {
        removeSuspensionFirstName.setText(temp.getFirstName());
        removeSuspensionLastName.setText(temp.getLastName());
        removeSuspensionFirstName.setEditable(false);
        removeSuspensionLastName.setEditable(false);
      }
    }
    if (e.getSource() == addStarterComboBox)
    {
      Player temp = addStarterComboBox.getSelectionModel().getSelectedItem();

      if (temp != null)
      {
        addStarterFirstName.setText(temp.getFirstName());
        addStarterLastName.setText(temp.getLastName());
        addStarterFirstName.setEditable(false);
        addStarterLastName.setEditable(false);
      }
    }
    if (e.getSource() == removeStarterComboBox)
    {
      Player temp = removeStarterComboBox.getSelectionModel().getSelectedItem();

      if (temp != null)
      {
        removeStarterFirstName.setText(temp.getFirstName());
        removeStarterLastName.setText(temp.getLastName());
        removeStarterFirstName.setEditable(false);
        removeStarterLastName.setEditable(false);
      }
    }
    if (e.getSource() == addSubstituteComboBox)
    {
      Player temp = addSubstituteComboBox.getSelectionModel().getSelectedItem();

      if (temp != null)
      {
        addSubstituteFirstName.setText(temp.getFirstName());
        addSubstituteLastName.setText(temp.getLastName());
        addSubstituteFirstName.setEditable(false);
        addSubstituteLastName.setEditable(false);
      }
    }
    if (e.getSource() == removeSubstituteComboBox)
    {
      Player temp = removeSubstituteComboBox.getSelectionModel()
          .getSelectedItem();

      if (temp != null)
      {
        removeSubstituteFirstName.setText(temp.getFirstName());
        removeSubstituteLastName.setText(temp.getLastName());
        removeSubstituteFirstName.setEditable(false);
        removeSubstituteLastName.setEditable(false);
      }
    }

    if (e.getSource() == addStarter)
    {
      addStarter();
    }
    if (e.getSource() == removeStarter)
    {
      removeStarter();
    }
    if (e.getSource() == addSubstitute)
    {
      addSubstitute();
    }
    if (e.getSource() == removeSubstitute)
    {
      removeSubstitute();
    }
    if (e.getSource() == deletePlayer)
    {
      deletePlayer();
    }
    if (e.getSource()==deleteMatch)
    {
      removeMatch();
    }
    if (e.getSource()==setResult)
    {
      setResult();
    }
  }
}
