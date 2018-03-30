package ru.mai.eights.eights;

import lib.Eight;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
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

        System.out.println(game.Heuristic());

    }
}
