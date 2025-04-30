package br.edu.ifsp.spo.java.cards.nucleo;

import br.edu.ifsp.spo.java.cards.itens.AcaoJogador;

public class JogadorAI extends Jogador{

    public JogadorAI(String nome) {
        super("CYBER LIDER 30Z");
    }

    public AcaoJogador vouComprar(int pontuacao){



        return AcaoJogador.COMPRAR;
    }
}
