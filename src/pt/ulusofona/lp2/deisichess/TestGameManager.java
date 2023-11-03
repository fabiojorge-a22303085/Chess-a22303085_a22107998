package pt.ulusofona.lp2.deisichess;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class TestGameManager {

    @Test
    public void test_move_moverHorizontal() {
        File file = new File("4x4.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);

        assertTrue(gameManager.move(2,1,3,1));
    }
    @Test
    public void test_move_moverVertical() {
        File file = new File("4x4.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);

        assertTrue(gameManager.move(2,1,2,2));
    }


    @Test
    public void test_move_moverDiagonal() {
        File file = new File("4x4.txt");
        GameManager gameManager = new GameManager();
        gameManager.loadGame(file);

        assertTrue(gameManager.move(2,1,3,2));
    }


    @Test
    public void test_getSquareInfo_temPeca() {
        File file = new File("4x4.txt");

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


}
