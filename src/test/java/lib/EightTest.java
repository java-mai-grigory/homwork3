package lib;

import junit.framework.Assert;
import junit.framework.TestCase;

public class EightTest extends TestCase {

    public void testEquals() {
        int m1[][] = {{8, 2, 3}, {4, 5, 6}, {7, 1, -1}};
        int m2[][] = {{8, 2, 3}, {4, 5, 6}, {7, 1, -1}};

        Eight game1 = new Eight(null, m1);
        Eight game2 = new Eight(null, m2);

        Assert.assertTrue(game1.equals(game2));
    }


    public void testIsSolution() {
        int m0[][] = {{1, 2, 3}, {3, 4, 5}, {6, 7, -1}};
        int m[][] = {{1, 2, 3}, {3, 4, 5}, {6, 7, -1}};

        Eight.setSolution(new Eight(null, m0));
        Eight game = new Eight(null, m);
        Assert.assertTrue(game.isSolution());
    }

    public void testInit() {
        int m[][] = {{1, 2, 4}, {8, 5, -1}, {6, 7, 3}};
        Eight game = new Eight(null, m);
        Assert.assertEquals(1, game.getX());
        Assert.assertEquals(2, game.getY());
    }

    public void testEuristic() {
        int m[][] = {
                        {6, 2, 4},
                        {8, 5, -1},
                        {1, 7,  3}
        };

        int sol[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, -1}
        };

        Eight.setSolution( new Eight(null, sol));

        Eight game = new Eight(null, m);
        Assert.assertEquals(13, game.Heuristic());

        //1   21
        //2   0
        //3   2
        //4   3
        //5   0
        //6   3
        //7   1
        //8   2
        //sum = 13;
    }


}