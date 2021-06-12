package Controller;

import Model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

/**
 * Class that's in charge of reading the logs.
 */
public class LoadFile
{
    /**
     * Model that holds all the information.
     */
    private Model model;

    /**
     * Parameterized constructor that receives a model.
     * @param m Parameter that holds all the information.
     */
    public LoadFile(Model m)
    {
        this.model = m;
    }

    /**
     * Method to read a file to our database
     * @param fileName Path of the file
     * @return A List with the file lines
     */
    public static List<String> readFile(String fileName) {
        List<String> lines;
        try { lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8); }
        catch(IOException exc) { lines = new ArrayList<>(); }
        return lines;
    }

    /**
     * Method to parse the file lines to our database
     * @throws IncorrectLineException Exception of an incorrect line on logs file
     * @throws NumberAlreadyExistsInTeamException Exception of a player with a certain number already exists in the team
     * @throws InvalidTeamException Exception of an invalid team (p.e. nonexistent team who played one (or more) game(s))
     */
    public void parse() throws IncorrectLineException, NumberAlreadyExistsInTeamException, InvalidTeamException, PlayerAlreadyExistsException, TeamAlreadyExistsException
    {
        List<String> lines = readFile("data/logs.txt");
        Map<String, Team> teams = new HashMap<>();
        Map<String, Player> players = new HashMap<>();
        List<Game> games = new ArrayList<>();
        Team last = null;
        Player p = null;
        String[] startLine;
        for (String line : lines) {
            startLine = line.split(":", 2);
            switch (startLine[0]) {
                case "Equipa":
                    Team t = buildTeam(startLine[1]);
                    if(teams.containsKey(t.getName())) throw new TeamAlreadyExistsException();
                    teams.put(t.getName(), t);
                    last = t;
                    break;
                case "Guarda-Redes":
                    GK pGK = buildGK(startLine[1]);
                    if(players.containsKey(pGK.getName())) throw new PlayerAlreadyExistsException();
                    players.put(pGK.getName(), pGK);
                    if (last == null)
                        throw new IncorrectLineException();
                    pGK.setCurrentTeamName(last.getName());
                    last.addPlayer(pGK.clone());
                    break;
                case "Defesa":
                    DF pDF = buildDF(startLine[1]);
                    if(players.containsKey(pDF.getName())) throw new PlayerAlreadyExistsException();
                    players.put(pDF.getName(), pDF);
                    if (last == null)
                        throw new IncorrectLineException();
                    pDF.setCurrentTeamName(last.getName());
                    last.addPlayer(pDF.clone());
                    break;
                case "Medio":
                    MD pMD = buildMD(startLine[1]);
                    if(players.containsKey(pMD.getName())) throw new PlayerAlreadyExistsException();
                    players.put(pMD.getName(), pMD);
                    if (last == null)
                        throw new IncorrectLineException();
                    pMD.setCurrentTeamName(last.getName());
                    last.addPlayer(pMD.clone());
                    break;
                case "Lateral":
                    WG pWG = buildWG(startLine[1]);
                    if(players.containsKey(pWG.getName())) throw new PlayerAlreadyExistsException();
                    players.put(pWG.getName(), pWG);
                    if (last == null)
                        throw new IncorrectLineException();
                    pWG.setCurrentTeamName(last.getName());
                    last.addPlayer(pWG.clone());
                    break;
                case "Avancado":
                    FW pFW = buildFW(startLine[1]);
                    if(players.containsKey(pFW.getName())) throw new PlayerAlreadyExistsException();
                    players.put(pFW.getName(), pFW);
                    if (last == null)
                        throw new IncorrectLineException();
                    pFW.setCurrentTeamName(last.getName());
                    last.addPlayer(pFW.clone());
                    break;
                case "Jogo":
                    Game game = buildGame(startLine[1], teams);
                    teams.get(game.getHomeTeam().getName()).addGameToHistory(game);
                    teams.get(game.getAwayTeam().getName()).addGameToHistory(game);
                    break;
                default:
                    throw new IncorrectLineException();

            }
        }
        this.model.setPlayers(players);
        this.model.setTeams(teams);
        this.model.setGames(games);
    }

    /**
     * Method to build a team
     * @param input Line of a team in logs file
     * @return created Team
     */
    public static Team buildTeam(String input){
        String[] fields = input.split(",");
        return new Team(fields[0]);
    }

    /**
     * Method to build a goalkeeper
     * @param input Line of a goalkeeper in logs file
     * @return created Goalkeeper
     */
    public static GK buildGK(String input){
        String[] fields = input.split(",");
        return new GK(fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), Integer.parseInt(fields[4]),
                        Integer.parseInt(fields[5]), Integer.parseInt(fields[6]), Integer.parseInt(fields[7]), Integer.parseInt(fields[8]), Integer.parseInt(fields[9]));
    }

    /**
     * Method to build a defender
     * @param input Line of a defender in logs file
     * @return created Defender
     */
    public static DF buildDF(String input){
        String[] fields = input.split(",");
        return new DF(fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), Integer.parseInt(fields[4]),
                Integer.parseInt(fields[5]), Integer.parseInt(fields[6]), Integer.parseInt(fields[7]), Integer.parseInt(fields[8]));
    }

    /**
     * Method to build a midfielder
     * @param input Line of a midfielder in logs file
     * @return created Midfielder
     */
    public static MD buildMD(String input){
        String[] fields = input.split(",");
        return new MD(fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), Integer.parseInt(fields[4]),
                Integer.parseInt(fields[5]), Integer.parseInt(fields[6]), Integer.parseInt(fields[7]), Integer.parseInt(fields[8]), Integer.parseInt(fields[9]));
    }

    /**
     * Method to build a winger
     * @param input Line of a winger in logs file
     * @return created Winger
     */
    public static WG buildWG(String input){
        String[] fields = input.split(",");
        return new WG(fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), Integer.parseInt(fields[4]),
                Integer.parseInt(fields[5]), Integer.parseInt(fields[6]), Integer.parseInt(fields[7]), Integer.parseInt(fields[8]), Integer.parseInt(fields[9]));
    }

    /**
     * Method to build a forward
     * @param input Line of a forward in logs file
     * @return created Forward
     */
    public static FW buildFW(String input){
        String[] fields = input.split(",");
        return new FW(fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), Integer.parseInt(fields[4]),
                Integer.parseInt(fields[5]), Integer.parseInt(fields[6]), Integer.parseInt(fields[7]), Integer.parseInt(fields[8]));
    }

    /**
     * Method to build a Game
     * @param input Line of a Game
     * @param ts Current teams on database
     * @return created Game
     * @throws InvalidTeamException Exception to control if the teams who played really exists on database
     */
    public static Game buildGame(String input, Map<String, Team> ts) throws InvalidTeamException{
        String[] fields = input.split(",");
        String[] data = fields[4].split("-");
        Set<Integer> hp = new HashSet<>();
        Set<Integer> ap = new HashSet<>();
        Map<Integer, Integer> subsH = new HashMap<>();
        Map<Integer, Integer> subsA = new HashMap<>();
        for(int i = 5; i < 16; i++)
            hp.add(Integer.parseInt(fields[i]));
        for(int j = 16; j < 19; j++) {
            String[] sub = fields[j].split("->");
            subsH.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        for(int k = 19; k < 30; k++)
            ap.add(Integer.parseInt(fields[k]));
        for(int m = 30; m < 33; m++){
            String[] sub = fields[m].split("->");
            subsA.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        if(ts == null) throw new InvalidTeamException();
        Team home = ts.get(fields[0]);
        Team away = ts.get(fields[1]);
        if(home == null || away == null) throw new InvalidTeamException();
        return new Game(home, away, Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])), hp, subsH, ap, subsA);
    }

}
