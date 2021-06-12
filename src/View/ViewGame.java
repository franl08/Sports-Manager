package View;

import java.io.Serializable;

/**
 * Class that's responsible to present to the user Game related messages.
 */
public final class ViewGame implements Serializable
{
    /**
     * Method that's in charge of printing the menu related to Games.
     */
    public static void printGameMenu()
    {
        String[] gameMenuArgs = new String[]{"New game."};
        Outputs.printMenu(gameMenuArgs, "Game Menu", false);
    }

    /**
     * Method that's in charge of printing the option list related to game tactics.
     */
    public static void printGameTactics(String teamName)
    {
        String[] gameTacticsArgs = new String[]{"1-4-4-2.", "1-4-3-3."};
        Outputs.printOptionList(gameTacticsArgs, "Game Tactics - " + teamName);
    }

    /**
     * Method that asks the home team that is to play.
     */
    public static void askHomeTeamName()
    {
        Outputs.showMessage("Introduce home team name: ");
    }

    /**
     * Method that asks the away team that is to play.
     */
    public static void askAwayTeamName()
    {
        Outputs.showMessage("Introduce away team name: ");
    }

    /**
     * Method that asks the team that is to make a substitution.
     */
    public static void askTeamReplace()
    {
        Outputs.showMessage("Which team do you want to replace a player: ");
    }

    /**
     * Method that asks how many parts a game is to be divided in.
     */
    public static void askHowManyParts()
    {
        Outputs.showMessage("How many parts do you want the game to be divided in (1 | 2 | 3 | 5): ");
    }

    /**
     * Method that's in charge of printing the list of available substitutes.
     */
    public static void printAllTeamPos(String[] allPos, String position)
    {
        String[] headArgs = new String[] {"Player Name","Player Number","Player Overall","Player Position"};
        Outputs.printStringArrayAsTable(allPos, headArgs);

        Outputs.showMessage("\nIntroduce the number of the player that will play as " + position + ": ");
    }

    /**
     * Method that's in charge of printing the option list of the playing teams.
     */
    public static void printTeams(String[] teams)
    {
        Outputs.printMenu(teams, "Teams", false);
    }
}
