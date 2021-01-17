package com;

import Interfaces.List;
import Interfaces.Stack;

import java.security.cert.CRLReason;


public class BinaryNode<T> {

    //Fields:

    protected T data;
    protected BinaryNode<T> left;
    protected  BinaryNode<T> right;


    //Constructors:
     public BinaryNode(T element){
         if(element == null){
             throw new IllegalArgumentException("node can't be null");
         }
         data = element;
         right = null;
         left = null;
     }



     //Methods:


    public T getData(){
         return data;
    }

    public BinaryNode<T> getLeft(){
         return left;
    }

    public BinaryNode<T> getRight(){
        return right;
    }

    public void insert(T element){
         if(Math.random()< 0.5){
             if(left!= null){
                 left.insert(element);
             }else{
                 left  = new BinaryNode(element);
             }
         }else{
             if (right != null){
                 right.insert(element);
             }else{
                 right = new BinaryNode(element);
             }
         }
    }

    public BinaryNode<T> remove(T element){
         BinaryNode<T>outPut = this;
         if (data.equals(element)){
             if(left!=null){
                 data = (T)left.getData();
                 left = left.remove(data);
             }else if (right!=null){
                 data = (T)right.getData();
                 right = right.remove(data);
             }else{
                 outPut = null;
             }
         }
         if(left!=null && left.contains(element)){
             left.remove(element);
         }else if(right!=null){
             right.remove(element);
         }
         return outPut;
    }



    public boolean contains(T element){
         boolean found = false;
         if(data.equals(element)){
             found = true;
         }
          else if(left != null && left.contains(element)){
             found = true;
         }
         else if(right != null && right.contains(element)){
             found = true;
         }
         return found;
    }

    public int height(){
         int leftH = -1, rightH=-1;
         if(left!= null){
             leftH = left.height();
         }
         if(right != null){
             rightH = right.height();
         }
         return Math.max(rightH,leftH) + 1;
    }


    public int size(){
         int leftS = 0, rightS = 0;
         if(left != null){
             leftS = left.size();
         }
         if (right != null){
             rightS = right.size();
         }
         return leftS+rightS +1;
    }


    public boolean equals(Object other){
         if (!(other instanceof BinaryNode)){
             return false;
         }
         BinaryNode otherNode = ((BinaryNode)other);
         boolean isEquals = false;

         isEquals = (data.equals(otherNode.data)) && ((left == null &&
                 otherNode.left == null) || (left != null && left.equals(otherNode.left))) &&
                 ((right == null && otherNode.right == null) || (right!=null && right.equals(otherNode.right)));
         return isEquals;

    }

    public void inOrder(){
         if(left != null ){
             left.inOrder();
         }
        System.out.print(data+ " ");
         if(right !=null){
             right.inOrder();
         }

    }
    public void preOrder(){
        System.out.print(data+ " ");
        if(left != null ){
            left.preOrder();
        }

        if(right !=null){
            right.preOrder();
        }

    }
    public void postOrder(){
        if(left != null ){
            left.postOrder();
        }

        if(right !=null){
            right.postOrder();
        }
        System.out.print(data + " ");
    }
    public int countNodesAtDepth(int depth){
         if(depth == 0){
             return 1;
         }
         int  leftCount = 0;
         int rightCount = 0;
         if (left!=null){
             leftCount = left.countNodesAtDepth(depth-1);
         }
         if (right!= null){
             rightCount = right.countNodesAtDepth(depth-1);
         }
         return rightCount+leftCount;
    }

    public void mirror(){
         if(left!=null){
             left.mirror();
         }
         if(right!=null){
             right.mirror();
         }
         BinaryNode tmp = left;
         left = right;
         right = tmp;

    }

    public boolean isEven(){
        boolean ans ;
        boolean isLeft = true;
        boolean isRight = true;
        if (left!=null){
            isLeft = left.isEven();

        }
        if (right!=null){
            isRight = right.isEven();

        }
        ans = !(isLeft == isRight);
        return ans;


    }

    public Integer evaluate(){
         Integer ans;
         if(data == "*"){
             ans=left.evaluate() * right.evaluate();
         }
         else if (data == "+"){
             ans = left.evaluate()+ right.evaluate();
         }
         else{
             ans= Integer.parseInt((String)data);
         }
         return ans;
    }

//    public String toString(){
//         String ans = "(";
//         if (left!= null){
//             ans = ans + left.toString()+",";
//         }
//         ans = ans + data.toString();
//         if (right!=null){
//             ans = ans +","+ right.toString();
//         }
//         return ans+")";
//    }

    public int numberOfLeaves(){
         int ans = 0;
         if (left !=null){
             ans = ans+ left.numberOfLeaves();
         }
         if (right!=null){
             ans = ans+right.numberOfLeaves();
         }
         if (left==null&right==null){
             ans = 1;
         }
         return ans;
    }

    public void listOfLeaves(List<T> list){
         if (left == null && right == null){
             list.add(data);
         }
         if (left!=null){
             left.listOfLeaves(list);
         }
         if (right!=null){
             right.listOfLeaves(list);
         }
    }


    public boolean isFullLevel(int i){
         boolean ans = false;
         boolean leftIs = false;
         boolean rightIs = false;
         if (i == 0){
             return true;
         }
         if (i==1){
             leftIs=left!=null;
             rightIs=right!=null;
         }
         if(right!=null && i>1){
             rightIs = right.isFullLevel(i-1);
         }
         if (left!=null && i>1){
             leftIs = left.isFullLevel(i-1);
         }
         ans = leftIs&&rightIs;

        return ans;
    }

    public boolean isFullTree(){
         boolean ans = false;
         if (right == null && left == null){
             ans = true;
         }
         else if (right!=null && left!=null){
             ans = left.isFullTree() && right.isFullTree();
         }else{
             ans = false;
         }
         return ans;
    }

    public String toString(){
         String ans = toString("");
         return ans;
    }

    private String toString(String spaces){
         String ans = "";
         if (left!=null){
             ans = left.toString(spaces+" ");
         }
         ans = ans + spaces + data+"\n";
         if (right!=null){
             ans = ans+right.toString(spaces+" ");
         }
         return ans;
    }


    public boolean hasPath(int sum){
         boolean ans = false;
         sum = sum-(Integer)data;
         if (left == null && right == null && sum ==0){
             ans = true;
         }
         if (!ans&&left!=null && sum>0){
             ans =left.hasPath(sum);
         }
         if (!ans&&right!=null && sum>0){
             ans= right.hasPath(sum);
         }
         return ans;
    }

    public boolean printPath(int sum,String acc){
         boolean found = false;
        sum = sum-(Integer)data;
        acc = acc+data.toString()+",";
        if (left == null && right == null && sum ==0){
            found =true;
            System.out.println(acc.substring(0,acc.length()-1));

        }
        if (!found && left!=null && sum>0){
            found = left.printPath(sum,acc);
        }
        if (!found && right!=null && sum>0){
             found = right.printPath(sum,acc);
        }
        return found;
    }


    public static BinaryNode<Object> buildTree(Object[] experetion){
        Stack<BinaryNode<Object>> stack = new StackAsLinkedList<>();
         for (Object i: experetion){
             BinaryNode<Object> toHandle = new BinaryNode<>(i);
             if (i instanceof Integer){
                 stack.push(toHandle);
             }else{
                 toHandle.left = stack.pop();
                 toHandle.right = stack.pop();
                 stack.push(toHandle);
             }
         }
         return stack.pop();

    }





}
