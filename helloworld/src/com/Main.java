package com;

import Interfaces.*;


public class Main {
    public static void main(String[] args) {
//        BinarySearchTree<Integer> tr = new BinarySearchTree<Integer>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer e1, Integer e2) {
//                return e1.compareTo(e2);
//            }
//        });
        BinaryTree<Integer> tr = new BinaryTree<Integer>();
        tr.insert(4);
        tr.insert(6);
        tr.insert(5);
        tr.insert(2);
        tr.insert(3);
        tr.insert(1);
        tr.insert(7);
//        System.out.println(tr);
//        tr.remove(4);
//        System.out.println(tr);
//        tr.remove(1);
//        System.out.println(tr);
//        System.out.println();
//        tr.printPath(7);
//        tr.printPath(9);
//        Integer[] arr = {4,5,-12,8,21,20};
//        Filter<Integer> f = new FibonaciFilter();
//        ArrayFilterIterator<Integer> it = new ArrayFilterIterator<Integer>(arr,f);
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
        int[] arr = {3, 4, 5};
        int[] arr2 = {2, 3, 2};
        Object[] arr3 = {2,33,1,"*","+",9,"+"};
        ExpressionAsBinaryTree extr = new ExpressionAsBinaryTree(arr3);
        System.out.println(extr);


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
        if (!isPrime(n)) {
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

    public static boolean isPrime(int n) {
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
}


