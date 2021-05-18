package Controller;

import Model.*;
import View.View;

import java.io.Serializable;
import java.util.Scanner;

// TODO: see player history ??
public class PlayerMenuController implements Serializable
{
    private final Model model;
    private final Scanner inputs;

    public PlayerMenuController()
    {
        this.model = new Model();
        this.inputs = new Scanner(System.in);
    }

    public PlayerMenuController(Model model,Scanner inputs)
    {
        this.model = model;
        this.inputs = inputs;
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
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
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

    private void createPlayerController() throws InvalidPlayerException, InvalidPositionException
    {
        Player newPlayer;

        View.askPlayerID();
        String id = this.inputs.next();

        View.askPlayerName();
        String playerName = this.inputs.next();

        View.askPlayerNumber();
        int number = this.inputs.nextInt();

        View.askPlayerTeam();
        String teamName = this.inputs.next();

        View.askPlayerPosition();
        int playerPosition = this.inputs.nextInt();

        View.askAttributesMode();
        int attMode = this.inputs.nextInt();
        if(attMode == 1)
        {
            if(playerPosition == 1)
            {
                View.askPlayerElasticity();
                int elasticity = this.inputs.nextInt();

                View.askPlayerReflexes();
                int reflexes = this.inputs.nextInt();

                View.askPlayerAgility();
                int agility = this.inputs.nextInt();

                View.askPlayerDecisions();
                int decisions = this.inputs.nextInt();

                newPlayer = new GK(id,playerName,teamName,elasticity,reflexes,agility,decisions);
            }
            else
            {
                View.askPlayerVelocity();
                int velocity = this.inputs.nextInt();

                View.askPlayerEndurance();
                int endurance = this.inputs.nextInt();

                View.askPlayerSkill();
                int skill = this.inputs.nextInt();

                View.askPlayerImpulsion();
                int impulsion = this.inputs.nextInt();

                View.askPlayerHeading();
                int heading = this.inputs.nextInt();

                View.askPlayerFinishing();
                int finishing = this.inputs.nextInt();

                View.askPlayerPassing();
                int passing = this.inputs.nextInt();

                View.askPlayerCrossing();
                int crossing = this.inputs.nextInt();

                View.askPlayerBallRecovery();
                int ballRecovery = this.inputs.nextInt();

                View.askPlayerPositioning();
                int positioning = this.inputs.nextInt();

                View.askPlayerCreativity();
                int creativity = this.inputs.nextInt();

                View.askPlayerAggressiveness();
                int aggressiveness = this.inputs.nextInt();

                View.askPlayerTackling();
                int tackling = this.inputs.nextInt();

                View.askPlayerVision();
                int vision = this.inputs.nextInt();

                switch(playerPosition)
                {
                    case 2:
                        newPlayer = new DF(id,playerName,teamName,velocity,endurance,skill,impulsion,heading,finishing,
                                passing,crossing,ballRecovery,positioning,creativity,aggressiveness,tackling,vision,Position.DEFENDER);
                        break;

                    case 3:
                        newPlayer = new WG(id,playerName,teamName,velocity,endurance,skill,impulsion,heading,finishing,
                                passing,crossing,ballRecovery,positioning,creativity,aggressiveness,tackling,vision,Position.WINGER);
                        break;

                    case 4:
                        newPlayer = new MD(id,playerName,teamName,velocity,endurance,skill,impulsion,heading,finishing,
                                passing,crossing,ballRecovery,positioning,creativity,aggressiveness,tackling,vision,Position.MIDFIELDER);
                        break;

                    case 5:
                        newPlayer = new FW(id,playerName,teamName,velocity,endurance,skill,impulsion,heading,finishing,
                                passing,crossing,ballRecovery,positioning,creativity,aggressiveness,tackling,vision,Position.FORWARD);
                        break;

                    default:
                        throw new InvalidPositionException("The position you selected does not exist");
                        break;
                }
            }
        }
        else
        {
            switch(playerPosition)
            {
                case 1:
                    newPlayer = new GK(id,playerName,teamName); // TODO: create goalkeeper constructor that does not require a list/set for historic
                    break;

                case 2:
                    newPlayer = new DF(id,playerName,teamName);
                    break;

                case 3:
                    newPlayer = new WG(id,playerName,teamName);
                    break;

                case 4:
                    newPlayer = new MD(id,playerName,teamName);
                    break;

                case 5:
                    newPlayer = new FW(id,playerName,teamName);
                    break;

                default:
                    throw new InvalidPositionException("The position you selected does not exist");
                    break;
            }
        }

        try
        {
            this.model.addPlayer(newPlayer);
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }

        View.printSuccessfulCreatedPlayer();

        View.printMessage("\nY/y to go back: ");

        while(!this.inputs.next().equals("Y") || !this.inputs.next().equals("y"))
        {
            View.printMessage("\nY/y to go back: ");
        }
    }

    private void seeAllPlayers()
    {
        String[] args = this.model.getPlayersAsStringArray();

        View.printAllPlayers(args);

        View.printMessage("\nY/y to go back: ");

        while(!this.inputs.next().equals("Y") || !this.inputs.next().equals("y"))
        {
            View.printMessage("\nY/y to go back: ");
        }
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
                    View.printMessage("\nY/y to go back: ");

                    while(!this.inputs.next().equals("Y") || !this.inputs.next().equals("y"))
                    {
                        View.printMessage("\nY/y to go back: ");
                    }
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

        View.printMessage("\nY/y to go back: ");

        while(!this.inputs.next().equals("Y") || !this.inputs.next().equals("y"))
        {
            View.printMessage("\nY/y to go back: ");
        }
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

        View.printMessage("\nY/y to go back: ");

        while(!this.inputs.next().equals("Y") || !this.inputs.next().equals("y"))
        {
            View.printMessage("\nY/y to go back: ");
        }
    }
}