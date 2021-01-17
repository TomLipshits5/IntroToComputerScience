package Graphs;

import Interfaces.Set;
import com.SetAsLinkedList;

public abstract class AbstractGraph implements Graph{
    //Fields:
    final private int nVertices;


    //Constructors:
    public AbstractGraph(int nVertices){
        if (nVertices<= 0){
            throw new IllegalArgumentException("Vertices cant be lower or equal to zero");
        }
        this.nVertices = nVertices;
    }


    //Methods:
    public int numberOfVertices() {
        return nVertices;
    }// HW

    public int numberOfEdges() {
        return edgeSet().size();
    } // HW

    public int degree(int v) {
        if (!rangeCheck(v)){
            throw new IllegalArgumentException("V not in range");
        }
        return neighborsOf(v).size();
    }

    public Set<Integer> neighborsOf(int v) {
        return null;
    } // HW

    public Set<Edge> edgeSet() {
        Set<Edge> edgeSet = new SetAsLinkedList<>();
        for (int i = 0 ; i<numberOfVertices(); i++){
            for (int j = i+1; j< numberOfVertices(); j++){
                if(containsEdge(i,j)){
                    edgeSet.add(new Edge(i,j));
                }
            }
        }
        return edgeSet;
    }

    /**
     * @param v Vertices to preform action on
     * @return true if v is in vertices.
     */
    public boolean rangeCheck(int v){
        if (v<0 || v>nVertices){
            return false;
        }
        return true;
    }

    //Abstract methods:
    public abstract boolean containsEdge(int i, int j);
    public abstract void addEdge(int i, int j);
    public abstract void removeEdge(int i, int j);
}
