package pt.ulusofona.lp2.deisichess;
import java.io.*;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.*;

public class GameManager {

    int boardSize;
    ArrayList<Piece> pecas;
    int rodada;
    int currentPlayer;

    public GameManager(int boardSize) {
    }

    public int getBoardSize() {
        return boardSize;
    }

    public boolean loadFile(File file) {
        ArrayList<String> lines = new ArrayList<>();

        try {
            if(file.exists()) {
                FileReader fileReader = new FileReader(file);

                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    lines.add(line);
                }
                bufferedReader.close();
                fileReader.close();
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(lines.size() == 12) {
            
        }





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
                pieceInfo[0] = piece.getPieceIDAsString();
                pieceInfo[1] = piece.getTipoPecaAsString();
                pieceInfo[2] = piece.getEquipaAsString();
                pieceInfo[3] = piece.getAlcunha();
                pieceInfo[4] =piece.getIcone();
            } else {
                return null;
            }
        }
        return pieceInfo;

    }

    public String getPieceInfoAsString(int ID) {
        String pieceInfoAsString = "";
        for (Piece piece : pecas) {
            if(piece.getPieceID() == ID) {
                pieceInfoAsString += piece.getPieceIDAsString() + "|" + piece.getTipoPecaAsString() + "|" +
                        piece.getEquipaAsString() + "|" + piece.getAlcunha() + "@" + piece.getPosicaoXY();
            } else {
                return null;
            }
            }
        return pieceInfoAsString;
    }
    public int getCurrentTeamID() {
        if(rodada % 2 == 0) {
            return 0;
        } else {
            return 1;
        }


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