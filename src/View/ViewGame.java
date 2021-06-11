package View;

import java.io.Serializable;

public final class ViewGame implements Serializable
{
    public static void printGameMenu()
    {
        String[] gameMenuArgs = new String[]{"New game."};
        Outputs.printMenu(gameMenuArgs, "Game Menu", false);
    }

    public static void printGameTactics(String teamName)
    {
        String[] gameTacticsArgs = new String[]{"1-4-4-2.", "1-4-3-3."};
        Outputs.printOptionList(gameTacticsArgs, "Game Tactics - " + teamName);
    }

    public static void askHomeTeamName()
    {
        Outputs.showMessage("Introduce home team name: ");
    }

    public static void askAwayTeamName()
    {
        Outputs.showMessage("Introduce away team name: ");
    }

    public static void askTeamReplace()
    {
        Outputs.showMessage("Which team do you want to replace a player: ");
    }

    public static void askHowManyParts()
    {
        Outputs.showMessage("How many parts do you want the game to be divided in (1 | 2 | 3 | 5): ");
    }


    public static void printAllTeamPos(String[] allPos, String position)
    {
        String[] headArgs = new String[] {"Player Name","Player Number","Player Overall","Player Position"};
        Outputs.printStringArrayAsTable(allPos, headArgs);

        Outputs.showMessage("\nIntroduce the number of the player that will play as " + position + ": ");
    }

    public static void printTeams(String[] teams)
    {
        Outputs.printMenu(teams, "Teams", false);
    }
}
