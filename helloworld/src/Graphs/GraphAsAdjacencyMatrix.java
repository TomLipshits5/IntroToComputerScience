package Graphs;

import Interfaces.*;

public class GraphAsAdjacencyMatrix extends AbstractGraph{
    //Fields:
    private boolean[][] edges;

    public GraphAsAdjacencyMatrix(int nVertices){
        super(nVertices);
        edges = new boolean[nVertices][nVertices];
    }


    //Methods:
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
