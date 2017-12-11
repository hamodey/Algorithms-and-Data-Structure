public class HashTable {
    // public for testing purposes
    public int buckets[];
    public int tombstone = -1;
    long _a;
    long _c;
    long _m;
    long size2 = 0;
    int [] new1;
    public HashTable(long _a, long _c, long _m) {
        this._a = _a;
        this._c = _c;
        this._m = _m;
        size2 = (int)_m;
        buckets = new int[(int)_m];
    }

    public long hash(int key){
        long hash = 0;
        hash = ((_a * key) + _c) % _m;
        return hash;
    }
    public long probe(long i,long k,long h){
        //math.pow
        //return (long)(i -Math.pow(-1, k) * Math.pow(k, 2)) % _m;
        return (i + k) % _m;
    }

    public void insert(int key) {

  //calculate hash value and use as index
      int i = (int) hash(key);
      //linear probing - while slot not 0, insert key in next available slot
      while ( i < buckets.length && buckets[i] != 0) {
          i++;
        }
        if (i >= buckets.length)

           extend();


       buckets[i] = key;
  }

    public void remove(int key) {
    //search for key in buckets
        for (int i = 0; i < buckets.length; i++) {
         if(buckets[i] == key)
         buckets[i] = 0;
        }
    }
    // public boolean find(int key) {
    //     long i = hash(key);
    //     long k = 0;
    //     long j = 0;
    //     do{
    //         j = probe(i, k, _m);
    //         k++;
    //         if(buckets[(int)j] == key){
    //             return true;
    //         }
    //     }while(buckets[(int)j] != 0);
    //     return false;
    // }
    public boolean find(int key) {
        for (int i = 0; i < buckets.length; i++) {
            if(buckets[i] == key)
                return true;
            }
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
        return load;
    }
    private void extend() {//copy()
        System.out.println("happening " + buckets.length);
        size2 = size2 * 2;
        new1 = new int[(int)size2];
        for (int j = 0; j < buckets.length; j++ ){
         new1[j] = buckets[j];
        }
        buckets = new1;
        System.out.println("happening new " + buckets.length);

    }
}
