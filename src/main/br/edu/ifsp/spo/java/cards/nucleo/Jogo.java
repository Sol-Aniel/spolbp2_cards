package br.edu.ifsp.spo.java.cards.nucleo;

import br.edu.ifsp.spo.java.cards.itens.*;
import br.edu.ifsp.spo.java.cards.regras.Pontuador;
import br.edu.ifsp.spo.java.cards.ui.JogoUI;

import javax.swing.text.html.Option;
import java.util.Objects;
import java.util.Optional;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Jogo {

    private Baralho baralho;
    private Jogador jogador1;
    private Jogador jogador2;
    private int PonParJogador1;
    private int PonParJogador2;

    private Pontuador pontuador;
    private TipoDeJogo tipoejogo;
    private int numeroderodadas;

    private JogoUI ui;

    public Jogo(){
        this.ui = new JogoUI();

        this.pontuador = this.ui.escolherPontuador();

        this.baralho = new Baralho();
        this.jogador1 = new Jogador(ui.solicitarNomeJogador(1));
        this.PonParJogador1 = 0;
//        this.jogador2 = new Jogador(ui.solicitarNomeJogador(2));
        this.jogador2 = new JogadorAI();
        this.PonParJogador2 = 0;

        for(int i = 0; i < 2; i++){
            this.jogador1.receberCarta(this.baralho.tirarCarta());
            this.jogador2.receberCarta(this.baralho.tirarCarta());
        }
        this.tipoejogo = this.ui.definirTipo();
        this.numeroderodadas = 0;
    }

    public void play(){
        Optional<Jogador> vencedor = Optional.empty();

        switch(this.tipoejogo){
            case RODADA -> jogoRodada();
            case PARTIDA -> jogoPartida();
            default -> jogoRodada();
        }
    }

    private void jogoPartida() {
        Optional<Jogador> vencedorR = Optional.empty();
        Optional<Jogador> vencedorP = Optional.empty();

        this.numeroderodadas = ui.numeroDeRodadas();

        ui.exibirInicioJogo();
        while (vencedorP.isEmpty()) {
            for(int i = 0; i < this.numeroderodadas; i++) {

                executarRodada(this.jogador1);
                executarRodada(this.jogador2);

                ResultadosPossiveis resultado1 = extrairResultado(this.jogador1);
                ResultadosPossiveis resultado2 = extrairResultado(this.jogador2);
                boolean empate = FALSE;
                if (resultado1 == resultado2){
                    empate = TRUE;
                }
                pontuarPartida(resultado1, resultado2, empate);

                vencedorR = this.verificarVencedor();

                if (vencedorR.isPresent()) {
                    ui.exibirVencedor(vencedorR.get());
                } else {
                    this.reiniciarRodada();
                }

                this.reiniciarRodada();
            }

            vencedorP = vencedorPartida();
            ui.exibirVencedorPartida(vencedorP.get(), this.PonParJogador1, this.PonParJogador2);
        }


    }

    private ResultadosPossiveis extrairResultado(Jogador jogador) {
        var pontuacao = this.pontuador.verificarPontuacao(this.jogador1.getMao());

        if(pontuacao > 21){
            return ResultadosPossiveis.ESTOURO;
        } else if (pontuacao < 21) {
            return ResultadosPossiveis.MENOS;
        } else {
            return ResultadosPossiveis.VINTEUM;
        }
    }

    private void jogoRodada() {
        Optional<Jogador> vencedor = Optional.empty();

        while (vencedor.isEmpty()) {
            ui.exibirInicioJogo();

            executarRodada(this.jogador1);
            executarRodada(this.jogador2);


            vencedor = this.verificarVencedor();

            if (vencedor.isPresent()) {
                ui.exibirVencedor(vencedor.get());
            } else {
                this.reiniciarRodada();
            }
        }
    }

    private void executarRodada(Jogador jogador) {
        ui.exibirInicioRodada(jogador.getNome());

        AcaoDoJogador acao;

        do {
            var pontuacao = this.pontuador.verificarPontuacao(jogador.getMao());

            if(jogador instanceof JogadorAI){
                var ia = (JogadorAI) jogador;
                var pontuacaoia = this.pontuador.verificarPontuacao(ia.getMao());

                ui.exibirMao(ia.getMao(), pontuacaoia);
                acao = ia.decidir(pontuacaoia);
            }else{
                ui.exibirMao(jogador.getMao(), pontuacao);

                acao = ui.obterAcao();
            }

            if(acao == AcaoDoJogador.COMPRAR)
                jogador.receberCarta(this.baralho.tirarCarta());

        } while(acao == AcaoDoJogador.COMPRAR);

        ui.exibirFimRodada(jogador.getNome());
    }

    private Optional<Jogador> verificarVencedor() {
        var pontuacaoJogador1 = this.pontuador.verificarPontuacao(this.jogador1.getMao());
        var pontuacaoJogador2 = this.pontuador.verificarPontuacao(this.jogador2.getMao());

        var empate = (pontuacaoJogador1 > 21 && pontuacaoJogador2 > 21) || (pontuacaoJogador1 == pontuacaoJogador2);

        Optional<Jogador> vencedor = Optional.empty();

        if(!empate){
            if(pontuacaoJogador1 > 21)
                vencedor = Optional.of(this.jogador2);
            else if(pontuacaoJogador2 > 21)
                vencedor = Optional.of(this.jogador1);
            else
                vencedor = Optional.of(pontuacaoJogador1>pontuacaoJogador2? this.jogador1 : this.jogador2);
        }else{
            ui.exibirEmpate();
        }

        return vencedor;
    }

    private void reiniciarRodada() {
        this.baralho.adicionarDescartes(this.jogador1.descartarMao());
        this.baralho.adicionarDescartes(this.jogador2.descartarMao());

        this.jogador1.receberCarta(this.baralho.tirarCarta());
        this.jogador2.receberCarta(this.baralho.tirarCarta());

        this.jogador1.receberCarta(this.baralho.tirarCarta());
        this.jogador2.receberCarta(this.baralho.tirarCarta());
    }

    private Optional<Jogador> vencedorPartida(){
        Optional<Jogador> vencedorP = Optional.empty();

        if (this.PonParJogador1 > this.PonParJogador2){
            vencedorP = Optional.of(this.jogador1);
        } else if (this.PonParJogador2 > this.PonParJogador1) {
            vencedorP = Optional.of(this.jogador2);
        } else {
            vencedorP = null;
        }

        return vencedorP;
    }

    private void pontuarPartida(ResultadosPossiveis resultado1, ResultadosPossiveis resultado2, Boolean empate) {
        int mao1 = this.pontuador.verificarPontuacao(this.jogador1.getMao());
        int mao2 = this.pontuador.verificarPontuacao(this.jogador2.getMao());

        switch (resultado1){
            case MENOS:
                switch (resultado2) {
                    case MENOS:
                        if (mao1 > mao2){
                            this.PonParJogador1 = mao1 - mao2;
                        }
                    case ESTOURO:
                        this.PonParJogador1 += mao1;
                    case VINTEUM:
                        {};
                }
            case ESTOURO:
                switch(resultado2) {
                    case MENOS -> this.PonParJogador1 -= 5;
                    case ESTOURO -> this.PonParJogador1 -= mao1 - 21;
                    case VINTEUM -> this.PonParJogador1 += 0;
                }
            case VINTEUM:
                if (resultado2 != ResultadosPossiveis.VINTEUM) {
                    this.PonParJogador1 += 30;
                } else {
                    this.PonParJogador1 += 21;
                }
        }

        switch (resultado2){
            case MENOS:
                switch (resultado1) {
                    case MENOS:
                        if (mao2 > mao1){
                            this.PonParJogador2 = mao2 - mao1;
                        }
                    case ESTOURO:
                        this.PonParJogador2 += mao2;
                    case VINTEUM:
                    {};
                }
            case ESTOURO:
                switch(resultado1) {
                    case MENOS -> this.PonParJogador2 -= 5;
                    case ESTOURO -> this.PonParJogador2 -= mao2 - 21;
                    case VINTEUM -> this.PonParJogador2 += 0;
                }
            case VINTEUM:
                if (resultado1 != ResultadosPossiveis.VINTEUM) {
                    this.PonParJogador2 += 30;
                } else {
                    this.PonParJogador2 += 21;
                }
        }

        if(empate == TRUE){
            this.PonParJogador1 += 10;
            this.PonParJogador2 += 10;
        }
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