package pt.ulusofona.lp2.deisichess;

public class Piece {
    int ID;
    int tipoPeca;
    int equipa;
    String alcunha;
    String icone;
    Integer posicaoX;
    Integer posicaoY;

    public Piece(int ID, int tipoPeca, int equipa, Integer posicaoX, Integer posicaoY) {
        this.ID = ID;
        this.tipoPeca = tipoPeca;
        this.equipa = equipa;
        if(tipoPeca == 0) {
            this.alcunha = "Chefe";
        }
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
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
    public Integer getPosicaoX() {
        return posicaoX;
    }
    public Integer getPosicaoY() {
        return posicaoY;
    }
    public String getPosicaoXY() {
        return "(" + posicaoX.toString() + "," + posicaoY.toString() + ")";
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
