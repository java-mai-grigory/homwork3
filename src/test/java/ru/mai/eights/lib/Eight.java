package ru.mai.eights.lib;

import java.util.Arrays;

public class Eight {
	protected int m[][];

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
	
	
}
