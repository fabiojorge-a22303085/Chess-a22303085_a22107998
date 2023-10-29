package pt.ulusofona.lp2.deisichess;
import java.io.*;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.*;

public class GameManager {

    int boardSize;
    ArrayList<Piece> pecas;
    int rodada;
    int nrPecas;

    public GameManager() {
    }

    public int getBoardSize() {
        return boardSize;
    }

    public boolean loadGame(File file) {
        ArrayList<String[]> elements = new ArrayList<>();

        try {
            if (file.exists()) {
                FileReader fileReader = new FileReader(file);

                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] lineElements = line.split(":"); // Substitua a vírgula pelo delimitador correto

                    // Adicionar os elementos da linha ao ArrayList de arrays de strings
                    elements.add(lineElements);
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
        if(elements.size() == 12) {
            boardSize = Integer.parseInt(elements.get(0)[0]);
            nrPecas = Integer.parseInt(elements.get(1)[0]);

            for(int i = 2; i < elements.size() - 4; i++ ) {
                int idPeca = Integer.parseInt(elements.get(i)[0]);
                int tipoPeca = Integer.parseInt(elements.get(i)[1]);
                int equipaPeca = Integer.parseInt(elements.get(i)[2]);
                String alcunha = elements.get(i)[3];

                pecas.add(new Piece(idPeca, tipoPeca, equipaPeca, alcunha));
            }
            for(int i = 8; i < elements.size(); i++) {
                for(int j = 0; j < elements.get(i).length; j++){
                    if(Integer.parseInt(elements.get(i)[j]) != 0) {
                        for(Piece peca : pecas) {
                            if(Integer.parseInt(elements.get(i)[j]) == peca.getPieceId()) {
                                peca.setPosicaoX(j);
                                peca.setPosicaoY(i -8);
                            }
                        }
                    }
                }
            }
            return true;

        } else if (elements.size() == 20) {
            boardSize = Integer.parseInt(elements.get(0)[0]);
            nrPecas = Integer.parseInt(elements.get(1)[0]);

            for(int i = 2; i < elements.size() - 8; i++ ) {
                int idPeca = Integer.parseInt(elements.get(i)[0]);
                int tipoPeca = Integer.parseInt(elements.get(i)[1]);
                int equipaPeca = Integer.parseInt(elements.get(i)[2]);
                String alcunha = elements.get(i)[3];

                pecas.add(new Piece(idPeca, tipoPeca, equipaPeca, alcunha));
            }
            for(int i = 12; i < elements.size(); i++) {
                for(int j = 0; j < elements.get(i).length; j++){
                    if(Integer.parseInt(elements.get(i)[j]) != 0) {
                        for(Piece peca : pecas) {
                            if(Integer.parseInt(elements.get(i)[j]) == peca.getPieceId()) {
                                peca.setPosicaoX(j);
                                peca.setPosicaoY(i -12);
                            }
                        }
                    }
                }
            }
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
        if (x >= boardSize || x < 0 || y >= boardSize || y < 0) {
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
            return squareInfo;
        }

    }
    public String[] getPieceInfo (int ID) {
        String[] pieceInfo = new String[7];
        for (Piece piece : pecas) {
            if(piece.getPieceId() == ID) {
                pieceInfo[0] = piece.getPieceIDAsString();
                pieceInfo[1] = piece.getTipoPecaAsString();
                pieceInfo[2] = piece.getEquipaAsString();
                pieceInfo[3] = piece.getAlcunha();
                if(piece.getCapturado()) {
                    pieceInfo[4] = "Capturado";
                } else {
                    pieceInfo[4] = "Em Jogo";
                }
                pieceInfo[5] =String.valueOf(piece.getPosicaoX());
                pieceInfo[6] =String.valueOf(piece.getPosicaoY());
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