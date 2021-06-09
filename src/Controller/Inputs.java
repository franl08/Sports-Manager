package Controller;

import View.View;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;


public final class Inputs implements Serializable
{
    public static int askForPlayerNumber(Scanner inputs, String[] args, String param)
    {
        View.clear();
        boolean isValidInput = true;
        int result = 0;

        while(isValidInput)
        {
            View.printMessage("\n");
            View.printTeamAvailableNumbers(args);
            View.printMessage("\n");
            View.askParam(param, false);

            try
            {
                result = inputs.nextInt();
                inputs.nextLine();

                try
                {
                    contains(result, args);
                    isValidInput = false;
                }
                catch (ValueOutofBoundsException e)
                {
                    View.clear();
                    View.printMessage(e.getMessage());
                    inputs.nextLine();
                }
            }
            catch(InputMismatchException e)
            {
                View.clear();
                View.printMessage("\nInvalid input. The program is expecting a Integer value.");
                inputs.nextLine();
            }
        }

        return result;
    }

    public static int askForInt(Scanner inputs, int lower_limit, int upper_limit, String param, boolean isGoalkeeper)
    {
        View.clear();
        boolean isValidInput = true;
        int result = 0;

        while(isValidInput)
        {
            View.printMessage("\n");
            View.askParam(param, isGoalkeeper);

            try
            {
                result = inputs.nextInt();
                inputs.nextLine();

                try
                {
                    inBounds(result, lower_limit, upper_limit);
                    isValidInput = false;
                }
                catch (ValueOutofBoundsException e)
                {
                    View.clear();
                    View.printMessage(e.getMessage());
                    inputs.nextLine();
                }
            }
            catch(InputMismatchException e)
            {
                View.clear();
                View.printMessage("\nInvalid input. The program is expecting a Integer value.");
                inputs.nextLine();
            }
        }

        return result;
    }

    public static String askForStringInput(Scanner inputs, String param)
    {
        View.clear();
        boolean isValidInput = false;
        String result = "";

        while(!isValidInput)
        {
            View.printMessage("\n");
            View.askParam(param, false);

            try
            {
                result = inputs.next();
                result = result.concat(inputs.nextLine());

                try
                {
                    isAlphaSpace(result);
                    isValidInput = true;
                }
                catch (ValueOutofBoundsException e)
                {
                    View.clear();
                    View.printMessage(e.getMessage());
                }
            }
            catch(InputMismatchException e)
            {
                View.clear();
                View.printMessage("\nInvalid input. The program is expecting a String value.");
                inputs.nextLine();
            }
        }

        return result;
    }

    private static void isAlphaSpace(String str) throws ValueOutofBoundsException
    {
        char[] aux = str.toCharArray();

        for(char c : aux)
        {
            if(!Character.isLetter(c) && c != ' ' && c != '.') throw new ValueOutofBoundsException("Expected a string without non-letters.");
        }
    }

    private static void inBounds(int x, int lower_limit, int upper_limit) throws ValueOutofBoundsException
    {
        if(lower_limit != -1 && (x < lower_limit || x > upper_limit)) throw new ValueOutofBoundsException("Expected value between " + lower_limit + " and " + upper_limit + ".");
    }

    private static void contains(int number, String[] args) throws ValueOutofBoundsException
    {
        String num = String.valueOf(number);
        boolean available = false;

        for(String s: args)
        {
            if (s.equals(num)) {
                available = true;
                break;
            }
        }

        if(!available) throw new ValueOutofBoundsException("Number is not available in the team.");
    }
}
