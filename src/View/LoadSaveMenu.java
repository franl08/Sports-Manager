package View;

import java.io.Serializable;

/**
 * Class that's responsible to present to the user Load and Save related messages.
 */
public final class LoadSaveMenu implements Serializable
{
    /**
     * Method that's in charge of printing the menu related to Save and Load the state of the program.
     */
    public static void printLoadSaveMenu()
    {
        String[] LoadSaveArgs = new String[]{"Save.", "Load."};
        Outputs.printMenu(LoadSaveArgs, "Load/Save Menu", false);
    }

    /**
     * Method that asks he filename where the user wants to save.
     */
    public static void askForPathToSave()
    {
        Outputs.showMessage("Filename to save: ");
    }

    /**
     * Method that prints a table like structure with the name of all the filenames in a array of Strings.
     * @param fileNames String of filenames.
     */
    public static void printLoadFiles(String[] fileNames)
    {
        Outputs.printMenu(fileNames, "Filename", false);
    }
}
