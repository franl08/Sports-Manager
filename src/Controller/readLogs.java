package Controller;


import Model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class readLogs {
    public void parse() throws NumberAlreadyExistsInTeamException {
        List<String> linhas = lerFicheiro("dados.csv");
        String[] linhaPartida;
        List<Team> equipas = new ArrayList<>();
        Integer count = -1;
        for (String linha : linhas) {
            String Team = "";
            linhaPartida = linha.split(":", 2);
            switch(linhaPartida[0]){
                case "Equipa:":
                    count++;
                    String nome = linhaPartida[1];
                    Team equipa = new Team(count.toString(),nome);
                    equipas.add(equipa);
                    break;
                case "Guarda-Redes":
                    GK guarda_redes = parseGuardaRedes(linhaPartida[1]);
                    equipas.get(equipas.size() - 1).addPlayer(guarda_redes);
                    break;
                case "Lateral":
                    WG lateral = parseLateral(linhaPartida[1]);
                    equipas.get(equipas.size() - 1).addPlayer(lateral);
                    break;
                case "Defesa":
                    DF defesa = parseDefesa(linhaPartida[1]);
                    equipas.get(equipas.size()-1).addPlayer(defesa);
                    break;
                case "Avancado":
                    FW avançado = parseAvançado(linhaPartida[1]);
                    equipas.get(equipas.size()-1).addPlayer(avançado);
                    break;
                case "Medio":
                    MD medio = parseMedio(linhaPartida[1]);
                    equipas.get(equipas.size()-1).addPlayer(medio);
                    break;
                default:
                    System.out.println("Linha inválida.");
                    break;
            }
        }
        System.out.println("done!");
    }

    public List<String> lerFicheiro(String nomeFich) {
        List<String> lines;
        try { lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); }
        catch(IOException exc) { lines = new ArrayList<>(); }
        return lines;
    }


    public GK parseGuardaRedes(String input){
        String[] campos = input.split(",");
        String name = campos[0];
        Integer number = Integer.parseInt(campos[1]);
        Integer velocity = Integer.parseInt(campos[2]);
        Integer elasticity = Integer.parseInt(campos[3]);
        Integer reflexes  = Integer.parseInt(campos[4]);
        Integer agility = Integer.parseInt(campos[5]);
        Integer decisions = Integer.parseInt(campos[6]);
        Integer Atribute1 = Integer.parseInt(campos[7]);
        Integer Atribute2 = Integer.parseInt(campos[8]);
        Integer Atribute3 = Integer.parseInt(campos[9]);
        return new GK(name,number,velocity,elasticity,reflexes,agility,decisions,Atribute1,Atribute2,Atribute3);
    }

    public WG parseLateral(String input) {
        String[] campos = input.split(",");
        String name = campos[0];
        Integer number = Integer.parseInt(campos[1]);
        Integer velocity = Integer.parseInt(campos[2]);
        Integer endurance = Integer.parseInt(campos[3]);
        Integer skill = Integer.parseInt(campos[4]);
        Integer impulsion = Integer.parseInt(campos[5]);
        Integer heading = Integer.parseInt(campos[6]);
        Integer finishing = Integer.parseInt(campos[7]);
        Integer passing = Integer.parseInt(campos[8]);
        Integer crossing = Integer.parseInt(campos[9]);
        return new WG(name,number,velocity,endurance,skill,impulsion,heading,finishing,passing,crossing);
    }

    public DF parseDefesa(String input){
        String[] campos = input.split(",");
        String name = campos[0];
        Integer number = Integer.parseInt(campos[1]);
        Integer velocity = Integer.parseInt(campos[2]);
        Integer endurance = Integer.parseInt(campos[3]);
        Integer skill = Integer.parseInt(campos[4]);
        Integer impulsion = Integer.parseInt(campos[5]);
        Integer heading = Integer.parseInt(campos[6]);
        Integer finishing = Integer.parseInt(campos[7]);
        Integer passing = Integer.parseInt(campos[8]);
        return new DF(name,number,velocity,endurance,skill,impulsion,heading,finishing,passing);
    }

    public FW parseAvançado(String input){
        String[] campos = input.split(",");
        String name = campos[0];
        Integer number= Integer.parseInt(campos[1]);
        Integer velocity = Integer.parseInt(campos[2]);
        Integer endurance = Integer.parseInt(campos[3]);
        Integer skill = Integer.parseInt(campos[4]);
        Integer impulsion = Integer.parseInt(campos[5]);
        Integer heading = Integer.parseInt(campos[6]);
        Integer finishing= Integer.parseInt(campos[7]);
        Integer passing = Integer.parseInt(campos[8]);
        return new FW(name,number,velocity,endurance,skill,impulsion,heading,finishing,passing);
    }

    public MD parseMedio(String input){
        String[] campos = input.split(",");
        String name = campos[0];
        Integer number = Integer.parseInt(campos[1]);
        Integer velocity = Integer.parseInt(campos[2]);
        Integer endurance = Integer.parseInt(campos[3]);
        Integer skill = Integer.parseInt(campos[4]);
        Integer impulsion = Integer.parseInt(campos[5]);
        Integer heading = Integer.parseInt(campos[6]);
        Integer finishing = Integer.parseInt(campos[7]);
        Integer passing = Integer.parseInt(campos[8]);
        Integer crossing = Integer.parseInt(campos[9]);
        return new MD(name,number,velocity,endurance,skill,impulsion,heading,finishing,passing,crossing);
    }
}
