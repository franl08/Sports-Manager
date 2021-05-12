package View;

import java.io.Serializable;

public class Outputs implements Serializable
{
    public void clear() {
    }

    public void printMenu(String[] menuArgs, String menuTitle, boolean isExit) {
        int length = menuTitle.length() + 10;

        for (String line : menuArgs)
        {
            length = Math.max(line.length() + 14, length);
        }

        this.printLine('-', length);
        System.out.print("|");
        this.printMenuTitle(menuTitle, length);
        System.out.println("|");
        int size = menuArgs.length;

        for(int i = 0; i < size; i++)
        {
            this.printLine('-', length);
            System.out.print("| " + (i + 1) + ". " + menuArgs[i]);
            this.printExcess(menuArgs[i].length(), length);
            System.out.println("|");
        }

        this.printLine('-', length);

        if (isExit)
        {
            System.out.print("| 0. Exit.");
            this.printExcess(5, length);
        }
        else
        {
            System.out.print("| 0. Return.");
            this.printExcess(7, length);
        }

        System.out.println("|");
        this.printLine('-', length);
        System.out.print("Choose an option: ");
    }

    public void printMatrix(char[][] matrix, int lines)
    {
        for(int i = 0; i < lines; i++)
        {
            System.out.println(matrix[i]);
        }
    }

    private void printMenuTitle(String menuTitle, int length)
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

    private void printLine(char c, int length)
    {
        for(int i = 0; i < length; i++)
            System.out.print(c);

        System.out.println();
    }

    private void printExcess(int strLength, int length)
    {
        for(int i = strLength + 4; i < length - 1; i++)
            System.out.print(" ");
    }
}