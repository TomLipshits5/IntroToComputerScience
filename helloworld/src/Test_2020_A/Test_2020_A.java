package Test_2020_A;
import Interfaces.Stack;
import Interfaces.StackOperator;
import com.*;
import Interfaces.Comparator;
import com.BinarySearchTree;



public class Test_2020_A {
    public static void main(String[] args) {
        StackOperator plus = new IntPlusOperator();
        StackOperator mult = new IntMultOperator();
        StackOperator three = new IntConstantOperator(3);
        StackOperator four = new IntConstantOperator(4);
        StackOperator seven = new IntConstantOperator(7);
        StackOperator[] list = {seven,four,three,plus,mult};
        System.out.println(toInfixString(list));

    }

    public static String toInfixString(StackOperator[] exp){
        if(!isLegal(exp)){
            throw new IllegalArgumentException();
        }
        Stack<String> st = new StackAsLinkedList<>();
        for (StackOperator op : exp){
            op.applyString(st);
        }
        return st.pop();
    }

    public static boolean isLegal(StackOperator[] exp){
        if (exp == null){
            return false;
        }
        int counter = 0;
        for (StackOperator op : exp){
            if (op == null){
                return false;
            }
            if (op instanceof IntConstantOperator){
                counter++;
            }else if(op instanceof IntPlusOperator || op instanceof IntMultOperator){
                counter--;
            }
            if (counter <= 0){
                return false;
            }
        }
        return counter == 1;
    }

}
