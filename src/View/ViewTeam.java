package View;

import java.io.Serializable;

public final class ViewTeam implements Serializable
{
    public static void printTeamMenu()
    {
        String[] teamMenuArgs = new String[]{"Create new team.", "See all teams.", "Look team information with ID.", "Manage team through ID."};
        Outputs.printMenu(teamMenuArgs, "Team Menu", false);
    }

    public static void printSuccessfulCreatedTeam() {
        System.out.println("Your team has been successfully created.");
    }

    public static void printRequestedTeamInvalid() {
        System.out.println("The team you requested does not exist.");
    }

    public static void askTeamID() {
        System.out.println("Introduce team ID: ");
    }
}
