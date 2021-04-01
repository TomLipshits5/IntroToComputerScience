package Test_2019_A;
import Graphs.*;


public class TwoDegreesAlgorithm extends GraphAlgorithm{


    public TwoDegreesAlgorithm(Graph input){
        super(input);

    }



    @Override
    public Object runAlgorithm() {
        for (int i = 0; i< input.numberOfVertices();i++){
            if (input.degree(i)!=2){
                return false;
            }
        }
        return true;
    }
}
