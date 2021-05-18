package Controller;

import Model.*;
import View.View;

import java.io.Serializable;
import java.util.Scanner;

// TODO: see player history and finish function create player
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

                case 3:
                    seePlayer();
                    break;

                case 4:
                    managePlayer();
                    break;

                case 0:
                    returnFlag = false;
                    break;

                default:
                    View.printMessage("Your action could not be identified. Try again please.\n");
                    break;
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
        String[] args = this.model.getPlayersAsStringArray();

        View.printAllPlayers(args);
    }

    private void seePlayer()
    {
        View.askPlayerID();
        String id = this.inputs.next();

        String playerInfo = this.model.getPlayerWithID(id).toString();

        View.printMessage(playerInfo);

        View.printMessage("\nY/y to go back: ");

        while(!this.inputs.next().equals("Y") || !this.inputs.next().equals("y"))
        {
            View.printMessage("\nY/y to go back: ");
        }
    }

    private void managePlayer()
    {
        View.askPlayerID();
        String id = this.inputs.next();

        boolean end = true;

        while (end)
        {
            View.printMessage(this.model.getPlayerWithID(id).toString());

            View.ManagePlayer();
            int option = this.inputs.nextInt();

            switch(option)
            {
                case 1:
                    transferPlayer(id);
                    break;

                case 2:
                    updatePlayer(id);
                    break;

                case 3:
                    this.model.removePlayer(id);
                    View.printMessage("The player has been successfully deleted.");
                    end = false;
                    break;

                case 0:
                    end = false;
                    break;

                default:
                    View.printMessage("Your action could not be identified. Try again please.\n");
                    break;
            }
        }
    }

    private void transferPlayer(String pID)
    {
        View.askNewTeamName();
        String newTeam = this.inputs.next();

        String team = this.model.getPlayerWithID(pID).getCurrentTeamName();

        this.model.transferPlayer(pID,team,newTeam);

        View.printMessage("The player has been successfully transferred.");
    }

    private void updatePlayer(String pID)
    {
        boolean end = true;

        boolean isGoalkeeper = this.model.getPlayerWithID(pID).getCurPosition().equals(Position.GOALKEEPER);

        while (end)
        {
            View.printMessage(this.model.getPlayerWithID(pID).toString());
            View.AttributesMenu(isGoalkeeper);

            int attribute = this.inputs.nextInt();

            if(attribute != 0)
            {
                View.printMessage("Introduce new value: ");

                int newValue = this.inputs.nextInt();

                this.model.updatePlayer(pID,attribute,newValue); //TODO: function updatePlayer that takes an String with a player id
                //TODO: an int that represents an attribute(see view.player.AttributesMenu)
                //TODO: and a newValue and updates the said player's given attribute to the new value
            }
            else
            {
                end = false;
            }
        }

        View.printMessage("The player has been successfully updated.");
    }
}