import java.util.ArrayList;

public class Graph {
    public ArrayList<Vertex> vlist;
    int numVertices;
    int numEdges;

    public Graph() {
        Vertex initialVertex = new Vertex("");
        this.vlist = new ArrayList<Vertex>();
        for(int i = 0; i < vlist.size(); i++){
            vlist.add(i, initialVertex);
        }
        numVertices = 0;
        numEdges = 0;
    }

    public void addVertex(String name) {
        numVertices++;
        Vertex v = new Vertex(name);
        vlist.add(v);
    }

    public Vertex getVertex(String name) {
        int i = vlist.indexOf(name);
        // System.out.println("ith index " + i);
        for(int j = 0; j < vlist.size(); j ++){
            Vertex v = vlist.get(j);
            System.out.println(v.name + ", ");
            if(v.name == name){
                return vlist.get(j);
            }
        }
        return null;
    }
    public void addEdge(String from, String to, int weight) {
        Vertex _from = getVertex(from);
        Vertex _to = getVertex(to);

        Edge e = new Edge(_from, _to, weight);

        _from.adjlist.add(e);
        _to.adjlist.add(e);
    }

    public Edge getEdge(String from, String to) {
        Vertex _from = getVertex(from);
        Vertex _to = getVertex(to);

        if(_from != null && _to != null){
            for(int k = 0; k < vlist.size(); k++){
                Vertex v = vlist.get(k);
                for(int j = 0; j < v.adjlist.size(); j++){
                    Edge e = v.adjlist.get(j);
                    if(e.from == _from && e.to == _to || e.to == _from && e.from == _to){
                        return e;
                    }
                }
            }
        }
        return null;
    }

    public int MSTCost() {
	return -1;
    }

    public Graph MST() {
	return null;
    }

    public int SPCost(String from, String to) {
	return 0;
    }

    public Graph SP(String from, String to) {
	return null;
    }
}
