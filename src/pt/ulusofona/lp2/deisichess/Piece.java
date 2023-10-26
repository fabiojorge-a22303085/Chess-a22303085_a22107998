package pt.ulusofona.lp2.deisichess;

public class Piece {
    int ID;
    int tipoPeca;
    int equipa;
    String alcunha;
    String icone;
    int posicaoX;
    int posicaoY;

    public Piece(int ID, int tipoPeca, int equipa, String alcunha, Integer posicaoX, Integer posicaoY) {
        this.ID = ID;
        this.tipoPeca = tipoPeca;
        this.equipa = equipa;
        this.alcunha = alcunha;
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.icone = null;
    }
    public int getPieceID() {
        return ID;
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
        return "(" + String.valueOf(posicaoX) + "," + String.valueOf(posicaoY) + ")";
    }
    public String getPieceIDAsString() {
        return String.valueOf(ID);
    }
    public String getTipoPecaAsString() {
        return String.valueOf(ID);
    }
    public String getEquipaAsString() {
        return String.valueOf(ID);
    }

}
