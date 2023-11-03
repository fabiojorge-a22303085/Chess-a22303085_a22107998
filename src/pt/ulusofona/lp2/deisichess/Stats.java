package pt.ulusofona.lp2.deisichess;

public class Stats {
    int nrCapturasPretas = 0;
    int nrCapturasBrancas = 0;
    int nrJogadasInvPretas = 0;
    int nrJogadasInvBrancas = 0;
    int rodada = 1;
    int nrPecasPretas;
    int nrPecasBrancas;

    public Stats() {
    }

    public int getNrCapturasPretas() {
        return nrCapturasPretas;
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

    public void setNrPecasPretas(int nrPecasPretas) {
        this.nrPecasPretas = nrPecasPretas;
    }

    public void setNrPecasBrancas(int nrPecasBrancas) {
        this.nrPecasBrancas = nrPecasBrancas;
    }
    public void capturaPretas() {
        nrCapturasPretas++;

    }
    public void capturasBrancas() {
        nrCapturasBrancas++;
    }
    public void jogadasInvalidasPretas() {
        nrJogadasInvPretas++;
    }
    public void jogadasInvalidasBrancas() {
        nrJogadasInvBrancas++;
    }
    public void proximaRodada() {
        rodada++;
    }
}
