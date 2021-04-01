package Graphs;

public class ConectivityAlgorithem2 extends GraphAlgorithm{
    private GraphAlgorithm brf;

    public ConectivityAlgorithem2(Graph input){
        super(input);
        brf = new BreadthFirstAlgorithem(input,0);
    }



    public Object runAlgorithm(){
        int[] results = (int[]) brf.runAlgorithm();
        for (Integer i : results){
            if (i==-1){
                return false;
            }
        }
        return true;
    }
}
