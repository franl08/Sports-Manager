package View;

import java.io.Serializable;

public final class ViewTeam implements Serializable
{
    public static void printTeamMenu()
    {
        String[] teamMenuArgs = new String[]{"Create new team.", "See all teams.", "See team players.", "See team history.","Delete team through name."};
        Outputs.printMenu(teamMenuArgs, "Team Menu", false);
    }

    public static void printSuccessfulCreatedTeam()
    {
        System.out.println("Your team has been successfully created.");
    }

    public static void printSuccessfulDeletedTeam()
    {
        System.out.println("Your team has been successfully deleted.");
    }

    public static void askTeamName()
    {
        Outputs.showMessage("Introduce team name: ");
    }

    public static void askNewTeamName() {
        Outputs.showMessage("Introduce new team name: ");
    }

    public static void printAllTeams(String[] allTeams)
    {
        String[] headArgs = new String[] {"Team Name"};
        Outputs.printStringArrayAsTable(allTeams, headArgs);
    }

    public static void printTeamPlayers(String[] teamPlayer)
    {
        String[] headArgs = new String[] {"Player Name","Player Number","Player Overall","Player Position"};
        Outputs.printStringArrayAsTable(teamPlayer, headArgs);
    }

    public static void printTeamHistory(String[] teamHistory)
    {
        String[] headArgs = new String[] {"Date","Home Team","Away Team","Home Team Goals","Away Team Goals"};
        Outputs.printStringArrayAsTable(teamHistory, headArgs);
    }

    public static void printTeamAvailableNumbers(String[] numbers)
    {
        String[] headArgs = new String[] {"Available Numbers"};
        Outputs.printStringArrayAsTable(numbers, headArgs);
    }
}
