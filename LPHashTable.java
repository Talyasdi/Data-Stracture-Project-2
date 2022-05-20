import java.util.Random;

public class LPHashTable extends OAHashTable {
	private long p;
	private ModHash hash_func;

	public LPHashTable(int m, long p) {
		super(m);
		this.p = p;
		this.hash_func = ModHash.GetFunc(m,p);
	}
	
	@Override
	public int Hash(long x, int i) {
		int res = (hash_func.Hash(x) + i) % this.m;
		return res;
	}
	
}
