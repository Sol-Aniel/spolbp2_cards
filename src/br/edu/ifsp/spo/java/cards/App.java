package br.edu.ifsp.spo.java.cards;

import br.edu.ifsp.spo.java.cards.basico.Baralho;
import br.edu.ifsp.spo.java.cards.basico.Carta;
import br.edu.ifsp.spo.java.cards.jogo.Jogo;
import br.edu.ifsp.spo.java.cards.regras.Pontuador21Basico;

import java.text.MessageFormat;

public class App {

    public static void main(String[] args) {

        Baralho baralho = new Baralho();
        Jogo vinteUm = new Jogo(2, new Pontuador21Basico());


        
        System.out.println(carta);

        System.out.println(MessageFormat.format("Cartas restantes no baralho: {0}", baralho.cartasRestantes()));
        System.out.println(vinteUm);


//        Carta carta1 = new Carta(Naipe.ESPADAS, Valor.AS);
//        Carta carta2 = new Carta(Naipe.PAUS, Valor.DAMA);
//
//        List<Carta> cartas = new ArrayList<>();
//        cartas.add(carta1);
//        cartas.add(carta2);
//        Pontuador PONTS = null;
//
//        System.out.println("Digite 1 para basico e 2 para vale 11");
//        int modo = new Scanner(System.in).nextInt();
//
//        if (modo==1){
//            PONTS = new Pontuador21Basico();
//        }
//        else {
//        }
//
//        int result = PONTS.verificarPontuacao(cartas);
//        System.out.println("La pontuacíon és: " + result);
    }
}