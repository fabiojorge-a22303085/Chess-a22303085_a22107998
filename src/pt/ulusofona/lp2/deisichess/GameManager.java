package pt.ulusofona.lp2.deisichess;
import java.io.*;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.*;

public class GameManager {

    int boardSize;
    ArrayList<Piece> pecas;
    int rodada = 0;
    int nrPecas;
    int currentTeam;

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
                    String[] lineElements = line.split(":");

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
        for(int i = 0; i < elements.size(); i++) {
            for(int j = 0; j < elements.get(i).length; j++) {
                if(elements.get(i)[j] == null) {
                    return false;
                }
            }
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
                                peca.setPosicaoY(i - 8);
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
                                peca.setPosicaoY(i - 12);

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

        if (x1 < 0 || y1 < 0 || x1 > boardSize - 1 || y1 > boardSize - 1) {
            return false;
        } else if (x0 < 0 || y0 < 0 || x0 > boardSize - 1 || y0 > boardSize - 1) {
            return false;
        } else if (x0 == x1 && y0 == y1) {
            return false;
        } else if (x0 - 1 != x1 && x0 != x1 && x0 + 1 != x1) {
            return false;
        } else if (y0 - 1 != y1 && y0 != y1 && y0 + 1 != y1) {
            return false;
        } else {
            for (Piece peca : pecas) {
                if (x0 == peca.getPosicaoX() && y0 == peca.getPosicaoY()) {
                    if (rodada % 2 == 0) {
                        if (peca.getEquipa() == 0) {
                            for(Piece pecaEquipaContraia : pecas) {
                                if(pecaEquipaContraia.getPosicaoX() == x1 && pecaEquipaContraia.getPosicaoY() == y1 && peca.getEquipa() != pecaEquipaContraia.getEquipa()) {
                                    pecas.remove(pecaEquipaContraia);
                                    peca.setPosicaoX(x1);
                                    peca.setPosicaoY(y1);
                                    rodada++;
                                    return true;
                                }
                            }
                            peca.setPosicaoX(x1);
                            peca.setPosicaoY(y1);
                            rodada++;
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        if (peca.getEquipa() == 1) {
                            for(Piece pecaEquipaContraia : pecas) {
                                if(pecaEquipaContraia.getPosicaoX() == x1 && pecaEquipaContraia.getPosicaoY() == y1 && peca.getEquipa() != pecaEquipaContraia.getEquipa()) {
                                    pecas.remove(pecaEquipaContraia);
                                    peca.setPosicaoX(x1);
                                    peca.setPosicaoY(y1);
                                    rodada++;
                                    return true;
                                }
                            }
                            peca.setPosicaoX(x1);
                            peca.setPosicaoY(y1);
                            rodada++;
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            }
            return false;
        }
    }


    public String[] getSquareInfo(int x, int y) {
        System.out.println("squareInfo");

        String[] squareInfo = new String[5];
        String [] squareInfoVazio = new String[0];

        if (x > boardSize -1 || x < 0 || y > boardSize -1 || y < 0) {
            return null;
        }
        for(Piece peca : pecas) {
            if (x == peca.getPosicaoX() && y == peca.getPosicaoY()) {
                squareInfo[0] = String.valueOf(peca.getPieceId());
                squareInfo[1] = String.valueOf(peca.getTipoPeca());
                squareInfo[2] = String.valueOf(peca.getEquipa());
                squareInfo[3] = String.valueOf(peca.getAlcunha());
                squareInfo[4] = String.valueOf(peca.getIcone());
                System.out.println(squareInfo[0]);
                return squareInfo;
            }
        }
        return squareInfoVazio;
    }
    public String[] getPieceInfo (int ID) {
        String[] pieceInfo = new String[7];
        String[] pieceInfoVazio = new String[0];

        for (Piece piece : pecas) {
            if (piece.getPieceId() == ID) {
                pieceInfo[0] = String.valueOf(piece.getPieceId());
                pieceInfo[1] = String.valueOf(piece.getTipoPeca());
                pieceInfo[2] = String.valueOf(piece.getEquipa());
                pieceInfo[3] = piece.getAlcunha();
                if (piece.getCapturado()) {
                    pieceInfo[4] = "capturado";
                } else {
                    pieceInfo[4] = "em jogo";
                }
                pieceInfo[5] = String.valueOf(piece.getPosicaoX());
                pieceInfo[6] = String.valueOf(piece.getPosicaoY());
                return pieceInfo;
            }
        }
        return pieceInfoVazio;
    }

    public String getPieceInfoAsString(int ID) {

        String pieceInfoAsString = "";
        for (Piece piece : pecas) {
            if(piece.getPieceId() == ID) {
                pieceInfoAsString += String.valueOf(piece.getPieceId()) + "|" + String.valueOf(piece.getTipoPeca()) + "|" +
                        String.valueOf(piece.getEquipa()) + "|" + piece.getAlcunha() + "@" + piece.getPosicaoXY();
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