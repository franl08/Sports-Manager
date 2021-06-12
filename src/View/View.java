package View;

import java.io.Serializable;

/**
 * Class responsible to show the user everything from menus to simple messages.
 */
public final class View implements Serializable
{
    /**
     * Method that displays on the screen the main menu.
     */
    public static void MainMenu()
    {
        MainMenu.printMainMenu();
    }

    //Player GUI

    /**
     * Method that displays on the screen the player menu.
     */
    public static void PlayerMenu()
    {
        ViewPlayer.printPlayerMenu();
    }

    /**
     * Method that displays on the screen the manage player menu.
     */
    public static void ManagePlayer()
    {
        ViewPlayer.printManagePlayerMenu();
    }

    /**
     * Method that displays on the screen a message related to a parameter.
     * @param param Parameter.
     * @param isGoalkeeper Necessary to know which attributes to display.
     */
    public static void askParam(String param, boolean isGoalkeeper)
    {
        // Player

        if(param.equals("player_name"))
            ViewPlayer.askPlayerName();

        if(param.equals("player_number"))
            ViewPlayer.askPlayerNumber();

        if(param.equals("player_team"))
            ViewPlayer.askPlayerTeam();

        if(param.equals("player_position"))
            ViewPlayer.printPositionMenu();

        if(param.equals("attributes_mode"))
            ViewPlayer.printAttributesModeMenu();

        if(param.equals("player_attributes"))
            ViewPlayer.printAttributesPlayerMenu(isGoalkeeper);

        if(param.equals("player_attributes_value"))
            ViewPlayer.askAttributeNewValue();

        if(param.equals("player_velocity"))
            ViewPlayer.askPlayerVelocity();

        if(param.equals("player_endurance"))
            ViewPlayer.askPlayerEndurance();

        if(param.equals("player_skill"))
            ViewPlayer.askPlayerSkill();

        if(param.equals("player_impulsion"))
            ViewPlayer.askPlayerImpulsion();

        if(param.equals("player_heading"))
            ViewPlayer.askPlayerHeading();

        if(param.equals("player_finishing"))
            ViewPlayer.askPlayerFinishing();

        if(param.equals("player_passing"))
            ViewPlayer.askPlayerPassing();

        if(param.equals("player_crossing"))
            ViewPlayer.askPlayerCrossing();

        if(param.equals("player_ball_recovery"))
            ViewPlayer.askPlayerBallRecovery();

        if(param.equals("player_positioning"))
            ViewPlayer.askPlayerPositioning();

        if(param.equals("player_creativity"))
            ViewPlayer.askPlayerCreativity();

        if(param.equals("player_aggressiveness"))
            ViewPlayer.askPlayerAggressiveness();

        if(param.equals("player_tackling"))
            ViewPlayer.askPlayerTackling();

        if(param.equals("player_vision"))
            ViewPlayer.askPlayerVision();

        if(param.equals("player_elasticity"))
            ViewPlayer.askPlayerElasticity();

        if(param.equals("player_reflexes"))
            ViewPlayer.askPlayerReflexes();

        if(param.equals("player_agility"))
            ViewPlayer.askPlayerAgility();

        if(param.equals("player_decisions"))
            ViewPlayer.askPlayerDecisions();

        if(param.equals("player_courage"))
            ViewPlayer.askPlayerCourage();

        // Team

        if(param.equals("new_team_name"))
            ViewTeam.askNewTeamName();

        if(param.equals("team_name"))
            ViewTeam.askTeamName();

        // Game

        if(param.equals("home_team"))
            ViewGame.askHomeTeamName();

        if(param.equals("away_team"))
            ViewGame.askAwayTeamName();

        if(param.equals("home_team_tactics"))
            ViewGame.printGameTactics("Home Team");

        if(param.equals("away_team_tactics"))
            ViewGame.printGameTactics("Away Team");

        if(param.equals("team_to_replace"))
            ViewGame.askTeamReplace();

        if(param.equals("parts"))
            ViewGame.askHowManyParts();

        // Load/Save

        if(param.equals("file_to_save"))
            LoadSaveMenu.askForPathToSave();
    }

    /**
     * Method that displays on the screen a successful created player message.
     */
    public static void printSuccessfulCreatedPlayer()
    {
        ViewPlayer.printSuccessfulCreatedPlayer();
    }

    /**
     * Method that displays on the screen a table like representation of all the players currently in the system.
     */
    public static void printAllPlayers(String[] allPlayers)
    {
        ViewPlayer.printAllPlayers(allPlayers);
    }

    //Team GUI

    /**
     * Method that displays on the screen the team menu.
     */
    public static void TeamMenu()
    {
        ViewTeam.printTeamMenu();
    }

    /**
     * Method that displays on the screen a successful deleted player team.
     */
    public static void printSuccessfulDeletedTeam()
    {
        ViewTeam.printSuccessfulDeletedTeam();
    }

    /**
     * Method that displays on the screen a table like representation of all the teams currently in the system.
     */
    public static void printAllTeams(String[] allTeams)
    {
        ViewTeam.printAllTeams(allTeams);
    }

    /**
     * Method that displays on the screen a table like representation of the history of a team currently in the system.
     */
    public static void printTeamPlayers(String[] teamPlayers)
    {
        ViewTeam.printTeamPlayers(teamPlayers);
    }

    /**
     * Method that displays on the screen a table like representation of the history of a team currently in the system.
     */
    public static void printTeamHistory(String[] teamHistory)
    {
        ViewTeam.printTeamHistory(teamHistory);
    }

    /**
     * Method that displays on the screen a table like representation of the numbers currently available in the team.
     */
    public static void printTeamAvailableNumbers(String[] numbers)
    {
        ViewTeam.printTeamAvailableNumbers(numbers);
    }

    //Game GUI

    /**
     * Method that displays on the screen the game menu.
     */
    public static void GameMenu()
    {
        ViewGame.printGameMenu();
    }

    /**
     * Method that displays on the screen a table like with all the players capable of playing a certain position in a team.
     * @param allPos Array of Strings with the players relevant information.
     * @param position Position.
     */
    public static void printAllTeamPos(String[] allPos, String position)
    {
        ViewGame.printAllTeamPos(allPos, position);
    }

    /**
     * Method that displays on the screen a table like with all the teams ina a game.
     * @param teams Array of Strings with the teams names.
     */
    public static void printTeams(String[] teams)
    {
        ViewGame.printTeams(teams);
    }

    //Save/Load Menu GUI

    /**
     * Method that displays on the screen the team menu.
     */
    public static void LoadSaveMenu()
    {
        LoadSaveMenu.printLoadSaveMenu();
    }

    /**
     * Method that displays on the screen a table like with all the filenames of a directory.
     * @param fileNames Array of Strings with the filenames.
     */
    public static void printLoadFiles(String[] fileNames)
    {
        LoadSaveMenu.printLoadFiles(fileNames);
    }

    //Util

    /**
     * Method that displays on the screen a message.
     * @param message The message to be displayed.
     */
    public static void printMessage(String message)
    {
        Outputs.showMessage(message);
    }

    /**
     * Method that clears the screen.
     */
    public static void clear()
    {
        Outputs.clear();
    }
}