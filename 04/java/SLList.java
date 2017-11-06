class SLList {
    Object firstList;
    SLList restOfList;
    public SLList(Object f, SLList r) {
        firstList = f;
        restOfList = r;

    }
    public static final SLList NIL = new SLList(0, null);

    public Object first() {
        return firstList;
    }
    public SLList rest() {
        return restOfList;
    }
    public void setFirst(Object f) {
        firstList = f;
    }
    public void setRest(SLList r) {
        restOfList = r;
    }

    public Object nth(int i) {
        int counter = 0;
        if (i == 0){
            return this.first();
        }else{
            counter++;
            return this.rest().nth(i-1);
        }
    }
    public SLList nthRest(int i){
        int counter = 0;
        SLList ongoing = this;
        boolean notFound = true;
        while(notFound){
            if(counter == i){
                notFound = false;
                return ongoing;
            }
            counter++;
            ongoing = ongoing.rest();
        }return ongoing;
    //return [0,1,2,n,3,4,5,6] nthRest(n) = [3,4,5,6]
    }
    // no such thing as `unsigned' in Java
    public int length() {
        if(restOfList == null){
            return 0;
        }else{
            return 1 + restOfList.length();
        }
    }

    public Integer sum(){
        int sum = 0;
        SLList ongoing = this;

        if(ongoing.restOfList == null){
            sum = sum + (Integer)ongoing.first();
            return sum;
        }
        while(ongoing.rest() != null){
            sum = sum + (Integer)ongoing.first();
            ongoing = ongoing.rest();
        }
        return sum;
    }

    public SLList removeAim(Object o,SLList lst) {

        if(lst.rest() == null){
            return NIL;
        }
        else if(o == lst.first()){
            return removeAim(o, lst.rest());
        }else{
            //return a new list with first is o and whos rest is rest list
            // ongoing.setFirst(nth((Integer)o));
            // ongoing = ongoing.rest();
            SLList new1 = new SLList(lst.first(), removeAim(o, lst.rest()));
            return new1;
        }
    }
    public SLList remove(Object o){
        SLList ongoing = this;
        return removeAim(o, ongoing);
    }
    //
    // static void reverseArray(int inputArray[]){
    // // System.out.println("Array Before Reverse : "+Arrays.toString(inputArray));
    // int temp;
    // for (int i = 0; i < inputArray.length/2; i++) {
    //     temp = inputArray[i];
    //     inputArray[i] = inputArray[inputArray.length-1-i];
    //     inputArray[inputArray.length-1-i] = temp;
    // }
    //
    //     // System.out.println("Array After Reverse : "+Arrays.toString(inputArray));
    // }

    public SLList reverse() {
        //
        // SLList head = firstList;
        // SLList ongoing = head;
        // SLList prev = null;
        // SLList next = this.rest();
        // int i = 1;
        // while(ongoing != null){
        //     next = ongoing.rest();
        //     ongoing.nth() = prev;
        //     prev = ongoing;
        //     currnt = ongoing.nth(i++);
        // }
        // // if(ongoing.first() == null){
        // //     return NIL;
        // // }
        // // Object[] arr = new Object[restOfList.length()];
        // // for(int i = 0; i < this.length(); i++){
        // //     arr[i] = this.nth(i);
        // // }
        // //
        // // return reverseArray((Integer)arr);
        return null;
    }
}
