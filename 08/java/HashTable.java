public class HashTable {
    // public for testing purposes
    public int buckets[];
    long _a;
    long _c;
    long _m;
    public HashTable(long _a, long _c, long _m) {
        this._a = _a;
        this._c = _c;
        this._m = _m;

        buckets = new int[(int)_m];
    }

    public long hash(int key){
        long hash = 0;
        hash = ((_a * key) + _c) % _m;
        return hash;
    }
    public long probe(long i,long k,long h){
        //math.pow
        return (long)(i -Math.pow(-1, k) * Math.pow(k, 2)) % _m;
    }

    public void insert(int key) {
        long i = hash(key);
        long k = 0;
        long j = 0;
        do{
            i = probe(i, k, _m);
            k++;
        }while(buckets[(int)i] != 0);
        buckets[(int)i] = key;
    }


    public boolean find(int key) {
        long i = hash(key);
        long k = 0;
        long j = 0;
        do{
            j = probe(i, k, _m);
            k++;
            if(buckets[(int)j] == key){
                return true;
            }
        }while(buckets[(int)j] != 0);
        return false;
    }
    public double loadFactor() {
        double counter = 0;
        //ITEMS IN TABLE / SIZE OF THE TABLE
        for(int i = 0; i < buckets.length; i++){
            if(buckets[i] != 0){
                counter++;
            }
        }
        double load = 0;
        double total_size = buckets.length;
        load = counter/total_size;
        return counter/total_size;
    } 
}
