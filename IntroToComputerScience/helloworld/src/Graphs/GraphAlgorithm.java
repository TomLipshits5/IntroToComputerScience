package Graphs;

public abstract class GraphAlgorithm {
    protected Graph input;

    public GraphAlgorithm(Graph input){
        this.input = input;
    }

    public abstract Object runAlgorithm();

}
