class DynamicArray {
    public OpCounter counter = new OpCounter();
    int nitems;
    int [] storage;
    int [] new1;
    int size2 = 0;
    public DynamicArray(int size) {
        storage = new int[size];
        nitems = 0;
        size2 = size;
        //storage[size2];
    }
    public int length() {
        return nitems;
    }
    public int select(int k) {
        return storage[k];
    }
    public void store(int o, int k) {
        storage[k] = o;
    }
    public void push(int o) {
        //System.out.println(size2 - nitems);
        if(nitems == size2){
            extend();
        }
        storage[nitems] = o;
        nitems++;
        counter.add(1);
    }
    public int pop() {
        nitems--;
        return storage[nitems];
    }
    private void extend() {
        size2 = size2 * size2;
        new1 = new int[size2];
        for (int j = 0; j < nitems; j++ ){
         new1[j] = storage[j];
         counter.add(1);
        }
        storage = new1;

    }
}
