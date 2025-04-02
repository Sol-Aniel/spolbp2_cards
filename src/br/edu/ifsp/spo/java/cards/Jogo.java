package br.edu.ifsp.spo.java.cards;

public class Jogo {
    private final Baralho baralho;
    private final Jogador jogador1;
    private final Jogador jogador2;

    public Jogo(int tamanhoIncialdaMao){
        this.baralho = new Baralho();
        this.jogador1 = new Jogador("Maria");
        this.jogador2 = new Jogador("João");

//        int tamanhoIncialdaMao = 2;

        for (int i = 0; i < tamanhoIncialdaMao; i++) {
            this.jogador1.receberCarta(this.baralho.tirarCarta());
            this.jogador2.receberCarta(this.baralho.tirarCarta());
        }
    }

    @Override
    public String toString() {
        String resultado = "Jogo de baralho genérico\n";
        resultado += "Jogadores";
        resultado += "\n" + this.jogador1.toString();
        resultado += "\n" + this.jogador2.toString();
        return resultado;
    }
}
