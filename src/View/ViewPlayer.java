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
        Outputs.printOptionList(positionMenuArgs, "Positions");
    }

    public static void printAttributesModeMenu()
    {
        String[] positionMenuArgs = new String[]{"Automatic.", "Manual."};
        Outputs.printOptionList(positionMenuArgs, "Attribute");
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
        Outputs.showMessage("Insert player's shirt number (1-99): ");
    }

    public static void askPlayerTeam()
    {
        Outputs.showMessage("Insert player's team: ");
    }

    public static void askPlayerVelocity()
    {
        Outputs.showMessage("Insert player's velocity (1-100): ");
    }

    public static void askPlayerEndurance()
    {
        Outputs.showMessage("Insert player's endurance (1-100): ");
    }

    public static void askPlayerSkill()
    {
        Outputs.showMessage("Insert player's skill (1-100): ");
    }

    public static void askPlayerImpulsion()
    {
        Outputs.showMessage("Insert player's impulsion (1-100): ");
    }

    public static void askPlayerHeading()
    {
        Outputs.showMessage("Insert player's heading (1-100): ");
    }

    public static void askPlayerFinishing()
    {
        Outputs.showMessage("Insert player's finishing (1-100): ");
    }

    public static void askPlayerPassing()
    {
        Outputs.showMessage("Insert player's passing (1-100): ");
    }

    public static void askPlayerCrossing()
    {
        Outputs.showMessage("Insert player's crossing (1-100): ");
    }

    public static void askPlayerBallRecovery()
    {
        Outputs.showMessage("Insert player's ball recovery (1-100): ");
    }

    public static void askPlayerPositioning()
    {
        Outputs.showMessage("Insert player's positioning (1-100): ");
    }

    public static void askPlayerCreativity()
    {
        Outputs.showMessage("Insert player's creativity (1-100): ");
    }

    public static void askPlayerAggressiveness()
    {
        Outputs.showMessage("Insert player's aggressiveness (1-100): ");
    }

    public static void askPlayerTackling()
    {
        Outputs.showMessage("Insert player's tackling (1-100): ");
    }

    public static void askPlayerVision()
    {
        Outputs.showMessage("Insert player's vision (1-100): ");
    }

    public static void askPlayerElasticity()
    {
        Outputs.showMessage("Insert player's elasticity (1-100): ");
    }

    public static void askPlayerReflexes()
    {
        Outputs.showMessage("Insert player's reflexes (1-100): ");
    }

    public static void askPlayerAgility()
    {
        Outputs.showMessage("Insert player's agility (1-100): ");
    }

    public static void askPlayerDecisions()
    {
        Outputs.showMessage("Insert player's decisions (1-100): ");
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