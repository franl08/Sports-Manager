package Controller;
import Model.*;
import View.*;

import java.util.Scanner;

/**
 * Class that links the entire program making it work.
 */
public class Controller
{
    /**
     * Model that holds all the information.
     */
    private Model model;

    /**
     * Scanner that's in charge of taking in the user inputs.
     */
    private Scanner inputs;

    /**
     * Controller that's in charge of handling player related actions.
     */
    private PlayerMenuController pmc;

    /**
     * Controller that's in charge of handling team related actions.
     */
    private TeamMenuController tmc;

    /**
     * Controller that's in charge of handling game related actions.
     */
    private GameMenuController gmc;

    /**
     * Controller that's in charge of handling the read of the logs.
     */
    private LoadFile lf;

    /**
     * Controller that's in charge of handling saving and loading the state of the program.
     */
    private LoadSaveController lsc;


    /**
     *  Empty constructor.
     */
    public Controller()
    {
        this.model = new Model();                                           // Creates a new model
        this.inputs = new Scanner(System.in);                               // Associates the STDIN to the ´inputs´ scanner

        this.pmc = new PlayerMenuController(this.model, this.inputs);       // Creates the player controller using the model and the scanner
        this.tmc = new TeamMenuController(this.model, this.inputs);         // Creates the team controller using the model and the scanner
        this.gmc = new GameMenuController(this.model, this.inputs);         // Creates the game controller using the model and the scanner

        this.lf = new LoadFile(this.model);                                 // Creates the logs controller using the model and the scanner

        this.lsc = new LoadSaveController(this.model, this.inputs);         // Creates the load/save controller using the model and the scanner
    }

    /**
     *  Function that effectively runs the program printing the main menu and asking the user what he wants to do.
     */
    public void run()
    {
        boolean exit = true;                                        // Controls whether the user wants to leave the program or not

        while(exit)
        {
            View.clear();
            View.MainMenu();                                        // Prints the main menu
            int option = this.inputs.nextInt();                     // Requests 1 of 7 possible user options:

            switch (option)
            {
                case 1:                                             // 1: Player option that redirects the user to the player controller
                    this.pmc.runPlayerMenu();
                    break;

                case 2:                                             // 2: Team option that redirects the user to the team controller
                    this.tmc.runTeamMenu();
                    break;

                case 3:                                             // 3: Game option that redirects the user to the game controller
                    this.gmc.runGameMenu();
                    break;

                case 4:                                             // 4: Read Logs option that reads the logs
                    try
                    {
                        this.lf.parse();
                    }
                    catch (Exception e)
                    {
                        View.printMessage(e.getMessage());
                    }
                    break;

                case 5:                                             // 5: Save/Load option that redirects the user to the load/save controller
                    this.lsc.run();
                    break;

                case 6:
                    this.model.resetModel();                        // 6: Reset Database option that resets the system
                    break;

                case 0:                                             // 0: Option that allows the user to leave the program
                    exit = false;
                    break;

                default:                                            // Default: Option to prevent program failure in case of mismatch input from user
                    View.printMessage("Your action could not be identified. Try again please.\n");
                    break;
            }
        }
    }
}