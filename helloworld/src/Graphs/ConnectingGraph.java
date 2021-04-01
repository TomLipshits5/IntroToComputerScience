package Graphs;

import Interfaces.Set;
import com.Iterator;

public class ConnectingGraph extends GraphAlgorithm{
    public ConnectingGraph(Graph input){
        super(input);
    }




    @Override
    public Object runAlgorithm() {
        Graph output = new GraphAsAdjacencyMatrix(input.numberOfVertices());
        Set<Edge> edges = input.edgeSet();
        Iterator<Edge> it = edges.iterator();
        while(it.hasNext()){
            Edge next = it.next();
            GraphAlgorithm pth = new HasPathAlgorithm(output, next.getLeft(), next.getRight());
            if (!(boolean)pth.runAlgorithm()){
                output.addEdge(next.getLeft(), next.getRight());
            }
        }
        return output;
    }
}
