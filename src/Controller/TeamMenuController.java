package Controller;

import Model.*;
import View.View;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Class that's in charge of controlling every aspect regarding teams.
 */
public class TeamMenuController implements Serializable
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
    public TeamMenuController(Model model, Scanner inputs)
    {
        this.model = model;
        this.inputs = inputs;
    }

    /**
     * Method that effectively runs the team controller and redirects the user's options to the respective method that will execute said option.
     */
    public void runTeamMenu()
    {
        View.clear();
        boolean returnFlag = true;

        while(returnFlag)
        {
            View.clear();
            View.TeamMenu();
            int option = this.inputs.nextInt();
            this.inputs.nextLine();

            switch (option)
            {
                case 1:
                    createTeam();
                    break;

                case 2:
                    seeAllTeams();
                    break;

                case 3:
                    seeTeamPlayers();
                    break;

                case 4:
                    seeTeamHistory();
                    break;

                case 5:
                    deleteTeam();
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
     * Method that's in charge of creating a new team.
     */
    private void createTeam()
    {
        String teamName = Inputs.askForStringInput(this.inputs, "team_name");

        Team newTeam = new Team(teamName);

        try
        {
            this.model.addTeam(newTeam);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        View.printSuccessfulCreatedPlayer();

        Inputs.next(this.inputs);
    }

    /**
     * Method that's in charge of showing the user a table like presentation of all the teams currently in the system.
     */
    private void seeAllTeams()
    {
        String[] allTeams = this.model.getTeamsAsStringArray();

        View.printAllTeams(allTeams);

        Inputs.next(this.inputs);
    }

    /**
     * Method that's in charge of showing the user a table like presentation of all the players in a requested team.
     */
    private void seeTeamPlayers()
    {
        String teamName = Inputs.askForStringInput(this.inputs, "team_name");

        View.printTeamPlayers(this.model.getPlayersTeamAsStringArray(teamName));

        Inputs.next(this.inputs);
    }

    /**
     * Method that's in charge of showing the user a table like presentation of all the games played by a requested team.
     */
    private void seeTeamHistory()
    {
        String teamName = Inputs.askForStringInput(this.inputs, "team_name");

        View.printTeamHistory(this.model.getHistoryTeamAsStringArray(teamName));

        Inputs.next(this.inputs);
    }

    /**
     * Method that is in charge of deleting a requested team.
     */
    private void deleteTeam()
    {
        String teamName = Inputs.askForStringInput(this.inputs, "team_name");

        this.model.removeTeam(teamName);

        View.printSuccessfulDeletedTeam();

        Inputs.next(this.inputs);
    }
}
