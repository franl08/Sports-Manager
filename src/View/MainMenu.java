package View;

import java.io.Serializable;

/**
 * Class that's responsible to present to the user the Main Menu.
 */
public final class MainMenu implements Serializable
{
    /**
     * Method that presents to the user the Main Menu.
     */
    public static void printMainMenu()
    {
        String[] gameMainMenuArgs = new String[]{"Player.", "Team.", "Game.", "Read logs.", "Save/Load.", "Reset Database."};
        Outputs.printMenu(gameMainMenuArgs, "Main Menu", true);
    }
}
