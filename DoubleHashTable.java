import java.util.Random;

public class DoubleHashTable extends OAHashTable {
	private long p;
	private ModHash hash_func_1;
	private ModHash hash_func_2;

	public DoubleHashTable(int m, long p) {
		super(m);
		this.p = p;
		this.hash_func_1 = ModHash.GetFunc(m,p); // h1'(x)
		this.hash_func_2 = ModHash.GetFunc(m-1,p); // h2'(x)
	}
	
	@Override
	public int Hash(long x, int i) {
		// res = ( h1'(x) + i*h2'(x) ) mod m
		int res = (int)((long)((long)hash_func_1.Hash(x) + (long)i*((long)(hash_func_2.Hash(x) +1))) % this.m);
		return res;
	}
	
}
