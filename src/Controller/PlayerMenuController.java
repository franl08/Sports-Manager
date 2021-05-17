package Controller;

import Model.*;
import View.View;

import java.io.Serializable;
import java.util.Scanner;

public class PlayerMenuController implements Serializable
{
    private final Model model;
    private final Scanner inputs;

    public PlayerMenuController()
    {
        this.model = new Model();
        this.inputs = new Scanner(System.in);
    }

    public PlayerMenuController(Model model,Scanner sc)
    {
        this.model = model;
        this.inputs = sc;
    }

    public void runPlayerMenu()
    {
        boolean returnFlag = true;

        while(returnFlag)
        {
            View.PlayerMenu();
            int option = inputs.nextInt();

            switch (option) {
                case 1:
                    try
                    {
                        createPlayerController();
                        View.printSuccessfulCreatedPlayer();
                    }
                    catch (InvalidPlayerException e)
                    {
                        View.printMessage(e.getMessage());
                    }
                    break;

                case 2:
                    seeAllPlayers();
                    break;

                case 0:
                    returnFlag = false;
                    break;

                default:
                    View.printMessage("Your action could not be identified. Try again please.\n");
            }
        }
    }

    private void createPlayerController() throws InvalidPlayerException
    {
        View.askPlayerName();
        String playerName = inputs.next();

        View.askPlayerNumber();
        int number = inputs.nextInt();

        View.askPlayerTeam();
        String teamName = inputs.next();

        View.askPlayerPosition();
        int playerPosition = inputs.nextInt();

        switch (playerPosition)
        {
            case 1:
                GK newPlayer = new GK(); // ...
                break;

            case 2:
                break;
        }

        View.askAttributesMode();
        int attMode = inputs.nextInt();
        if(attMode == 1)
        {
            // ...
        }
    }

    private void seeAllPlayers()
    {
        String[] args = model.getPlayersAsStringArray();

        View.printAllPlayers(args);
    }
}