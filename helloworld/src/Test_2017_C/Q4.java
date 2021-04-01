package Test_2017_C;

import Interfaces.List;
import com.Iterator;

public class Q4 {
    public static boolean containsNVertices(List<Integer> number, int n){
        if (number.size() != n){
            return false;
        }
        boolean[] visited = new boolean[n];
        Iterator<Integer> listIt = number.iterator();
        while(listIt.hasNext()){
            Integer next = listIt.next();
            if (next<n){
                visited[next] = true;
            }
        }
        for (boolean b:visited){
            if(!b){
                return false;
            }
        }
        return true;
    }
}
