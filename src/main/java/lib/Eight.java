package lib;

import java.util.ArrayList;
import java.util.Arrays;

public class Eight extends State {
	protected int m[][];
	int distance;

    static  Eight solution;

    static void setSolution(Eight sol) {
        solution = sol;
    }


    public Eight(Eight parent, int[][] m) {
        super(parent);
        this.m = m;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(m);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Eight other = (Eight) obj;
		if (!Arrays.deepEquals(m, other.m))
			return false;
		return true;
	}

    @Override
    public ArrayList<State> getMoves() {
        ArrayList<State> list = new ArrayList<>();
        return null;
    }

    @Override
	boolean isSolution() {
		return this.equals(solution);
	}

    @Override
	public int Heuristic() {
		return 0;
	}

    @Override
	public int Distance() {
		return distance;
	}

    private final boolean isLegal(int x, int y) {
        int size = m.length;
        return (x < 0) ||  (x > size - 1) || (y < 0) || (y > size - 1);
    }

    private void move(int[][] nm, int x0, int y0, int x, int y)
    {
        int temp;
        temp = nm[x0][y0];
        nm[x0][y0] = nm[x][y];
        nm[x][y] = temp;
    }

    private int[][] deepClone(int m[][])
    {
        int size = m.length;
        int[][] nm = new int[size][size];
        for(int i = 0; i < size; i++)
            nm[i] = m[i].clone();
        return nm;
    }
}
