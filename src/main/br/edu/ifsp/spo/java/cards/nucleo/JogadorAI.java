package br.edu.ifsp.spo.java.cards.nucleo;

import br.edu.ifsp.spo.java.cards.itens.AcaoDoJogador;

public class JogadorAI extends Jogador {

    public JogadorAI(){
        super("CYBER LIDER 30Z");
    }

    public AcaoDoJogador decidir(int pontuacao){
        return pontuacao < 18 ? AcaoDoJogador.COMPRAR : AcaoDoJogador.PASSAR;
    }
}