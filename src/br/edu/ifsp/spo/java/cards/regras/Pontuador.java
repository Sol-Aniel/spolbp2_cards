package br.edu.ifsp.spo.java.cards.regras;

import br.edu.ifsp.spo.java.cards.basico.Carta;

import java.util.List;

public interface Pontuador {
    int verificarPontuacao(List<Carta> cartas);
}
