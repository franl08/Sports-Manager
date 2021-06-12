package View;

import java.io.Serializable;

public final class LoadSaveMenu implements Serializable
{
    public static void printLoadSaveMenu()
    {
        String[] LoadSaveArgs = new String[]{"Save.", "Load."};
        Outputs.printMenu(LoadSaveArgs, "Load/Save Menu", false);
    }

    public static void askForPathToSave()
    {
        Outputs.showMessage("Filename to save: ");
    }

    public static void printLoadFiles(String[] fileNames)
    {
        Outputs.printMenu(fileNames, "Filename", false);
    }
}
