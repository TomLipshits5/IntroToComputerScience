package Graphs;


public class ConectivityAlgorithm extends GraphAlgorithm {

    public ConectivityAlgorithm(Graph input){
        super(input);
    }

    @Override
    public Object runAlgorithm() {
        int nVertices = input.numberOfVertices();
        boolean[] visited =  new boolean[nVertices];
        for (int i = 0 ; i<visited.length ;i++){
            visited[i] = false;
        }
//        dfsVisit(0,visited);
        return reachAll(visited);
    }
//
//    private void dfsVisit(int i,boolean[] visited){
//        visited[i] = true;
//        for (Integer j : input.neighborsOf(i)) {
//            if (!visited[j]){
//                dfsVisit(j,visited);
//            }
//        }
//    }

    private boolean reachAll(boolean[] visited){
        for (Boolean i : visited){
            if (!i){
                return false;
            }
        }
        return true;
    }


}
