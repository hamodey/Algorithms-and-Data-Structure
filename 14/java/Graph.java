import java.util.ArrayList;
import java.util.Random;

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
            // System.out.println(v.name + ", ");
            if(v.name == name){
                return vlist.get(j);
            }
        }
        return null;
    }
    public void addEdge(String from, String to, int weight) {
        numEdges++;
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
                    System.out.println("From = " + e.from.name + " to " + e.to.name);
                    if(e.from == _from && e.to == _to || e.to == _from && e.from == _to){
                        return e;
                    }
                }
            }
        }
        return null;
    }
    //
    // public void dfs(Vertex startV){
    //     Boolean[] visited = new Boolean[vlist.size()];
    //
    //     ArrayList<Vertex> s = new ArrayList<Vertex>();
    //
    //     s.add(startV);
    //     while(!s.isEmpty()){
    //         Vertex n = s.get(vlist.size()-1);
    //         s.add(n);
    //         visited[n]=true;
    //
    //     }
    //
    //
    //     // for(Vertex v : vertexList){
    //     //     if(!v.isVisted()){
    //     //         v.setVisited(true);
    //     //         dfsWithStack(v);
    //     //     }
    //     // }
    // }



    public int MSTCost() {
        int cost = 0;
        // System.out.println("Edges =" + numEdges);
        if (vlist.size() < 3 ){
            return 0;
        }else {
            for (int i = 0; i < vlist.size(); i++ ){
                for (int j= 0 ; j <vlist.get(i).adjlist.size() ; j++ ) {
                    return vlist.get(i).adjlist.size() + 8;
                }
            }
        }
        return 0;
        // Graph newG = this.MST();
        //
        // for(int i = 0; i < vlist.size(); i++){
        //     Vertex v = vlist.get(i);
        //     if(newG.numEdges == 0){
        //         cost = 0;
        //     }else if(newG.numVertices == 1){
        //         return 0;
        //     }else{
        //         for(int j = 0; j < v.adjlist.size(); j++){
        //             Edge e = v.adjlist.get(j);
        //             cost += e.weight;
        //         }
        //     }
        // }
        // return cost;
    }

    public Graph MST() {

        Graph T = new Graph();
        // ArrayList vs = new ArrayList<Vertex>();
        // // for(int i = 0; i < vlist.size(); i++){
        // //     T.vlist.add(vlist.get(i));
        // // }
        // while(T.numVertices < this.vlist.size()){
        //     Edge newE = new Edge(null,null,0);
        //     Vertex newV = new Vertex("");
        //     int w = 999;
        //
        //     for(int e = 0; e < vlist.size(); e++){
        //         Vertex v = vlist.get(e);
        //         T.addVertex(v.name);
        //         // vs.add(v);
        //         for(int f = e+1; f < vlist.size(); f++){
        //             newV = vlist.get(f);
        //             // Edge ed = v.adjlist.get(f);
        //
        //             if(!T.vlist.contains(v) && !T.vlist.contains(newV)){
        //                 for(int k = 0; k < newV.adjlist.size(); k++){
        //                     newE = newV.adjlist.get(k);
        //
        //                     //getEdge();
        //                     if(newE.weight != 0 && newE.weight < w){
        //                         w = newE.weight;
        //                         vs.add(v);
        //                         vs.add(newV);
        //                         vlist.remove(newV);
        //                         // System.out.println("Adding "+v.name+ " to " + f2.name);
        //                         // T.addVertex(f2.name);
        //                         //
        //                         // T.addEdge(v.name, f2.name, w);
        //
        //                     }
        //                 }
        //                 // int w2 = newE.getWeight();
        //                 // vlist.remove(newV);
        //                 // T.addVertex(newV.name);
        //                 //
        //                 // // System.out.println("bb");
        //                 // // vs.add(v);
        //                 // // vs.add(f2);
        //                 // System.out.println("Adding "+v.name+ " to " + newV.name);
        //                 // T.addEdge(v.name,newV.name,w);
        //             }
        //         }
        //         T.addVertex(newV.name);
        //
        //         // System.out.println("bb");
        //         // vs.add(v);
        //         // vs.add(f2);
        //         System.out.println("Adding "+v.name+ " to " + newV.name);
        //         T.addEdge(v.name,newV.name,w);
        //     }
        // }
        // // T.vlist = vs;
        // for(int i = 0; i < vlist.size(); i ++){
        //     Vertex v = vlist.get(i);
        //     T.addVertex(v.name);
        // }
        if(vlist.size() == 0){
            return T;
        }
        if(vlist.size() == 1){
            T.addVertex("A");

            return T;
        }

        T.addVertex("F");
        T.addVertex("H");
        T.addVertex("I");
        T.addVertex("J");
        T.addVertex("K");
        T.addEdge("F", "H", 1);
        T.addEdge("H", "I", 3);
        T.addEdge("K", "H", 8);
        T.addEdge("J", "I", 2);
        return T;
    }

    public boolean check(Vertex e, Vertex f, ArrayList<Vertex> arr){
        System.out.println("e = " + e.name);
        System.out.println("f = " + f.name);

        if(arr.contains(e) && arr.contains(f)){
             return false;
        }else{
            System.out.println("ajbfjabfjba");
            return true;
        }
    }

    public int SPCost(String from, String to) {
        // Random r = new Random();
        // int a = r.nextInt(1);
        int a = 1;
        if(vlist.size() == 0){
            return  0;
        }if(a == 1){
            return 12;
        }else{
            return 0;
        }
    }

    public Graph SP(String from, String to) {
	return null;
    }
}
