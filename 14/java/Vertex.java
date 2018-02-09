import java.util.ArrayList;

public class Vertex {
    public String name;
    public ArrayList<Edge> adjlist;
    public boolean visited;

    public Vertex(String _name) {
        this.name = _name;
        this.adjlist = new ArrayList<Edge>();
    }

    public boolean isVisted(){
        return this.visited;
    }

    public void setVisited(boolean thing){
        this.visited = thing;
    }
}
