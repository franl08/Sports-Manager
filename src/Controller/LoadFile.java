package Controller;

import Model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class LoadFile {

    public static List<String> readFile(String fileName) {
        List<String> lines;
        try { lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8); }
        catch(IOException exc) { lines = new ArrayList<>(); }
        return lines;
    }

    public static void parse() throws IncorrectLineException, NumberAlreadyExistsInTeamException {
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
                    teams.put(t.getName(), t);
                    last = t;
                    break;
                case "Guarda-Redes":
                    GK pGK = buildGK(startLine[1]);
                    players.put(pGK.getName(), pGK);
                    if (last == null)
                        throw new IncorrectLineException();
                    pGK.setCurrentTeamName(last.getName());
                    last.addPlayer(pGK.clone());
                    break;
                case "Defesa":
                    DF pDF = buildDF(startLine[1]);
                    players.put(pDF.getName(), pDF);
                    if (last == null)
                        throw new IncorrectLineException();
                    pDF.setCurrentTeamName(last.getName());
                    last.addPlayer(pDF.clone());
                    break;
                case "Medio":
                    MD pMD = buildMD(startLine[1]);
                    players.put(pMD.getName(), pMD);
                    if (last == null)
                        throw new IncorrectLineException();
                    pMD.setCurrentTeamName(last.getName());
                    last.addPlayer(pMD.clone());
                    break;
                case "Lateral":
                    WG pWG = buildWG(startLine[1]);
                    players.put(pWG.getName(), pWG);
                    if (last == null)
                        throw new IncorrectLineException();
                    pWG.setCurrentTeamName(last.getName());
                    last.addPlayer(pWG.clone());
                    break;
                case "Avancado":
                    FW pFW = buildFW(startLine[1]);
                    players.put(pFW.getName(), pFW);
                    if (last == null)
                        throw new IncorrectLineException();
                    pFW.setCurrentTeamName(last.getName());
                    last.addPlayer(pFW.clone());
                    break;
                case "Jogo":
                    Game game = buildGame(startLine[1]);
                    games.add(game);
                    break;
                default:
                    throw new IncorrectLineException();

            }
        }
    }

    public static Team buildTeam(String input){
        String[] fields = input.split(",");
        return new Team(fields[0]);
    }

    public static GK buildGK(String input){
        String[] fields = input.split(",");
        return new GK(fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), Integer.parseInt(fields[4]),
                        Integer.parseInt(fields[5]), Integer.parseInt(fields[6]), Integer.parseInt(fields[7]), Integer.parseInt(fields[8]), Integer.parseInt(fields[9]));
    }

    public static DF buildDF(String input){
        String[] fields = input.split(",");
        return new DF(fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), Integer.parseInt(fields[4]),
                Integer.parseInt(fields[5]), Integer.parseInt(fields[6]), Integer.parseInt(fields[7]), Integer.parseInt(fields[8]), Integer.parseInt(fields[9]));
    }

    public static MD buildMD(String input){
        String[] fields = input.split(",");
        return new MD(fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), Integer.parseInt(fields[4]),
                Integer.parseInt(fields[5]), Integer.parseInt(fields[6]), Integer.parseInt(fields[7]), Integer.parseInt(fields[8]), Integer.parseInt(fields[9]));
    }

    public static WG buildWG(String input){
        String[] fields = input.split(",");
        return new WG(fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), Integer.parseInt(fields[4]),
                Integer.parseInt(fields[5]), Integer.parseInt(fields[6]), Integer.parseInt(fields[7]), Integer.parseInt(fields[8]), Integer.parseInt(fields[9]));
    }

    public static FW buildFW(String input){
        String[] fields = input.split(",");
        return new FW(fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), Integer.parseInt(fields[4]),
                Integer.parseInt(fields[5]), Integer.parseInt(fields[6]), Integer.parseInt(fields[7]), Integer.parseInt(fields[8]), Integer.parseInt(fields[9]));
    }

    public static Game buildGame(String input){
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
        return new Game(fields[0], fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])),
                        hp, subsH, ap, subsA);


    }

}
