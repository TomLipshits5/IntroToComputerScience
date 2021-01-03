package com;
import Interfaces.*;
public class LargeInt {
    //Fields:
    private List<Integer> list;




    //Constructors:
    public LargeInt(){
        list = new LinkedList<Integer>();
    }

    public LargeInt(String s){
        if(isLegal(s)){
            list = new DynamicArray<>();
            for(int i = s.length()-1; i>=0; i--){
                list.add((int)s.charAt(i)-'0');
            }

        }else{
            throw new IllegalArgumentException("Input is illegal");
        }
    }



    //Methods:
    public boolean isLegal(String s){
        if(s == null || s.length()==0 || (s.charAt(0) == '0' && s.length()>1)){
            return false;
        }
        for (int i = 0 ;i<s.length(); i++){
            if(s.charAt(i)<'0' || s.charAt(i)>'9'){
                return false;
            }
        }
        return true;
    }

    public boolean emptyNumber(){
        return true;
    }

    public Iterator<Integer> iterator(){
        return list.iterator();
    }

    private void addDigit(int digit){
        list.add(digit);
    }

    private int size(){
        return list.size();
    }

    public String toString(){
        String s ="";
        for(int i = list.size()-1; i>=0; i--){
            s =s+list.get(i);
        }
        return s;
    }



    public static LargeInt sum(LargeInt num1, LargeInt num2){
        LargeInt ans = new LargeInt();
        int carry =0;
        int tmp =0;
        int counter = 0;
        Iterator<Integer> it1 = num1.iterator();
        Iterator<Integer> it2 = num2.iterator();
        while(it1.hasNext()){
            int n = it1.next();
            int m = it2.next();
            tmp = n+m + carry;
            carry = tmp/10;
            if(counter == num1.size()-1){
                ans.addDigit(tmp);
            }else{
                ans.addDigit(tmp%10);
            }
            counter++;

        }
        return ans;

    }


}
