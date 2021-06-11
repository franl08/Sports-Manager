package Controller;

import Model.*;
import View.View;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class GameMenuController implements Serializable
{
    private Model model;
    private Scanner inputs;

    public GameMenuController()
    {
        this.model = new Model();
        this.inputs = new Scanner(System.in);
    }

    public GameMenuController(Model model, Scanner inputs)
    {
        this.model = model;
        this.inputs = inputs;
    }

    public void runGameMenu()
    {
        boolean returnFlag = true;

        while(returnFlag)
        {
            View.GameMenu();
            int option = this.inputs.nextInt();

            switch (option)
            {
                case 1:
                    runGame();
                    break;

                case 2:
                    loadGame();
                    break;

                case 0:
                    returnFlag = false;
                    break;

                default:
                    View.printMessage("Your action could not be identified. Try again please.\n");
                    break;
            }
        }
    }

    //TODO
    private void runGame()
    {
        // Home team def.

        String homeTeam = Inputs.askForStringInput(this.inputs, "home_team");

        int homeTactic = Inputs.askForInt(this.inputs, 1, 2, "home_team_tactics", false);

        int[] home_players_num;

        if(homeTactic == 1)
        {
            home_players_num = new int[]{1,4,4,2};
        }
        else home_players_num = new int[]{1,4,3,3};

        Set<Integer> home_players = new HashSet<>();

        for(int gk_num = 0; gk_num < home_players_num[0]; gk_num++)
        {
            int gk = choosePlayer(homeTeam,"GK", home_players);
            this.model.setPlayerPositionForGame(homeTeam, gk, 0);
            home_players.add(gk);
        }

        for(int wg_num = 0; wg_num < 2; wg_num++)
        {
            int wg = choosePlayer(homeTeam,"WG", home_players);
            this.model.setPlayerPositionForGame(homeTeam, wg, 2);
            home_players.add(wg);
        }

        for(int df_num = 0; df_num < home_players_num[1] - 2; df_num++)
        {
            int df = choosePlayer(homeTeam,"DF", home_players);
            this.model.setPlayerPositionForGame(homeTeam, df, 1);
            home_players.add(df);
        }

        for(int md_num = 0; md_num < home_players_num[2]; md_num++)
        {
            int md = choosePlayer(homeTeam,"MD", home_players);
            this.model.setPlayerPositionForGame(homeTeam, md, 3);
            home_players.add(md);
        }

        for(int fw_num = 0; fw_num < home_players_num[3]; fw_num++)
        {
            int fw = choosePlayer(homeTeam,"FW", home_players);
            this.model.setPlayerPositionForGame(homeTeam, fw, 4);
            home_players.add(fw);
        }

        // Away team def.

        String awayTeam = Inputs.askForStringInput(this.inputs, "away_team");

        int awayTactic = Inputs.askForInt(this.inputs, 1, 2, "away_team_tactics", false);

        int[] away_players_num;

        if(awayTactic == 1)
        {
            away_players_num = new int[]{1,4,4,2};
        }
        else away_players_num = new int[]{1,4,3,3};

        Set<Integer> away_players = new HashSet<>();

        for(int gk_num = 0; gk_num < away_players_num[0]; gk_num++)
        {
            int gk = choosePlayer(awayTeam,"GK", away_players);
            this.model.setPlayerPositionForGame(awayTeam, gk, 0);
            away_players.add(gk);
        }

        for(int wg_num = 0; wg_num < 2; wg_num++)
        {
            int wg = choosePlayer(awayTeam,"WG", away_players);
            this.model.setPlayerPositionForGame(awayTeam, wg, 2);
            away_players.add(wg);
        }

        for(int df_num = 0; df_num < away_players_num[1] - 2; df_num++)
        {
            int df = choosePlayer(awayTeam,"DF", away_players);
            this.model.setPlayerPositionForGame(awayTeam, df, 1);
            away_players.add(df);
        }

        for(int md_num = 0; md_num < away_players_num[2]; md_num++)
        {
            int md = choosePlayer(awayTeam,"MD", away_players);
            this.model.setPlayerPositionForGame(awayTeam, md, 3);
            away_players.add(md);
        }

        for(int fw_num = 0; fw_num < away_players_num[3]; fw_num++)
        {
            int fw = choosePlayer(awayTeam,"FW", away_players);
            this.model.setPlayerPositionForGame(awayTeam, fw, 4);
            away_players.add(fw);
        }

        Game new_game = new Game(this.model.getTeamWithName(homeTeam), this.model.getTeamWithName(awayTeam), home_players, away_players);

        StringBuilder sb = new StringBuilder();

        View.clear();
        sb.append(new_game.getInitialGameConditions());
        sb.append("\n");

        while(new_game.getTimer() < 90)
        {
            sb.append(new_game.advancePartInGame(2, 90));
        }

        sb.append("\n");
        sb.append(new_game.finalGameMessage());

        View.printMessage(sb.toString());

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

    private int choosePlayer(String team_name, String position, Set<Integer> home_players)
    {
        int result = 0;
        Set<Integer> players_num;
        boolean done = false;

        switch(position)
        {
            case("GK"):
                View.clear();

                players_num = this.model.getPlayersNum(this.model.getTeamGK(team_name));

                while(!done)
                {
                    View.printMessage("\n");
                    View.printAllTeamPos(this.model.getTeamGKAsStringArray(team_name), "goalkeeper");

                    try
                    {
                        result = this.inputs.nextInt();
                        this.inputs.nextLine();

                        try
                        {
                            contains(result, home_players);
                            notContains(result, players_num);
                            done = true;
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
                        View.printMessage("\nInvalid input. The program is expecting a Integer value.");
                        inputs.nextLine();
                    }
                }
                break;

            case("WG"):
                View.clear();

                players_num = this.model.getPlayersNum(this.model.getTeamWG(team_name));

                while(!done)
                {
                    View.printMessage("\n");
                    View.printAllTeamPos(this.model.getTeamWGAsStringArray(team_name), "winger");

                    try
                    {
                        result = this.inputs.nextInt();
                        this.inputs.nextLine();

                        try
                        {
                            contains(result, home_players);
                            notContains(result, players_num);
                            done = true;
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
                        View.printMessage("\nInvalid input. The program is expecting a Integer value.");
                        inputs.nextLine();
                    }
                }
                break;

            case("DF"):
                View.clear();

                players_num = this.model.getPlayersNum(this.model.getTeamExchangeable(team_name));

                while(!done)
                {
                    View.printMessage("\n");
                    View.printAllTeamPos(this.model.getTeamExchangeableAsStringArray(team_name), "defender");

                    try
                    {
                        result = this.inputs.nextInt();
                        this.inputs.nextLine();

                        try
                        {
                            contains(result, home_players);
                            notContains(result, players_num);
                            done = true;
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
                        View.printMessage("\nInvalid input. The program is expecting a Integer value.");
                        inputs.nextLine();
                    }
                }
                break;

            case("MD"):
                View.clear();

                players_num = this.model.getPlayersNum(this.model.getTeamExchangeable(team_name));

                while(!done)
                {
                    View.printMessage("\n");
                    View.printAllTeamPos(this.model.getTeamExchangeableAsStringArray(team_name), "midfielder");

                    try
                    {
                        result = this.inputs.nextInt();
                        this.inputs.nextLine();

                        try
                        {
                            contains(result, home_players);
                            notContains(result, players_num);
                            done = true;
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
                        View.printMessage("\nInvalid input. The program is expecting a Integer value.");
                        inputs.nextLine();
                    }
                }
                break;

            case("FW"):
                View.clear();

                players_num = this.model.getPlayersNum(this.model.getTeamExchangeable(team_name));

                while(!done)
                {
                    View.printMessage("\n");
                    View.printAllTeamPos(this.model.getTeamExchangeableAsStringArray(team_name), "forward");

                    try
                    {
                        result = this.inputs.nextInt();
                        this.inputs.nextLine();

                        try
                        {
                            contains(result, home_players);
                            notContains(result, players_num);
                            done = true;
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
                        View.printMessage("\nInvalid input. The program is expecting a Integer value.");
                        inputs.nextLine();
                    }
                }
                break;

            default:
                break;
        }

        return result;
    }

    private void contains(int x, Set<Integer> set) throws ValueOutofBoundsException
    {
        if(set.contains(x)) throw new ValueOutofBoundsException("The player you choose is already playing in a different position.");
    }

    private void notContains(int x, Set<Integer> set) throws ValueOutofBoundsException
    {
        if(!set.contains(x)) throw new ValueOutofBoundsException("The player you choose does not exist.");
    }

    private void loadGame()
    {

    }
}