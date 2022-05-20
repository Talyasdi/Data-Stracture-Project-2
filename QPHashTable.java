import java.util.Random;

public class QPHashTable extends OAHashTable {
	private long p;
	private ModHash hash_func;

	public QPHashTable(int m, long p) {
		super(m);
		this.p = p;
		this.hash_func = ModHash.GetFunc(m,p);
	}
	
	@Override
	public int Hash(long x, int i) {
		int res = (int) ((hash_func.Hash(x) + Math.pow(i, 2)) % this.m);
		return res;
	}
}
