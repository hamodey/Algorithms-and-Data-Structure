public class LCG {
	long _a;
	long _c;
	long _m;
	long seed;
    public LCG(long _a, long _c, long _m, long seed) {

    	this._a = _a;
    	this._c = _c;
    	this._m = _m;
    	this.seed = seed;

    }
    public long next() {
    	long next =(_a*seed + _c) % _m;
    	seed = next;
        return next;
    }
    public void seed(long seed) { // seed(1)

    	this.seed = seed;

    }
}
