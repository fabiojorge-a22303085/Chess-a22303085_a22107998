package pt.ulusofona.lp2.deisichess;

public class Piece {
    int id;
    int tipoPeca;
    int equipa;
    String alcunha;
    String icone;
    int posicaoX;
    int posicaoY;
    boolean capturado;

    public Piece(int id, int tipoPeca, int equipa, String alcunha, int posicaoX, int posicaoY) {
        this.id = id;
        this.tipoPeca = tipoPeca;
        this.equipa = equipa;
        this.alcunha = alcunha;
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.icone = null;
        this.capturado = false;
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
    public boolean getCapturado() {
        return capturado;
    }

    public int getPosicaoX() {
        return posicaoX;
    }
    public int getPosicaoY() {
        return posicaoY;
    }
    public String getPosicaoXY() {
        return "(" + String.valueOf(posicaoX) + "," + String.valueOf(posicaoY) + ")";
    }
    public String getPieceIDAsString() {
        return String.valueOf(id);
    }
    public String getTipoPecaAsString() {
        return String.valueOf(tipoPeca);
    }
    public String getEquipaAsString() {
        return String.valueOf(equipa);
    }

}
