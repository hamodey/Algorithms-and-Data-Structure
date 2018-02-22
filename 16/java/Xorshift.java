public class Xorshift {

	long a,b,c, seed;
    public Xorshift(long _a, long _b, long _c, long seed) {


    	a = _a;
    	b = _b;
    	c = _c;
    	this.seed = seed;
    }

    public long next() {


    	  seed ^= (seed << a) % 4294967296L;
  	    seed ^= (seed >> b) % 4294967296L;
  	   seed ^= (seed << c) % 4294967296L;

  	   return seed;

    }
    public void seed(long seed) {

    	this.seed = seed;
    }
}
