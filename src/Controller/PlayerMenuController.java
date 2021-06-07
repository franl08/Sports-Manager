package Controller;

import Model.*;
import View.View;

import java.io.Serializable;
import java.util.Scanner;
import java.util.Set;

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

        String playerName = Inputs.askForStringInput(this.inputs, "player_name");

        String teamName = Inputs.askForStringInput(this.inputs, "player_team");

        int number = Inputs.askForPlayerNumber(this.inputs, this.model.availableNumbersAsString(teamName), "player_number");

        int playerPosition = Inputs.askForInt(this.inputs, 1, 5, "player_position");

        int attMode = Inputs.askForInt(this.inputs, 1, 2, "attributes_mode");

        if(attMode == 2)
        {
            if(playerPosition == 1)
            {
                int elasticity = Inputs.askForInt(this.inputs, 1, 99, "player_elasticity");

                int reflexes = Inputs.askForInt(this.inputs, 1, 99, "player_reflexes");

                int agility = Inputs.askForInt(this.inputs, 1, 99, "player_agility");

                int decisions = Inputs.askForInt(this.inputs, 1, 99, "player_decisions");

                int velocity = Inputs.askForInt(this.inputs, 1, 99, "player_velocity");

                int passing = Inputs.askForInt(this.inputs, 1, 99, "player_passing");

                int courage = Inputs.askForInt(this.inputs, 1, 99, "player_courage");

                int endurance = Inputs.askForInt(this.inputs, 1, 99, "player_endurance");

                newPlayer = new GK(playerName,number,teamName,elasticity,reflexes,agility,decisions,velocity,passing,courage,endurance);
            }
            else
            {
                int velocity = Inputs.askForInt(this.inputs, 1, 99, "player_velocity");

                int endurance = Inputs.askForInt(this.inputs, 1, 99, "player_endurance");

                int skill = Inputs.askForInt(this.inputs, 1, 99, "player_skill");

                int impulsion = Inputs.askForInt(this.inputs, 1, 99, "player_impulsion");

                int heading = Inputs.askForInt(this.inputs, 1, 99, "player_heading");

                int finishing = Inputs.askForInt(this.inputs, 1, 99, "player_finishing");

                int passing = Inputs.askForInt(this.inputs, 1, 99, "player_passing");

                int crossing = Inputs.askForInt(this.inputs, 1, 99, "player_crossing");

                int ballRecovery = Inputs.askForInt(this.inputs, 1, 99, "player_ball_recovery");

                int positioning = Inputs.askForInt(this.inputs, 1, 99, "player_positioning");

                int creativity = Inputs.askForInt(this.inputs, 1, 99, "player_creativity");

                int aggressiveness = Inputs.askForInt(this.inputs, 1, 99, "player_aggressiveness");

                int tackling = Inputs.askForInt(this.inputs, 1, 99, "player_tackling");

                int vision = Inputs.askForInt(this.inputs, 1, 99, "player_vision");

                switch(playerPosition)
                {
                    case 2:
                        newPlayer = new DF(playerName,number,teamName,velocity,endurance,skill,impulsion,heading,finishing,
                                passing,crossing,ballRecovery,positioning,creativity,aggressiveness,tackling,vision,Position.DEFENDER);
                        break;

                    case 3:
                        newPlayer = new WG(playerName,number,teamName,velocity,endurance,skill,impulsion,heading,finishing,
                                passing,crossing,ballRecovery,positioning,creativity,aggressiveness,tackling,vision,Position.WINGER);
                        break;

                    case 4:
                        newPlayer = new MD(playerName,number,teamName,velocity,endurance,skill,impulsion,heading,finishing,
                                passing,crossing,ballRecovery,positioning,creativity,aggressiveness,tackling,vision,Position.MIDFIELDER);
                        break;

                    case 5:
                        newPlayer = new FW(playerName,number,teamName,velocity,endurance,skill,impulsion,heading,finishing,
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
                    newPlayer = new GK(playerName,number,teamName);
                    break;

                case 2:
                    newPlayer = new DF(playerName,number,teamName);
                    break;

                case 3:
                    newPlayer = new WG(playerName,number,teamName);
                    break;

                case 4:
                    newPlayer = new MD(playerName,number,teamName);
                    break;

                case 5:
                    newPlayer = new FW(playerName,number,teamName);
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

            View.clear();
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

            View.clear();
        }
    }

    private void seePlayer()
    {
        String playerName = Inputs.askForStringInput(this.inputs, "player_name");

        String playerInfo = this.model.getPlayerWithName(playerName).toString();

        View.printMessage(playerInfo);

        boolean go = true;

        while(go)
        {
            View.printMessage("\nY/y to go back: ");
            String yes = this.inputs.next();
            this.inputs.nextLine();

            if(yes.equals("Y") || yes.equals("y")) go = false;

            View.clear();
        }
    }

    private void managePlayer()
    {
        String playerName = Inputs.askForStringInput(this.inputs, "player_name");

        boolean end = true;

        while (end)
        {
            View.printMessage(this.model.getPlayerWithName(playerName).toString());

            View.ManagePlayer();
            int option = this.inputs.nextInt();
            this.inputs.nextLine();


            switch(option)
            {
                case 1:
                    transferPlayer(playerName);
                    break;

                case 2:
                    updatePlayer(playerName);
                    break;

                case 3:
                    this.model.removePlayer(playerName);
                    View.printMessage("The player has been successfully deleted.");
                    boolean go = true;

                    while(go)
                    {
                        View.printMessage("\nY/y to go back: ");
                        String yes = this.inputs.next();
                        this.inputs.nextLine();

                        if(yes.equals("Y") || yes.equals("y")) go = false;

                        View.clear();
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

    private void transferPlayer(String playerName)
    {
        View.askNewTeamName();
        String newTeam = this.inputs.next();
        this.inputs.nextLine();

        String team = this.model.getPlayerWithName(playerName).getCurrentTeamName();

        int newNumber = Inputs.askForPlayerNumber(this.inputs, this.model.availableNumbersAsString(newTeam), "player_number");

        this.model.transferPlayer(playerName,team,newTeam, newNumber);

        View.printMessage("The player has been successfully transferred.");

        boolean go = true;

        while(go)
        {
            View.printMessage("\nY/y to go back: ");
            String yes = this.inputs.next();

            if(yes.equals("Y") || yes.equals("y")) go = false;

            View.clear();
        }
    }

    private void updatePlayer(String playerName)
    {
        boolean end = true;

        boolean isGoalkeeper = this.model.getPlayerWithName(playerName).getCurPosition().equals(Position.GOALKEEPER);

        while (end)
        {
            View.printMessage(this.model.getPlayerWithName(playerName).toString());
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
                    this.model.updatePlayer(playerName, attribute, newValue);
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

            View.clear();
        }
    }
}