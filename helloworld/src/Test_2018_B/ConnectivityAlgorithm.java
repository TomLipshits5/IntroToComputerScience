package Test_2018_B;

import Graphs.Graph;
import Graphs.GraphAlgorithm;

public class ConnectivityAlgorithm extends GraphAlgorithm {
    private GraphAlgorithm bfa;

    public ConnectivityAlgorithm(Graph input){
        super(input);
        bfa = new BreathFirstAlgorithm(input,0);
    }

    @Override
    public Object runAlgorithm() {
        int[] dist = (int[])bfa.runAlgorithm();
        for (int i: dist){
            if (i ==-1){
                return false;
            }
        }
        return true;
    }
}
