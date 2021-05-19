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

    private void createPlayerController() throws InvalidPositionException, PlayerAlreadyExistsException, InvalidTeamException {
        Player newPlayer;

        View.askPlayerID();
        String id = this.inputs.next();
        this.inputs.nextLine();

        View.askPlayerName();
        String playerName = this.inputs.next();
        playerName = playerName.concat(this.inputs.nextLine());

        View.askPlayerNumber();
        int number = this.inputs.nextInt();
        this.inputs.nextLine();

        View.askPlayerTeam();
        String teamName = this.inputs.next();
        teamName = teamName.concat(this.inputs.nextLine());

        View.askPlayerPosition();
        int playerPosition = this.inputs.nextInt();
        this.inputs.nextLine();

        View.askAttributesMode();
        int attMode = this.inputs.nextInt();
        this.inputs.nextLine();
        if(attMode == 2)
        {
            if(playerPosition == 1)
            {
                View.askPlayerElasticity();
                int elasticity = this.inputs.nextInt();
                this.inputs.nextLine();

                View.askPlayerReflexes();
                int reflexes = this.inputs.nextInt();
                this.inputs.nextLine();

                View.askPlayerAgility();
                int agility = this.inputs.nextInt();
                this.inputs.nextLine();

                View.askPlayerDecisions();
                int decisions = this.inputs.nextInt();
                this.inputs.nextLine();

                newPlayer = new GK(id,playerName,teamName,elasticity,reflexes,agility,decisions);
            }
            else
            {
                View.askPlayerVelocity();
                int velocity = this.inputs.nextInt();
                this.inputs.nextLine();

                View.askPlayerEndurance();
                int endurance = this.inputs.nextInt();
                this.inputs.nextLine();

                View.askPlayerSkill();
                int skill = this.inputs.nextInt();
                this.inputs.nextLine();

                View.askPlayerImpulsion();
                int impulsion = this.inputs.nextInt();
                this.inputs.nextLine();

                View.askPlayerHeading();
                int heading = this.inputs.nextInt();
                this.inputs.nextLine();

                View.askPlayerFinishing();
                int finishing = this.inputs.nextInt();
                this.inputs.nextLine();

                View.askPlayerPassing();
                int passing = this.inputs.nextInt();
                this.inputs.nextLine();

                View.askPlayerCrossing();
                int crossing = this.inputs.nextInt();
                this.inputs.nextLine();

                View.askPlayerBallRecovery();
                int ballRecovery = this.inputs.nextInt();
                this.inputs.nextLine();

                View.askPlayerPositioning();
                int positioning = this.inputs.nextInt();
                this.inputs.nextLine();

                View.askPlayerCreativity();
                int creativity = this.inputs.nextInt();
                this.inputs.nextLine();

                View.askPlayerAggressiveness();
                int aggressiveness = this.inputs.nextInt();
                this.inputs.nextLine();

                View.askPlayerTackling();
                int tackling = this.inputs.nextInt();
                this.inputs.nextLine();

                View.askPlayerVision();
                int vision = this.inputs.nextInt();
                this.inputs.nextLine();

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
                }
            }
        }
        else
        {
            switch(playerPosition)
            {
                case 1:
                    newPlayer = new GK(id,playerName,teamName);
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
            }
        }

        this.model.addPlayer(newPlayer);

        View.printSuccessfulCreatedPlayer();

        boolean go = true;

        while(go)
        {
            View.printMessage("\nY/y to go back: ");
            String yes = this.inputs.next();
            this.inputs.nextLine();

            if(yes.equals("Y") || yes.equals("y")) go = false;
        }
    }

    private void seeAllPlayers()
    {
        String[] args = this.model.getPlayersAsStringArray();

        View.printAllPlayers(args);

        boolean go = true;

        while(go)
        {
            View.printMessage("\nY/y to go back: ");
            String yes = this.inputs.next();
            this.inputs.nextLine();

            if(yes.equals("Y") || yes.equals("y")) go = false;
        }
    }

    private void seePlayer()
    {
        View.askPlayerID();
        String id = this.inputs.next();
        this.inputs.nextLine();

        String playerInfo = this.model.getPlayerWithID(id).toString();

        View.printMessage(playerInfo);

        boolean go = true;

        while(go)
        {
            View.printMessage("\nY/y to go back: ");
            String yes = this.inputs.next();
            this.inputs.nextLine();

            if(yes.equals("Y") || yes.equals("y")) go = false;
        }
    }

    private void managePlayer()
    {
        View.askPlayerID();
        String id = this.inputs.next();
        this.inputs.nextLine();

        boolean end = true;

        while (end)
        {
            View.printMessage(this.model.getPlayerWithID(id).toString());

            View.ManagePlayer();
            int option = this.inputs.nextInt();
            this.inputs.nextLine();


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
                    boolean go = true;

                    while(go)
                    {
                        View.printMessage("\nY/y to go back: ");
                        String yes = this.inputs.next();
                        this.inputs.nextLine();

                        if(yes.equals("Y") || yes.equals("y")) go = false;
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
        this.inputs.nextLine();

        String team = this.model.getPlayerWithID(pID).getCurrentTeamName();

        this.model.transferPlayer(pID,team,newTeam);

        View.printMessage("The player has been successfully transferred.");

        boolean go = true;

        while(go)
        {
            View.printMessage("\nY/y to go back: ");
            String yes = this.inputs.next();

            if(yes.equals("Y") || yes.equals("y")) go = false;
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
            this.inputs.nextLine();

            if(attribute != 0)
            {
                View.printMessage("Introduce new value: ");

                int newValue = this.inputs.nextInt();
                this.inputs.nextLine();

                try
                {
                    this.model.updatePlayer(pID, attribute, newValue);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                end = false;
            }
        }

        View.printMessage("The player has been successfully updated.");

        boolean go = true;

        while(go)
        {
            View.printMessage("\nY/y to go back: ");
            String yes = this.inputs.next();
            this.inputs.nextLine();

            if(yes.equals("Y") || yes.equals("y")) go = false;
        }
    }
}