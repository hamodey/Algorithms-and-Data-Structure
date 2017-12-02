public class ListVisualiser {
    SLList l;
    SLList tortoise;
    SLList hare;

    public static final SLList NIL = new SLList(0, null);

    public ListVisualiser(SLList l) {

        this.l = l;
        SLList tortoise = l.rest();
        SLList hare = tortoise.rest();

    }
    //check List
    //length √
    //nth √
    //hare and t √
    //node, pipe, ends √

    public void visualise() {
        //retrun ListVisualiser
        //apply Hare and Tortoise Algorithm
        System.out.print("found");

        handt(l);
        // System.out.print("line28");

        //startLoop(l);

        if(handt(l) == false){
            //System.out.println("##############################");
            //int counter = l.counter();
            int counter = length(l);
            int x = 0;
            //head = l.first()
            while(x != counter){
                if(x != counter-1){
                    System.out.print(node(x));
                }else{
                    System.out.print(end());
                }
                x++;
            }
            System.out.println();
            x = 0;
            while(x != counter ){
                System.out.print(piplines());
                x++;
            }
            System.out.println();
            x = 0;
            while(x != counter ){
                System.out.print(next(l, x));
                x++;
            }
        }
        else{
            //do dis init
            //endLoop(l);
            int counter = 10;
            int x = 0;
            //head = l.first()
            while(x != counter){
                if(x != counter-1){
                    System.out.print(node(x));
                }else{
                    System.out.print(end());
                }
                x++;
            }
            System.out.println();
            x = 0;
            while(x != counter ){
                System.out.print(piplines());
                x++;
            }
            System.out.println();
            x = 0;
            while(x != counter ){
                System.out.print(next(l, x));
                x++;
            }
        }
    }

    public int length(SLList lst) {
        if(lst.rest() == null){
            return 0;
        }else{
            return 1 + lst.rest().length();
        }
    }

    public Object nth(SLList lst, int i) {
        int counter = 0;
        if (i == 0){
            return lst.first();
        }else{
            counter++;
            return lst.rest().nth(i-1);
        }
    }

    public Object node(int i){
        //this.nth(i);
        //System.out.print("[" + this.nth(i) + "]" + "-->");
        return "[*|*]->"; //+ this.nth(i);
    }
    public Object next(SLList lst, int i){
        return " " + lst.nth(i) + "    ";
    }
    public Object piplines(){
        return " |     ";

    }
    public Object end(){
        return  "[*|/]";

    }

    public boolean handt(SLList lst){

        tortoise = lst.rest();
        hare = tortoise.rest();

        while(hare != NIL){
            if(hare == tortoise){
                return true;
            }
            tortoise = tortoise.rest();
            if(hare.rest().rest() != null){
                hare = hare.rest().rest();

            }else{
                break;
            }
        }
        return false;
    }

    public SLList startLoop(SLList lst){
        SLList head = lst.rest();
        while(tortoise != head){
            tortoise = tortoise.rest();
            if(hare.rest().rest() != null){
                hare = hare.rest().rest();
            }else{
                break;
            }
            head = head.rest();
        }
        return tortoise;
    }

    // public SLList endLoop(SLList lst){
    //
    //     SLList hare = lst.rest();
    //
    //     while(tortoise.rest() != hare){
    //
    //         tortoise = tortoise.rest();
    //         hare = hare.rest();
    //     }
    //     tortoise.rest() = null;
    // }

}
