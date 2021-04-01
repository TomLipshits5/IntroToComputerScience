package com;

public class ExpressionAsBinaryTree extends BinaryTree<Object> {


    public ExpressionAsBinaryTree(Object[] expression){
        root = BinaryNode.buildTree(expression);

    }

    public String toString(){
        return root.toString();
    }

}
