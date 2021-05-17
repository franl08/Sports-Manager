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

    public static void PlayerMenu()
    {
        ViewPlayer.printPlayerMenu();
    }

    public static void askPlayerName()
    {
        Outputs.showMessage("Insert player's name: ");
    }

    public static void askPlayerNumber()
    {
        Outputs.showMessage("Insert player's shirt number: ");
    }

    public static void askPlayerTeam()
    {
        Outputs.showMessage("Insert player's team: ");
    }

    public static void askPlayerPosition()
    {
        PositionMenu.printPositionMenu();
    }

    public static void askAttributesMode()
    {
        AttributesMenu.printAttributesMenu();
    }

    public static void askPlayerVelocity()
    {
        Outputs.showMessage("Insert player's velocity: ");
    }

    public static void askPlayerEndurance()
    {
        Outputs.showMessage("Insert player's endurance: ");
    }

    public static void askPlayerImpulsion()
    {
        Outputs.showMessage("Insert player's impulsion: ");
    }

    public static void askPlayerHeading()
    {
        Outputs.showMessage("Insert player's heading: ");
    }

    public static void askPlayerPassing()
    {
        Outputs.showMessage("Insert player's passing: ");
    }

    public static void askPlayerCrossing()
    {
        Outputs.showMessage("Insert player's crossing: ");
    }

    public static void askPlayerBallRecovery()
    {
        Outputs.showMessage("Insert player's ball recovery: ");
    }

    public static void askPlayerPositioning()
    {
        Outputs.showMessage("Insert player's positioning: ");
    }

    public static void askPlayerCreativity()
    {
        Outputs.showMessage("Insert player's creativity: ");
    }

    public static void askPlayerAggressiveness()
    {
        Outputs.showMessage("Insert player's aggressiveness: ");
    }

    public static void askPlayerTackling()
    {
        Outputs.showMessage("Insert player's tackling: ");
    }

    public static void askPlayerElasticity()
    {
        Outputs.showMessage("Insert player's elasticity: ");
    }

    public static void askPlayerReflexes()
    {
        Outputs.showMessage("Insert player's reflexes: ");
    }

    public static void askPlayerAgility()
    {
        Outputs.showMessage("Insert player's agility: ");
    }

    public static void askPlayerDecisions()
    {
        Outputs.showMessage("Insert player's decisions: ");
    }

    public static void printSuccessfulCreatedPlayer() {
        Outputs.showMessage("Your player has been successfully created.");
    }

    public static void printAllPlayers(String[] allPlayers)
    {
        String[] headArgs = new String[] {"Player ID","Player Name","Player Number","Player Team","Player Overall","Player Position"};
        Outputs.printStringArrayAsTable(allPlayers, headArgs);
    }

    //Team GUI

    public static void TeamMenu()
    {
        ViewTeam.printTeamMenu();
    }

    public static void askTeamName()
    {
        Outputs.showMessage("Insert team's name: ");
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