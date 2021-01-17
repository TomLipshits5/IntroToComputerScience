package com;

import Interfaces.Stack;
import Interfaces.StackOperator;

public class IntMultOperator implements StackOperator {
    public String toString(){
        return "+";
    }
    @Override
    public void apply(Stack<Integer> st) {

    }

    @Override
    public void applyString(Stack<String> st) {

    }
}
