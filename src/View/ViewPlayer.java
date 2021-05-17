package View;

import java.io.Serializable;

public final class ViewPlayer implements Serializable
{
    public static void printPlayerMenu()
    {
        String[] playerMenuArgs = new String[]{"Create new player.", "See all players.", "Look player information with ID.", "Manage player through ID."};
        Outputs.printMenu(playerMenuArgs, "Player Menu", false);
    }



    public static void printRequestedPlayerInvalid() {
        System.out.println("The player you requested does not exist.");
    }
}