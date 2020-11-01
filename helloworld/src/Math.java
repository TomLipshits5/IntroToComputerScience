
import java.util.Arrays;

import java.util.Scanner;

import static java.lang.Math.sqrt;
import static  java.lang.Math.*;

public class Math {
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
    public static void swap(int a, int b){
        int temp = a;
        a=b;
        b=temp;
    }

    public static void main(String[] args) {

        double a = Integer.MAX_VALUE;
        System.out.println("tom is the king");
    }


}






