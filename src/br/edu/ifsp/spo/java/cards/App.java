package br.edu.ifsp.spo.java.cards;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

//        Baralho baralho = new Baralho();
//        Jogo vinteUm = new Jogo(2);
//
//        Carta carta = baralho.tirarCarta();
//
//        System.out.println(carta);
//
//        System.out.println(MessageFormat.format("Cartas restantes no baralho: {0}", baralho.cartasRestantes()));
//        System.out.println(vinteUm);
        Carta carta1 = new Carta(Naipe.ESPADAS, Valor.AS);
        Carta carta2 = new Carta(Naipe.PAUS, Valor.DAMA);

        List<Carta> cartas = new ArrayList<>();
        cartas.add(carta1);
        cartas.add(carta2);

        Pontuador PONTS = new Pontuador();
        int result = PONTS.verificarScore(cartas);
        System.out.println("La pontuacíon és: " + result);
    }
}