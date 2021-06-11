package Controller;

import Model.*;
import View.View;

import java.io.Serializable;
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

                case 0:
                    returnFlag = false;
                    break;

                default:
                    View.printMessage("Your action could not be identified. Try again please.\n");
                    break;
            }
        }
    }

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

        View.clear();
        int parts = Inputs.askForInt(this.inputs, -1,0,"parts", false);

        Game new_game = new Game(this.model.getTeamWithName(homeTeam), this.model.getTeamWithName(awayTeam), home_players, away_players);

        View.clear();
        View.printMessage(new_game.getInitialGameConditions());
        View.printMessage("\n");

        int part = 1;

        while(new_game.getTimer() < 90)
        {
            View.printMessage(new_game.advancePartInGame(parts, 90));
            if(new_game.getTimer() < 90) {
                View.printMessage("\n");
                View.printMessage(new_game.partGameMessage());
                substitutePlayer(part, new_game);
            }
            part++;
        }

        View.printMessage("\n");
        View.printMessage(new_game.finalGameMessage());

        this.model.updateTeamsHistory(homeTeam, awayTeam, new_game);

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

    private void substitutePlayer(int part, Game game)
    {
        boolean go = true;

        while(go)
        {
            View.printMessage("\n" + part + "º has ended. Do you want to replace any player?\n(Y/y) or (N/n): ");
            String options = this.inputs.next();
            this.inputs.nextLine();

            while(options.equals("Y") || options.equals("y"))
            {
                View.clear();

                String[] teams = new String[]{game.getHomeTeam().getName(), game.getAwayTeam().getName()};
                View.printTeams(teams);

                int option = this.inputs.nextInt();
                this.inputs.nextLine();

                switch (option)
                {
                    case 1:
                        View.clear();
                        Set<Integer> home_players = game.getHomePlayers();

                        int replace = 0;

                        boolean done = false;

                        while(!done) {
                            View.printMessage("\n");
                            View.printTeamPlayers(this.model.getTeamPlayingPlayersAsStringArray(game.getHomeTeam().getName(), home_players));

                            View.printMessage("\nWhich player do you want to replace (number): ");

                            try {
                                replace = this.inputs.nextInt();
                                this.inputs.nextLine();

                                try {
                                    notContains(replace, home_players);
                                    done = true;
                                } catch (ValueOutofBoundsException e) {
                                    View.clear();
                                    View.printMessage(e.getMessage());
                                }
                            } catch (InputMismatchException e) {
                                View.clear();
                                View.printMessage("\nInvalid input. The program is expecting a Integer value.");
                                inputs.nextLine();
                            }
                        }

                        switch (this.model.getTeamWithName(game.getHomeTeam().getName()).getPlayers().get(replace).getPosition())
                        {
                            case GOALKEEPER:
                                Set<Integer> playingGK = this.model.getPlayersNum(this.model.getTeamGK(game.getHomeTeam().getName(),home_players));
                                int gk = choosePlayer(game.getHomeTeam().getName(),"GK", playingGK);
                                this.model.setPlayerPositionForGame(game.getHomeTeam().getName(), gk, 0);
                                try
                                {
                                    View.clear();
                                    View.printMessage(game.executeHomeSubstitution(gk, replace));
                                }
                                catch (Exception e)
                                {
                                    View.clear();
                                    View.printMessage(e.getMessage());
                                }
                                break;

                            case WINGER:
                                Set<Integer> playingWG = this.model.getPlayersNum(this.model.getTeamWG(game.getHomeTeam().getName(),home_players));
                                int wg = choosePlayer(game.getHomeTeam().getName(),"WG", playingWG);
                                this.model.setPlayerPositionForGame(game.getHomeTeam().getName(), wg, 2);
                                try
                                {
                                    View.clear();
                                    View.printMessage(game.executeHomeSubstitution(wg, replace));
                                }
                                catch (Exception e)
                                {
                                    View.clear();
                                    View.printMessage(e.getMessage());
                                }
                                break;

                            case DEFENDER:
                                Set<Integer> playingDF = this.model.getPlayersNum(this.model.getTeamExchangeable(game.getHomeTeam().getName(),home_players));
                                int df = choosePlayer(game.getHomeTeam().getName(),"DF", playingDF);
                                this.model.setPlayerPositionForGame(game.getHomeTeam().getName(), df, 1);
                                try
                                {
                                    View.clear();
                                    View.printMessage(game.executeHomeSubstitution(df, replace));
                                }
                                catch (Exception e)
                                {
                                    View.clear();
                                    View.printMessage(e.getMessage());
                                }
                                break;

                            case MIDFIELDER:
                                Set<Integer> playingMD = this.model.getPlayersNum(this.model.getTeamExchangeable(game.getHomeTeam().getName(),home_players));
                                int md = choosePlayer(game.getHomeTeam().getName(),"MD", playingMD);
                                this.model.setPlayerPositionForGame(game.getHomeTeam().getName(), md, 3);
                                try
                                {
                                    View.clear();
                                    View.printMessage(game.executeHomeSubstitution(md, replace));
                                }
                                catch (Exception e)
                                {
                                    View.clear();
                                    View.printMessage(e.getMessage());
                                }
                                break;

                            case FORWARD:
                                Set<Integer> playingFW = this.model.getPlayersNum(this.model.getTeamExchangeable(game.getHomeTeam().getName(),home_players));
                                int fw = choosePlayer(game.getHomeTeam().getName(),"FW", playingFW);
                                this.model.setPlayerPositionForGame(game.getHomeTeam().getName(), fw, 4);
                                try
                                {
                                    View.clear();
                                    View.printMessage(game.executeHomeSubstitution(fw, replace));
                                }
                                catch (Exception e)
                                {
                                    View.clear();
                                    View.printMessage(e.getMessage());
                                }
                                break;
                        }
                        break;

                    case 2:
                        View.clear();
                        Set<Integer> away_players = game.getAwayPlayers();

                        int replace1 = 0;

                        boolean done1 = false;

                        while(!done1) {
                            View.printMessage("\n");
                            View.printTeamPlayers(this.model.getTeamPlayingPlayersAsStringArray(game.getAwayTeam().getName(), away_players));

                            try {
                                replace1 = this.inputs.nextInt();
                                this.inputs.nextLine();

                                try {
                                    notContains(replace1, away_players);
                                    done1 = true;
                                } catch (ValueOutofBoundsException e) {
                                    View.clear();
                                    View.printMessage(e.getMessage());
                                }
                            } catch (InputMismatchException e) {
                                View.clear();
                                View.printMessage("\nInvalid input. The program is expecting a Integer value.");
                                inputs.nextLine();
                            }
                        }

                        switch (this.model.getTeamWithName(game.getAwayTeam().getName()).getPlayers().get(replace1).getPosition())
                        {
                            case GOALKEEPER:
                                Set<Integer> playingGK = this.model.getPlayersNum(this.model.getTeamGK(game.getAwayTeam().getName(),away_players));
                                int gk = choosePlayer(game.getAwayTeam().getName(),"GK", playingGK);
                                this.model.setPlayerPositionForGame(game.getAwayTeam().getName(), gk, 0);
                                try
                                {
                                    View.clear();
                                    View.printMessage(game.executeAwaySubstitution(gk, replace1));
                                }
                                catch (Exception e)
                                {
                                    View.clear();
                                    View.printMessage(e.getMessage());
                                }
                                break;

                            case WINGER:
                                Set<Integer> playingWG = this.model.getPlayersNum(this.model.getTeamWG(game.getAwayTeam().getName(),away_players));
                                int wg = choosePlayer(game.getAwayTeam().getName(),"WG", playingWG);
                                this.model.setPlayerPositionForGame(game.getAwayTeam().getName(), wg, 2);
                                try
                                {
                                    View.clear();
                                    View.printMessage(game.executeAwaySubstitution(wg, replace1));
                                }
                                catch (Exception e)
                                {
                                    View.clear();
                                    View.printMessage(e.getMessage());
                                }
                                break;

                            case DEFENDER:
                                Set<Integer> playingDF = this.model.getPlayersNum(this.model.getTeamExchangeable(game.getAwayTeam().getName(),away_players));
                                int df = choosePlayer(game.getAwayTeam().getName(),"DF", playingDF);
                                this.model.setPlayerPositionForGame(game.getAwayTeam().getName(), df, 1);
                                try
                                {
                                    View.clear();
                                    View.printMessage(game.executeAwaySubstitution(df, replace1));
                                }
                                catch (Exception e)
                                {
                                    View.clear();
                                    View.printMessage(e.getMessage());
                                }
                                break;

                            case MIDFIELDER:
                                Set<Integer> playingMD = this.model.getPlayersNum(this.model.getTeamExchangeable(game.getAwayTeam().getName(),away_players));
                                int md = choosePlayer(game.getAwayTeam().getName(),"MD", playingMD);
                                this.model.setPlayerPositionForGame(game.getAwayTeam().getName(), md, 3);
                                try
                                {
                                    View.clear();
                                    View.printMessage(game.executeAwaySubstitution(md, replace1));
                                }
                                catch (Exception e)
                                {
                                    View.clear();
                                    View.printMessage(e.getMessage());
                                }
                                break;

                            case FORWARD:
                                Set<Integer> playingFW = this.model.getPlayersNum(this.model.getTeamExchangeable(game.getAwayTeam().getName(),away_players));
                                int fw = choosePlayer(game.getAwayTeam().getName(),"FW", playingFW);
                                this.model.setPlayerPositionForGame(game.getAwayTeam().getName(), fw, 4);
                                try
                                {
                                    View.clear();
                                    View.printMessage(game.executeAwaySubstitution(fw, replace1));
                                }
                                catch (Exception e)
                                {
                                    View.clear();
                                    View.printMessage(e.getMessage());
                                }
                                break;
                        }
                        break;

                    case 0:
                        options = "";
                        break;

                    default:
                        View.clear();
                        View.printMessage("Your action could not be identified. Try again please.\n");
                        break;
                }
            }

            if(options.equals("N") || options.equals("n"))
                go = false;
        }
    }

    private void contains(int x, Set<Integer> set) throws ValueOutofBoundsException
    {
        if(set.contains(x)) throw new ValueOutofBoundsException("The player you choose is already playing in a different position.");
    }

    private void notContains(int x, Set<Integer> set) throws ValueOutofBoundsException
    {
        if(!set.contains(x)) throw new ValueOutofBoundsException("The player you choose does not exist.");
    }
}