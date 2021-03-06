
public class WeightedQuickUnion implements UnionFind {
	private int numberComponents;
	private int[] id; //can later change to ArrayList;
	private int[] size;
	private int count;
	
	public WeightedQuickUnion(int n) {
		this.numberComponents = n;
		this.id = new int[n];
		this.size = new int[n];
		for (int i = 0; i < size.length; i++) {
			size[i] = 1;
			id[i] = i;
		}
	}
	
	@Override
	public void union(int x, int y) {
		// TODO Auto-generated method stub
		int xParent = findParent(x);
		int yParent = findParent(y);
		
		if (xParent != yParent) {
			numberComponents--;
			//this is where the weighted is done
			//link the smaller tree under the bigger tree to prevent tall tree
			if (size[xParent] < size[yParent]) {
				id[xParent] = yParent;
				size[yParent] += size[xParent];
			} else {
				id[yParent] = xParent;
				size[xParent] += size[yParent];
			}
		}
		
	}

	@Override
	public boolean find(int x, int y) {
		// TODO Auto-generated method stub
		return findParent(x) == findParent(y);
	}

	public int findParent(int x) {
		// TODO Auto-generated method stub
		while (id[x] != x) {
			x = id[x];
			count++;
		}
		return x;
	}

	@Override
	public int numberComponents() {
		// TODO Auto-generated method stub
		return numberComponents;
	}

	@Override
	public int[] returnGraph() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	public int getCount() {
		return this.count;
	}
}
