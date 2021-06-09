package Controller;

import Model.*;
import View.View;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public class GameMenuController implements Serializable
{
    private Model model;
    private Scanner inputs;

    public GameMenuController()
    {
        this.model = new Model();
        this.inputs = new Scanner(System.in);
    }

    public GameMenuController(Model model, Scanner inputs)
    {
        this.model = model;
        this.inputs = inputs;
    }

    public void runGameMenu()
    {
        boolean returnFlag = true;

        while(returnFlag)
        {
            View.GameMenu();
            int option = this.inputs.nextInt();

            switch (option)
            {
                case 1:
                    runGame();
                    break;

                case 2:
                    loadGame();
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

    //TODO
    private void runGame()
    {
        int meteorology = Inputs.askForInt(this.inputs, 1, 5, "game_meteorology", false);

        int year = Inputs.askForInt(this.inputs, LocalDate.now().getYear(), LocalDate.MAX.getYear(), "game_day", false);

        boolean isLeapYear = isLeapYear(year);

        int month = Inputs.askForInt(this.inputs, LocalDate.now().getMonthValue(), 12, "game_month", false);

        int day;

        if(month == 2 && isLeapYear)
            day = Inputs.askForInt(this.inputs, LocalDate.now().getDayOfMonth(), 29, "game_day", false);

        else if(month == 2)
            day = Inputs.askForInt(this.inputs, LocalDate.now().getDayOfMonth(), 28, "game_day", false);

        else if(month == 4 || month == 6 || month == 9 || month == 11)
            day = Inputs.askForInt(this.inputs, LocalDate.now().getDayOfMonth(), 30, "game_day", false);

        else day = Inputs.askForInt(this.inputs, LocalDate.now().getDayOfMonth(), 31, "game_day", false);

        LocalDate gameDay = LocalDate.of(year, month, day);

        String homeTeam = Inputs.askForStringInput(this.inputs, "home_team");

        View.TacticsMenu(homeTeam);
        int homeTactic = this.inputs.nextInt();

        String awayTeam = Inputs.askForStringInput(this.inputs, "away_team");
    }

    private boolean isLeapYear(int year)
    {
        if(year % 400 == 0)
            return true;

        else return (year % 4 == 0) && (year % 100 == 0);
    }

    private void loadGame()
    {

    }
}
