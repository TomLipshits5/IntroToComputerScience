package Test_2020_A;

import com.Link;

public class BiDirectionalLink<E> extends Link<E> {
    private Link<E> prev;

    public BiDirectionalLink(E data,Link<E> next,Link<E> prev){
        super(data,next);
        this.prev = prev;
    }

    public Link<E> getPrev(){
        return prev;
    }
    public void setPrev(Link<E> element){
        prev = element;
    }
}
