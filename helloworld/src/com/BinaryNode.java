public class BinaryNode<T> {

    //Fields:

    protected T data;
    protected BinaryNode left;
    protected  BinaryNode right;


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



}
