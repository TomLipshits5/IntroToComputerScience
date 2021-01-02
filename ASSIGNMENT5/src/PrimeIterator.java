/*---------------------------------------
Genuine author: Tom Lipshits, I.D.: 316005370
 Date: 29-12-2020
---------------------------------------*/

import java.util.Iterator;

public class PrimeIterator implements Iterator<Integer> {

    private List<Integer> primes;

    //Complete the following methods
    //Constructor, initialise a linked list ans add the first prime number 2.
    public PrimeIterator() {
        // task 0
        primes = new DynamicArray<>();
        primes.add(2);
    }

    //return true a long as the user don't request a prime number bigger than INTEGER.MAX_VALUE
    public boolean hasNext() {
        // task 0
        return primes.get(primes.size()-1) > 0;
    }

    //Finds the next prime number and adds it to the  primes list, returns former last to the user.
    public Integer next() {
        // task 0
        int next = primes.get(primes.size() - 1);
        int number = next + 1;
        int i = 0;
        //Iterate through all primes in the primes list if non of them divides number than number is prime.
        while (i < primes.size()) {
            if (number % primes.get(i) == 0) {
                number++;
                i = 0;
            }else{
                i++;
            }
        }
        primes.add(number);
        return next;
    }
}
