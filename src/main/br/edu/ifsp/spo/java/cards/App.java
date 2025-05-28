package br.edu.ifsp.spo.java.cards;

import br.edu.ifsp.spo.java.cards.itens.Carta;
import br.edu.ifsp.spo.java.cards.itens.Naipe;
import br.edu.ifsp.spo.java.cards.itens.Valor;
import br.edu.ifsp.spo.java.cards.nucleo.Jogo;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;

public class App {

    public static void main(String[] args) {
        for (var naipe : Naipe.values()) {
            for (var valor : Valor.values()) {
                soltaTigrinho(naipe, valor);
            }
        }
    }

    private static void soltaTigrinho(Naipe naipe, Valor valor) {
        var carta = new Carta(naipe, valor);

        var caminhoCompleto = String.format(
                "%s/%s/%s.txt",
                "/cards",
                carta.getNaipe().toString().toLowerCase(),
                carta.getValor().toString().toLowerCase());

        System.out.println(caminhoCompleto);

        try{
            InputStream inputStream = App.class.getResourceAsStream(caminhoCompleto);

            if(inputStream == null){
                System.out.println("O arquivo não existe");
            }else {
                byte[] buffer = new byte[inputStream.available()];
                inputStream.read(buffer);

                var cartaComoString = new String(buffer);
                System.out.println(cartaComoString);
            }

        } catch (IOException exception){
            System.out.println(exception.getMessage());
        } catch (Exception exception){
            System.out.println("Exception: " +exception.getMessage() + exception.getClass().getName());
        }
    }
}