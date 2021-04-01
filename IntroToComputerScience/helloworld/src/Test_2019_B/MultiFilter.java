package Test_2019_B;

import Interfaces.Filter;
import Interfaces.List;
import com.Iterator;
import com.LinkedList;

public class MultiFilter<T> implements Filter<T> {
    private List<Filter<T>> filters;

    public MultiFilter(){
        filters = new LinkedList<Filter<T>>();
    }

    public void addFilter(Filter<T> filter){
        filters.add(filter);
    }

    @Override
    public boolean accept(T object) {
        Iterator<Filter<T>> filterIt = filters.iterator();
        while(filterIt.hasNext()){
            Filter<T> curr = filterIt.next();
            if (!curr.accept(object)){
                return false;
            }
        }
        return true;
    }
}
