package View;

import java.io.Serializable;

public final class ViewPlayer implements Serializable
{
    public static void printPlayerMenu()
    {
        String[] playerMenuArgs = new String[]{"Create new player.", "See all players.", "Look player information with ID.", "Manage player through ID."};
        Outputs.printMenu(playerMenuArgs, "Player Menu", false);
    }

    public static void printManagePlayerMenu()
    {
        String[] managePlayerMenuArgs = new String[]{"Transfer player.","Update player stats.","Delete player."};
        Outputs.printMenu(managePlayerMenuArgs,"Manage Player",false);
    }

    public static void printAttributesPlayerMenu(boolean isGoalkeeper)
    {
        String[] attributesPlayerMenuArgs;
        if (isGoalkeeper)
        {
            attributesPlayerMenuArgs = new String[]{"Velocity.", "Endurance.", "Skill.", "Impulsion.", "Heading.", "Finishing", "Passing.", "Crossing.",
                    "Ball Recovery.", "Positioning.", "Creativity.", "Aggressiveness.", "Tackling.", "Vision."};

        }
        else
        {
            attributesPlayerMenuArgs = new String[]{"Elasticity.", "Reflexes.", "Agility.", "Decisions."};

        }

        Outputs.printMenu(attributesPlayerMenuArgs,"Attributes List",false);
    }

    public static void printPositionMenu()
    {
        String[] positionMenuArgs = new String[]{"Goalkeeper.", "Defender.", "Winger.", "Midfielder.", "Forward."};
        Outputs.printMenu(positionMenuArgs, "Positions", false);
    }

    public static void printAttributesModeMenu()
    {
        String[] positionMenuArgs = new String[]{"Automatic.", "Manual."};
        Outputs.printMenu(positionMenuArgs, "Attribute", false);
    }

    public static void askPlayerID()
    {
        Outputs.showMessage("Insert player's ID: ");
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
}