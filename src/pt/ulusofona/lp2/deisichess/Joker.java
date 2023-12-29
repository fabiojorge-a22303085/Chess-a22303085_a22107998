package pt.ulusofona.lp2.deisichess;

public class Joker extends Piece {

    int valor;
    String icone;
    String tipoPecaAsString;
    public Joker(int id, int tipoPeca, int equipa, String alcunha) {
        super(id, tipoPeca, equipa, alcunha);
        this.valor = 4;
        if (this.equipa == 10) {
            this.icone = "crazy_emoji_black.png";
        } else if (this.equipa == 20) {
            this.icone = "crazy_emoji_white.png";
        }
        this.tipoPecaAsString = "Joker";
    }

    @Override
    public int getValor() {
        return valor;
    }

    @Override
    public String getIcone() {
        return icone;
    }

    @Override
    public String getTipoPecaAsString() {
        return tipoPecaAsString;
    }

    public boolean validaMovimentos(int x0, int y0, int x1, int y1) {
        return false;
    }
}
