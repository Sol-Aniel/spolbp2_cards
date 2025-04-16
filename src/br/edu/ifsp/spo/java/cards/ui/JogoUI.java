package br.edu.ifsp.spo.java.cards.ui;

import br.edu.ifsp.spo.java.cards.regras.Pontuador;
import br.edu.ifsp.spo.java.cards.regras.Pontuador21Basico;

import java.util.Scanner;

public class JogoUI {
    public String pedirNomeJogador (int numero){
        Scanner sc = new Scanner(System.in);

        String mensagem = "Digite o nome do jogador"+ numero + ": ";
        System.out.println(mensagem);
        String nome = sc.nextLine();
        return nome;
    }

    public Pontuador selecionarPontuador(){
        Pontuador pontuadorSelecionado;
        Scanner sc = new Scanner(System.in);

        System.out.println("Selecione suas regras");
        System.out.println("\n(1) 21");

        int selecao = sc.nextInt();

        switch (selecao){
            case 1:
                pontuadorSelecionado = new Pontuador21Basico();
                break;
            default:
                pontuadorSelecionado = new Pontuador21Basico();
                System.out.println("Selecione um numero valido!");
        }
        
        return pontuadorSelecionado;
    }
}
