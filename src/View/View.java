package View;

import java.io.Serializable;
import java.lang.reflect.Method;

public class View implements Serializable
{
    public static void MainMenu()
    {
        MainMenu.printMainMenu();
    }

    //Player GUI

    /**
     * Function that displays on the screen th player menu.
     */
    public static void PlayerMenu()
    {
        ViewPlayer.printPlayerMenu();
    }

    /**
     * Function that displays on the screen the manage player menu.
     */
    public static void ManagePlayer()
    {
        ViewPlayer.printManagePlayerMenu();
    }

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

        if(param.equals("game_meteorology"))
            ViewGame.printGameMeteorology();

        if(param.equals("game_month"))
            ViewGame.askGameMonth();

        if(param.equals("game_day"))
            ViewGame.askGameDay();

        if(param.equals("game_year"))
            ViewGame.askGameYear();

        if(param.equals("home_team_tactics"))
            ViewGame.printGameTactics("Home Team");

        if(param.equals("away_team_tactics"))
            ViewGame.printGameTactics("Away Team");
    }

    public static void printSuccessfulCreatedPlayer()
    {
        ViewPlayer.printSuccessfulCreatedPlayer();
    }

    /**
     * Function that displays on the screen a table like representation of all the players currently in the system.
     */
    public static void printAllPlayers(String[] allPlayers)
    {
        ViewPlayer.printAllPlayers(allPlayers);
    }

    //Team GUI

    public static void TeamMenu()
    {
        ViewTeam.printTeamMenu();
    }

    public static void printSuccessfulCreatedTeam()
    {
        ViewTeam.printSuccessfulCreatedTeam();
    }

    public static void printSuccessfulDeletedTeam()
    {
        ViewTeam.printSuccessfulDeletedTeam();
    }

    /**
     * Function that displays on the screen a table like representation of all the teams currently in the system.
     */
    public static void printAllTeams(String[] allTeams)
    {
        ViewTeam.printAllTeams(allTeams);
    }

    /**
     * Function that displays on the screen a table like representation of the history of a team currently in the system.
     */
    public static void printTeamPlayers(String[] teamPlayers)
    {
        ViewTeam.printTeamPlayers(teamPlayers);
    }

    /**
     * Function that displays on the screen a table like representation of the history of a team currently in the system.
     */
    public static void printTeamHistory(String[] teamHistory)
    {
        ViewTeam.printTeamHistory(teamHistory);
    }

    /**
     * Function that displays on the screen a table like representation of the numbers currently available in the team.
     */
    public static void printTeamAvailableNumbers(String[] numbers)
    {
        ViewTeam.printTeamAvailableNumbers(numbers);
    }

    //Game GUI

    public static void GameMenu()
    {
        ViewGame.printGameMenu();
    }

    public static void TacticsMenu(String teamName)
    {
        ViewGame.printGameTactics(teamName);
    }

    //Util

    public static void printMessage(String message)
    {
        Outputs.showMessage(message);
    }

    public static void clear()
    {
        Outputs.clear();
    }
}