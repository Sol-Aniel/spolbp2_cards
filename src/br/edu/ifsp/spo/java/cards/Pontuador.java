package br.edu.ifsp.spo.java.cards;

import br.edu.ifsp.spo.java.cards.Carta;
import br.edu.ifsp.spo.java.cards.Valor;
import com.sun.source.tree.SwitchTree;

import java.util.List;

public class Pontuador {

    public Pontuador(){
    }

    public int verificarScore(List<Carta> cartas){
        int resultado = 0;
        for (int i = 0; i < cartas.size(); i++) {
            int valor = 0;
            Valor valoreal = cartas.get(i).getValor();
            switch (valoreal){
                case AS:
                    valor = 1;
                    break;
                case DOIS:
                    valor = 2;
                    break;
                case TRES:
                    valor = 3;
                    break;
                case QUATRO:
                    valor = 4;
                    break;
                case CINCO:
                    valor = 5;
                    break;
                case SEIS:
                    valor = 6;
                    break;
                case SETE:
                    valor = 7;
                    break;
                case OITO:
                    valor = 8;
                    break;
                case NOVE:
                    valor = 9;
                    break;
                case DEZ:
                case DAMA:
                case VALETE:
                case REI:
                    valor = 10;
                    break;
            }
            resultado = resultado + valor;
        }
        return resultado;
    }

    @Override
    public String toString(){
        String resultado = "";
        return resultado;
    }
}
