package pt.ulusofona.lp2.deisichess;

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

    public Piece(int id, int tipoPeca, int equipa, String alcunha) {
        this.id = id;
        this.tipoPeca = tipoPeca;
        this.equipa = equipa;
        this.alcunha = alcunha;
        if(this.equipa == 10) {
            this.icone = "crazy_emoji_black.png";
        } else if(this.equipa == 20) {
            this.icone = "crazy_emoji_white.png";
        }
        this.estado = "capturado";
        if(this.tipoPeca == 0) {
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
        if(this.tipoPeca == 0) {
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

    public String valorAsString() {
        if(tipoPeca == 0) {
            return "(infinito)";
        } else {
            return String.valueOf(valor);
        }
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
}
