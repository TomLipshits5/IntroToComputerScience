

import java.math.BigInteger;
import java.util.Random;

class Part1_BigInteger{
    //Task 1.1
    //Sum the value of all of the numbers smaller than n.
    public static BigInteger sumSmaller(BigInteger n){
        BigInteger sum =  new BigInteger("0");
        for (int i = 0; i<n.intValue(); i++) {
            sum = sum.add(BigInteger.valueOf(i));
        }

        return sum;
    }



    //Task 1.2
    //Prints n numbers in range of int type.
    public static void printRandoms(int n){
        Random rg = new Random();
        int i = 0;
        while(i<n){
            System.out.println(rg.nextInt());
            i++;
        }
    }



    //Task 1.3
    // Find out if n is a prime number.
    public static boolean isPrime(BigInteger n){
        if (n.intValue() == 0 || n.intValue()==1){
            return false;
        }

        for(BigInteger p = new BigInteger("2"); p.multiply(p).compareTo(n) < 0 || p.multiply(p).compareTo(n) ==0; p = p.add(BigInteger.ONE)){
            if (n.mod(p).intValue() == 0)
                return false;
        }
        return true;
    }



    //Task 1.4
    //Return a BigInteger in rang of 0 to 2^n.
    public static BigInteger randomPrime(int n){
        BigInteger randBig = new BigInteger("0");
        boolean isPrime = false;
        while(!isPrime) {
            BigInteger myInt = new BigInteger(n, new Random());
            isPrime = isPrime(myInt);
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
        BigInteger bi1 = new BigInteger("2147521921");
//        System.out.println(randomPrime(2).toString());

//        BigInteger myInt = new BigInteger(2, new Random());

//        BigInteger rNum = randomPrime(7);
        System.out.println(isPrime(bi1));
//        System.out.println(bi0.add(bi7));
//        System.out.println(bi7.compareTo(bi7));

    }
}