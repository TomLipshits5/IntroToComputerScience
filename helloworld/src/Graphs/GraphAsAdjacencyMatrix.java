package Graphs;

import Interfaces.*;

public class GraphAsAdjacencyMatrix extends AbstractGraph{
    //Fields:
    private boolean[][] edges;

    public GraphAsAdjacencyMatrix(int nVertices){
        super(nVertices);
        edges = new boolean[nVertices][nVertices];
    }

    public GraphAsAdjacencyMatrix(Graph other){
        this(other.numberOfVertices());
        for (int i = 0; i<other.numberOfVertices(); i++){
            for (int j = i+1; j< other.numberOfVertices(); j++){
                if (other.containsEdge(i,j)){
                    addEdge(i,j);
                }
            }
        }
    }


    //Methods:
    @Override
    public boolean containsEdge(int i, int j) {
        if(!rangeCheck(i,j)){
            throw new IllegalArgumentException("Edge out of range");
        }
        return edges[i][j];
    }

    @Override
    public void addEdge(int i, int j) {
        if(!rangeCheck(i,j)){
            throw new IllegalArgumentException("Edge out of range");
        }
        edges[i][j] = true;
        edges[j][i] = true;
    }

    @Override
    public void removeEdge(int i, int j) {
        if(!rangeCheck(i,j)){
            throw new IllegalArgumentException("Edge out of range");
        }
        edges[i][j] = false;
        edges[j][i] = false;
    }

    private boolean rangeCheck(int i,int j){
        if (super.rangeCheck(i)&&super.rangeCheck(j)){
            return true;
        }
        return false;
    }


}
