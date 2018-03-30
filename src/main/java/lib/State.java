package lib;

import java.util.ArrayList;

public abstract class State implements Comparable{
	
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

    @Override
	public int compareTo(Object o)
	{
		State other = (State)o;

		if (this.Heuristic() + this.Distance() > other.Heuristic() + other.Distance())
			return 1;

		else if (this.Heuristic() + this.Distance() < other.Heuristic() + other.Distance())
			return -1;
		else
			return 0;
	}
}
