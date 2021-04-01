package Graphs;

public class Edge {
    //Fields:
    protected int left;
    protected int right;

    //Constructors:
    public Edge(int left, int right){
        this.left = left;
        this.right = right;

    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public String toString(){
        return "(" + left+","+right+")";
    }
}
