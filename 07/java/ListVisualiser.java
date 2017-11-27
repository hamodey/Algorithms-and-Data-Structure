public class ListVisualiser {
    SLList l;
    public ListVisualiser(SLList l) {

        this.l = l;

    }

    public void visualise() {
        //retrun ListVisualiser
        //apply Hare and Tortoise Algorithm
        System.out.println("##############################");
        //int counter = l.counter();
        int counter = l.length();
        int x = 0;
        //head = l.first()
        while(x != counter){
            if(x != counter-1){
                System.out.print(l.node(x));
            }else{
                System.out.print(l.end());
            }
            // if(x != counter-1){

            //     System.out.print(l.next());
            // }
            x++;
        }
        System.out.println();
        x = 0;
        while(x != counter ){
            System.out.print(l.piplines());
            x++;
        }
        System.out.println();
        x = 0;
        while(x != counter ){
            System.out.print(l.next(x));
            x++;
        }
    }
}
