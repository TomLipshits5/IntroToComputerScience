import java.util.Iterator;

public class PrimesIterator2 implements Iterator {
    //Fields:
    private List primes;
    private int nextPrime;

    public PrimesIterator2(){
        primes = new DynamicArray();
        nextPrime = 2;
    }
    public boolean isPrime(int num){
        int p = 2;
        boolean ans = true;
        while(ans && p*p<=num){
            if(num%p==0){
                ans = false;
            }
            p++;

        }
        return ans;
    }

    private void prepaireNext(){
        primes.add(nextPrime);
        int ans = nextPrime+1;
        while(!isPrime(ans)){
            ans++;
        }
        nextPrime = ans;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Object next() {
        int output = nextPrime;
        prepaireNext();
        return output;
    }



    public static void main(String[] args){
        Iterator it = new PrimesIterator2();
        for (int i = 0 ; i<7; i++ ){
            System.out.println(it.next());
        }
    }
}
