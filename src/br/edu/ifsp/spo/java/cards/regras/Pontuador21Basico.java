package br.edu.ifsp.spo.java.cards.regras;

import br.edu.ifsp.spo.java.cards.basico.Carta;
import br.edu.ifsp.spo.java.cards.basico.Valor;

import java.util.List;

public class Pontuador21Basico implements Pontuador {

    public Pontuador21Basico(){
    }

    public int verificarPontuacao(List<Carta> cartas){
        int resultado = 0;
        int asCount = 0;
        for (int i = 0; i < cartas.size(); i++) {
            int valor = 0;
            Valor valoreal = cartas.get(i).getValor();
            switch (valoreal){
                case AS:
                    valor = 1;
                    asCount++;
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
            resultado += valor;
        }
        for (int i = 0; i < asCount; i++) {
            if (resultado + 10 <= 21) {
                resultado += 10;
            }
        }
        return resultado;
    }

    @Override
    public String toString(){
        String resultado = "";
        return resultado;
    }

}
