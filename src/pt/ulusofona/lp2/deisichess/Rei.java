package pt.ulusofona.lp2.deisichess;

public class Rei extends Piece {
    int valor;
    String icone;
    String tipoPecaAsString;


    public Rei(int id, int tipoPeca, int equipa, String alcunha) {
        super(id, tipoPeca, equipa, alcunha);
        this.valor = 1000;
        if (this.equipa == 10) {
            this.icone = "crazy_emoji_black.png";
        } else if (this.equipa == 20) {
            this.icone = "crazy_emoji_white.png";
        }
        this.tipoPecaAsString = "Rei";
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
    public boolean movimentoImitado(int x0, int y0, int x1, int y1, int imitacaoJoker) {
        return false;
    }
    public boolean validaMovimentos(int x0, int y0, int x1, int y1, int rodada) {
        if (x0 == x1 && y0 == y1) {
            return true;
        } else if (x0 - 1 != x1 && x0 != x1 && x0 + 1 != x1) {
            return true;
        } else if (y0 - 1 != y1 && y0 != y1 && y0 + 1 != y1) {
            return true;
        }
        return false;
    }
}
