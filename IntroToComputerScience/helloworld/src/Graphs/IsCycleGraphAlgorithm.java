package Graphs;

import Interfaces.Set;
import com.Iterator;

public class IsCycleGraphAlgorithm extends GraphAlgorithm {
    private GraphAlgorithm twoDegree;

    public IsCycleGraphAlgorithm(Graph input) {
        super(input);
        twoDegree = new TwoDegreeAlgorithm(input);
    }

    @Override
    public Object runAlgorithm() {
        boolean output = true;
        int n = input.numberOfVertices();
        if (n < 3 || !(boolean)twoDegree.runAlgorithm()) output = false;
        else {
            boolean[] beenThere = new boolean[n];
            visit(0,beenThere);
            output = visitedAll(beenThere);
        }
        return output;
    }


    private void visit(int vertex, boolean[] beenThere) {
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
        for (boolean i : arr) {
            if (!i) {
                return false;
            }
        }
        return true;
    }
}
