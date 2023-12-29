package pt.ulusofona.lp2.deisichess;

public class HomerSimpson extends Piece {

    int valor;
    String icone;
    String tipoPecaAsString;
    boolean estaADormir;

    public HomerSimpson(int id, int tipoPeca, int equipa, String alcunha) {
        super(id, tipoPeca, equipa, alcunha);
        this.valor = 5;
        if (this.equipa == 10) {
            this.icone = "crazy_emoji_black.png";
        } else if (this.equipa == 20) {
            this.icone = "crazy_emoji_white.png";
        }
        this.tipoPecaAsString = "Homer Simpson";
        this.estaADormir = true;
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

    @Override
    public boolean isEstaADormir() {
        return estaADormir;
    }
    public void setAcordaOuDorme (int rodada) {
        if(rodada % 3 == 0) {
            estaADormir = true;
        } else {
            estaADormir = false;
        }
    }

    public boolean movimentoImitado(int x0, int y0, int x1, int y1, int imitacaoJoker) {
        return false;
    }

    public boolean validaMovimentos(int x0, int y0, int x1, int y1, int rodada) {
        if(rodada % 3 == 0) {
            return true;
        } else if (x0 == x1 && y0 == y1) {
            return true;
        } else if (x0 - 1 != x1 && x0 + 1 != x1) {
            return true;
        } else if (y0 - 1 != y1 && y0 + 1 != y1) {
            return true;
        }
        return false;
    }
}
