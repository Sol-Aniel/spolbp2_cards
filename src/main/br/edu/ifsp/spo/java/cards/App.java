package br.edu.ifsp.spo.java.cards;

import br.edu.ifsp.spo.java.cards.itens.Baralho;
import br.edu.ifsp.spo.java.cards.itens.Carta;
import br.edu.ifsp.spo.java.cards.itens.Naipe;
import br.edu.ifsp.spo.java.cards.itens.Valor;
import br.edu.ifsp.spo.java.cards.nucleo.Jogo;
import br.edu.ifsp.spo.java.cards.ui.Midia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        jogo.play();
    }


}