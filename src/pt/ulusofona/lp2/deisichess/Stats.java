package pt.ulusofona.lp2.deisichess;

public class Stats {
    int nrCapturrasPretas = 0;
    int nrCapturasBrancas = 0;
    int nrJogadasInvPretas = 0;
    int nrJogadasInvBrancas = 0;
    int rodada = 0;
    int nrPecasPretas;
    int nrPecasBrancas;

    public Stats() {
    }

    public int getNrCapturrasPretas() {
        return nrCapturrasPretas;
    }

    public int getNrCapturasBrancas() {
        return nrCapturasBrancas;
    }

    public int getNrJogadasInvPretas() {
        return nrJogadasInvPretas;
    }

    public int getNrJogadasInvBrancas() {
        return nrJogadasInvBrancas;
    }

    public int getRodada() {
        return rodada;
    }

    public int getNrPecasPretas() {
        return nrPecasPretas;
    }
    public int getNrPecasBrancas() {
        return nrPecasBrancas;
    }
    public void incrementaPreta() {
        nrPecasPretas++;
    }
    public void incrementaBranca() {
        nrPecasBrancas++;

    }
    public void decrementaBranca() {
        nrPecasBrancas--;

    }
    public void decrementaPreta() {
        nrPecasPretas--;
    }

    public void setNrCapturrasPretas(int nrCapturrasPretas) {
        this.nrCapturrasPretas = nrCapturrasPretas;
    }

    public void setNrCapturasBrancas(int nrCapturasBrancas) {
        this.nrCapturasBrancas = nrCapturasBrancas;
    }

    public void setNrJogadasInvPretas(int nrJogadasInvPretas) {
        this.nrJogadasInvPretas = nrJogadasInvPretas;
    }

    public void setNrJogadasInvBrancas(int nrJogadasInvBrancas) {
        this.nrJogadasInvBrancas = nrJogadasInvBrancas;
    }

    public void setRodada(int rodada) {
        this.rodada = rodada;
    }

    public void setNrPecasPretas(int nrPecasPretas) {
        this.nrPecasPretas = nrPecasPretas;
    }

    public void setNrPecasBrancas(int nrPecasBrancas) {
        this.nrPecasBrancas = nrPecasBrancas;
    }
}
