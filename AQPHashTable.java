import java.util.Random;

public class AQPHashTable extends OAHashTable {
	private long p;
	private ModHash hash_func;
	public AQPHashTable(int m, long p) {
		super(m);
		this.p = p;
		this.hash_func = ModHash.GetFunc(m,p);
	}
	
	@Override
	public int Hash(long x, int i) {
		int one;
		if (i % 2 == 0){
			one = 1;
		}
		else{
			one = -1;
		}
		int res = (hash_func.Hash(x) + (one * i * i)) % this.m;
		if (res < 0){
			res += this.m;
		}
		return res;
	}
}

