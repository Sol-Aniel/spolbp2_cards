package br.edu.ifsp.spo.java.cards.ui;

import java.util.Scanner;

public class JogoUI {
    public String pedirNomeJogador (int numero){
        String mensagem = "Digite o nome do jogador"+ numero + ": ";
        System.out.println(mensagem);
        String nome = new Scanner(System.in).nextLine();
        return nome;
    }
}
