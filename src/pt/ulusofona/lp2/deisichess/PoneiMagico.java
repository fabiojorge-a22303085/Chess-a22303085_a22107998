package pt.ulusofona.lp2.deisichess;

public class PoneiMagico extends Piece {

    int valor;
    String icone;
    String tipoPecaAsString;

    public PoneiMagico(int id, int tipoPeca, int equipa, String alcunha) {
        super(id, tipoPeca, equipa, alcunha);
        this.valor = 5;
        if (this.equipa == 10) {
            this.icone = "crazy_emoji_black.png";
        } else if (this.equipa == 20) {
            this.icone = "crazy_emoji_white.png";
        }
        this.tipoPecaAsString = "Ponei Mágico";
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
    public boolean movimentoImitado(int x0, int y0, int x1, int y1, int imitacaoJoker) {
        return false;
    }

    public boolean validaMovimentos(int x0, int y0, int x1, int y1, int rodada) {
        if (x0 == x1 && y0 == y1) {
            return true;
        } else if (x0 - 2 != x1 && x0 + 2 != x1) {
            return true;
        } else if (y0 - 2 != y1 && y0 + 2 != y1) {
            return true;
        }
        return false;
    }
}
