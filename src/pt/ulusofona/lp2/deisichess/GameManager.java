package pt.ulusofona.lp2.deisichess;
import java.io.*;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.*;

public class GameManager {

    ArrayList<Piece> pecas;
    Board board = new Board(1);
    int nrPecas;
    Stats stats = new Stats();



    public GameManager() {
    }

    public int getBoardSize() {
        return board.getBoardSize();
    }

    public boolean loadGame(File file) {
        pecas = new ArrayList<>();

        try {
            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));

                int boardSize = Integer.parseInt(br.readLine());

                board.setBoardSize(boardSize);
                nrPecas = Integer.parseInt(br.readLine());


                for(int i = 0; i < nrPecas; i++) {
                    String line = br.readLine();
                    if(line == null) {
                        return false;
                    }
                    String[] dados = line.split(":");

                    Piece peca = new Piece(Integer.parseInt(dados[0]), Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), dados[3]);
                    pecas.add(peca);

                    if(peca.getEquipa() == 0) {
                        stats.incrementaPreta();
                    } else if (peca.getEquipa() == 1) {
                        stats.incrementaBranca();
                    }

                }
                for(int i = 0; i < board.getBoardSize(); i++) {
                    String line = br.readLine();
                    if(line == null) {
                        return false;
                    }
                    String[] dados = line.split(":");
                    for(int j = 0; j < board.getBoardSize(); j++) {
                        for(Piece peca : pecas) {
                            if(Integer.parseInt(dados[j]) == peca.getPieceId()) {
                                peca.setPosicaoX(j);
                                peca.setPosicaoY(i);
                                peca.setEmJogo();
                            }
                        }
                    }
                }
                for(Piece peca : pecas) {
                    if(peca.getEstado().equals("capturado")) {
                        if(peca.getEquipa() == 0) {
                            stats.decrementaPreta();
                        } else if (peca.getEquipa() == 1) {
                            stats.decrementaBranca();
                        }
                    }
                }
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }


    public boolean move(int x0, int y0, int x1, int y1) {
        for (Piece peca : pecas) {
            if (x0 == peca.getPosicaoX() && y0 == peca.getPosicaoY()) {
                if (stats.getRodada() % 2 != 0) {
                    if (peca.getEquipa() == 0) {
                        if (x1 < 0 || y1 < 0 || x1 > board.getBoardSize()- 1 || y1 > board.getBoardSize() - 1) {
                            stats.jogadasInvalidasPretas();
                            return false;
                        } else if (x0 < 0 || y0 < 0 || x0 > board.getBoardSize()- 1 || y0 > board.getBoardSize() - 1) {
                            stats.jogadasInvalidasPretas();
                            return false;
                        } else if (x0 == x1 && y0 == y1) {
                            stats.jogadasInvalidasPretas();
                            return false;
                        } else if (x0 - 1 != x1 && x0 != x1 && x0 + 1 != x1) {
                            stats.jogadasInvalidasPretas();
                            return false;
                        } else if (y0 - 1 != y1 && y0 != y1 && y0 + 1 != y1) {
                            stats.jogadasInvalidasPretas();
                            return false;
                        } else {
                            for (Piece pecaEquipaContraia : pecas) {
                                if (pecaEquipaContraia.getPosicaoX() == x1 && pecaEquipaContraia.getPosicaoY() == y1 && peca.getEquipa() != pecaEquipaContraia.getEquipa()) {
                                    pecaEquipaContraia.setCaptura();
                                    stats.decrementaBranca();
                                    stats.capturaPretas();
                                    peca.setPosicaoX(x1);
                                    peca.setPosicaoY(y1);
                                    stats.proximaRodada();
                                    stats.jogadaValidaPreta();
                                    return true;
                                } else if(pecaEquipaContraia.getPosicaoX() == x1 && pecaEquipaContraia.getPosicaoY() == y1 && peca.getEquipa() == pecaEquipaContraia.getEquipa()){
                                    stats.jogadasInvalidasPretas();
                                    return false;
                                }
                            }
                            peca.setPosicaoX(x1);
                            peca.setPosicaoY(y1);
                            stats.proximaRodada();
                            stats.jogadaValidaPreta();
                            return true;
                        }
                    } else {
                        stats.jogadasInvalidasPretas();
                        return false;
                    }
                } else {
                    if (peca.getEquipa() == 1) {
                        if (x1 < 0 || y1 < 0 || x1 > board.getBoardSize() - 1 || y1 > board.getBoardSize() - 1) {
                            stats.jogadasInvalidasBrancas();
                            return false;
                        } else if (x0 < 0 || y0 < 0 || x0 > board.getBoardSize() - 1 || y0 > board.getBoardSize() - 1) {
                            stats.jogadasInvalidasBrancas();
                            return false;
                        } else if (x0 == x1 && y0 == y1) {
                            stats.jogadasInvalidasBrancas();
                            return false;
                        } else if (x0 - 1 != x1 && x0 != x1 && x0 + 1 != x1) {
                            stats.jogadasInvalidasBrancas();
                            return false;
                        } else if (y0 - 1 != y1 && y0 != y1 && y0 + 1 != y1) {
                            stats.jogadasInvalidasBrancas();
                            return false;
                        } else {
                            for (Piece pecaEquipaContraia : pecas) {
                                if (pecaEquipaContraia.getPosicaoX() == x1 && pecaEquipaContraia.getPosicaoY() == y1 && peca.getEquipa() != pecaEquipaContraia.getEquipa()) {
                                    pecaEquipaContraia.setCaptura();
                                    stats.decrementaPreta();
                                    stats.capturasBrancas();
                                    peca.setPosicaoX(x1);
                                    peca.setPosicaoY(y1);
                                    stats.proximaRodada();
                                    stats.jogadaValidaBranca();
                                    return true;
                                } else if(pecaEquipaContraia.getPosicaoX() == x1 && pecaEquipaContraia.getPosicaoY() == y1 && peca.getEquipa() == pecaEquipaContraia.getEquipa()){
                                    stats.jogadasInvalidasBrancas();
                                    return false;
                                }
                            }
                            peca.setPosicaoX(x1);
                            peca.setPosicaoY(y1);
                            stats.proximaRodada();
                            stats.jogadaValidaBranca();
                            return true;
                        }
                    } else {
                        stats.jogadasInvalidasBrancas();
                        return false;
                    }
                }
            }
        }
        return false;
    }



    public String[] getSquareInfo(int x, int y) {

        String[] squareInfo = new String[5];
        String [] squareInfoVazio = new String[0];

        if (x > board.getBoardSize() -1 || x < 0 || y > board.getBoardSize() -1 || y < 0) {
            return null;
        }
        for(Piece peca : pecas) {
            if (x == peca.getPosicaoX() && y == peca.getPosicaoY()) {
                squareInfo[0] = String.valueOf(peca.getPieceId());
                squareInfo[1] = String.valueOf(peca.getTipoPeca());
                squareInfo[2] = String.valueOf(peca.getEquipa());
                squareInfo[3] = String.valueOf(peca.getAlcunha());
                squareInfo[4] = String.valueOf(peca.getIcone());
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
                if(piece.getEstado().equals("em jogo")) {
                    pieceInfo[0] = String.valueOf(piece.getPieceId());
                    pieceInfo[1] = String.valueOf(piece.getTipoPeca());
                    pieceInfo[2] = String.valueOf(piece.getEquipa());
                    pieceInfo[3] = piece.getAlcunha();
                    pieceInfo[4] = piece.getEstado();
                    pieceInfo[5] = String.valueOf(piece.getPosicaoX());
                    pieceInfo[6] = String.valueOf(piece.getPosicaoY());
                    return pieceInfo;
                } else if (piece.getEstado().equals("capturado")) {
                    pieceInfo[0] = String.valueOf(piece.getPieceId());
                    pieceInfo[1] = String.valueOf(piece.getTipoPeca());
                    pieceInfo[2] = String.valueOf(piece.getEquipa());
                    pieceInfo[3] = piece.getAlcunha();
                    pieceInfo[4] = piece.getEstado();
                    pieceInfo[5] = "";
                    pieceInfo[6] = "";
                    return pieceInfo;
                }


            }
        }
        return pieceInfoVazio;
    }

    public String getPieceInfoAsString(int ID) {

        String pieceInfoAsString = "";
        for (Piece piece : pecas) {
            if(piece.getPieceId() == ID) {
                if(piece.getEstado().equals("em jogo")) {
                    pieceInfoAsString += String.valueOf(piece.getPieceId()) + " | " + String.valueOf(piece.getTipoPeca()) + " | " +
                            String.valueOf(piece.getEquipa()) + " | " + piece.getAlcunha() + " @ " + piece.getPosicaoXY();
                } else if (piece.getEstado().equals("capturado")) {
                    pieceInfoAsString += String.valueOf(piece.getPieceId()) + " | " + String.valueOf(piece.getTipoPeca()) + " | " +
                            String.valueOf(piece.getEquipa()) + " | " + piece.getAlcunha() + " @ (n/a)";
                }
            }
        }
        return pieceInfoAsString;
    }
    public int getCurrentTeamID() {
        if(stats.getRodada() % 2 == 0) {
            return 1;
        } else {
            return 0;
        }


    }
    public boolean gameOver() {
        if(stats.getNrPecasBrancas() > 0 && stats.getNrPecasPretas() == 0) {
            stats.setResultado("VENCERAM AS BRANCAS");
            return true;

        } else if(stats.getNrPecasBrancas() == 0 && stats.getNrPecasPretas() > 0) {
            stats.setResultado("VENCERAM AS PRETAS");
            return true;

        } else if(stats.getRodada() == 10 && stats.getNrCapturasPretas() == 0 && stats.getNrCapturasBrancas() == 0) {
            stats.setResultado("EMPATE");
            return true;

        } else if(stats.getNrPecasPretas() == 1 && stats.getNrPecasBrancas() == 1) {
            stats.setResultado("EMPATE");
            return true;
        }
        return false;
    }

    public ArrayList<String> getGameResults() {
        ArrayList<String> gameResults = new ArrayList<>();
        gameResults.add("JOGO DE CRAZY CHESS");
        gameResults.add("Resultado: " + stats.getResultado());
        gameResults.add("---");
        gameResults.add("Equipa das Pretas");
        gameResults.add(String.valueOf(stats.getNrCapturasPretas()));
        gameResults.add(String.valueOf(stats.getJogadasValPretas()));
        gameResults.add(String.valueOf(stats.getNrJogadasInvPretas()));
        gameResults.add("Equipa das Brancas");
        gameResults.add(String.valueOf(stats.getNrCapturasBrancas()));
        gameResults.add(String.valueOf(stats.getJogdasValBrancas()));
        gameResults.add(String.valueOf(stats.getJogadasInvBrancas()));

        return gameResults;
    }
    public JPanel getAuthorsPanel() {
        return null;

    }
}