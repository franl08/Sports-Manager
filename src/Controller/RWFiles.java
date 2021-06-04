package Controller;


import Model.GK;
import Model.NumberAlreadyExistsInTeamException;
import Model.Team;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RWFiles {
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

                    break;
                case "Defesa":
                    break;
                case "Avançado":
                    break;
                default:
                    System.out.println("Linha invÃ¡lida.");
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
        String nome = campos[0];
        Integer numCamisola = Integer.parseInt(campos[1]);
        Integer velocidade = Integer.parseInt(campos[2]);
        Integer resistência = Integer.parseInt(campos[3]);
        Integer destreza = Integer.parseInt(campos[4]);
        Integer impulsão = Integer.parseInt(campos[5]);
        Integer cabeça = Integer.parseInt(campos[6]);
        Integer remate = Integer.parseInt(campos[7]);
        Integer passe = Integer.parseInt(campos[8]);
        Integer elasticidade = Integer.parseInt(campos[9]);
        return new GK(nome,numCamisola,velocidade,resistência,destreza,impulsão,cabeça,remate,passe,elasticidade);
    }

}
