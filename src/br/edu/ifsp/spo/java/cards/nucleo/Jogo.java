package br.edu.ifsp.spo.java.cards.nucleo;

import br.edu.ifsp.spo.java.cards.itens.AcaoJogador;
import br.edu.ifsp.spo.java.cards.itens.Baralho;
import br.edu.ifsp.spo.java.cards.regras.Pontuador;
import br.edu.ifsp.spo.java.cards.ui.JogoUI;

import java.util.Optional;

public class Jogo {

    private Baralho baralho;
    private Jogador jogador1;
    private Jogador jogador2;

    private Pontuador pontuador;

    private JogoUI ui;

    public Jogo(){
        this.ui = new JogoUI();

        this.pontuador = this.ui.escolherPontuador();

        this.baralho = new Baralho();
        this.jogador1 = new Jogador(ui.solicitarNomeJogador(1));
        this.jogador2 = new Jogador(ui.solicitarNomeJogador(2));

        for(int i = 0; i < 2; i++){
            this.jogador1.receberCarta(this.baralho.tirarCarta());
            this.jogador2.receberCarta(this.baralho.tirarCarta());
        }
    }

    public void play(){

        rodadaDoJogador(this.jogador1);
        rodadaDoJogador(this.jogador2);

        var pontuacaoJogador1 = this.pontuador.verificarPontuacao(this.jogador1.getMao());
        var pontuacaoJogador2 = this.pontuador.verificarPontuacao(this.jogador2.getMao());


        var vencedor = obterVencedor(pontuacaoJogador1, pontuacaoJogador2);

        if(vencedor.isPresent()){
            this.ui.exibirVencedor(vencedor, this.pontuador.verificarPontuacao(vencedor.get().getMao()));
        } else{
            this.ui.exibirEmpate();

        }

    }

    private Optional<Jogador> obterVencedor(int pontuacaoJogador1, int pontuacaoJogador2) {
        var partidaEmpata =
                (pontuacaoJogador1 == pontuacaoJogador2);

        Jogador vencedor;

        if(!partidaEmpata) {
            if (pontuacaoJogador1 == 21) {
                vencedor = this.jogador1;
            } else if (pontuacaoJogador2 == 21) {
                vencedor = this.jogador2;
            } else if (pontuacaoJogador1 >21) {
                vencedor = this.jogador2;
            } else if (pontuacaoJogador2 > 21) {
                vencedor = this.jogador1;
            } else if (pontuacaoJogador1 > pontuacaoJogador2) {
                vencedor = this.jogador1;
            }else{
                vencedor = this.jogador2;
            }
        }else{
            vencedor = null;
        }
        return Optional.ofNullable(vencedor);
    }

    public void rodadaDoJogador(Jogador jogador){
        AcaoJogador acao;

        do {
            var pontuacao = this.pontuador.verificarPontuacao(jogador.getMao());
            System.out.println("Exibir Cartas:");
            this.ui.exibirDeQuemEAVez(jogador.getNome());
            this.ui.exibirMao(jogador.getMao(), pontuacao);

            if (jogador.getClass() == JogadorAI.class){
                acao = ((JogadorAI)jogador).vouComprar(pontuacao);
            }else {
                acao = this.ui.escolherAcao();
            }

            if (acao == AcaoJogador.COMPRAR) {
                this.jogador1.receberCarta(this.baralho.tirarCarta());
            }
        } while(acao == AcaoJogador.COMPRAR);
    }

    @Override
    public String toString() {
        String resultado = "Jogo de Baralho Genérico";

        resultado += "\n Jogadores: ";
        resultado += this.jogador1.toString();
        resultado += "\n A pontuação do jogador 1 é: " + this.pontuador.verificarPontuacao(this.jogador1.getMao());
        resultado += this.jogador2.toString();
        resultado += "\n A pontuação do jogador 2 é: " + this.pontuador.verificarPontuacao(this.jogador2.getMao());

        return resultado;
    }
}
