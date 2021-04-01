package Test_2018_B;

import Graphs.*;
import Interfaces.Queue;
import Interfaces.Set;
import com.Iterator;
import com.QueueAsLinkedList;


public class BreathFirstAlgorithm extends GraphAlgorithm {

    private int source;

    public BreathFirstAlgorithm(Graph input, int source) {
        super(input);
        this.source = source;
    }


    public Object runAlgorithm() {
        int[] distance = new int[input.numberOfVertices()];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = -1;
        }
        Queue<Integer> q = new QueueAsLinkedList<>();
        q.enqueue(source);
        distance[source] = 0;
        bfsVisit(distance, q);
        return distance;
    }


    private void bfsVisit(int[] distance, Queue<Integer> q) {
        while (!q.isEmpty()) {
            int curr = q.dequeue();
            Set<Integer> neighbors = input.neighborsOf(curr);
            Iterator<Integer> it = neighbors.iterator();
            while (it.hasNext()) {
                int next = it.next();
                if (distance[next] == -1){
                    q.enqueue(next);
                    distance[next] = distance[curr] + 1;
                }
            }
        }
    }

}
