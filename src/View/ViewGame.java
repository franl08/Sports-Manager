package View;

import java.io.Serializable;

public final class ViewGame implements Serializable
{
    public static void printGameMenu()
    {
        String[] gameMenuArgs = new String[]{"New game.", "Load game."};
        Outputs.printMenu(gameMenuArgs, "Game Menu", false);
    }

    public static void printGameTactics(String teamName)
    {
        String[] gameTacticsArgs = new String[]{"1-4-4-2.", "1-4-3-3."};
        Outputs.printOptionList(gameTacticsArgs, "Game Tactics - " + teamName);
    }

    public static void printGameMeteorology()
    {
        String[] gameMeteorologyArgs = new String[]{"Sun.", "Rain.", "Snow."};
        Outputs.printOptionList(gameMeteorologyArgs, "Game Weather");
    }

    public static void askHomeTeamName()
    {
        Outputs.showMessage("Introduce home team name: ");
    }

    public static void askAwayTeamName()
    {
        Outputs.showMessage("Introduce away team name: ");
    }

    public static void askGameDay()
    {
        Outputs.showMessage("Introduce the day the game is to be played: ");
    }

    public static void askGameMonth()
    {
        Outputs.showMessage("Introduce the month the game is to be played: ");
    }

    public static void askGameYear()
    {
        Outputs.showMessage("Introduce the day the year is to be played: ");
    }
}
