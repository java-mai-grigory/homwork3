package lib;

import java.util.ArrayList;

public abstract class State {
	
	protected State parent = null;
	protected int distance = 0;
	
	abstract public ArrayList<State> getMoves();
	abstract boolean isSolution();

	public State(State parent) {
		this.parent = parent;
		if (parent != null) this.distance = parent.Distance() + 1;
		else
			this.distance = 0;
	}

	abstract public int Heuristic();
	
	abstract public int Distance();
}
