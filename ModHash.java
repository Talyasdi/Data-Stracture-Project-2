import java.util.concurrent.ThreadLocalRandom;

public class ModHash {
	private long a;
	private long b;
	private int m;
	private long p;

	public ModHash(long a, long b, long p, int m)  {
		this.a = a;
		this.b = b;
		this.m = m;
		this.p = p;
	}

	public static ModHash GetFunc(int m, long p){
		long a =  ThreadLocalRandom.current().nextLong(1,p);
		long b = ThreadLocalRandom.current().nextLong(0,p);
		ModHash res = new ModHash(a,b,p,m);
		return res;
	}
	
	public int Hash(long key) {
		return (int)(((this.a*key + this.b) % p) % m);
	}
}
