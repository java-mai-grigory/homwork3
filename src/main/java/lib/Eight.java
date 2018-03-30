package lib;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Eight extends State {
	private int m[][];
	private int x, y;

    private static  Eight solution;

    public static void setSolution(Eight sol) {
        solution = sol;
    }

    public int getX() { return x; };
    public int getY() { return y; };

    public  String toString()
    {
        String str = "";
        for(int i = 0; i < m.length; i++)
        {
            for(int j = 0; j < m.length; j++)
                str += m[i][j] + "  ";
            str += "\n";
        }
        return str;
    }


    public Eight(Eight parent, int[][] m) {
        super(parent);
        this.m = m;
        for(int i = 0; i < m.length; i++)
            for(int j = 0; j < m.length; j++)
                if (m[i][j] <= 0 )
                {
                    x = i;
                    y = j;
                    return;
                }

        x = y = -1;
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
        int[][] nm;
        int size = m.length;
        ArrayList<State> list = new ArrayList<>();
        if ( isLegal(x, y + 1) ) {
            nm = new int[size][size];
            for (int i = 0; i < size; i++)
                nm[i] = m[i].clone();
            move(nm, x, y, x, y + 1);
            list.add( new Eight(this, nm));
        }
        if ( isLegal(x, y -1) ) {
            nm = new int[size][size];
            for (int i = 0; i < size; i++)
                nm[i] = m[i].clone();
            move(nm, x, y, x, y - 1);
            list.add( new Eight(this, nm));
        }
        if ( isLegal(x + 1, y ) ) {
            nm = new int[size][size];
            for (int i = 0; i < size; i++)
                nm[i] = m[i].clone();
            move(nm, x, y, x + 1, y );
            list.add( new Eight(this, nm));
        }
        if ( isLegal(x - 1, y) ) {
            nm = new int[size][size];
            for (int i = 0; i < size; i++)
                nm[i] = m[i].clone();
            move(nm, x, y, x - 1, y );
            list.add( new Eight(this, nm));
        }
        return list;
    }

    @Override
	boolean isSolution() {
		return this.equals(solution);
	}

    @Override
	public int Heuristic() {
        HashMap<Integer, Pair> map = new HashMap<Integer, Pair>();
        if (solution == null) return 0;
        for (int x = 0; x < solution.m.length; x++)
            for (int y = 0; y < solution.m.length; y++)
            {
                map.put( solution.m[x][y], new Pair(x, y));
            }
        int val;
        int sum = 0;
        for (int x = 0; x < m.length; x++)
            for (int y = 0; y < m.length; y++)
            {
                val = m[x][y];
                if (val > 0)
                {
                    sum += Math.abs( map.get(val).getX() - x);
                    sum += Math.abs( map.get(val).getY() - y);
                }
            }
        return sum;
    }

    @Override
	public int Distance() {
		return distance;
	}

    private final boolean isLegal(int x, int y) {
        int size = m.length;
        return (x >= 0) &&  (x <= size - 1) && (y >= 0) && (y <= size - 1);
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
