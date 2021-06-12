package Controller;
import Model.*;
import View.*;

import java.util.Scanner;

public class Controller
{
    private Model model;
    private Scanner inputs;

    private PlayerMenuController pmc;
    private TeamMenuController tmc;
    private GameMenuController gmc;
    private LoadFile lf;

    public Controller()
    {
        this.model = new Model();
        this.inputs = new Scanner(System.in);

        this.pmc = new PlayerMenuController(this.model, this.inputs);
        this.tmc = new TeamMenuController(this.model, this.inputs);
        this.gmc = new GameMenuController(this.model, this.inputs);

        this.lf = new LoadFile(this.model);
    }

    public Controller(Model m)
    {
        this.model = m;
    }

    public void run()
    {
        boolean exit = true;

        while(exit)
        {
            View.MainMenu();
            int option = this.inputs.nextInt();

            switch (option)
            {
                case 1:
                    this.pmc.runPlayerMenu();
                    break;

                case 2:
                    this.tmc.runTeamMenu();
                    break;

                case 3:
                    this.gmc.runGameMenu();
                    break;

                case 4:
                    try
                    {
                        this.lf.parse();
                    }
                    catch (Exception e)
                    {
                        View.printMessage(e.getMessage());
                    }
                    break;

                case 5:
                    break;

                case 6:
                    this.model.resetModel();
                    break;

                case 0:
                    exit = false;
                    break;

                default:
                    View.printMessage("Your action could not be identified. Try again please.\n");
                    break;
            }
        }
    }
}