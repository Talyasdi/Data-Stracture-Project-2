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
		int res = (int) (((long)hash_func.Hash(x) + (long)(i*i)) % this.m);
		return res;
	}
}
