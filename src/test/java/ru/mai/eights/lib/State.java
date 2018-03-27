package ru.mai.eights.lib;

import java.util.ArrayList;

public abstract class State {
	
	static  State solution;
	
	static void set_solution(State sol) {
		solution = sol;
	}

	protected State parent;
	
	abstract public ArrayList<State> generateMoves();
	abstract boolean isSolution();
	
	abstract public int Heuristic();
	
	abstract public int Distance();
}
