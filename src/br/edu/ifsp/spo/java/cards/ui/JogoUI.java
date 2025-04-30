package br.edu.ifsp.spo.java.cards.ui;

import br.edu.ifsp.spo.java.cards.itens.AcaoJogador;
import br.edu.ifsp.spo.java.cards.itens.Carta;
import br.edu.ifsp.spo.java.cards.regras.Pontuador;
import br.edu.ifsp.spo.java.cards.regras.PontuadorAsValeOnze;
import br.edu.ifsp.spo.java.cards.regras.PontuadorClassico;

import java.util.List;
import java.util.Scanner;

public class JogoUI {

    public String solicitarNomeJogador(int numeroJogador) {
        System.out.println("Digite o nome do jogador " + numeroJogador);

        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public Pontuador escolherPontuador() {
        System.out.println("Escolha o mecanismo de pontuação:");
        System.out.println("(1) Para pontuação clássica (Padrão)");
        System.out.println("(2) Para pontuação \"Ás vale 11\"");

        Scanner sc = new Scanner(System.in);

        int selecao = sc.nextInt();

        Pontuador pontuador = new PontuadorClassico();

        switch (selecao) {
            case 1 -> pontuador = new PontuadorClassico();
            case 2 -> pontuador = new PontuadorAsValeOnze();
            default -> System.out.println("Utilizando o mecanismo de pontuação padrão.");
        }

        return pontuador;
    }

    public AcaoJogador escolherAcao(){
        System.out.println("O que você deseja fazer?");
        System.out.println("(1) Para comprar uma carta");
        System.out.println("(2) Para passar a vez");
        System.out.println("Caso não for escolhido nenhum, se passará a vez");

        Scanner sc = new Scanner(System.in);

        int selecao = sc.nextInt();

        return switch (selecao){
            case 1 -> AcaoJogador.COMPRAR;
            case 2 -> AcaoJogador.PASSAR;
            default -> AcaoJogador.PASSAR;
        };
    }

    public void exibirMao(List<Carta> mao, int pontuacao){
        System.out.println("Sua mão atual é:");
        for (var carta : mao){
            System.out.println(carta);
        }

        System.out.println("E a sua pontuação é: " + pontuacao);
    }

    public void exibirDeQuemEAVez(String nome){
        System.out.println("Agora é a vez de: " + nome);
    }
}
