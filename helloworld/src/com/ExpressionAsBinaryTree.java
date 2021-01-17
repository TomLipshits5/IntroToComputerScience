package com;

public class ExpressionAsBinaryTree extends BinaryTree<Object> {
    private BinaryNode<Object> root;


    public ExpressionAsBinaryTree(Object[] expression){
        root = BinaryNode.buildTree(expression);
    }

    public String toString(){
        return root.toString();
    }

}
