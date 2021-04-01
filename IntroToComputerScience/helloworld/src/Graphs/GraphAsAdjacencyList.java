package Graphs;

import Interfaces.*;
import com.DynamicArray;


public class GraphAsAdjacencyList extends AbstractGraph{
    //Fields:
    private List<List<Integer>> adj;

    //Constructors:
    public GraphAsAdjacencyList(int nVertices){
        super(nVertices);
        adj = new DynamicArray<List<Integer>>();
        for (int i =0 ; i<nVertices; i++){
            adj.add(new DynamicArray<Integer>());
        }

    }


    @Override
    public boolean containsEdge(int i, int j) {
        Edge e = toEdge(i,j);
        return adj.get(e.left).contains(e.right);
    }

    @Override
    public void addEdge(int i, int j) {
        Edge e = toEdge(i,j);
        if (!adj.get(e.left).contains(e.right)){
            adj.get(e.left).add(e.right);
        }
    }

    @Override
    public void removeEdge(int i, int j) {
        Edge e = toEdge(i,j);
        if (adj.get(e.left).contains(e.right)){
            adj.get(e.left).remove(e.right);
        }
    }


    private Edge toEdge(int i , int j){
        Edge edge = new Edge(Math.min(i,j),Math.max(i,j));
        return edge;
    }


}
