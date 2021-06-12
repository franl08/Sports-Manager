package Controller;

import View.View;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Utility class to help gathering inputs from the user.
 */
public final class Inputs implements Serializable
{
    /**
     * Method that's in charge of requesting a player number from the user.
     * @param inputs Scanner that is connected to the STDIN.
     * @param args Array with strings that are the available numbers for the user to pick.
     * @param param Name of the parameter that is to be asked to pass the View.
     * @return The chosen number.
     */
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

    /**
     * Method that's in charge of requesting a number that is to be between two limits from the user.
     * @param inputs Scanner that is connected to the STDIN.
     * @param lower_limit The lower limit for number that is to be chosen (In case of it being -1 the number has no limits).
     * @param upper_limit The upper limit for number that is to be chosen.
     * @param param Name of the parameter that is to be asked to pass the View.
     * @param isGoalkeeper Assertion if the said number is related to a goalkeeper (mostly when it comes to attributes is useful).
     * @return The chosen number.
     */
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

    /**
     * Method that's in charge of requesting a string that is to have no special characters except '.' from the user.
     * @param inputs Scanner that is connected to the STDIN.
     * @param param Name of the parameter that is to be asked to pass the View.
     * @return The chosen string.
     */
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

    /**
     * Auxiliary method that evaluates if a passed string has any special characters except '.'.
     * @param str String to be evaluated.
     * @throws ValueOutofBoundsException Thrown when the passed string has any special characters except '.'.
     */
    private static void isAlphaSpace(String str) throws ValueOutofBoundsException
    {
        char[] aux = str.toCharArray();

        for(char c : aux)
        {
            if(!Character.isLetter(c) && c != ' ' && c != '.') throw new ValueOutofBoundsException("Expected a string without non-letters.");
        }
    }

    /**
     * Auxiliary method that evaluates if a passed integer is within two limits.
     * @param x Integer to be evaluated.
     * @param lower_limit The lower limit.
     * @param upper_limit The upper limit.
     * @throws ValueOutofBoundsException Thrown when the passed integer is not inbounds (In case of lower_limit being -1 is not thrown).
     */
    private static void inBounds(int x, int lower_limit, int upper_limit) throws ValueOutofBoundsException
    {
        if(lower_limit != -1 && (x < lower_limit || x > upper_limit)) throw new ValueOutofBoundsException("Expected value between " + lower_limit + " and " + upper_limit + ".");
    }

    /**
     *  Auxiliary method that evaluates if a passed integer is within array of integers as strings.
     * @param number Number to be evaluated.
     * @param args Strings of integers.
     * @throws ValueOutofBoundsException Thrown when the passed integer is not in the passed array.
     */
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

    /**
     * Utils method used throughout the program to allow the user to see the result of some actions.
     * @param inputs Parameter that's in charge of taking in the user inputs.
     */
    public static void next(Scanner inputs)
    {
        boolean ok = true;

        while(ok)
        {
            View.printMessage("\nY/y to go back: ");
            String yes = inputs.next();
            inputs.nextLine();

            if(yes.equals("Y") || yes.equals("y")) ok = false;

            View.clear();
        }
    }
}