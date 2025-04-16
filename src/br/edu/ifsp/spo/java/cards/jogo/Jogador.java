package br.edu.ifsp.spo.java.cards.jogo;

import br.edu.ifsp.spo.java.cards.basico.Carta;

import java.util.ArrayList;
import java.util.List;

public class Jogador {

    private final List<Carta> mao;

    private final String nome;

    public Jogador(String nome) {
        this.nome = nome;
        this.mao = new ArrayList<>();
    }

    public void receberCarta(Carta carta){
        this.mao.add(carta);
    }

    public Carta tirarCarta() {
        return this.mao.remove(0);
    }

    public int cartasRestantes() {
        return this.mao.size();
    }

    public String getNome(){
        return nome;
    }

    public List<Carta> getMao(){
        return mao;
    }

    @Override
    public String toString() {
        String resultado = "Jogador: " + getNome();
        resultado += "\n" + "A mão do jogador é:";
        for (Carta carta : this.mao) {
            resultado += "\n- " + carta.toString();
        }
        return resultado;
    }
}
