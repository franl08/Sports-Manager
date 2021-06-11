package View;

import java.io.Serializable;

public final class MainMenu implements Serializable
{
    public static void printMainMenu()
    {
        String[] gameMainMenuArgs = new String[]{"Player.", "Team.", "Game.", "Read logs.", "Save/Load.", "Restart."};
        Outputs.printMenu(gameMainMenuArgs, "Main Menu", true);
    }
}
