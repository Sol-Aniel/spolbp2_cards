package br.edu.ifsp.spo.java.cards.ui;

import br.edu.ifsp.spo.java.cards.itens.AcaoDoJogador;
import br.edu.ifsp.spo.java.cards.itens.Carta;
import br.edu.ifsp.spo.java.cards.itens.TipoDeJogo;
import br.edu.ifsp.spo.java.cards.nucleo.Jogador;
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

    public int numeroDeRodadas() {
        System.out.println("Escolha o número de rodadas (até 10):");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        if (number > 10 || number < 1){
            return 10;
        }
        else{
            return number;
        }
    }

    public TipoDeJogo definirTipo () {
        System.out.println("Escolha:");
        System.out.println("(1) Para uma única rodada (Padrão)");
        System.out.println("(2) Para partida \"de até 10 rodadas\"");

        Scanner sc = new Scanner(System.in);
        int type = sc.nextInt();

        if(type != 2){
            return TipoDeJogo.RODADA;
        }
        else{
            return TipoDeJogo.PARTIDA;
        }
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

    public void exibirVencedor(Jogador jogador) {

        System.out.println(jogador.getNome() + " venceu a rodada!");

    }

    public void exibirVencedorPartida(Jogador jogador, int pontuacao1, int pontuacao2) {

        int pontuacaoV;
        int pontuacaoP;

        if (pontuacao1 > pontuacao2){
            pontuacaoV = pontuacao1;
            pontuacaoP = pontuacao2;
        } else {
            pontuacaoV = pontuacao2;
            pontuacaoP = pontuacao1;
        }

        System.out.println(jogador.getNome() + " venceu a Partida! Parabens!!!");
        System.out.println("Sua pontuação total foi de: " + pontuacaoV);
        System.out.println("A pontuação perdedora foi de: " + pontuacaoP);
    }

    public void exibirInicioJogo() {
        System.out.println("Iniciando a partida!!!!");
    }

    public void exibirInicioRodada(String nome) {

        System.out.println("Agora é a vez de " + nome);

    }

    public AcaoDoJogador obterAcao() {
        System.out.println("O que você deseja fazer?");

        System.out.println("(1) Comprar uma carta");
        System.out.println("(2) Manter a mão atual");

        var scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();

        return opcao == 1 ? AcaoDoJogador.COMPRAR : AcaoDoJogador.PASSAR;
    }

    public void exibirMao(List<Carta> mao, int pontuacao) {
        Midia midia = new Midia();
        System.out.println("Sua mão atual é:");
        midia.carregarCartas(mao);

        System.out.println("Sua pontuação atual é: " + pontuacao);
    }

    public void exibirFimRodada(String nome) {
        System.out.println("Fim da rodada de " + nome);
    }

    public void exibirEmpate() {
        System.out.println("Rodada empatada! Iniciando uma nova rodada...");
    }
}