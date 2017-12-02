public class ListVisualiserDriver {
    public static void main(String args[]) {
        //SLList a = new SLList(1, new SLList(11, new SLList(23, SLList.NIL)));

        SLList list1 = new SLList(1, null);
        SLList a = new SLList(4, list1);
        SLList list2 = new SLList(2, list1);
        list1.setRest(a);


	ListVisualiser v = new ListVisualiser(a);
        v.visualise();
    }
}
