package pt.ulusofona.lp2.deisichess;

import java.util.ArrayList;

public class Piece {
    int id;
    int tipoPeca;
    String tipoPecaAsString;
    int equipa;
    String alcunha;
    String icone;
    int valor;
    int posicaoX;
    int posicaoY;
    String estado;
    int nrCapturas;
    int pontosPorCapturas;
    int nrjJogadasInvalidas;


    public Piece(int id, int tipoPeca, int equipa, String alcunha) {
        this.id = id;
        this.tipoPeca = tipoPeca;
        this.equipa = equipa;
        this.alcunha = alcunha;
        if (this.equipa == 10) {
            this.icone = "crazy_emoji_black.png";
        } else if (this.equipa == 20) {
            this.icone = "crazy_emoji_white.png";
        }
        this.estado = "capturado";
        if (this.tipoPeca == 0) {
            this.valor = 1000;
        } else if (this.tipoPeca == 1) {
            this.valor = 8;
        } else if (this.tipoPeca == 2) {
            this.valor = 5;
        } else if (this.tipoPeca == 3) {
            this.valor = 3;
        } else if (this.tipoPeca == 4) {
            this.valor = 3;
        } else if (this.tipoPeca == 5) {
            this.valor = 3;
        } else if (this.tipoPeca == 6) {
            this.valor = 5;
        } else if (this.tipoPeca == 7) {
            this.valor = 4;
        }
        if (this.tipoPeca == 0) {
            this.tipoPecaAsString = "Rei";
        } else if (this.tipoPeca == 1) {
            this.tipoPecaAsString = "Rainha";
        } else if (this.tipoPeca == 2) {
            this.tipoPecaAsString = "Ponei Mágico";
        } else if (this.tipoPeca == 3) {
            this.tipoPecaAsString = "Padre da Vila";
        } else if (this.tipoPeca == 4) {
            this.tipoPecaAsString = "TorreHor";
        } else if (this.tipoPeca == 5) {
            this.tipoPecaAsString = "TorreVer";
        } else if (this.tipoPeca == 6) {
            this.tipoPecaAsString = "Homer Simpson";
        } else if (this.tipoPeca == 7) {
            this.tipoPecaAsString = "Joker/";
        }
        this.nrCapturas = 0;
        this.pontosPorCapturas = 0;
        this.nrjJogadasInvalidas = 0;

    }

    public int getPieceId() {
        return id;
    }

    public int getTipoPeca() {
        return tipoPeca;
    }

    public String getTipoPecaAsString() {
        return tipoPecaAsString;
    }

    public int getValor() {
        return valor;
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

    public String getEstado() {
        return estado;
    }

    public int getPosicaoX() {
        return posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public String getPosicaoXY() {
        return "(" + String.valueOf(posicaoX) + ", " + String.valueOf(posicaoY) + ")";
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
        this.posicaoY = -1;
        this.posicaoX = -1;
    }

    public String valorAsString() {
        if (tipoPeca == 0) {
            return "(infinito)";
        } else {
            return String.valueOf(valor);
        }
    }

    public void incrementaNrCaptura() {
        nrCapturas++;
    }

    public void somaPontosPorCaptura(int pontos) {
        pontosPorCapturas += pontos;
    }

    public void somaJogadasInvalidas() {
        nrjJogadasInvalidas++;
    }

    public boolean validaRei(int x0,int x1,int y0,int y1) {
        if (x0 == x1 && y0 == y1) {
            return true;
        } else if (x0 - 1 != x1 && x0 != x1 && x0 + 1 != x1) {
            return true;
        } else if (y0 - 1 != y1 && y0 != y1 && y0 + 1 != y1) {
            return true;
        }
        return false;
    }
    public boolean validaRainha(int x0,int x1,int y0,int y1) {
        if (x0 == x1 && y0 == y1) {
            return true;
        } else if (x0 != x1 && x0 - 1 != x1 && x0 - 2 != x1 && x0 - 3 != x1 && x0 - 4 != x1 && x0 - 5 != x1 && x0 + 1 != x1 && x0 + 2 != x1 && x0 + 3 != x1 && x0 + 4 != x1 && x0 + 5 != x1) {
            return true;
        } else if (y0 != y1 && y0 + 1 != y1 && y0 + 2 != y1 && y0 + 3 != y1 && y0 + 4 != y1 && y0 + 5 != y1 && y0 - 1 != y1 && y0 - 2 != y1 && y0 - 3 != y1 && y0 - 4 != y1 && y0 - 5 != y1) {
            return true;
        }
        return false;
    }
    public boolean validaPadreDaVila(int x0,int x1,int y0,int y1) {
        if (x0 == x1 && y0 == y1) {
            return true;
        } else if (x0 - 3 != x1 && x0 + 3 != x1) {
            return true;
        } else if (y0 - 3 != y1 && y0 + 3 != y1) {
            return true;
        }
        return false;
    }
    public boolean validaTorreHor(int x0,int x1,int y0,int y1) {
        if (x0 == x1 && y0 == y1) {
            return true;
        } else if (y0 != y1) {
            return true;
        }
        return false;
    }
    public boolean validaTorreVer(int x0,int x1,int y0,int y1) {
        if (x0 == x1 && y0 == y1) {
            return true;
        } else if (x0 != x1) {
            return true;
        }
        return false;
    }
    public boolean validaPoneiMagico(int x0,int x1,int y0,int y1) {
        if (x0 == x1 && y0 == y1) {
            return true;
        } else if (x0 - 2 != x1 && x0 + 2 != x1) {
            return true;
        } else if (y0 - 2 != y1 && y0 + 2 != y1) {
            return true;
        }
        return false;
    }
    public boolean validaHomerSipson(int x0,int x1,int y0,int y1) {
        if (x0 == x1 && y0 == y1) {
            return true;
        } else if (x0 - 1 != x1 && x0 + 1 != x1) {
            return true;
        } else if (y0 - 1 != y1 && y0 + 1 != y1) {
            return true;
        }
        return false;
    }

    public boolean movimentacaoPecas(int x0, int y0, int x1, int y1, int tipoPeca, int personagemJoker) {
        if (tipoPeca == 0) { //Rei
            return validaRei(x0, x1, y0, y1);
        } else if (tipoPeca == 1) { //Rainha
            return validaRainha(x0, x1, y0, y1);
        } else if (tipoPeca == 2) { //Ponei Magico
            return validaPoneiMagico(x0, x1, y0, y1);
        } else if (tipoPeca == 3) { //Padre da Vila
            return validaPadreDaVila(x0, x1, y0, y1);
        } else if (tipoPeca == 4) { //TorreHor
            return validaTorreHor(x0, x1, y0, y1);
        } else if (tipoPeca == 5) { //TorreVer
            return validaTorreVer(x0, x1, y0, y1);
        } else if (tipoPeca == 6) { //HomerSipson
            return validaHomerSipson(x0, x1, y0, y1);
        } else if(tipoPeca == 7) {
            if(personagemJoker == 0) {
                return validaRei(x0, x1, y0, y1);
            } else if (personagemJoker == 1) {
                return validaRainha(x0, x1, y0, y1);
            } else if (personagemJoker == 2) {
                return validaPoneiMagico(x0, x1, y0, y1);
            } else if (personagemJoker == 3) {
                return validaPadreDaVila(x0, x1, y0, y1);
            } else if (personagemJoker == 4) {
                return validaTorreHor(x0, x1, y0, y1);
            }else if (personagemJoker == 5) {
                return validaTorreVer(x0, x1, y0, y1);
            }else if (personagemJoker == 6) {
                return validaHomerSipson(x0, x1, y0, y1);
            }
        }
        return false;
    }

}
