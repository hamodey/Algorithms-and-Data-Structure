import java.util.ArrayList;
import java.util.List;


public class AhmedHeapTest{
    public static void main(String [] args){

        Heap a = new Heap(11342);
        a.buildMaxHeap();
        System.out.println(a.counter);
    }
}
