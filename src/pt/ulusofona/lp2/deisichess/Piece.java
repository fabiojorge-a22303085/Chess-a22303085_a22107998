package pt.ulusofona.lp2.deisichess;

public class Piece {
    int id;
    int tipoPeca;
    int equipa;
    String alcunha;
    String icone;
    int posicaoX;
    int posicaoY;
    String estado;

    public Piece(int id, int tipoPeca, int equipa, String alcunha) {
        this.id = id;
        this.tipoPeca = tipoPeca;
        this.equipa = equipa;
        this.alcunha = alcunha;
        if(this.equipa == 0) {
            this.icone = "crazy_emoji_black.png";
        } else if(this.equipa == 1) {
            this.icone = "crazy_emoji_white.png";
        }
        this.estado = "capturado";
    }



    public int getPieceId() {
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
}
