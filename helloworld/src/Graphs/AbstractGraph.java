package Graphs;

import Interfaces.Set;

public abstract class AbstractGraph implements Graph {
    //Fields:
    final private int nVertices;


    //Constructors:
    public AbstractGraph(int nVertices){
        this.nVertices = nVertices;
    }


    //Methods:
    public int numberOfVertices() {
        return nVertices;
    }

    public int numberOfEdges() {
        return edgeSet().size();
    }

    public int degree(int v) {
        return 0;
    }

    public Set<Integer> neighborsOf(int v) {
        return null;
    }

    public Set<Integer> edgeSet() {
        return null;
    }

    //Abstract methods:
    public abstract boolean containsEdge(int i, int j);
    public abstract void addEdge(int i, int j);
    public abstract void removeEdge(int i, int j);
}
