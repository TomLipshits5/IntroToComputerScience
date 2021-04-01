package Graphs;

import Interfaces.Set;
import com.Iterator;

public class HasPathAlgorithm extends GraphAlgorithm {
    private int ver1,ver2;

    public HasPathAlgorithm(Graph input,int ver1,int ver2){
        super(input);
        this.ver1 = ver1;
        this.ver2 = ver2;
    }

    private void dfsVisit(int vertex, boolean[] visited){
        visited[vertex] = true;
        Set<Integer> neighbors = input.neighborsOf(vertex);
        Iterator<Integer> it = neighbors.iterator();
        while(it.hasNext()){
            int next = it.next();
            if (!visited[next]){
                dfsVisit(next,visited);
            }
        }
    }




    @Override
    public Object runAlgorithm() {
        boolean[] results = new boolean[input.numberOfVertices()];
        dfsVisit(ver1,results);
        return results[ver2];
    }
}
