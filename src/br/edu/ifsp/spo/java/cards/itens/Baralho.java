package br.edu.ifsp.spo.java.cards.itens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {
    private final List<Carta> cartas;
    
    private final List<Carta> descarte;

    public Baralho() {
        this.cartas = new ArrayList<>();
        this.descarte = new ArrayList<>();

        for (var suit : Naipe.values()) {
            for (var rank : Valor.values()) {
                this.cartas.add(new Carta(suit, rank));
            }
        }

        Collections.shuffle(this.cartas);
    }

    public Carta tirarCarta() {
        return this.cartas.removeFirst();
    }
    
    public void receberDescarte(List<Carta> cartas){
        this.descarte.addAll(cartas);
    }

    public int cartasRestantes() {
        return this.cartas.size();
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cartasRestantes() +
                '}';
    }

    public List<Carta> getCards() {
        return cartas;
    }
}
