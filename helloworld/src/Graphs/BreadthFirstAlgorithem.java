package Graphs;
import Interfaces.Queue;
import Interfaces.Set;
import com.Iterator;
import com.QueueAsLinkedList;

public class BreadthFirstAlgorithem extends GraphAlgorithm{
    private int source;

    public BreadthFirstAlgorithem(Graph input , int source){
        super(input);
        this.source = source;
    }

    @Override
    public Object runAlgorithm() {
        int[] distance = new int[input.numberOfVertices()];
        for (int i = 0 ; i<input.numberOfVertices(); i++){
            distance[i] =-1;
        }
        Queue<Integer> q = new QueueAsLinkedList<>();
        q.enqueue(source);
        distance[source] =0;
        bfsVisit(q,distance);
        return distance;
    }


    private void bfsVisit(Queue<Integer> q, int[] distance){
        int d = 1;
        while(!q.isEmpty()){
            int node = q.dequeue();
            Set<Integer> neighbors = input.neighborsOf(node);
            Iterator<Integer> it = neighbors.iterator();
            while(it.hasNext()){
                int i = it.next();
                if(distance[i] ==-1){
                    distance[i] = distance[node] +1;
                    q.enqueue(i);
                }
            }

        }
    }
}
