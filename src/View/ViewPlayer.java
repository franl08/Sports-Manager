package View;

import java.io.Serializable;

public class ViewPlayer implements Serializable {
    private final Outputs out;

    public ViewPlayer()
    {
        out = new Outputs();
    }

    public void printPlayerMenu() {
        String[] playerMenuArgs = new String[]{"Create new player.", "See all players.", "Look player information with ID.", "Manage player through ID."};
        this.out.printMenu(playerMenuArgs, "Player", false);
    }

    public void printSuccessfulCreatedPlayer() {
        System.out.println("Your player has been successfully created.");
    }

    public void printRequestedPlayerInvalid() {
        System.out.println("The player you requested does not exist.");
    }

    public void askPlayerID() {
        System.out.println("Introduce player ID: ");
    }
}