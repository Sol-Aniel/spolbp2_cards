package br.edu.ifsp.spo.java.cards;

import br.edu.ifsp.spo.java.cards.itens.Carta;
import br.edu.ifsp.spo.java.cards.itens.Naipe;
import br.edu.ifsp.spo.java.cards.itens.Valor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        soltaTigrinho();
    }

    private static void soltaTigrinho() {
//        var carta = new Carta(naipe, valor);
        var cartas = new ArrayList<Carta>(Arrays.asList());
        var grupinho = new ArrayList<Carta>(Arrays.asList());
        for (var suit : Naipe.values()) {
            for (var rank : Valor.values()) {
                cartas.add(new Carta(suit, rank));
            }
        }
        for(int i = 0; i<=5; i++) {
            if (i == 5 || cartas.isEmpty()) {
                tigrinhos(grupinho);
                grupinho.clear();
                if (!cartas.isEmpty()){
                    i = -1;
                }else{
                    break;
                }
            }else{
                grupinho.add(cartas.removeFirst());
            }
        }
    }

    private static void tigrinhos(ArrayList<Carta> cartas) {
        var cardOffset = "      ";

        var linhas = new String[8];
        var linhaAtual = -1;

        for( var carta: cartas){
            var caminhoCompleto = String.format(
                    "%s/%s/%s.txt",
                    "/cards",
                    carta.getNaipe().toString().toLowerCase(),
                    carta.getValor().toString().toLowerCase());

        System.out.println(caminhoCompleto);

        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(App.class.getResourceAsStream(caminhoCompleto)))){

            String linha;
            while((linha = reader.readLine()) != null) {
                linhaAtual++;

                if (linhas[linhaAtual] == null) {
                    linhas[linhaAtual] = linha;
                } else {
                    linhas[linhaAtual] = linhas[linhaAtual] + cardOffset + linha;
                }
            }
            linhaAtual = -1;
//            if(inputStream == null){
//                System.out.println("O arquivo não existe");
//            }else {
//                byte[] buffer = new byte[inputStream.available()];
//                inputStream.read(buffer);
//
//                var cartaComoString = new String(buffer);
//                System.out.println(cartaComoString);
//            }

        } catch (IOException exception){
            System.out.println(exception.getMessage());
        } catch (Exception exception){
            System.out.println("Exception: " +exception.getMessage() + exception.getClass().getName());
        }
        }

        for(var linha: linhas){
            System.out.println(linha);
        }
    }
}