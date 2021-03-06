package Controller;

import Model.*;
import View.View;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Class that's in charge of controlling every aspect regarding players.
 */
public class PlayerMenuController implements Serializable
{
    /**
     * Model that holds all the information.
     */
    private final Model model;

    /**
     * Scanner that's in charge of taking in the user inputs.
     */
    private final Scanner inputs;

    /**
     * Parameterized constructor that receives a model and a scanner.
     * @param model Parameter that holds all the information.
     * @param inputs Parameter that's in charge of taking in the user inputs.
     */
    public PlayerMenuController(Model model,Scanner inputs)
    {
        this.model = model;
        this.inputs = inputs;
    }

    /**
     * Method that effectively runs the player controller and redirects the user's options to the respective method that will execute said option.
     */
    public void runPlayerMenu()
    {
        View.clear();
        boolean returnFlag = true;

        while(returnFlag)
        {
            View.clear();
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
                    seePlayerHistory();
                    break;

                case 5:
                    managePlayer();
                    break;

                case 0:
                    returnFlag = false;
                    View.clear();
                    break;

                default:
                    View.clear();
                    View.printMessage("Your action could not be identified. Try again please.\n");
                    break;
            }
        }
    }

    /**
     * Method that's in charge of creating a new player.
     * @throws InvalidPositionException Exception that handles an invalid position input.
     * @throws PlayerAlreadyExistsException Exception that handles the existence of another player with the same one as the input.
     * @throws InvalidTeamException Exception that handles the non-existence of the team to which said player is to be inserted.
     * @throws NumberAlreadyExistsInTeamException Exception that handles the occupancy of the number in the team of the input.
     */
    private void createPlayerController() throws InvalidPositionException, PlayerAlreadyExistsException, InvalidTeamException, NumberAlreadyExistsInTeamException {
        Player newPlayer;

        String playerName = Inputs.askForStringInput(this.inputs, "player_name");

        String teamName = Inputs.askForStringInput(this.inputs, "player_team");

        int number = Inputs.askForPlayerNumber(this.inputs, this.model.availableNumbersAsString(teamName), "player_number");

        int playerPosition = Inputs.askForInt(this.inputs, 1, 5, "player_position", false);

        int attMode = Inputs.askForInt(this.inputs, 1, 2, "attributes_mode", false);

        if(attMode == 2)
        {
            if(playerPosition == 1)
            {
                int elasticity = Inputs.askForInt(this.inputs, 1, 99, "player_elasticity", false);

                int reflexes = Inputs.askForInt(this.inputs, 1, 99, "player_reflexes", false);

                int agility = Inputs.askForInt(this.inputs, 1, 99, "player_agility", false);

                int decisions = Inputs.askForInt(this.inputs, 1, 99, "player_decisions", false);

                int velocity = Inputs.askForInt(this.inputs, 1, 99, "player_velocity", false);

                int passing = Inputs.askForInt(this.inputs, 1, 99, "player_passing", false);

                int courage = Inputs.askForInt(this.inputs, 1, 99, "player_courage", false);

                int endurance = Inputs.askForInt(this.inputs, 1, 99, "player_endurance", false);

                newPlayer = new GK(playerName,number,teamName,elasticity,reflexes,agility,decisions,velocity,passing,courage,endurance);
                this.model.getTeams().get(teamName).addPlayer(newPlayer);
            }
            else
            {
                int velocity = Inputs.askForInt(this.inputs, 1, 99, "player_velocity",false);

                int endurance = Inputs.askForInt(this.inputs, 1, 99, "player_endurance",false);

                int skill = Inputs.askForInt(this.inputs, 1, 99, "player_skill",false);

                int impulsion = Inputs.askForInt(this.inputs, 1, 99, "player_impulsion",false);

                int heading = Inputs.askForInt(this.inputs, 1, 99, "player_heading",false);

                int finishing = Inputs.askForInt(this.inputs, 1, 99, "player_finishing",false);

                int passing = Inputs.askForInt(this.inputs, 1, 99, "player_passing",false);

                int crossing = Inputs.askForInt(this.inputs, 1, 99, "player_crossing",false);

                int ballRecovery = Inputs.askForInt(this.inputs, 1, 99, "player_ball_recovery",false);

                int positioning = Inputs.askForInt(this.inputs, 1, 99, "player_positioning",false);

                int creativity = Inputs.askForInt(this.inputs, 1, 99, "player_creativity",false);

                int aggressiveness = Inputs.askForInt(this.inputs, 1, 99, "player_aggressiveness",false);

                int tackling = Inputs.askForInt(this.inputs, 1, 99, "player_tackling",false);

                int vision = Inputs.askForInt(this.inputs, 1, 99, "player_vision",false);

                switch(playerPosition)
                {
                    case 2:
                        newPlayer = new DF(playerName,number,teamName,velocity,endurance,skill,impulsion,heading,finishing,
                                passing,crossing,ballRecovery,positioning,creativity,aggressiveness,tackling,vision,Position.DEFENDER);
                        this.model.getTeams().get(teamName).addPlayer(newPlayer);
                        break;

                    case 3:
                        newPlayer = new WG(playerName,number,teamName,velocity,endurance,skill,impulsion,heading,finishing,
                                passing,crossing,ballRecovery,positioning,creativity,aggressiveness,tackling,vision,Position.WINGER);
                        this.model.getTeams().get(teamName).addPlayer(newPlayer);
                        break;

                    case 4:
                        newPlayer = new MD(playerName,number,teamName,velocity,endurance,skill,impulsion,heading,finishing,
                                passing,crossing,ballRecovery,positioning,creativity,aggressiveness,tackling,vision,Position.MIDFIELDER);
                        this.model.getTeams().get(teamName).addPlayer(newPlayer);
                        break;

                    case 5:
                        newPlayer = new FW(playerName,number,teamName,velocity,endurance,skill,impulsion,heading,finishing,
                                passing,crossing,ballRecovery,positioning,creativity,aggressiveness,tackling,vision,Position.FORWARD);
                        this.model.getTeams().get(teamName).addPlayer(newPlayer);
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
                    this.model.getTeams().get(teamName).addPlayer(newPlayer);
                    break;

                case 2:
                    newPlayer = new DF(playerName,number,teamName);
                    this.model.getTeams().get(teamName).addPlayer(newPlayer);
                    break;

                case 3:
                    newPlayer = new WG(playerName,number,teamName);
                    this.model.getTeams().get(teamName).addPlayer(newPlayer);
                    break;

                case 4:
                    newPlayer = new MD(playerName,number,teamName);
                    this.model.getTeams().get(teamName).addPlayer(newPlayer);
                    break;

                case 5:
                    newPlayer = new FW(playerName,number,teamName);
                    this.model.getTeams().get(teamName).addPlayer(newPlayer);
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

    /**
     * Method that's in charge of showing the user a table like presentation of all the players currently in the system.
     */
    private void seeAllPlayers()
    {
        String[] args = this.model.getPlayersAsStringArray();

        View.printAllPlayers(args);

        Inputs.next(this.inputs);
    }

    /**
     * Method that's in charge of showing the user the basic information of a requested player searching by its name.
     */
    private void seePlayer()
    {
        String playerName = Inputs.askForStringInput(this.inputs, "player_name");

        String playerInfo = this.model.getPlayerWithName(playerName).toString();

        View.printMessage(playerInfo);

        Inputs.next(this.inputs);
    }

    /**
     * Method that's in charge of showing the user the team history of a requested player searching by its name.
     */
    private void seePlayerHistory()
    {
        String playerName = Inputs.askForStringInput(this.inputs, "player_name");

        String[] playerHistory = this.model.getPlayerHistoryAsStringArray(playerName);

        View.clear();
        View.printAllTeams(playerHistory);

        Inputs.next(this.inputs);
    }

    /**
     * Method that's in charge of allowing the user to manage a player (i.e. transfer, updating).
     */
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
                    Inputs.next(this.inputs);
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

    /**
     * Method that's in charge of allowing the user to transfer a player to another team.
     * @param playerName The name of the player that is to be transferred.
     */
    private void transferPlayer(String playerName)
    {
        String newTeam = Inputs.askForStringInput(this.inputs, "new_team_name");

        String team = this.model.getPlayerWithName(playerName).getCurrentTeamName();

        int newNumber = Inputs.askForPlayerNumber(this.inputs, this.model.availableNumbersAsString(newTeam), "player_number");

        this.model.transferPlayer(playerName,team,newTeam, newNumber);

        View.printMessage("The player has been successfully transferred.");

        Inputs.next(this.inputs);
    }

    /**
     * Method that's in charge of allowing the user to update a player to another team.
     * @param playerName The name of the player that is to be transferred.
     */
    private void updatePlayer(String playerName)
    {
        boolean end = true;

        boolean isGoalkeeper = this.model.getPlayerWithName(playerName).getCurPosition().equals(Position.GOALKEEPER);

        while (end)
        {
            int attribute;

            if(isGoalkeeper) attribute = Inputs.askForInt(this.inputs, 0, 8, "player_attributes",true);

            else attribute = Inputs.askForInt(this.inputs, 0, 15, "player_attributes",false);

            if(attribute != 0)
            {
                int newValue = Inputs.askForInt(this.inputs, 1, 99, "player_attributes_value",false);

                try
                {
                    this.model.updatePlayer(playerName, attribute, newValue);
                }
                catch (Exception e)
                {
                    View.printMessage(e.getMessage());
                }
            }
            else
            {
                end = false;
            }
        }

        View.printMessage("The player has been successfully updated.");

        Inputs.next(this.inputs);
    }
}