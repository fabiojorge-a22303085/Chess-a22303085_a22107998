package pt.ulusofona.lp2.deisichess;

import java.util.ArrayList;

public abstract class Piece {
    int id;
    int tipoPeca;
    int equipa;
    String alcunha;
    String icone;
    int posicaoX;
    int posicaoY;
    int valor;
    String tipoPecaAsString;
    String estado;
    int nrCapturas;
    int pontosPorCapturas;
    int nrjJogadasInvalidas;
    boolean isJoker;


    public Piece(int id, int tipoPeca, int equipa, String alcunha) {
        this.id = id;
        this.tipoPeca = tipoPeca;
        this.equipa = equipa;
        this.alcunha = alcunha;
        this.estado = "capturado";
        this.nrCapturas = 0;
        this.pontosPorCapturas = 0;
        this.nrjJogadasInvalidas = 0;
        this.isJoker = false;
    }

    public int getId() {
        return id;
    }

    public int getTipoPeca() {
        return tipoPeca;
    }

    public int getEquipa() {
        return equipa;
    }

    public String getAlcunha() {
        return alcunha;
    }

    public String getIcone() {
        return icone;
    }

    public int getPosicaoX() {
        return posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }
    public String getPosicaoXY() {
        return "(" + posicaoX + ", " + posicaoY + ")";
    }

    public int getValor() {
        return valor;
    }

    public String getTipoPecaAsString() {
        return tipoPecaAsString;
    }

    public String getEstado() {
        return estado;
    }

    public int getNrCapturas() {
        return nrCapturas;
    }

    public int getPontosPorCapturas() {
        return pontosPorCapturas;
    }

    public int getNrjJogadasInvalidas() {
        return nrjJogadasInvalidas;
    }

    public boolean isJoker() {
        return isJoker;
    }

    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }

    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }

    public void setEmJogo() {
        this.estado = "em jogo";
    }
    public void setCaptura() {
        this.estado = "capturado";
    }

    public abstract boolean movimentoImitado(int x0, int y0, int x1, int y1, int imitacaoJoker);

    public abstract boolean validaMovimentos(int x0, int y0, int x1, int y1);



}
