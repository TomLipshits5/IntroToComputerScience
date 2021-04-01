package com;

import Interfaces.Stack;
import Interfaces.StackOperator;

public class IntPlusOperator implements StackOperator {
    public String toString(){
        return "*";
    }

    @Override
    public void apply(Stack<Integer> st) {

    }

    @Override
    public void applyString(Stack<String> st) {
        st.push("("+ st.pop() + "+" + st.pop() +")");
    }
}
