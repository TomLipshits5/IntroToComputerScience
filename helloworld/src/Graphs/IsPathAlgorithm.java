package Graphs;

import Interfaces.List;
import com.Iterator;


public class IsPathAlgorithm extends GraphAlgorithm{
    private List<Integer> vList;

    public IsPathAlgorithm(Graph input, List<Integer> vList){
        super(input);
        this.vList = vList;
    }


    @Override
    public Object runAlgorithm() {
        Iterator<Integer> it = vList.iterator();
        int first=0;
        if(it.hasNext()) {first = it.next();}
        while(it.hasNext()){
            int second = it.next();
            if (!input.containsEdge(first,second)){
                return false;
            }
            first = second;

        }
        return true;
    }
}
