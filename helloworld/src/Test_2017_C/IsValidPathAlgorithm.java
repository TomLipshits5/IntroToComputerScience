package Test_2017_C;
import Graphs.*;
import Interfaces.*;
import com.Iterator;


public class IsValidPathAlgorithm extends GraphAlgorithm{
    private List<Integer> vertices;

    public IsValidPathAlgorithm(Graph input,List<Integer> vertices){
        super(input);
        if (vertices == null){
            throw new IllegalArgumentException("vertices cant be null");
        }
        this.vertices = vertices;
    }



    @Override
    public Object runAlgorithm() {
        if (vertices.size()<=1){
            return true;
        }
        Iterator<Integer> listIt = vertices.iterator();
        Integer first = listIt.next();
        while(listIt.hasNext()){
            Integer second = listIt.next();
            if (!input.containsEdge(first,second)){
                return false;
            }
            first = second;
        }
        return true;
    }
}
