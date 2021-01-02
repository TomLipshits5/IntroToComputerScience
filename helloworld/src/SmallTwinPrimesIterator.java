import java.util.Iterator;

public class SmallTwinPrimesIterator implements Iterator{

    private Iterator primesIter;
    private int nextSmallTwin;


    public SmallTwinPrimesIterator(){
        Iterator<Integer> primesIter = new PrimesIterator2();
        primesIter.next();
        nextSmallTwin = primesIter.next();;
    }


    public  void prepareNext(){
        primesIter = new PrimesIterator2();
        int smallTwin = (int)primesIter.next();
        while(smallTwin<nextSmallTwin){
            smallTwin = (int)primesIter.next();
        }
        smallTwin = (int)primesIter.next();
        int bigTwin = (int) primesIter.next();
        while(bigTwin-smallTwin != 2){
            smallTwin = bigTwin;
            bigTwin = (int)primesIter.next();
        }
        nextSmallTwin = smallTwin;
    }






    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Object next() {
        int output = (int)nextSmallTwin;
        prepareNext();
        return output;
    }


    public static void main(String[] args){
        Iterator it = new SmallTwinPrimesIterator();
        for (int i = 0 ; i<15; i++ ){
            System.out.println(it.next());
        }
    }
}
