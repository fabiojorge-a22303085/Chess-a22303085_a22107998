package pt.ulusofona.lp2.deisichess;
import java.io.*;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.*;

public class GameManager {

    int boardSize;
    ArrayList<Piece> pecas;
    int rodada;

    public GameManager() {
    }

    public int getBoardSize() {
        return boardSize;
    }

    public boolean loadGame(File file) {
        ArrayList<String> lines = new ArrayList<>();

        try {
            if (file.exists()) {
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

        pecas = new ArrayList<>();
        if (lines.size() == 12) {
            boardSize = 4;
            pecas.add(new Piece(1, 0, 0 , "Chefe", 1, 0));
            pecas.add(new Piece(2, 0, 0 , "Selvagem", 3, 0));
            pecas.add(new Piece(3, 0, 0 , "Grande Artista", 2, 1));
            pecas.add(new Piece(4, 0, 1 , "O Maior", 2, 3));
            pecas.add(new Piece(5, 0, 1 , "Amigo", 1, 3));
            pecas.add(new Piece(6, 0, 1 , "Beberolas", 1, 2));

            return true;

        } else if (lines.size() == 20) {
            boardSize = 8;
            pecas.add(new Piece(1, 0, 0 , "Chefe", 1, 0));
            pecas.add(new Piece(2, 0, 0 , "Selvagem", 3, 0));
            pecas.add(new Piece(3, 0, 0 , "Grande Artista", 2, 1));
            pecas.add(new Piece(4, 0, 0 , "Amante de Prata", 4, 1));
            pecas.add(new Piece(5, 0, 0 , "Artolas", 6, 1));
            pecas.add(new Piece(6, 0, 1 , "Maior", 4, 5));
            pecas.add(new Piece(7, 0, 1 , "Amigo", 2, 6));
            pecas.add(new Piece(8, 0, 1 , "Beberolas", 6, 6));
            pecas.add(new Piece(9, 0, 1 , "Esperto", 2, 7));
            pecas.add(new Piece(10, 0, 1 , "Barulhento", 4, 7));

            return true;

        } else {
            return false;
        }
    }


    public boolean move(int x0, int y0, int x1, int y1) {
        return true;
    }
    public String[] getSquareInfo(int x, int y) {

        String[] squareInfo = new String[5];
        boolean temPeca = false;
        if (x > boardSize || x < 0 || y > boardSize || y < 0) {
            return null;
        }
        for(Piece peca : pecas) {
            if (x == peca.getPosicaoX() && y == peca.getPosicaoY()) {
                squareInfo[0] = peca.getPieceIDAsString();
                squareInfo[1] = peca.getTipoPecaAsString();
                squareInfo[2] = peca.getEquipaAsString();
                squareInfo[3] = peca.getAlcunha();
                squareInfo[4] = peca.getIcone();
                temPeca = true;

            }
        }
        if(temPeca) {
            return squareInfo;
        } else {
            return null;
        }

    }
    public String[] getPieceInfo (int ID) {
        String[] pieceInfo = new String[5];
        for (Piece piece : pecas) {
            if(piece.getPieceId() == ID) {
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
            if(piece.getPieceId() == ID) {
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