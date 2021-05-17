package View;

import java.io.Serializable;

public final class ViewGame implements Serializable
{
    public static void printGameMenu()
    {
        String[] gameMenuArgs = new String[]{"New game.", "Load game."};
        Outputs.printMenu(gameMenuArgs, "Game Menu", false);
    }

    public static void askHomeTeamID() {
        System.out.println("Introduce home team ID: ");
    }

    public static void askAwayTeamID() {
        System.out.println("Introduce home team ID: ");
    }
}
