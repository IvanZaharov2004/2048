package com.example.a2048;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}

    /* public void add_tile() {
        int notEmpty = 0;
        Board TileMap = new Board();
        TileMap.add_tile();
        for (int i = 0; i < 4; i++) {
            if (TileMap.map.get(i).contains(2) || TileMap.map.get(i).contains(4))
                notEmpty++;
        }
        assertTrue(notEmpty > 0);
    }
   */
