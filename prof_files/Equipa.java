package proj;

import java.util.ArrayList;
import java.util.List;

public class Equipa {

    private String nome;
    private List<Jogador> jogadores;

    public Equipa(String nomeE) {
        nome=nomeE;
        jogadores = new ArrayList<>();
    }

    public static Equipa parse(String input){
        String[] campos = input.split(",");
        return new Equipa(campos[0]);
    }

    public void insereJogador(Jogador j) {
        jogadores.add(j.clone());
    }

    public String getNome(){
        return nome;
    }

    public String toString(){
        String r =  "Equipa:" + nome + "\n";
        for (Jogador j : jogadores){
            r += j.toString();
        }
        return r;
    }

}


