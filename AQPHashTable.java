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

		// Checking if i is odd or even for the result of (-1)^2
		if (i % 2 == 0){
			one = 1;
		}
		else{
			one = -1;
		}

		// res = ( h'(x) + (-1)^i * i^2 ) mod m
		int res = (int)(((long)hash_func.Hash(x) + (long)(one * i * i)) % this.m);

		// In case res is negative, add M to make it positive
		if (res < 0){
			res += this.m;
		}
		return res;
	}
}

