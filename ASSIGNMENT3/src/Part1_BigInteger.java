

import java.math.BigInteger;
import java.util.Random;

class Part1_BigInteger{
    //Task 1.1
    //Sum the value of all of the numbers smaller than n.
    public static BigInteger sumSmaller(BigInteger n){
        BigInteger sum =  new BigInteger("0");
        BigInteger i = new BigInteger("1");
        while(i.compareTo(n)<0){    //loop throw and sum all numbers smaller than n.
            sum = sum.add(i);
            i = i.add(BigInteger.ONE);
        }
        return sum;
    }



    //Task 1.2
    //Prints n numbers in range of int type.
    public static void printRandoms(int n){
        Random rg = new Random();
        int i = 0;
        while(i<n){       //repeat the print action fot n time.
            System.out.println(rg.nextInt());           //generate a random number.
            i++;
        }
    }



    //Task 1.3
    // Find out if n is a prime number.
    public static boolean isPrime(BigInteger n){
        // input check for edge cases.
        if (n.intValue() == 0 || n.intValue()==1){
            return false;
        }
        //Compare n module p to zero.
        for(BigInteger p = new BigInteger("2"); p.multiply(p).compareTo(n) < 0 || p.multiply(p).compareTo(n) ==0; p = p.add(BigInteger.ONE)){
            if (n.mod(p).compareTo(BigInteger.ZERO) == 0)
                return false;
        }
        return true;
    }



    //Task 1.4
    //Return a BigInteger in range of 0 to 2^n.
    public static BigInteger randomPrime(int n){
        BigInteger randBig = new BigInteger("0");
        boolean isPrime = false;
        while(!isPrime) {
            BigInteger myInt = new BigInteger(n, new Random()); //generate a random number in range 0 to 2^n.
            isPrime = isPrime(myInt);                   //checks if the random number is prime.
            randBig = myInt;
        }

        return randBig;
    }






    public static void main(String[] args) {
//        BigInteger biMinus = new BigInteger("-10");
//        System.out.println(sumSmaller(biMinus)); // 0
        BigInteger bi0 = new BigInteger("0");
//        System.out.println(sumSmaller(bi0)); // 0
        BigInteger bi7 = new BigInteger("7");
//        System.out.println(sumSmaller(bi7)); // 21
        BigInteger biHigh = new BigInteger("99999");
//        System.out.println(sumSmaller(biHigh)); // 4999850001
        BigInteger bi1 = new BigInteger("200000");
//        System.out.println(randomPrime(2).toString());

//        BigInteger myInt = new BigInteger(2, new Random());

//        BigInteger rNum = randomPrime(7);
        System.out.println(biHigh.mod(bi7).getClass());


    }
}