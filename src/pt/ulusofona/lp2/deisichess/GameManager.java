package pt.ulusofona.lp2.deisichess;

import java.util.ArrayList;
import javax.swing.*;

public class GameManager {

    int boardSize;
    ArrayList<Piece> pecas;
    int rodada;

    public GameManager(int boardSize) {
        this.boardSize = boardSize;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public boolean move(int x0, int y0, int x1, int y1) {
        return true;
    }
    public String[] getSquareInfo(int x, int y) {
        if (x > boardSize || x < 0 || y > boardSize || y < 0) {
            return null;

        }
        return null;
    }
    public String[] getPieceInfo (int ID) {
        String[] pieceInfo = new String[5];
        for (Piece piece : pecas) {
            if(piece.getPieceID() == ID) {
                pieceInfo[0] = String.valueOf(piece.getPieceID());
                pieceInfo[1] = String.valueOf(piece.getTipoPeca());
                pieceInfo[2] = String.valueOf(piece.getEquipa());
                pieceInfo[3] = piece.getAlcunha();
                pieceInfo[4] =piece.getIcone();
            }
        }
        return pieceInfo;

    }

    public String getPieceInfoAsString(int ID) {
        return null;
    }
    public int getCurrentTeamID() {
        return 0;

    }
    public boolean gameOver() {
        return true;

    }
    public ArrayList<String> getGameResults() {
        return null;

    }
    public JPanel getAuthorsPanel() {
        return null;

    }
}