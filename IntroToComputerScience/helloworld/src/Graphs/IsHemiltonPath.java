package Graphs;


import Interfaces.List;
import com.Iterator;

import java.util.ArrayList;

public class IsHemiltonPath  extends  GraphAlgorithm{
    private List<Integer> vList;


    public IsHemiltonPath(Graph input, List<Integer> vList){
        super(input);
        this.vList = vList;
    }

    @Override
    public Object runAlgorithm() {
        if (vList.size() != input.numberOfVertices()||input.numberOfVertices()<3){
            return false;
        }
        Iterator<Integer> it = vList.iterator();
        boolean[] arr = new boolean[vList.size()];
        while(it.hasNext()){
            int next = it.next();
            if (arr[next]){
                return false;
            }
            else{
                arr[next] = true;
            }
        }

        GraphAlgorithm isPath = new IsPathAlgorithm(input,vList);
        int first = vList.get(0);
        int last = vList.get(vList.size()-1);

        return input.containsEdge(first,last) && (Boolean) isPath.runAlgorithm();
    }
}
