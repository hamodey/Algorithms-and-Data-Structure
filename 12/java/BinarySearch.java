public class BinarySearch {
    // public OpCounter counter = new OpCounter();
    int counter = 0;
    public boolean search(int array[], int key, int lo, int hi) {
        int mid = lo + (hi - 1 - lo)/2;

        if(lo == hi){
            return false;
        }
        // counter.add(1);
        counter++;
        if(array[mid] == key){
            return true;
        }
        else if(key < array[mid]){
            return search(array, key, lo, mid);
        }
        else {
            return search(array, key, mid+1, hi);
        }
    }

    // int count(int array[], int key, int lo, int hi) {
    // 	counter = new OpCounter();
    // 	search(array, key, lo, hi);
    // 	return counter.report();
    //
    // }
    int count(int array[], int key, int lo, int hi) {
        counter = 0;
        search(array, key, lo, hi);
        return counter;

    }
}
