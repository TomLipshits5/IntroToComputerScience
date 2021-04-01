package Test_2019_B;

import Interfaces.Comparator;
import Interfaces.List;
import com.Iterator;

public class BinaryNumberComperator implements Comparator<List<Integer>>{
    @Override
    public int compare(List<Integer> e1, List<Integer> e2) {
        Iterator<Integer> it1 = e1.iterator();
        Iterator<Integer> it2 = e2.iterator();
        int output = 0;
        while(it1.hasNext()&&it2.hasNext()){
            int comp = it1.next().compareTo(it2.next());
            if (comp!=0){
                output = comp;
            }
        }if (it1.hasNext()){
            while(it1.hasNext()){
                if (it1.next() == 1){
                    return 1;
                }
            }
        }if (it2.hasNext()){
            while(it2.hasNext()){
                if (it2.next()==1){
                    return -1;
                }
            }
        }
        return output;
    }
}
