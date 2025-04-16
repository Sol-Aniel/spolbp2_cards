package br.edu.ifsp.spo.java.cards.basico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {
    private final List<Carta> cartas;

    public Baralho() {
        this.cartas = new ArrayList<>();

        for (var suit : Naipe.values()) {
            for (var rank : Valor.values()) {
                this.cartas.add(new Carta(suit, rank));
            }
        }

        Collections.shuffle(this.cartas);
    }

    public Carta tirarCarta() {

        Carta cartaTirada = this.cartas.remove(0);

        return cartaTirada;
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
