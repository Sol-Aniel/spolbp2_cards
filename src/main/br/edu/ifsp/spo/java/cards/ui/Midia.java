package br.edu.ifsp.spo.java.cards.ui;

import br.edu.ifsp.spo.java.cards.itens.Carta;
import br.edu.ifsp.spo.java.cards.itens.Naipe;
import br.edu.ifsp.spo.java.cards.itens.Valor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Midia {

    public static final int numeroLinhasCarta = 8;
    private static final String cardOffset = "      ";

    public static void carregarCarta(Carta carta) {
        var linhas = new String[8];
        var linhaAtual = -1;
            var caminhoCompleto = String.format(
                    "%s/%s/%s.txt",
                    "/cards",
                    carta.getNaipe().toString().toLowerCase(),
                    carta.getValor().toString().toLowerCase());

            try(BufferedReader reader = new BufferedReader(
                    new InputStreamReader(Midia.class.getResourceAsStream(caminhoCompleto)))){

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

            } catch (IOException exception){
                System.out.println(exception.getMessage());
            } catch (Exception exception){
                System.out.println("Exception: " +exception.getMessage() + exception.getClass().getName());
            }

        for(var linha: linhas){
            System.out.println(linha);
        }
    }

    public static void carregarCartas(List<Carta> cartas) {

        var linhas = new String[8];
        var linhaAtual = -1;

        for( var carta: cartas){
            var caminhoCompleto = String.format(
                    "%s/%s/%s.txt",
                    "/cards",
                    carta.getNaipe().toString().toLowerCase(),
                    carta.getValor().toString().toLowerCase());

        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(Midia.class.getResourceAsStream(caminhoCompleto)))){

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