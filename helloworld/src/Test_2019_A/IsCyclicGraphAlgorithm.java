package Test_2019_A;
import Graphs.*;
import Interfaces.Set;
import com.Iterator;


public class IsCyclicGraphAlgorithm extends GraphAlgorithm{

    private GraphAlgorithm tdAlgo;

    public IsCyclicGraphAlgorithm(Graph input){
        super(input);
        tdAlgo = new TwoDegreeAlgorithm(input);
    }

    @Override
    public Object runAlgorithm(){
        boolean output ;
        int n = input.numberOfVertices();
        if (n<3 || !(boolean)tdAlgo.runAlgorithm()){
            output = false;
        }else{
            boolean[] beenThere = new boolean[n];
            visit(0,beenThere);
            output = visitedAll(beenThere);
        }
        return output;
    }
    private void visit(int vertex,boolean[] beenThere){
        beenThere[vertex] = true;
        Set<Integer> neighbors = input.neighborsOf(vertex);
        Iterator<Integer> it = neighbors.iterator();
        while(it.hasNext()){
            int next = it.next();
            if (!beenThere[next]){
                visit(next,beenThere);
            }
        }
    }

    private boolean visitedAll(boolean[] arr) {
        boolean output = true;
        for (int i = 0; i < arr.length & output; i = i + 1)
            if (!arr[i])
                output = false;
        return output;
    }
}
