import java.util.Random;

public class DoubleHashTable extends OAHashTable {
	private long p;
	private ModHash hash_func_1;
	private ModHash hash_func_2;

	public DoubleHashTable(int m, long p) {
		super(m);
		this.p = p;
		this.hash_func_1 = ModHash.GetFunc(m,p);
		this.hash_func_2 = ModHash.GetFunc(m-1,p);
	}
	
	@Override
	public int Hash(long x, int i) {
		int res = (int)((long)((long)hash_func_1.Hash(x) + (long)i*((long)(hash_func_2.Hash(x) +1))) % this.m);
		return res;
	}
	
}
