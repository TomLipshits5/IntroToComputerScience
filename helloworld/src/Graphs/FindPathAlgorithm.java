package Graphs;

import Interfaces.List;
import Interfaces.Set;
import com.Iterator;
import com.LinkedList;

public class FindPathAlgorithm extends GraphAlgorithm{
    private int start,end;

    public FindPathAlgorithm(Graph input,int start,int end){
        super(input);
        this.start = start;
        this.end = end;
    }


    @Override
    public Object runAlgorithm() {
        int[] visited = new int[input.numberOfVertices()];
        for(int i = 0 ;i<input.numberOfVertices();i++){
            visited[i] = -1;
        }
        dfsVisited(start,visited,-2);
        return restorePath(visited,start,end);
    }


    private void dfsVisited(int start , int[] visited,int v){
        visited[start] = v;
        Set<Integer> neighbors = input.neighborsOf(start);
        Iterator<Integer> it = neighbors.iterator();
        while(it.hasNext()){
            int next = it.next();
            if (visited[next] == -1){
                dfsVisited(next,visited,start);
            }

        }
    }

    private List<Integer> restorePath(int[] visited,int start,int end){
        if (visited[end] == -1){
            return null;
        }
        int value = end;
        List<Integer> output = new LinkedList<>();
        output.add(end);
        while(value!=start){
            output.add(0,visited[value]);
            value = visited[value];
        }
        return output;
    }
}
