package Controller;

import Model.Model;
import View.View;

import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Class that's in charge of managing the saving and loading the state of the program.
 */
public class LoadSaveController implements Serializable
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
     * Parameterized constructor that receives a model and a scanner.
     * @param model Parameter that holds all the information.
     * @param scanner Parameter that's in charge of taking in the user inputs.
     */
    public LoadSaveController(Model model, Scanner scanner)
    {
        this.model = model;
        this.inputs = scanner;
    }

    /**
     * Method that effectively runs the load/save controller and redirects the user's options to the respective method that will execute said option.
     */
    public void run()
    {
        View.clear();
        boolean end = false;

        while(!end)
        {
            View.LoadSaveMenu();

            int option = this.inputs.nextInt();
            this.inputs.nextLine();

            switch (option)
            {
                case 1:
                    saveGame();
                    break;

                case 2:
                    loadGame();
                    break;

                case 0:
                    end = true;
                    break;

                default:
                    View.printMessage("Your action could not be identified. Try again please.\n");
                    break;
            }
        }
    }

    /**
     * Auxiliary method of method run that saves the state of the program to an .sm file.
     */
    private void saveGame()
    {
        View.clear();

        String filename = Inputs.askForStringInput(this.inputs,"file_to_save");

        try
        {
            this.model.saveObject(filename);
            View.clear();
            View.printMessage("File successfully saved.");
        }
        catch (Exception e)
        {
            View.clear();
            View.printMessage(e.getMessage());
        }

        boolean go = true;

        while(go)
        {
            View.printMessage("\nY/y to go back: ");
            String yes = this.inputs.next();
            this.inputs.nextLine();

            if(yes.equals("Y") || yes.equals("y")) go = false;

            View.clear();
        }
    }

    /**
     * Auxiliary method of method run that loads the state of the program from an .sm file.
     */
    private void loadGame()
    {
        File[] files = new File("saves/").listFiles();
        String[] fileNames;

        if(files != null)
        {
            fileNames = new String[files.length];
        }
        else fileNames = new String[0];

        for(int i = 0; i < fileNames.length; i++)
        {
            fileNames[i] = files[i].getName();
        }

        boolean valid = false;
        int option = -1;

        while(!valid)
        {
            View.clear();

            View.printLoadFiles(fileNames);

            option = this.inputs.nextInt();
            this.inputs.nextLine();

            try
            {
                validOption(option - 1, fileNames.length);
                valid = true;
            }
            catch (ValueOutofBoundsException e)
            {
                View.clear();
                View.printMessage(e.getMessage());
                this.inputs.nextLine();
            }
        }

        if(option != 0)
        {
            String filename = fileNames[option - 1];

            try
            {
                this.model.setModel(this.model.readObject(filename));
                View.clear();
                View.printMessage("File successfully loaded.");

            }
            catch (Exception e)
            {
                View.clear();
                View.printMessage(e.getMessage());
            }

            boolean go = true;

            while(go)
            {
                View.printMessage("\nY/y to go back: ");
                String yes = this.inputs.next();
                this.inputs.nextLine();

                if(yes.equals("Y") || yes.equals("y")) go = false;

                View.clear();
            }
        }
    }

    /**
     * Auxiliary method of method loadGame that evaluates if an integer is inbounds of the length of an array.
     * @param option Integer that is to be evaluated.
     * @param length Length of the array.
     * @throws ValueOutofBoundsException Exception that is thrown if said Integer is not inbounds of said array length.
     */
    private void validOption(int option, int length) throws ValueOutofBoundsException
    {
        if(option < 0 || (length > 0 && option >= length)) throw new ValueOutofBoundsException("The filename you chose is invalid. Please try again.");
    }
}