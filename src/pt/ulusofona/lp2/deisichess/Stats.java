package pt.ulusofona.lp2.deisichess;

public class Stats {
    int nrCapturasPretas = 0;
    int nrCapturasBrancas = 0;
    int jogadasInvPretas = 0;
    int jogadasInvBrancas = 0;
    int jogadasValPretas = 0;
    int jogdasValBrancas = 0;
    int rodada = 1;
    int nrPecasPretas;
    int nrPecasBrancas;
    String resultado;
    int rodadasSemCaptura = 0;

    public Stats() {
    }

    public int getJogadasInvPretas() {
        return jogadasInvPretas;
    }

    public int getJogadasValPretas() {
        return jogadasValPretas;
    }

    public int getJogdasValBrancas() {
        return jogdasValBrancas;
    }

    public int getNrCapturasPretas() {
        return nrCapturasPretas;
    }

    public int getNrCapturasBrancas() {
        return nrCapturasBrancas;
    }

    public int getNrJogadasInvPretas() {
        return jogadasInvPretas;
    }

    public int getJogadasInvBrancas() {
        return jogadasInvBrancas;
    }

    public String getResultado() {
        return resultado;
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
    public void rodadaSemCaptura() {
        rodadasSemCaptura++;

    }

    public int getRodadasSemCaptura() {
        return rodadasSemCaptura;
    }
    public void rodadaSemCapturaReset() {
        rodadasSemCaptura = 0;
    }

    public void decrementaPreta() {
        nrPecasPretas--;
    }

    public void setResultado(String resultadoo) {
        resultado = resultadoo;
    }

    public void setRodada(int rodada) {
        this.rodada = rodada;
    }

    public void capturaPretas() {
        nrCapturasPretas++;

    }
    public void capturasBrancas() {
        nrCapturasBrancas++;
    }
    public void jogadasInvalidasPretas() {
        jogadasInvPretas++;
    }
    public void jogadasInvalidasBrancas() {
        jogadasInvBrancas++;
    }
    public void proximaRodada() {
        rodada++;
    }
    public void jogadaValidaPreta() {
        jogadasValPretas++;
    }
    public void jogadaValidaBranca() {
        jogdasValBrancas++;
    }

}
