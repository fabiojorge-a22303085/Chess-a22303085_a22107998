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
        this.isJoker = true;


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
    public void setAcordaOuDorme(int rodada) {

    }
    @Override
    public boolean validaMovimentos(int x0, int y0, int x1, int y1, int rodada) {
        return true;
    }

    public boolean movimentoImitado(int x0, int y0, int x1, int y1, int imitacaoJoker) {
        switch (imitacaoJoker) {
            case 1:
                if (x0 == x1 && y0 == y1) {
                    return true;
                } else if (x0 != x1 && x0 - 1 != x1 && x0 - 2 != x1 && x0 - 3 != x1 && x0 - 4 != x1 && x0 - 5 != x1 && x0 + 1 != x1 && x0 + 2 != x1 && x0 + 3 != x1 && x0 + 4 != x1 && x0 + 5 != x1) {
                    return true;
                } else if (y0 != y1 && y0 + 1 != y1 && y0 + 2 != y1 && y0 + 3 != y1 && y0 + 4 != y1 && y0 + 5 != y1 && y0 - 1 != y1 && y0 - 2 != y1 && y0 - 3 != y1 && y0 - 4 != y1 && y0 - 5 != y1) {
                    return true;
                }
                return false;
            case 2:
                if (x0 == x1 && y0 == y1) {
                    return true;
                } else if (x0 - 2 != x1 && x0 + 2 != x1) {
                    return true;
                } else if (y0 - 2 != y1 && y0 + 2 != y1) {
                    return true;
                }
                return false;
            case 3:
                if (x0 == x1 && y0 == y1) {
                    return true;
                } else if (x0 - 3 != x1 && x0 + 3 != x1) {
                    return true;
                } else if (y0 - 3 != y1 && y0 + 3 != y1) {
                    return true;
                }
                return false;
            case 4:
                if (x0 == x1 && y0 == y1) {
                    return true;
                } else if (y0 != y1) {
                    return true;
                }
                return false;


            case 5:
                if (x0 == x1 && y0 == y1) {
                    return true;
                } else if (x0 != x1) {
                    return true;
                }
                return false;

            case 6:
                if (x0 == x1 && y0 == y1) {
                    return true;
                } else if (x0 - 1 != x1 && x0 + 1 != x1) {
                    return true;
                } else if (y0 - 1 != y1 && y0 + 1 != y1) {
                    return true;
                }
                return false;
        }
        return false;
    }

}


