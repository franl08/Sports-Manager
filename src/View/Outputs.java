package View;

import java.io.Serializable;
import java.util.Arrays;

public final class Outputs implements Serializable
{
    public static void clear()
    {
        for(int i = 0; i < 10; i++)
            System.out.println();
    }

    public static void showMessage(String message)
    {
        System.out.print(message);
    }

    public static void printMenu(String[] menuArgs, String menuTitle, boolean isExit)
    {
        System.out.println();

        int length = menuTitle.length() + 10;

        for (String line : menuArgs)
        {
            length = Math.max(line.length() + 14, length);
        }

        Outputs.printLine('-', length);
        System.out.print("|");
        Outputs.printMenuTitle(menuTitle, length);
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
        Outputs.printLine('-', length);
        System.out.print("Choose an option: ");
    }

    public static void printMatrix(char[][] matrix, int lines)
    {
        for(int i = 0; i < lines; i++)
        {
            System.out.println(matrix[i]);
        }
    }

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

    private static void printLine(char c, int length)
    {
        for(int i = 0; i < length; i++)
            System.out.print(c);

        System.out.println();
    }

    private static void printSpaces(int length)
    {
        for(int i = 0; i < length; i++)
            System.out.print(" ");
    }

    private static void printExcess(int strLength, int length)
    {
        for(int i = strLength + 4; i < length - 1; i++)
            System.out.print(" ");
    }
}