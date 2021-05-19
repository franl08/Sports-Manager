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
        this.inputs.nextLine();

        View.askTeamName();
        String teamName = this.inputs.next();
        teamName = teamName.concat(this.inputs.nextLine());

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

        boolean go = true;

        while(go)
        {
            View.printMessage("\nY/y to go back: ");
            String yes = this.inputs.next();
            this.inputs.nextLine();

            if(yes.equals("Y") || yes.equals("y")) go = false;
        }
    }

    private void seeAllTeams()
    {
        String[] allTeams = this.model.getTeamsAsStringArray();

        View.printAllTeams(allTeams);

        boolean go = true;

        while(go)
        {
            View.printMessage("\nY/y to go back: ");
            String yes = this.inputs.next();
            this.inputs.nextLine();

            if(yes.equals("Y") || yes.equals("y")) go = false;
        }
    }

    private void seeTeamPlayers()
    {
        View.askTeamName();
        String teamName = this.inputs.next();
        teamName = teamName.concat(this.inputs.nextLine());

        View.printTeamPlayers(this.model.getPlayersTeamAsStringArray(teamName));

        boolean go = true;

        while(go)
        {
            View.printMessage("\nY/y to go back: ");
            String yes = this.inputs.next();
            this.inputs.nextLine();

            if(yes.equals("Y") || yes.equals("y")) go = false;
        }
    }

    private void seeTeamHistory()
    {
        View.askTeamName();
        String teamName = this.inputs.next();
        teamName = teamName.concat(this.inputs.nextLine());

        View.printTeamHistory(this.model.getHistoryTeamAsStringArray(teamName));

        boolean go = true;

        while(go)
        {
            View.printMessage("\nY/y to go back: ");
            String yes = this.inputs.next();
            this.inputs.nextLine();

            if(yes.equals("Y") || yes.equals("y")) go = false;
        }
    }

    private void deleteTeam()
    {
        View.askTeamName();
        String teamName = this.inputs.next();
        teamName = teamName.concat(this.inputs.nextLine());

        this.model.removeTeam(teamName);

        View.printSuccessfulDeletedTeam();

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
