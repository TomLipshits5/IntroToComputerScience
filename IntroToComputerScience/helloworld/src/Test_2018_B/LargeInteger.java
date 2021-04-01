package Test_2018_B;

import Interfaces.List;
import com.DynamicArray;
import com.Iterator;
import com.LinkedList;

public class LargeInteger {
    private List<Integer> number;

    public LargeInteger(){
        number = new DynamicArray<>();
    }

    public LargeInteger(String s){
        if (!Test_2018_B.isLegal(s)){
            throw new IllegalArgumentException("not a valid number");
        }
        number = new DynamicArray<>();
        for (int i = 1; i<=s.length();i++){
            Integer num = s.charAt(s.length()-i) - '0';
            addDigit(num);
        }
    }

    public Iterator<Integer> iterator(){
        return number.iterator();
    }

    public void addDigit(Integer n){
        number.add(n);
    }

    public static LargeInteger sum(LargeInteger num1,LargeInteger num2){
        Integer carry = 0;
        int i = 0;
        LargeInteger output = new LargeInteger();
        while(i<num1.number.size()){
            Integer sum = num1.number.get(i)+num2.number.get(i) + carry;
            output.addDigit(sum%10);
            carry = sum/10;
            i++;
        }
        if (carry!=0){
            output.addDigit(carry);
        }
        return output;
    }

    @Override
    public String toString() {
        return "LargeInteger{" +
                "number=" + number +
                '}';
    }
}
