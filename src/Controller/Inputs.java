package Controller;

import View.View;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;


public final class Inputs implements Serializable
{
    public static int askForIntOneToNNInput(Scanner inputs)
    {
        boolean isValidInput = true;
        int result = 0;

        while(isValidInput)
        {
            try
            {
                result = inputs.nextInt();
                inputs.nextLine();
                isValidInput = result <= 0 || result >= 100;

                if(isValidInput)
                {
                    View.clear();
                    View.printMessage("\nInvalid input " + result + ". The program is expecting a Integer value from 1 to 99. Please try again: ");
                }
            }
            catch(InputMismatchException e)
            {
                View.clear();
                View.printMessage("\nInvalid input. The program is expecting a Integer value. Please try again: ");
                inputs.nextLine();
            }
        }

        return result;
    }

    public static String askForStringInput(Scanner inputs)
    {
        boolean isValidInput = false;
        String result = "";

        while(!isValidInput)
        {
            try
            {
                result = inputs.next();
                result = result.concat(inputs.nextLine());
                isValidInput = isAlphaSpace(result);

                if(!isValidInput)
                {
                    View.clear();
                    View.printMessage("\nInvalid input \"" + result + "\". The program is expecting a String value with only letters. Please try again: ");
                }
            }
            catch(InputMismatchException e)
            {
                View.clear();
                View.printMessage("\nInvalid input. The program is expecting a String value. Please try again: ");
                inputs.nextLine();
            }
        }

        return result;
    }

    private static boolean isAlphaSpace(String str)
    {
        char[] aux = str.toCharArray();

        for(char c : aux)
        {
            if(!Character.isLetter(c) && c != ' ') return false;
        }

        return true;
    }

    public static int askForIntOneOrTwoInput(Scanner inputs) {
        boolean isValidInput = true;
        int result = 0;

        while (isValidInput) {
            try {
                result = inputs.nextInt();
                inputs.nextLine();
                isValidInput = result != 1 && result != 2;

                if (isValidInput) {
                    View.clear();
                    View.printMessage("\nInvalid input " + result + ". The program is expecting a Integer value that is either 1 or 2. Please try again: ");
                }
            } catch (InputMismatchException e) {
                View.clear();
                View.printMessage("\nInvalid input. The program is expecting a Integer value. Please try again: ");
                inputs.nextLine();
            }
        }

        return result;
    }

    public static int askForIntOneToFiveInput(Scanner inputs) {
        boolean isValidInput = true;
        int result = 0;

        while (isValidInput) {
            try {
                result = inputs.nextInt();
                inputs.nextLine();
                isValidInput = result < 1 || result > 5;

                if (isValidInput) {
                    View.clear();
                    View.printMessage("\nInvalid input " + result + ". The program is expecting a Integer value that from 1 to 5. Please try again.\n");
                }
            } catch (InputMismatchException e) {
                View.clear();
                View.printMessage("\nInvalid input. The program is expecting a Integer value. Please try again: ");
                inputs.nextLine();
            }
        }

        return result;
    }
}
