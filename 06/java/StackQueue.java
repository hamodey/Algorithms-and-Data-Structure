public class StackQueue {
    private static Stack s;
    private static Queue q;
    public static void main(String[] args) {
	prepare();
	System.out.print(q.dequeue());//3
	System.out.print(s.pop());//3
	System.out.print(s.pop());//4
	System.out.print(q.dequeue());//9
	s.pop();
	q.dequeue();
	System.out.print(s.pop());//7
	System.out.print(q.dequeue());//5
	System.out.print(s.pop());//8
	System.out.println(q.dequeue());//8;
	s.pop();
	q.dequeue();
    }
    private static void prepare() {

        q.enqueue(3);
        s.push(3);
        s.push(4);
        q.enqueue(9);
        s.push(7);
        q.enqueue(5);
        s.push(8);
        q.enqueue(8);

    }
}
