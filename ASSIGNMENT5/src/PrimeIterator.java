/*---------------------------------------
 Genuine author: <name>, I.D.: <id number>
 Date: xx-xx-2020 
---------------------------------------*/

import java.util.Iterator;

public class PrimeIterator implements Iterator<Integer> {

    private List<Integer> primes;

    //Complete the following methods
    //Constructor, initialise a linked list ans add the first prime number 2.
    public PrimeIterator() {
        // task 0
        primes = new LinkedList<Integer>();
        primes.add(2);
    }

    //return true a long as the user don't request a prime number bigger than INTEGER.MAX_VALUE
    public boolean hasNext() {
        // task 0
        return primes.get(0) > 0;
    }

    //Finds the next prime number ans add it to the beginning of primes list, returns former first to user.
    public Integer next() {
        // task 0
        int next = primes.get(0);          //Save prime number to return to user.
        int number = next + 1;
        int p = 2;
        boolean isPrime;
        boolean found = false;
        while (!found) {                           //Loop throw all numbers bigger than next until one is prime.
            isPrime = true;
            if (p > 46340) {                    //prevents infinite loop on large numbers.
                while (p < number) {
                    if (number % p == 0) {
                        isPrime = false;
                        number++;
                        p = 2;
                    } else {
                        p++;
                    }
                }
            } else {                        //Efficient loop for smaller numbers.
                while (p * p <= number) {
                    if (number % p == 0) {
                        isPrime = false;
                        number++;
                        p = 2;
                    } else {
                        p++;
                    }
                }
            }
            if (isPrime) found = true;
        }
        ((LinkedList<Integer>) primes).addFirst(number);
        return next;
    }
}
