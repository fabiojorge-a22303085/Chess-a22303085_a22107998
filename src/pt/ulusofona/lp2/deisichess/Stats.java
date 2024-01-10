package pt.ulusofona.lp2.deisichess;

public class Stats {
    int nrCapturasPretas = 0;
    int nrCapturasBrancas = 0;
    int nrCapturasAmarelas = 0;
    int jogadasInvPretas = 0;
    int jogadasInvBrancas = 0;
    int jogadasInvAmarelas = 0;
    int jogadasValPretas = 0;
    int jogadasValBrancas = 0;
    int jogadasValAmarelas = 0;
    int rodada = 0;
    int nrPecasPretas = 0;
    int nrPecasBrancas = 0;
    int nrPecasAmarelas = 0;
    String resultado;
    int rodadasSemCaptura = 0;

    public Stats() {
    }

    public int getJogadasValPretas() {
        return jogadasValPretas;
    }

    public int getJogadasValBrancas() {
        return jogadasValBrancas;
    }

    public int getJogadasValAmarelas() {
        return jogadasValAmarelas;
    }

    public int getNrCapturasPretas() {
        return nrCapturasPretas;
    }

    public int getNrCapturasBrancas() {
        return nrCapturasBrancas;
    }

    public int getNrCapturasAmarelas() {
        return nrCapturasAmarelas;
    }

    public int getNrJogadasInvPretas() {
        return jogadasInvPretas;
    }

    public int getJogadasInvBrancas() {
        return jogadasInvBrancas;
    }

    public int getJogadasInvAmarelas() {
        return jogadasInvAmarelas;
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

    public int getNrPecasAmarelas() {
        return nrPecasAmarelas;
    }

    public void incrementaPreta() {
        nrPecasPretas++;
    }
    public void incrementaBranca() {
        nrPecasBrancas++;
    }
    public void incrementaAmarela() {
        nrPecasAmarelas++;
    }
    public void decrementaBranca() {
        nrPecasBrancas--;

    }
    public void decrementaPreta() {
        nrPecasPretas--;
    }
    public void decrementaAmarela() {
        nrPecasAmarelas--;
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

    public void setResultado(String resultadoo) {
        resultado = resultadoo;
    }

    public void setRodada(int rodada) {
        this.rodada = rodada;
    }

    public void capturaPeca(int teamId) {
        if(teamId == 10) {
            nrCapturasPretas++;
        } else if(teamId == 20) {
            nrCapturasBrancas++;
        } else if(teamId == 30) {
            nrCapturasAmarelas++;
        }
    }
    public void jogadasInvalidas(int idEquipa) {
        if(idEquipa == 10) {
            jogadasInvPretas++;
        } else if (idEquipa == 20) {
            jogadasInvBrancas++;
        } else if(idEquipa == 30) {
            jogadasInvAmarelas++;
        }
    }
    public void jogadasValidas(int idEquipa) {
        if(idEquipa == 10) {
            jogadasValPretas++;
        } else if (idEquipa == 20) {
            jogadasValBrancas++;
        } else if(idEquipa == 30) {
            jogadasValAmarelas++;
        }
    }
    public void proximaRodada() {
        rodada++;
    }

}
