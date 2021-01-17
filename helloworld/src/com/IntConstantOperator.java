package com;

import Interfaces.Stack;
import Interfaces.StackOperator;

public class IntConstantOperator implements StackOperator {
    private Integer value;

    public IntConstantOperator(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public String toString(){
        return value.toString();
    }
    @Override
    public void apply(Stack<Integer> st) {

    }

    @Override
    public void applyString(Stack<String> st) {

    }
}
