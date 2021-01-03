package Graphs;

import Interfaces.*;
import com.LinkedList;


public class GraphAsAdjacencyList extends AbstractGraph{
    //Fields:
    private List<List<Integer>> adj;

    //Constructors:
    public GraphAsAdjacencyList(int nVertices){
        super(nVertices);
        adj = new LinkedList<List<Integer>>();
        for (int i =0 ; i<nVertices; i++){
            adj.add(0,new LinkedList<Integer>());
        }

    }


    @Override
    public boolean containsEdge(int i, int j) {
        return false;
    }

    @Override
    public void addEdge(int i, int j) {

    }

    @Override
    public void removeEdge(int i, int j) {

    }


}
