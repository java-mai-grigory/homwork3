package ru.mai.eights.eights;

import lib.Eight;
import lib.State;

import java.util.ArrayList;
import java.util.PriorityQueue;


public class App 
{
    public static void main( String[] args )
    {
        int m[][] = {
                {4, 2, 6},
                {8, -1, 5},
                {1, 3,  7}
        };

        int sol[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, -1}
        };

        Eight.setSolution( new Eight(null, sol));
        Eight game = new Eight(null, m);

        System.out.println(game.toString());

        PriorityQueue<State> queue = new PriorityQueue<>();

        for(State state : game.getMoves())
        {
              queue.add( state );
        }

        while (!queue.isEmpty())
        {
            Eight ei = (Eight)queue.remove();
            System.out.println(ei);
            System.out.println (ei.Heuristic() );
        }

    }
}
