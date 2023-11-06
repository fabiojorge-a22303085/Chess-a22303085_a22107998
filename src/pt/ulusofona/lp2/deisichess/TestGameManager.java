package pt.ulusofona.lp2.deisichess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class TestGameManager {

    //Testes da função move
    @Test
    public void test_move_moverHorizontalPreta4x4() {
        File file = new File("test-files/4x4.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);

        assertTrue(gameManager.move(2,1,3,1));
    }
    @Test
    public void test_move_moverHorizontaPreta8x8() {
        File file = new File("test-files/8x8.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);

        assertTrue(gameManager.move(1,0,2,0));
    }
    @Test
    public void test_move_moverVerticalPreta4x4() {
        File file = new File("test-files/4x4.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);

        assertTrue(gameManager.move(2,1,2,2));
    }
    @Test
    public void test_move_moverVertical8x8Preta() {
        File file = new File("test-files/8x8.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);

        assertTrue(gameManager.move(1,0,1,1));
    }
    @Test
    public void test_move_moverDiagonal4x4Preta() {
        File file = new File("test-files/4x4.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);

        assertTrue(gameManager.move(2,1,3,2));
    }
    @Test
    public void test_move_moverDiagonalPreta8x8() {
        File file = new File("test-files/8x8.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);

        assertTrue(gameManager.move(1,0,0,1));
    }
    @Test
    public void test_move_casa_vaziaPreta4x4() {
        File file = new File ("test-files/4x4.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);

        assertFalse(gameManager.move(1,1,1,2));
    }
    @Test
    public void test_move_casa_vaziaPreta8x8() {
        File file = new File ("test-files/8x8.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);

        assertFalse(gameManager.move(0,0,1,1));
    }
    @Test
    public void test_move_paraCimaDaMesmaEquipaPreta4x4() {
        File file = new File ("test-files/4x4.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);

        assertFalse(gameManager.move(1,0,2,1));
    }
    @Test
    public void test_move_paraCimaDaMesmaEquipaPreta8x8() {
        File file = new File ("test-files/8x8.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);

        assertFalse(gameManager.move(1,0,2,1));
    }
    @Test
    public void test_move_capturaPreta4x4() {
        File file = new File("test-files/4x4.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);

        assertTrue(gameManager.move(2,1,1,2));
    }
    @Test
    public void test_move_capturaPreta8x8() {
        File file = new File("test-files/8x8.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);
        gameManager.pecas.get(3).setPosicaoY(3);
        gameManager.pecas.get(3).setPosicaoX(3);
        gameManager.pecas.get(6).setPosicaoY(4);
        gameManager.pecas.get(6).setPosicaoX(4);

        assertTrue(gameManager.move(3,3,4,4));
    }
    @Test
    public void test_move_moverHorizontalBranca4x4() {
        File file = new File("test-files/4x4.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);
        gameManager.stats.setRodada(2);

        assertTrue(gameManager.move(1,3,0,3));
    }
    @Test
    public void test_move_moverHorizontaBranca8x8() {
        File file = new File("test-files/8x8.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);
        gameManager.stats.setRodada(2);

        assertTrue(gameManager.move(2,7,1,7));
    }
    @Test
    public void test_move_moverVerticalBranca4x4() {
        File file = new File("test-files/4x4.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);
        gameManager.stats.setRodada(2);

        assertTrue(gameManager.move(2,3,2,2));
    }
    @Test
    public void test_move_moverVerticalBranca8x8() {
        File file = new File("test-files/8x8.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);
        gameManager.stats.setRodada(2);

        assertTrue(gameManager.move(6,6,6,5));
    }
    @Test
    public void test_move_moverDiagonal4x4Branca() {
        File file = new File("test-files/4x4.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);
        gameManager.stats.setRodada(2);

        assertTrue(gameManager.move(1,3,0,2));
    }
    @Test
    public void test_move_moverDiagonalBranca8x8() {
        File file = new File("test-files/8x8.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);
        gameManager.stats.setRodada(2);

        assertTrue(gameManager.move(2,7,1,6));
    }
    @Test
    public void test_move_casa_vaziaBranca4x4() {
        File file = new File ("test-files/4x4.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);
        gameManager.stats.setRodada(2);

        assertFalse(gameManager.move(0,3,0,2));
    }
    @Test
    public void test_move_casa_vaziaBranca8x8() {
        File file = new File ("test-files/8x8.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);
        gameManager.stats.setRodada(2);

        assertFalse(gameManager.move(0,7,0,6));
    }
    @Test
    public void test_move_paraCimaDaMesmaEquipaBranca4x4() {
        File file = new File ("test-files/4x4.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);
        gameManager.stats.setRodada(2);

        assertFalse(gameManager.move(1,3,1,2));
    }
    @Test
    public void test_move_paraCimaDaMesmaEquipaBranca8x8() {
        File file = new File ("test-files/8x8.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);
        gameManager.stats.setRodada(2);

        assertFalse(gameManager.move(2,7,2,6));
    }
    @Test
    public void test_move_capturaBranca4x4() {
        File file = new File("test-files/4x4.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);
        gameManager.stats.setRodada(2);

        assertTrue(gameManager.move(1,2,2,1));
    }
    @Test
    public void test_move_capturaBranca8x8() {
        File file = new File("test-files/8x8.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);
        gameManager.pecas.get(3).setPosicaoY(3);
        gameManager.pecas.get(3).setPosicaoX(3);
        gameManager.pecas.get(6).setPosicaoY(4);
        gameManager.pecas.get(6).setPosicaoX(4);
        gameManager.stats.setRodada(2);

        assertTrue(gameManager.move(4,4,3,3));
    }

    //Testes getSquareInfo
    @Test
    public void test_getSquareInfo_temPeca() {
        File file = new File("test-files/4x4.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);

        String[] info = gameManager.getSquareInfo(1, 0);
        String[] infoEsperada = new String[5];
        infoEsperada[0] = "1";
        infoEsperada[1] = "0";
        infoEsperada[2] = "0";
        infoEsperada[3] = "Chefe";
        infoEsperada[4] = "crazy_emoji_black.png";

        assertArrayEquals(infoEsperada, info);
    }
    @Test
    public void test_getSquareInfo_naoTemPeca() {
        File file = new File("test-files/4x4.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);

        String[] info = gameManager.getSquareInfo(0, 0);
        String[] infoEsperada = new String[0];

        assertArrayEquals(infoEsperada, info);
    }


    //Testes getPieceInfo
    @Test
    public void test_getPieceInfo_pecaEmJogo() {
        File file = new File("test-files/4x4.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);

        String[] infoEsperada = new String[7];
        infoEsperada[0] = "1";
        infoEsperada[1] = "0";
        infoEsperada[2] = "0";
        infoEsperada[3] = "Chefe";
        infoEsperada[4] = "em jogo";
        infoEsperada[5] = "1";
        infoEsperada[6] = "0";

        assertArrayEquals(infoEsperada, gameManager.getPieceInfo(1));
    }
    @Test
    public void test_getPieceInfo_pecaCapturad0() {
        File file = new File("4x4_FicheiroDeTestes.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);

        String[] infoEsperada = new String[7];
        infoEsperada[0] = "1";
        infoEsperada[1] = "0";
        infoEsperada[2] = "0";
        infoEsperada[3] = "Chefe";
        infoEsperada[4] = "capturado";
        infoEsperada[5] = "";
        infoEsperada[6] = "";

        assertArrayEquals(infoEsperada, gameManager.getPieceInfo(1));
    }
    @Test
    public void test_getPieceInfo_naoExistePecaComId() {
        File file = new File("test-files/4x4.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);

        String[] infoEsperada = new String[0];

        assertArrayEquals(infoEsperada, gameManager.getPieceInfo(7));
    }

    //Testes da função getPieceInfoAsString
    @Test
    public void test_getPieceInfoAsString_pecaEmJogo() {
        File file = new File("test-files/4x4.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);

        String infoEsperada = "1 | 0 | 0 | Chefe @ (1, 0)";

        assertEquals(infoEsperada, gameManager.getPieceInfoAsString(1));
    }
    @Test
    public void test_getPieceInfoAsString_pecaCapturada() {
        File file = new File("4x4_FicheiroDeTestes.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);

        String infoEsperada = "1 | 0 | 0 | Chefe @ (n/a)";

        assertEquals(infoEsperada, gameManager.getPieceInfoAsString(1));
    }
    @Test
    public void test_getPieceInfoAsString_naoExistePecaComId() {
        File file = new File("test-files/4x4.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);

        String infoEsperada = "";

        assertEquals(infoEsperada, gameManager.getPieceInfoAsString(7));
    }


    //Testes getCurrentTeamId
    @Test
    public void test_getCurrentTeamId_EquipaPreta() {
        File file = new File("test-files/4x4.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);
        gameManager.stats.setRodada(5);

        assertEquals(0, gameManager.getCurrentTeamID());
    }
    @Test
    public void test_getCurrentTeamId_EquipaBranca() {
        File file = new File("test-files/4x4.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);
        gameManager.stats.setRodada(6);

        assertEquals(1, gameManager.getCurrentTeamID());
    }

}
