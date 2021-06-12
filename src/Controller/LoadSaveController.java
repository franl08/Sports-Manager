package Controller;

import Model.Model;
import View.View;

import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

public class LoadSaveController implements Serializable
{
    private Model model;
    private Scanner inputs;

    public LoadSaveController(Model model, Scanner scanner)
    {
        this.model = model;
        this.inputs = scanner;
    }

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
            String filename = fileNames[option];

            try
            {
                this.model.readObject(filename);
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

    private void validOption(int option, int length) throws ValueOutofBoundsException
    {
        if(option < 0 || (length > 0 && option >= length)) throw new ValueOutofBoundsException("The filename you chose is invalid. Please try again.");
    }
}