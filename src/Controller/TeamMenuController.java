package Controller;

import Model.*;
import View.View;

import java.io.Serializable;
import java.util.Scanner;

public class TeamMenuController implements Serializable
{
    private final Model model;
    private final Scanner inputs;

    public TeamMenuController()
    {
        this.model = new Model();
        this.inputs = new Scanner(System.in);
    }

    public TeamMenuController(Model model, Scanner inputs)
    {
        this.model = model;
        this.inputs = inputs;
    }

    public void runTeamMenu()
    {
        boolean returnFlag = true;

        while(returnFlag)
        {
            View.TeamMenu();
            int option = this.inputs.nextInt();

            switch (option)
            {
                case 1:
                    createTeam();
                    break;

                case 2:
                    seeAllTeams();
                    break;

                case 3:
                    seeTeam();
                    break;

                case 4:
                    deleteTeam();
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

    private void createTeam()
    {
        View.askTeamID();
        String id = this.inputs.next();

        View.askTeamName();
        String teamName = this.inputs.next();

        Team newTeam = new Team(id,teamName);

        try
        {
            this.model.addTeam(newTeam);
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

    private void seeAllTeams()
    {
        String[] allTeams = this.model.getTeamsAsStringArray();

        View.printAllTeams(allTeams);

        View.printMessage("\nY/y to go back: ");

        while(!this.inputs.next().equals("Y") || !this.inputs.next().equals("y"))
        {
            View.printMessage("\nY/y to go back: ");
        }
    }

    private void seeTeam()
    {
        View.askTeamName();
        String name = this.inputs.next();

        String teamInfo = this.model.getTeamWithName(name).toString();

        View.printMessage(teamInfo);

        View.printMessage("\nY/y to go back: ");

        while(!this.inputs.next().equals("Y") || !this.inputs.next().equals("y"))
        {
            View.printMessage("\nY/y to go back: ");
        }
    }

    private void deleteTeam()
    {
        View.askTeamName();
        String name = this.inputs.next();

        this.model.removeTeam(name);

        View.printSuccessfulDeletedTeam();

        View.printMessage("\nY/y to go back: ");

        while(!this.inputs.next().equals("Y") || !this.inputs.next().equals("y"))
        {
            View.printMessage("\nY/y to go back: ");
        }
    }
}
