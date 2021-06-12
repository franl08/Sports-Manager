package View;

import java.io.Serializable;

/**
 * Class that's responsible to present to the user Team related messages.
 */
public final class ViewTeam implements Serializable
{
    /**
     * Method that's in charge of printing the menu related to Teams.
     */
    public static void printTeamMenu()
    {
        String[] teamMenuArgs = new String[]{"Create new team.", "See all teams.", "See team players.", "See team history.","Delete team through name."};
        Outputs.printMenu(teamMenuArgs, "Team Menu", false);
    }

    /**
     * Method that prints a successful deleted team message.
     */
    public static void printSuccessfulDeletedTeam()
    {
        System.out.println("Your team has been successfully deleted.");
    }

    /**
     * Method that asks the team's name.
     */
    public static void askTeamName()
    {
        Outputs.showMessage("Introduce team name: ");
    }

    /**
     * Method that asks a new team's name (to transfer players).
     */
    public static void askNewTeamName() {
        Outputs.showMessage("Introduce new team name: ");
    }

    /**
     * Method that prints a table like structure of all the teams currently on the system.
     * @param allTeams Array of Strings of all teams information.
     */
    public static void printAllTeams(String[] allTeams)
    {
        String[] headArgs = new String[] {"Team Name", "Team Overall"};
        Outputs.printStringArrayAsTable(allTeams, headArgs);
    }

    /**
     * Method that prints a table like structure of all a team's players currently on the system.
     * @param teamPlayer Array of Strings of all team's players information.
     */
    public static void printTeamPlayers(String[] teamPlayer)
    {
        String[] headArgs = new String[] {"Player Name","Player Number","Player Overall","Player Position"};
        Outputs.printStringArrayAsTable(teamPlayer, headArgs);
    }

    /**
     * Method that prints a table like structure of the game history of a team.
     * @param teamHistory Array of Strings of all the team's games.
     */
    public static void printTeamHistory(String[] teamHistory)
    {
        String[] headArgs = new String[] {"Date","Home Team","Away Team","Home Team Goals","Away Team Goals"};
        Outputs.printStringArrayAsTable(teamHistory, headArgs);
    }

    /**
     * Method that prints a table like structure of the available numbers in a team.
     * @param numbers Array of Strings of all the team's available numbers.
     */
    public static void printTeamAvailableNumbers(String[] numbers)
    {
        String[] headArgs = new String[] {"Available Numbers"};
        Outputs.printStringArrayAsTable(numbers, headArgs);
    }
}
