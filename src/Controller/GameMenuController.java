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
        View.MeteorologyMenu();
        String meteorology = this.inputs.next();

        View.askGameDay();
        int day = this.inputs.nextInt();

        View.askGameMonth();
        int month = this.inputs.nextInt();

        View.askGameYear();
        int year = this.inputs.nextInt();

        LocalDate gameDay = LocalDate.of(year, month, day);

        View.askHomeTeamName();
        String homeTeam = this.inputs.next();

        View.TacticsMenu(homeTeam);
        int homeTactic = this.inputs.nextInt();


        View.askAwayTeamName();
        String awayTeam = this.inputs.next();
    }

    private void loadGame()
    {

    }
}
