import java.util.Arrays;
import static  java.lang.Math.*;

public class MyMath {
    public static int GCD(int x, int y) {
        if (x <= 0 || y <= 0) {
            return 0;
        } else {
            int remainder = x % y;
            while (remainder != 0) {
                x = y;
                y = remainder;
                remainder = x % y;
            }

        }
        return y;
    }
    public static int recorsivGCD(int m,int n){
        int output;
        if (m%n == 0){
            output = n;
        }
        else{
            output = recorsivGCD(n,m%n);
        }
        return output;
    }


    static char[] convertToList(int num) {
        String Snumber;
        Snumber = String.valueOf(num);
        char[] stringList = new char[Snumber.length()];
        for (int i = 0; i < Snumber.length(); i++) {
            stringList[i] = Snumber.charAt(i);
        }
        return stringList;

    }

    public static double convertToDec(int num) {
        double sum = 0;
        char[] numList = convertToList(num);
        int len = numList.length;
        int i = 0;
        while (i < len) {
            i = i + 1;
            if (numList[i - 1] == '1') {
                sum = sum + pow(2, len - i);

            }
        }
        return sum;
    }

    public static String convertToBase(long num, int base) {
        StringBuilder myString = new StringBuilder();
        while (num > 0) {
            long digit = num % base;
            myString.insert(0, digit);
            num = num / base;

        }
        return myString.toString();

    }

    public static int[] isPrime(int num) {
        int n = 2;
        int[] array = {};
        while (n <= num) {
            int p = 2;
            boolean isNumPrime = true;
            while (p * p <= n && isNumPrime) {
                if (n % p == 0) {
                    isNumPrime = false;
                } else {
                    p = p + 1;
                }
            }
            if (isNumPrime) {
                array = Arrays.copyOf(array, array.length + 1);
                array[array.length-1] = n;
            }
            n = n + 1;

        }

        return array;

    }
    public static int factorial(int n){
        int output = 1;
        for (int i = 2; i<=n ; i++){
            output = output * i;
        }
        return output;
    }
    public static int recorsivFactorial(int n){
        int output;
        if (n==0){
            output = 1;
        }
        else {
            output = n * recorsivFactorial(n - 1);
        }
        return output;
    }
    public static int recorsivPerfectMait(int n){
        int output;
        if (n == 0){
            output = 1;
        }
        else{
            output = (n-1) * recorsivPerfectMait(n-2);
        }
        return output;
    }
    public static int factorialOdds(int n){
        int output = 1;
        if(n%2 != 0){
            throw new IllegalArgumentException("input has to be an even number");
        }
        else
            for (int i = 3; i<n; i=i+2){
                output = output * i;
            }

        return output;
    }
    public static int fibonachy(int n){
        int output = 1;
        int f0 = 1;
        int f1= 1;
        for(int i = 2; i<=n; i++){
            output = f0+f1;
            f0 = f1;
            f1 = output;

        }
        return output;
    }

    public static int recorsivFibonachy(int n){
        int output;
        if(n == 1 || n== 0 ){
            output = 1;
        }
        else{
            output = recorsivFibonachy(n-1) + recorsivFibonachy(n-2);
        }
        return output;
    }
    public static int spiderman(int n){
        int ouutput;
        if(n==0|n==1){
            ouutput =1;
        }
        else{
            ouutput = spiderman(n-1) + spiderman(n-2);
        }
        return ouutput;
    }

    public static void hanoiTour(int n, char source, char destinatoin,char extra){

    }
    




    public static void main(String[] args) {
        Circle c = new Circle(3);
        Shape c2 = new Circle(3);
        Shape r = new Rectangle(2,2);
        Shape r2 = new Square(2);
        System.out.println(r2.toString());
        System.out.println(r.equals(r2));

    }




}









