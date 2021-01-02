<<<<<<< HEAD:helloworld/src/com/Main.java
package com;
=======
>>>>>>> 9eb6263c9ee1997bca74e161df114adbff43051a:helloworld/src/Main.java

public class Main {
    public static void main(String[] args){
<<<<<<< HEAD:helloworld/src/com/Main.java
        DynamicArray ls = new DynamicArray<>();
        ls.add(1);

=======
        System.out.println(postFix("67+5*4+3*2+1*"));
>>>>>>> 9eb6263c9ee1997bca74e161df114adbff43051a:helloworld/src/Main.java




    }


    public static int postFix(String s){
        int tmp =0;
        Stack<Integer> myStack= new StackAsLinkedList<>();
        for(int i = 0 ; i<s.length(); i++){
            Character c = s.charAt(i);
            if (c>='0' && c<='9'){
                myStack.push(c-'0');
            }else{
                int num1 = myStack.pop();
                int num2 = myStack.pop();
                if (c == '+'){
                    tmp = num1 + num2;
                }
                if (c == '*'){
                    tmp = num1 * num2;
                }
                if (c == '-'){
                    tmp = num1 - num2;
                }
                if (c == '/'){
                    tmp = num1 / num2;
                }
                myStack.push(tmp);
            }

        }
        return myStack.pop();
    }


