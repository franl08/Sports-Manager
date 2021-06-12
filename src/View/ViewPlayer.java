package View;

import java.io.Serializable;

/**
 * Class that's responsible to present to the user Player related messages.
 */
public final class ViewPlayer implements Serializable
{
    /**
     * Method that's in charge of printing the menu related to Players.
     */
    public static void printPlayerMenu()
    {
        String[] playerMenuArgs = new String[]{"Create new player.", "See all players.", "Look player information with name.", "See player's team history with name.", "Manage player through name."};
        Outputs.printMenu(playerMenuArgs, "Player Menu", false);
    }

    /**
     * Method that's in charge of printing the menu related to managing players.
     */
    public static void printManagePlayerMenu()
    {
        String[] managePlayerMenuArgs = new String[]{"Transfer player.","Update player stats.","Delete player."};
        Outputs.printMenu(managePlayerMenuArgs,"Manage Player",false);
    }

    /**
     * Method that's in charge of printing the menu related to players attributes.
     */
    public static void printAttributesPlayerMenu(boolean isGoalkeeper)
    {
        String[] attributesPlayerMenuArgs;
        if (!isGoalkeeper)
        {
            attributesPlayerMenuArgs = new String[]{"Velocity.", "Endurance.", "Skill.", "Impulsion.", "Heading.", "Finishing.", "Passing.", "Crossing.",
                    "Ball Recovery.", "Positioning.", "Creativity.", "Aggressiveness.", "Tackling.", "Vision."};

        }
        else
        {
            attributesPlayerMenuArgs = new String[]{"Elasticity.", "Reflexes.", "Agility.", "Decisions.", "Velocity.", "Passing.", "Courage.", "Endurance."};

        }

        Outputs.printMenu(attributesPlayerMenuArgs,"Attributes List",false);
    }

    /**
     * Method that's in charge of printing the menu related to players positions.
     */
    public static void printPositionMenu()
    {
        String[] positionMenuArgs = new String[]{"Goalkeeper.", "Defender.", "Winger.", "Midfielder.", "Forward."};
        Outputs.printOptionList(positionMenuArgs, "Positions");
    }

    /**
     * Method that's in charge of printing the menu related to players attributes menu 1-Automatic 2-Manual.
     */
    public static void printAttributesModeMenu()
    {
        String[] positionMenuArgs = new String[]{"Automatic.", "Manual."};
        Outputs.printOptionList(positionMenuArgs, "Attribute");
    }

    /**
     * Method that asks the player's name.
     */
    public static void askPlayerName()
    {
        Outputs.showMessage("Insert player's name: ");
    }

    /**
     * Method that asks the player's number.
     */
    public static void askPlayerNumber()
    {
        Outputs.showMessage("Insert player's shirt number (1-99): ");
    }

    /**
     * Method that asks the player's team.
     */
    public static void askPlayerTeam()
    {
        Outputs.showMessage("Insert player's team: ");
    }

    /**
     * Method that asks the player's velocity.
     */
    public static void askPlayerVelocity()
    {
        Outputs.showMessage("Insert player's velocity (1-99): ");
    }

    /**
     * Method that asks the player's endurance.
     */
    public static void askPlayerEndurance()
    {
        Outputs.showMessage("Insert player's endurance (1-99): ");
    }

    /**
     * Method that asks the player's skill.
     */
    public static void askPlayerSkill()
    {
        Outputs.showMessage("Insert player's skill (1-99): ");
    }

    /**
     * Method that asks the player's impulsion.
     */
    public static void askPlayerImpulsion()
    {
        Outputs.showMessage("Insert player's impulsion (1-99): ");
    }

    /**
     * Method that asks the player's heading.
     */
    public static void askPlayerHeading()
    {
        Outputs.showMessage("Insert player's heading (1-99): ");
    }

    /**
     * Method that asks the player's finishing.
     */
    public static void askPlayerFinishing()
    {
        Outputs.showMessage("Insert player's finishing (1-99): ");
    }

    /**
     * Method that asks the player's passing.
     */
    public static void askPlayerPassing()
    {
        Outputs.showMessage("Insert player's passing (1-99): ");
    }

    /**
     * Method that asks the player's crossing.
     */
    public static void askPlayerCrossing()
    {
        Outputs.showMessage("Insert player's crossing (1-99): ");
    }

    /**
     * Method that asks the player's recovery.
     */
    public static void askPlayerBallRecovery()
    {
        Outputs.showMessage("Insert player's ball recovery (1-99): ");
    }

    /**
     * Method that asks the player's positioning.
     */
    public static void askPlayerPositioning()
    {
        Outputs.showMessage("Insert player's positioning (1-99): ");
    }

    /**
     * Method that asks the player's creativity.
     */
    public static void askPlayerCreativity()
    {
        Outputs.showMessage("Insert player's creativity (1-99): ");
    }

    /**
     * Method that asks the player's aggressiveness.
     */
    public static void askPlayerAggressiveness()
    {
        Outputs.showMessage("Insert player's aggressiveness (1-99): ");
    }

    /**
     * Method that asks the player's tackling.
     */
    public static void askPlayerTackling()
    {
        Outputs.showMessage("Insert player's tackling (1-99): ");
    }

    /**
     * Method that asks the player's vision.
     */
    public static void askPlayerVision()
    {
        Outputs.showMessage("Insert player's vision (1-99): ");
    }

    /**
     * Method that asks the player's elasticity.
     */
    public static void askPlayerElasticity()
    {
        Outputs.showMessage("Insert player's elasticity (1-99): ");
    }

    /**
     * Method that asks the player's reflexes.
     */
    public static void askPlayerReflexes()
    {
        Outputs.showMessage("Insert player's reflexes (1-99): ");
    }

    /**
     * Method that asks the player's agility.
     */
    public static void askPlayerAgility()
    {
        Outputs.showMessage("Insert player's agility (1-99): ");
    }

    /**
     * Method that asks the player's decisions.
     */
    public static void askPlayerDecisions()
    {
        Outputs.showMessage("Insert player's decisions (1-99): ");
    }

    /**
     * Method that asks the player's courage.
     */
    public static void askPlayerCourage(){Outputs.showMessage("Insert player's courage (1-99): ");}

    /**
     * Method that asks the player's attribute new value.
     */
    public static void askAttributeNewValue()
    {
        Outputs.showMessage("Insert new value (1-99): ");
    }

    /**
     * Method that prints a successful created player message.
     */
    public static void printSuccessfulCreatedPlayer() {
        Outputs.showMessage("Your player has been successfully created.");
    }

    /**
     * Method that prints a table like structure of all the players currently on the system.
     * @param allPlayers Array of Strings of all players information.
     */
    public static void printAllPlayers(String[] allPlayers)
    {
        String[] headArgs = new String[] {"Player Name","Player Number","Player Team","Player Overall","Player Position"};
        Outputs.printStringArrayAsTable(allPlayers, headArgs);
    }
}