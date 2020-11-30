
import java.math.BigInteger;
import java.util.Random;

class Part1_BigInteger{
    //Task 1.1
    public static BigInteger sumSmaller(BigInteger n){
        BigInteger sum =  new BigInteger("0");
        for (int i = 0; i<n.intValue(); i++) {
            sum = sum.add(BigInteger.valueOf(i));
        }

        return sum;
    }
    //Task 1.2
    public static void printRandoms(int n){
        Random rg = new Random();
        int i = 0;
        while(i<n){
            System.out.println(rg.nextInt());
            i++;
        }
    }
    //Task 1.3
    public static   boolean isPrime(BigInteger n){
        boolean ans= true;

        if (n.intValue() == 0 || n.intValue()==1){
            return false;
        }


        BigInteger p = new BigInteger("2");
        while(n.intValue()>p.multiply(p).intValue()){
            if (n.mod(p).intValue() == 0)
                return false;
            p=p.add(BigInteger.ONE);
        }
        return ans;
    }



    //Task 1.4
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
        BigInteger bi1 = new BigInteger("1");
//        System.out.println(randomPrime(2).toString());

        BigInteger myInt = new BigInteger(2, new Random());

        BigInteger rNum = randomPrime(7);
        System.out.println(rNum.toString());

    }
}