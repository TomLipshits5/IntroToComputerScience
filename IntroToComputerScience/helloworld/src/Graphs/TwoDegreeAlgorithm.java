package Graphs;

public class TwoDegreeAlgorithm extends GraphAlgorithm{
    public TwoDegreeAlgorithm(Graph input){
        super(input);
    }



    @Override
    public Object runAlgorithm() {
        for (int i = 0; i<input.numberOfVertices();i++){
            if(input.neighborsOf(i).size() != 2){
                return false;
            }
        }
        return true;
    }
}
