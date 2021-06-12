package View;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Utility class to help showing outputs from the user.
 */
public final class Outputs implements Serializable
{
    /**
     * Method that clears the screen.
     */
    public static void clear()
    {
        for(int i = 0; i < 100; i++)
            System.out.println();
    }

    /**
     * Method that shows a message on the screen.
     * @param message Message to be shown.
     */
    public static void showMessage(String message)
    {
        System.out.print(message);
    }

    /**
     * Method that prints a table like menu with option. Option 0 is always related to exit or return.
     * @param menuArgs The different options available to the user in a array of Strings.
     * @param menuTitle The title of the menu.
     * @param isExit To assert whether it is the main menu or any other.
     */
    public static void printMenu(String[] menuArgs, String menuTitle, boolean isExit)
    {
        System.out.println();

        int length = menuTitle.length() + 10;

        for (String line : menuArgs)
        {
            length = Math.max(line.length() + 14, length);
        }

        Outputs.printLine('-', length+1);
        System.out.print("|");
        Outputs.printMenuTitle(menuTitle, length);
        System.out.println("|");
        int size = menuArgs.length;

        for(int i = 0; i < size; i++)
        {
            Outputs.printLine('-', length+1);
            System.out.print("| " + (i + 1) + ". " + menuArgs[i]);
            Outputs.printExcess(menuArgs[i].length(), length);
            System.out.println("|");
        }

        Outputs.printLine('-', length+1);

        if (isExit)
        {
            System.out.print("| 0. Exit.");
            Outputs.printExcess(5, length);
        }
        else
        {
            System.out.print("| 0. Return.");
            Outputs.printExcess(7, length);
        }

        System.out.println("|");
        Outputs.printLine('-', length+1);
        System.out.print("Choose an option: ");
    }

    /**
     * Method that prints a table like list with option.
     * @param menuArgs The different options available to the user in a array of Strings.
     * @param listTitle The title of the list.
     */
    public static void printOptionList(String[] menuArgs, String listTitle)
    {
        System.out.println();

        int length = listTitle.length() + 10;

        for (String line : menuArgs)
        {
            length = Math.max(line.length() + 14, length);
        }

        Outputs.printLine('-', length);
        System.out.print("|");
        Outputs.printMenuTitle(listTitle, length);
        System.out.println("|");
        int size = menuArgs.length;

        for(int i = 0; i < size; i++)
        {
            Outputs.printLine('-', length);
            System.out.print("| " + (i + 1) + ". " + menuArgs[i]);
            Outputs.printExcess(menuArgs[i].length(), length);
            System.out.println("|");
        }

        Outputs.printLine('-', length);

        System.out.print("\nChoose an option: ");
    }

    /**
     * Method that prints a table like list.
     * @param table The different information relevant to the user in a array of Strings.
     * @param headArgs The head of each column of the table.
     */
    public static void printStringArrayAsTable(String[] table, String[] headArgs)
    {
        int args = headArgs.length;

        int[] lengths = new int[args];
        for(int i = 0; i < args; i++)
        {
            lengths[i] = headArgs[i].length() + 10;
        }

        int lines = table.length/args;

        for(int i = 0; i < lines; i++)
        {
            for(int j = 0; j < args; j++)
            {
                lengths[j] = Math.max(table[i * args + j].length() + 10,lengths[j]);
            }
        }

        int lineLength = Arrays.stream(lengths).sum() + 1;

        System.out.println();

        Outputs.printLine('-', lineLength);

        for(int i = 0; i < args; i++)
        {
            System.out.print("|");
            Outputs.printMenuTitle(headArgs[i], lengths[i]);
        }

        System.out.println("|");

        for(int i = 0;i < lines; i++)
        {
            Outputs.printLine('-', lineLength);

            for(int j = 0; j < args; j++)
            {
                int spaces = lengths[j] - table[i * args + j].length() - 2;

                System.out.print("| " + table[i * args + j]);
                printSpaces(spaces);
            }

            System.out.println("|");
        }

        Outputs.printLine('-', lineLength);
    }

    /**
     * Method that prints a menu title atop a menu.
     * @param menuTitle Title of the menu.
     * @param length Length of the table (x axis).
     */
    private static void printMenuTitle(String menuTitle, int length)
    {
        int spaces = length - menuTitle.length() - 1;

        int correction = spaces % 2 == 0 ? 0 : 1;

        spaces /= 2;

        for(int i = 0; i < spaces + correction; i++)
            System.out.print(" ");

        System.out.print(menuTitle);

        for(int i = 0; i < spaces; ++i)
            System.out.print(" ");
    }

    /**
     * Method that prints a set number of a character.
     * @param length Number of characters to print.
     */
    private static void printLine(char c, int length)
    {
        for(int i = 0; i < length; i++)
            System.out.print(c);

        System.out.println();
    }

    /**
     * Method that prints a set number of spaces.
     * @param length Number of spaces to print.
     */
    private static void printSpaces(int length)
    {
        for(int i = 0; i < length; i++)
            System.out.print(" ");
    }

    /**
     * Method that prints the excess on a table.
     * @param strLength Length of the information that is to be present on that space of the table.
     * @param length Length of that portion of the table (x axis).
     */
    private static void printExcess(int strLength, int length)
    {
        for(int i = strLength + 4; i < length - 1; i++)
            System.out.print(" ");
    }
}