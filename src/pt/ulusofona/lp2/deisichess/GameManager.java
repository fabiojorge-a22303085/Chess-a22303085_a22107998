package pt.ulusofona.lp2.deisichess;
import java.io.*;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;

public class GameManager {

    ArrayList<Piece> pecas;
    Board board = new Board(1);
    int nrPecas;
    Stats stats = new Stats();
    int personagemJoker = 1;

    public GameManager() {
    }

    public int getBoardSize() {
        return board.getBoardSize();
    }


    public void loadGame(File file) throws InvalidGameInputException, IOException {
        pecas = new ArrayList<>();

        try {
            if (!file.exists()) {
                throw new FileNotFoundException("Ficheiro não existente");
            }
                BufferedReader br = new BufferedReader(new FileReader(file));

                int boardSize = Integer.parseInt(br.readLine());

                board.setBoardSize(boardSize);
                nrPecas = Integer.parseInt(br.readLine());


                for(int i = 0; i < nrPecas; i++) {
                    String line = br.readLine();
                    if(line == null) {
                        throw new InvalidGameInputException(i + 3, "LINHA NULA");
                    }
                    String[] dados = line.split(":");

                    if(dados.length < 4) {
                        throw new InvalidGameInputException(i + 3, "DADOS A MENOS (Esperava: 4 ; Obtive: " + dados.length + ")");

                    } else if(dados.length > 4) {
                        throw new InvalidGameInputException(i + 3, "DADOS A MAIS (Esperava: 4 ; Obtive: " + dados.length + ")");
                    }
                    int id = Integer.parseInt(dados[0]);
                    int tipoPeca = Integer.parseInt(dados[1]);
                    int equipa = Integer.parseInt(dados[2]);
                    String alcunha = dados[3];

                    Piece peca;
                    if (tipoPeca == 0) {
                        peca = new Rei(Integer.parseInt(dados[0]), tipoPeca, equipa, alcunha);
                    } else if (tipoPeca == 1) {
                        peca = new Rainha(Integer.parseInt(dados[0]), tipoPeca, equipa, alcunha);
                    } else if (tipoPeca == 2) {
                        peca = new PoneiMagico(Integer.parseInt(dados[0]), tipoPeca, equipa, alcunha);
                    } else if (tipoPeca == 3) {
                        peca = new PadreDaVila(Integer.parseInt(dados[0]), tipoPeca, equipa, alcunha);
                    } else if (tipoPeca == 4) {
                        peca = new TorreHor(Integer.parseInt(dados[0]), tipoPeca, equipa, alcunha);
                    } else if (tipoPeca == 5) {
                        peca = new TorreVert(Integer.parseInt(dados[0]), tipoPeca, equipa, alcunha);
                    } else if (tipoPeca == 6) {
                        peca = new HomerSimpson(Integer.parseInt(dados[0]), tipoPeca, equipa, alcunha);
                    } else if (tipoPeca == 7) {
                        peca = new Joker(Integer.parseInt(dados[0]), tipoPeca, equipa, alcunha);
                    } else {
                        throw new InvalidGameInputException(i + 3, "TIPO DE PECA DESCONHECIDO: " + tipoPeca);
                    }
                    pecas.add(peca);

                    if(peca.getEquipa() == 10) {
                        stats.incrementaPreta();
                    } else if (peca.getEquipa() == 20) {
                        stats.incrementaBranca();
                    } else if (peca.getEquipa() == 30) {
                        stats.incrementaAmarela();
                    } else {
                        throw new InvalidTeamException(peca.getAlcunha());
                    }

                }
                for(int i = 0; i < board.getBoardSize(); i++) {
                    String line = br.readLine();
                    if(line == null) {
                        throw new InvalidGameInputException(i + 3 + nrPecas, "LINHA NULA");
                    }
                    String[] dados = line.split(":");

                    if(dados.length < board.getBoardSize()){
                        throw new InvalidGameInputException(i + 3 + nrPecas, "DADOS A MENOS (Esperava: " + board.getBoardSize() + " ; Obtive: " + dados.length + ")");

                    } else if(dados.length > board.getBoardSize()){
                        throw new InvalidGameInputException(i + 3 + nrPecas, "DADOS A MAIS (Esperava: " + board.getBoardSize() + " ; Obtive: " + dados.length + ")");
                    }
                    for(int j = 0; j < board.getBoardSize(); j++) {
                        for(Piece peca : pecas) {
                            if(Integer.parseInt(dados[j]) == peca.getId()) {
                                peca.setPosicaoX(j);
                                peca.setPosicaoY(i);
                                peca.setEmJogo();
                            }
                        }
                    }
                }
                for(Piece peca : pecas) {
                    if(peca.getEstado().equals("capturado")) {
                        if(peca.getEquipa() == 10) {
                            stats.decrementaPreta();
                        } else if (peca.getEquipa() == 20) {
                            stats.decrementaBranca();
                        }
                    }
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void mudaPecaJoker() {
        if(personagemJoker == 6) {
            personagemJoker = 1;
        } else {
            personagemJoker++;
        }
    }

    public boolean move(int x0, int y0, int x1, int y1) {
        for (Piece peca : pecas) {
            if (x0 == peca.getPosicaoX() && y0 == peca.getPosicaoY()) {
                int equipa = peca.getEquipa();
                int rodada = stats.getRodada();

                if ((rodada % 2 == 0 && equipa == 10) || (rodada % 2 != 0 && equipa == 20)) {
                    if (x1 < 0 || y1 < 0 || x1 > board.getBoardSize() - 1 || y1 > board.getBoardSize() - 1 || x0 < 0 || y0 < 0 || x0 > board.getBoardSize() - 1 || y0 > board.getBoardSize() - 1) {
                        stats.jogadasInvalidas(equipa);
                        return false;
                    } else if (peca.isJoker()) {
                        if (peca.movimentoImitado(x0, y0, x1, y1, personagemJoker)) {
                            stats.jogadasInvalidas(equipa);
                            return false;
                        } else {
                            for (Piece pecaEquipaContraia : pecas) {
                                if (pecaEquipaContraia.getPosicaoX() == x1 && pecaEquipaContraia.getPosicaoY() == y1 && equipa != pecaEquipaContraia.getEquipa()) {
                                    pecaEquipaContraia.setCaptura();
                                    stats.decrementaBranca();
                                    stats.capturaPeca(equipa);
                                    peca.setPosicaoX(x1);
                                    peca.setPosicaoY(y1);
                                    stats.proximaRodada();
                                    stats.jogadasValidas(equipa);
                                    stats.rodadaSemCapturaReset();
                                    mudaPecaJoker();
                                    for(Piece homerSimpson : pecas) {
                                        if(homerSimpson.getTipoPeca() == 6) {
                                            homerSimpson.isEstaADormir();
                                        }
                                    }
                                    return true;
                                } else if (pecaEquipaContraia.getPosicaoX() == x1 && pecaEquipaContraia.getPosicaoY() == y1 && equipa == pecaEquipaContraia.getEquipa()) {
                                    stats.jogadasValidas(equipa);
                                    return false;
                                }
                            }
                            peca.setPosicaoX(x1);
                            peca.setPosicaoY(y1);
                            stats.proximaRodada();
                            stats.jogadasValidas(equipa);
                            stats.rodadaSemCaptura();
                            mudaPecaJoker();
                            for(Piece homerSimpson : pecas) {
                                if(homerSimpson.getTipoPeca() == 6) {
                                    homerSimpson.isEstaADormir();
                                }
                            }
                            return true;
                        }


                    } else if (peca.validaMovimentos(x0, y0, x1, y1 , stats.getRodada())) {
                        stats.jogadasInvalidas(equipa);
                        return false;
                    } else {
                        for (Piece pecaEquipaContraia : pecas) {
                            if (pecaEquipaContraia.getPosicaoX() == x1 && pecaEquipaContraia.getPosicaoY() == y1 && equipa != pecaEquipaContraia.getEquipa()) {
                                pecaEquipaContraia.setCaptura();
                                stats.decrementaBranca();
                                stats.capturaPeca(equipa);
                                peca.setPosicaoX(x1);
                                peca.setPosicaoY(y1);
                                stats.proximaRodada();
                                stats.jogadasValidas(equipa);
                                stats.rodadaSemCapturaReset();
                                mudaPecaJoker();
                                for(Piece homerSimpson : pecas) {
                                    if(homerSimpson.getTipoPeca() == 6) {
                                        homerSimpson.isEstaADormir();
                                    }
                                }
                                return true;
                            } else if (pecaEquipaContraia.getPosicaoX() == x1 && pecaEquipaContraia.getPosicaoY() == y1 && equipa == pecaEquipaContraia.getEquipa()) {
                                stats.jogadasValidas(equipa);
                                return false;
                            }
                        }
                        peca.setPosicaoX(x1);
                        peca.setPosicaoY(y1);
                        stats.proximaRodada();
                        stats.jogadasValidas(equipa);
                        stats.rodadaSemCaptura();
                        mudaPecaJoker();
                        for(Piece homerSimpson : pecas) {
                            if(homerSimpson.getTipoPeca() == 6) {
                                homerSimpson.isEstaADormir();
                            }
                        }
                        return true;
                    }
                } else {
                    return false;
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
                squareInfo[0] = String.valueOf(peca.getId());
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
            if (piece.getId() == ID) {
                if(piece.getEstado().equals("em jogo")) {
                    pieceInfo[0] = String.valueOf(piece.getId());
                    pieceInfo[1] = String.valueOf(piece.getTipoPeca());
                    pieceInfo[2] = String.valueOf(piece.getEquipa());
                    pieceInfo[3] = piece.getAlcunha();
                    pieceInfo[4] = piece.getEstado();
                    pieceInfo[5] = String.valueOf(piece.getPosicaoX());
                    pieceInfo[6] = String.valueOf(piece.getPosicaoY());
                    return pieceInfo;
                } else if (piece.getEstado().equals("capturado")) {
                    pieceInfo[0] = String.valueOf(piece.getId());
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
            if (piece.getId() == ID) {
                if(piece.getTipoPeca() == 7) {
                    if (piece.getEstado().equals("em jogo")) {
                        pieceInfoAsString += String.valueOf(piece.getId()) + " | " + piece.getTipoPecaAsString() + "/" + piece.pecaJoker(personagemJoker) + " | " + piece.getValorString() + " | " +
                                String.valueOf(piece.getEquipa()) + " | " + piece.getAlcunha() + " @ " + piece.getPosicaoXY();
                    } else if (piece.getEstado().equals("capturado")) {
                        pieceInfoAsString += String.valueOf(piece.getId()) + " | " + piece.getTipoPecaAsString() + piece.pecaJoker(personagemJoker) + " | " + piece.getValorString() + " | " +
                                String.valueOf(piece.getEquipa()) + " | " + piece.getAlcunha() + " @ (n/a)";
                    }
                } else if(piece.getTipoPeca() == 6) {
                    if(piece.isEstaADormir()) {
                        pieceInfoAsString += "Doh! zzzzzz";
                    } else {
                        if (piece.getEstado().equals("em jogo")) {
                            pieceInfoAsString += String.valueOf(piece.getId()) + " | " + piece.getTipoPecaAsString() + " | " + piece.getValorString() + " | " +
                                    String.valueOf(piece.getEquipa()) + " | " + piece.getAlcunha() + " @ " + piece.getPosicaoXY();
                        } else if (piece.getEstado().equals("capturado")) {
                            pieceInfoAsString += String.valueOf(piece.getId()) + " | " + piece.getTipoPecaAsString() + " | " + piece.getValorString() + " | " +
                                    String.valueOf(piece.getEquipa()) + " | " + piece.getAlcunha() + " @ (n/a)";
                        }
                    }
                } else if (piece.getEstado().equals("em jogo")) {
                    pieceInfoAsString += String.valueOf(piece.getId()) + " | " + piece.getTipoPecaAsString() + " | " + piece.getValorString() + " | " +
                            String.valueOf(piece.getEquipa()) + " | " + piece.getAlcunha() + " @ " + piece.getPosicaoXY();
                } else if (piece.getEstado().equals("capturado")) {
                    pieceInfoAsString += String.valueOf(piece.getId()) + " | " + piece.getTipoPecaAsString() + " | " + piece.getValorString() + " | " +
                            String.valueOf(piece.getEquipa()) + " | " + piece.getAlcunha() + " @ (n/a)";
                }
            }
        }
        return pieceInfoAsString;
    }

    public int getCurrentTeamID() {
        if(stats.getRodada() % 2 == 0) {
            return 10;
        } else {
            return 20;
        }

    }
    public boolean gameOver() {
        if(stats.getNrPecasBrancas() > 0 && stats.getNrPecasPretas() == 0) {
            stats.setResultado("VENCERAM AS BRANCAS");
            return true;

        } else if(stats.getNrPecasBrancas() == 0 && stats.getNrPecasPretas() > 0) {
            stats.setResultado("VENCERAM AS PRETAS");
            return true;

        } else if(stats.getRodadasSemCaptura() == 10) {
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
        gameResults.add(String.valueOf(stats.getJogadasValBrancas()));
        gameResults.add(String.valueOf(stats.getJogadasInvBrancas()));

        return gameResults;
    }
    public JPanel getAuthorsPanel() {
        return null;
    }

    public void saveGame (File file) throws IOException {
    }

    public void undo() {

    }

    public List<Comparable> getHints (int x, int y) {
        return null;
    }

    public Map<String, String > customizeBoard() {
        return new HashMap<>();
    }
}