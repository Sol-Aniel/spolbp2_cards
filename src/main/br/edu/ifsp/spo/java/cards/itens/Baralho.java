package br.edu.ifsp.spo.java.cards.itens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {
    private final List<Carta> cartas;
    private final List<Carta> descartes;

    public Baralho() {
        this.cartas = new ArrayList<>();
        this.descartes = new ArrayList<>();

        for (var suit : Naipe.values()) {
            for (var rank : Valor.values()) {
                this.cartas.add(new Carta(suit, rank));
            }
        }

        Collections.shuffle(this.cartas);
    }

    public Carta tirarCarta() {
        if (this.cartas.isEmpty()){
            this.cartas.addAll(this.descartes);
            this.descartes.clear();
            return this.cartas.removeFirst();
        }else{
            return this.cartas.removeFirst();
        }
    }

    public int cartasRestantes() {
        return this.cartas.size();
    }

    public void adicionarDescartes(List<Carta> cartas){
        this.descartes.addAll(cartas);
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

    public boolean isEmpty() {
        if(this.cartas.isEmpty()){
            return true;
        }else{return false;}
    }
}