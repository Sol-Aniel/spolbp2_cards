package br.edu.ifsp.spo.java.cards.jogo;

import br.edu.ifsp.spo.java.cards.ui.JogoUI;
import br.edu.ifsp.spo.java.cards.basico.Baralho;
import br.edu.ifsp.spo.java.cards.regras.Pontuador;

public class Jogo {
    private Baralho baralho;
    private Jogador jogador1;
    private Jogador jogador2;
    private Pontuador pontuador;

    private JogoUI ui;

    public Jogo(int tamanhoIncialdaMao){
        this.ui = new JogoUI();

        this.baralho = new Baralho();

        this.inicializarJogadores();
        this.distribuirMao(tamanhoIncialdaMao);
        this.inicializarPontuador();
    }

    private void inicializarJogadores(){
        String nomeJogador1 = this.ui.pedirNomeJogador(1);
        this.jogador1 = new Jogador(nomeJogador1);

        String nomeJogador2 = this.ui.pedirNomeJogador(2);
        this.jogador2 = new Jogador(nomeJogador2);
    }

    private void distribuirMao(int tamanhoIncialdaMao){
        for (int i = 0; i < tamanhoIncialdaMao; i++) {
            this.jogador1.receberCarta(this.baralho.tirarCarta());
            this.jogador2.receberCarta(this.baralho.tirarCarta());
        }
    }

    private void inicializarPontuador(){
        Pontuador pontuadorSelecionado = this.ui.selecionarPontuador();
        this.pontuador = pontuadorSelecionado;
    }

    @Override
    public String toString() {
        String resultado = "Jogo de baralho genérico\n";
        resultado += "Jogadores";
        resultado += "\n" + this.jogador1.toString()
            + "\n" + "La pontuácion del jogador és: "
            + pontuador.verificarPontuacao(this.jogador1.getMao());
        resultado += "\n" + this.jogador2.toString()
                + "\n" + "La pontuácion del jogador és: "
                + pontuador.verificarPontuacao(this.jogador2.getMao());
        return resultado;
    }
}