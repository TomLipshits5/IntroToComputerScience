package com;
import Interfaces.Stack;
import Interfaces.StackOperator;
import java.util.Arrays;


public class RandomAlgorithems {
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
                sum = sum + Math.pow(2, len - i);

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

    public static int fibCount(int n, int k){
        int output = 0;
        if (n == k){
            output = output+1;
        }
        else if(n>=1){
            output = fibCount(n-1,k)+fibCount(n-2,k);
        }
        return output;
    }

    public static int fibCount2(int n,int k){
        int[] memo = new int[n+1];
        for (int i: memo){
            i = 0;
        }
        return fibCount2(n,k,memo);
    }

    public static int fibCount2(int n, int k, int[] memo){
        if (n==k){
            return 1;
        }
        if(memo[n] ==0 && n>=2){
            memo[n] = fibCount2(n-1,k,memo)+fibCount2(n-2,k,memo);
        }
        return memo[n];
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

    public static <T extends Comparable<T>> void insertionSort(T[] array){
        for(int i =1 ; i< array.length; i++){
            insert(array,i);
        }
    }

    public static <T extends Comparable<T>> void insert(T[] array , int index){
        T value = array[index];
        while(index>0 && array[index-1].compareTo(value) > 0){
            array[index] = array[index-1];
            index--;
        }
        array[index] = value;
    }
    public static String toInfix(String str){
        Stack<String> stack = new StackAsLinkedList<>();
        int index=0;
        for (int i=0; i<str.length();i++){
            if (str.charAt(i) == ' '){
                if (str.charAt(i-1) == '+' || str.charAt(i-1) == '*'){
                    stack.push("("+ stack.pop() + str.charAt(i-1) + stack.pop()+")");
                }else{
                    stack.push(str.substring(index,i));
                }
                index = i+1;
            }if (i == str.length()-1){
                stack.push("("+ stack.pop() + str.charAt(i)+stack.pop()+")");
            }

        }
        return stack.pop();
    }

    public static int chinese(int[] arr1, int[] arr2) {
        int max = arr1[0];
        for (int i = 1; i < arr1.length; i++) {
            max = max * arr1[i];
        }

        for (int i = 0; i < arr1.length; i++) {
            if (max % arr1[i] != arr2[i]) {
                i = 0;
                max = max - 1;
            }
        }
        return max;

    }

    public static boolean zarim(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (gcd(arr[i], arr[j]) != 1) {
                    return false;
                }
            }
        }
        return true;
    }


    public static int gcd(int n, int m) {
        int r = m % n;
        while (r > 0) {
            m = n;
            n = r;
            r = m % n;
        }
        return n;
    }


    public static void printPrimes(int m) {
        String ans = "";
        int prime = 2;
        int mult = 1;
        while (mult < m) {
            mult = mult * prime;
            ans = ans + " " + prime;
            prime = nextPrime(prime);
        }
        System.out.println(ans);
    }

    public static int nextPrime(int n) {
        int p = 2;
        n = n + 1;
        while (p * p <= n) {
            if (n % p == 0) {
                p = 2;
                n = n + 1;
            } else {
                p = p + 1;
            }
        }
        return n;
    }


    public static int path(int n, int m) {
        int ans = 0;
        if (n == 1 && m == 1) {
            ans = 1;
        } else if (n >= 1 && m >= 1) {
            ans = path(n - 1, m) + path(n, m - 1);
        }
        return ans;


    }


    public static String toInfixString(StackOperator[] expression) {
        Stack<String> stack = new StackAsLinkedList<>();
        for (int i = 0; i < expression.length; i++) {
            if (expression[i] instanceof IntConstantOperator) {
                stack.push(expression[i].toString());
            } else {
                String subExp = "(" + stack.pop() + expression[i] + stack.pop() + ")";
                stack.push(subExp);
            }
        }
        return stack.pop();
    }


    public static boolean isLegal(StackOperator[] expression) {
        if (expression == null || expression.length % 2 == 0) {
            return false;
        }
        int counter = 0;
        for (int i = 0; i < expression.length; i++) {
            if (expression[i] == null) {
                return false;
            }
            if (expression[i] instanceof IntConstantOperator) {
                counter++;
            } else {
                counter--;

            }
            if (counter < 1) {
                return false;
            }
        }
        return counter == 1;

    }

    public static int intValue(String s) {
        if (s.length() == 1) {
            return intValue(s.charAt(0));
        }
        int base = 10;
        int pow = 1;
        int ans = 0;
        if (s.charAt(0) == '0' && s.charAt(1) == 'x') {
            s = s.substring(2);
            base = 16;

        } else if (s.charAt(0) == '0') {
            s = s.substring(1);
            base = 8;
        }
        for (int i = 1; i <= s.length(); i++) {
            ans = ans + intValue(s.charAt(s.length() - i)) * pow;
            pow = base * pow;
        }
        return ans;
    }

    public static int intValue(char c) {
        String base = "0123456789ABCDEF";
        return base.indexOf(c);
    }

    public static boolean isCarmichel(int n) {
        if (!isPrime2(n)) {
            int p = 1;
            while (p < n) {
                if (coPrime(n, p)) {
                    if (pow(p, n - 1, n) != 1) {
                        return false;
                    }
                }
                p++;
            }
            return true;

        }
        return false;
    }

    public static boolean isPrime2(int n) {
        boolean isPrime = true;
        int p = 2;
        while (isPrime && p < n) {
            if (n % p == 0) {
                isPrime = false;
            }
            p++;
        }
        return isPrime;
    }

    public static int pow(int a, int n, int m) {
        int ans = 0;
        if (n == 1) {
            ans = a % m;
        }
        if (n > 1) {
            ans = ((a % m) * (pow(a, n - 1, m))) % m;
        }
        return ans;
    }


    public static boolean partition(int[] arr) {
        return partition(arr, 0, 0, 0);
    }

    public static boolean partition(int[] arr, int i, int sum1, int sum2) {
        boolean isPartition = true;
        if (i == arr.length && sum1 == sum2) {
            isPartition = true;
        }
        if (i == arr.length && sum1 != sum2) {
            isPartition = false;
        }
        if (i < arr.length) {
            isPartition = partition(arr, i + 1, sum1 + arr[i], sum2) || partition(arr, i + 1, sum1, sum2 + arr[i]);
        }
        return isPartition;
    }


    public static boolean isParentecis(String s) {
        Stack<Character> stack = new StackAsLinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }


    public static boolean coPrime(int i, int j) {
        int min;
        if (i > j) {
            min = j;
        } else {
            min = i;
        }
        int p = 2;
        boolean isCoPrime = true;
        while (isCoPrime && p <= min) {
            if (i % p == 0 && j % p == 0) {
                isCoPrime = false;
            }
            p++;
        }
        return isCoPrime;
    }


    public static int postFix(String s) {
        int tmp = 0;
        Stack<Integer> myStack = new StackAsLinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                myStack.push(c - '0');
            } else {
                int num1 = myStack.pop();
                int num2 = myStack.pop();
                if (c == '+') {
                    tmp = num1 + num2;
                }
                if (c == '*') {
                    tmp = num1 * num2;
                }
                if (c == '-') {
                    tmp = num1 - num2;
                }
                if (c == '/') {
                    tmp = num1 / num2;
                }
                myStack.push(tmp);
            }

        }
        return myStack.pop();
    }

    public static boolean isBinaryArr(int[] arr,int n){
        if (arr != null && arr.length == n){
            for (int i: arr){
                if (i!=0 && i!=1){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean isBinaryMatrix(int[][] matrix){
        if (matrix==null){
            return false;
        }
        int n = matrix.length;
        for (int[] i : matrix){
            if (!isBinaryArr(i,n)){
                return false;
            }
        }
        return true;
    }
    public static boolean maze(int[][] matrix){
        if (!isBinaryMatrix(matrix)){
            return false;
        }
        return maze(matrix,0,0);
    }
    public static boolean maze(int[][] matrix,int i,int j){
        int n = matrix.length-1;
        if (i==n&&j==n){
            return true;
        }
        if (i>n||j>n||matrix[i][j]==0){
            return false;
        }else{
            return maze(matrix,i+1,j)||maze(matrix,i,j+1);
        }
    }

    public static boolean mazeMemo(int[][] matrix){
        Boolean[][] memo = new Boolean[matrix.length][matrix.length];
        for (Boolean[] arr: memo){
            for (Boolean val: arr){
                val = null;
            }
        }
        return mazeMemo(matrix,0,0,memo);
    }

    public static boolean mazeMemo(int[][] maze,int i, int j,Boolean[][] memo){
        int n = maze.length-1;
        if (i==n && j==n){
            return true;
        }
        if (i>n||j>n||maze[i][j]==0){
            return false;
        }
        if (memo[i][j]==null){
            memo[i][j] = mazeMemo(maze,i+1,j,memo)||mazeMemo(maze,i,j+1,memo);
        }
        return memo[i][j];
    }



    public static int[] splitLeft(int[] arr){
        int[] output = new int[arr.length/2];
        for (int i =0;i<arr.length/2;i++){
            output[i] = arr[i];
        }
        return output;
    }

    public static int[] splitRight(int[] arr){
        int[] output = new int[arr.length-arr.length/2];
        for (int i = arr.length/2;i<arr.length;i++){
            output[i-arr.length/2] = arr[i];
        }
        return output;

    }

    public static int[] merge(int[] arr1,int[] arr2){
        int i1=0,i2= 0,i0 = 0;
        int[] output = new int[arr1.length+arr2.length];
        while(i1< arr1.length&i2<arr2.length){
            if (arr1[i1]<=arr2[i2]){
                output[i0] = arr1[i1];
                i0++;
                i1++;
            }else{
                output[i0] = arr2[i2];
                i0++;
                i2++;
            }
        }
        if (i1<arr1.length){
            for (int i =i1;i<arr1.length;i++){
                output[i0] = arr1[i];
                i0++;
            }
        }else if(i2<arr2.length){
            for (int i =i2;i<arr2.length;i++){
                output[i0] = arr2[i];
                i0++;
            }
        }
        return output;
    }


    public static int[] sort(int[] arr){
        if (arr.length == 1 || arr.length==0){
            return arr;
        }
        int[] left = splitLeft(arr);
        int[] right = splitRight(arr);

        left = sort(left);
        right = sort(right);

        return merge(left,right);
    }




    public static void main(String[] args) {

        int[] arr = {2,3,1,7,4,0};
        int[] arrL = splitLeft(arr);
        int[] arrr = splitRight(arr);

//        System.out.println(Arrays.toString(arrL));
//        System.out.println(Arrays.toString(arrr));
        System.out.println(Arrays.toString(sort(arr)));






    }




}









