
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
    public static void add5(int[] n){
        n[0]=n[0]+1;


    }
    


    public static void main(String[] args) {
//        String pasok = "{a&(b|c)}&d";
//        char[] character = pasok.toCharArray();
//        int numPar = 0;
//        for (char i : character){
//            boolean isnum = Character.isLetter(i);
//            if (isnum) numPar++;
//            }
//        System.out.println(numPar);
//
//        int start = 0;
//        int end = 0;
//        for(int i = 0 ; i<character.length;i++){
//
//            if (character[i] == '{'|character[i] == '('|character[i] == '['){
//                if (start<i) start = i;
//            }
//
//            if (character[i] == '}'|character[i] == ')'|character[i] == ']') {
//                end = i;
//            }
//        }
//        System.out.println(pasok.substring(start,end))
        boolean x= true;
        boolean y = false;
        boolean test = x&y;
        String test1= "false|true";
        char[] arr = {'a','b','c'};
        System.out.println(Boolean.valueOf(test1));




    }




}









