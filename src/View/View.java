package View;

import java.io.Serializable;

// TODO showPlayers && showMessage, see Controller to know what is supposed to do.
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

    /**
     * Function that displays on the screen the Attributes menu.
     * @param isGoalkeeper is a boolean parameter that asserts whether the player that was requested is a goalkeeper or not.
     */
    public static void AttributesMenu(boolean isGoalkeeper)
    {
        ViewPlayer.printAttributesPlayerMenu(isGoalkeeper);
    }

    /**
     * Function that displays on the screen a phrase asking an input from the user which is supposed to be an player's id.
     */
    public static void askPlayerID()
    {
        ViewPlayer.askPlayerID();
    }

    /**
     * Function that displays on the screen a phrase asking an input from the user which is supposed to be an player's name.
     */
    public static void askPlayerName()
    {
        ViewPlayer.askPlayerName();
    }

    /**
     * Function that displays on the screen a phrase asking an input from the user which is supposed to be an player's shirt number.
     */
    public static void askPlayerNumber()
    {
        ViewPlayer.askPlayerNumber();
    }

    /**
     * Function that displays on the screen a phrase asking an input from the user which is supposed to be an player's starting team.
     */
    public static void askPlayerTeam()
    {
        ViewPlayer.askPlayerTeam();
    }

    /**
     * Function that displays on the screen the player position mode menu that is to confirm which position shall the player that is
     * being created is to play.
     */
    public static void askPlayerPosition()
    {
        ViewPlayer.printPositionMenu();
    }

    /**
     * Function that displays on the screen the attributes mode menu that is to assert whether the user would like to setup his/her
     * player attributes manually or have them randomly generated.
     */
    public static void askAttributesMode()
    {
        ViewPlayer.printAttributesModeMenu();
    }

    /**
     * Function that displays on the screen a phrase asking an input from the user which is supposed to be an player's starting velocity.
     */
    public static void askPlayerVelocity()
    {
        ViewPlayer.askPlayerVelocity();
    }

    /**
     * Function that displays on the screen a phrase asking an input from the user which is supposed to be an player's starting endurance.
     */
    public static void askPlayerEndurance()
    {
        ViewPlayer.askPlayerEndurance();
    }

    /**
     * Function that displays on the screen a phrase asking an input from the user which is supposed to be an player's starting skill.
     */
    public static void askPlayerSkill()
    {
        ViewPlayer.askPlayerSkill();
    }

    /**
     * Function that displays on the screen a phrase asking an input from the user which is supposed to be an player's starting impulsion.
     */
    public static void askPlayerImpulsion()
    {
        ViewPlayer.askPlayerImpulsion();
    }

    /**
     * Function that displays on the screen a phrase asking an input from the user which is supposed to be an player's starting heading.
     */
    public static void askPlayerHeading()
    {
        ViewPlayer.askPlayerHeading();
    }

    /**
     * Function that displays on the screen a phrase asking an input from the user which is supposed to be an player's starting skill.
     */
    public static void askPlayerFinishing()
    {
        ViewPlayer.askPlayerFinishing();
    }

    /**
     * Function that displays on the screen a phrase asking an input from the user which is supposed to be an player's starting passing.
     */
    public static void askPlayerPassing()
    {
        ViewPlayer.askPlayerPassing();
    }

    /**
     * Function that displays on the screen a phrase asking an input from the user which is supposed to be an player's starting crossing.
     */
    public static void askPlayerCrossing()
    {
        ViewPlayer.askPlayerCrossing();
    }

    /**
     * Function that displays on the screen a phrase asking an input from the user which is supposed to be an player's starting recovery.
     */
    public static void askPlayerBallRecovery()
    {
        ViewPlayer.askPlayerBallRecovery();
    }

    /**
     * Function that displays on the screen a phrase asking an input from the user which is supposed to be an player's starting positioning.
     */
    public static void askPlayerPositioning()
    {
        ViewPlayer.askPlayerPositioning();
    }

    /**
     * Function that displays on the screen a phrase asking an input from the user which is supposed to be an player's starting creativity.
     */
    public static void askPlayerCreativity()
    {
        ViewPlayer.askPlayerCreativity();
    }

    /**
     * Function that displays on the screen a phrase asking an input from the user which is supposed to be an player's starting aggressiveness.
     */
    public static void askPlayerAggressiveness()
    {
        ViewPlayer.askPlayerAggressiveness();
    }

    /**
     * Function that displays on the screen a phrase asking an input from the user which is supposed to be an player's starting tackling.
     */
    public static void askPlayerTackling()
    {
        ViewPlayer.askPlayerTackling();
    }

    /**
     * Function that displays on the screen a phrase asking an input from the user which is supposed to be an player's vision .
     */
    public static void askPlayerVision()
    {
        ViewPlayer.askPlayerVision();
    }

    /**
     * Function that displays on the screen a phrase asking an input from the user which is supposed to be an player's starting elasticity.
     */
    public static void askPlayerElasticity()
    {
        ViewPlayer.askPlayerElasticity();
    }

    /**
     * Function that displays on the screen a phrase asking an input from the user which is supposed to be an player's starting reflexes.
     */
    public static void askPlayerReflexes()
    {
        ViewPlayer.askPlayerReflexes();
    }

    /**
     * Function that displays on the screen a phrase asking an input from the user which is supposed to be an player's starting agility.
     */
    public static void askPlayerAgility()
    {
        ViewPlayer.askPlayerAgility();
    }

    /**
     * Function that displays on the screen a phrase asking an input from the user which is supposed to be an player's starting decisions.
     */
    public static void askPlayerDecisions()
    {
        ViewPlayer.askPlayerDecisions();
    }

    public static void printSuccessfulCreatedPlayer() {
        Outputs.showMessage("Your player has been successfully created.");
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

    public static void askTeamID()
    {
        ViewTeam.askTeamID();
    }

    public static void askTeamName()
    {
        ViewTeam.askTeamName();
    }

    public static void askNewTeamName()
    {
        ViewTeam.askNewTeamName();
    }

    /**
     * Function that displays on the screen a table like representation of all the teams currently in the system.
     */
    public static void printAllTeams(String[] allTeams)
    {
        ViewTeam.printAllTeams(allTeams);
    }

    //Game GUI

    public static void GameMenu()
    {
        ViewGame.printGameMenu();
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