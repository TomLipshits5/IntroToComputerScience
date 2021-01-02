public class BinaryTree<T> implements Iterable<T> {
   //Fields:
    protected BinaryNode<T> root;

    //Constructor:
    public BinaryTree(){
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void insert(T element){
        if(element == null){
            throw new IllegalArgumentException("can't insert null");
        }
        if(root == null){
            root = new BinaryNode<T>(element);
        }else{
            root.insert(element);
        }
    }

    public boolean contains(T element){
        boolean ans;
        if(element == null){
            throw new IllegalArgumentException("can't contain null");
        }
        if(isEmpty()){
            return false;
        }
        else{
            ans = root.contains(element);
        }
        return ans;
    }


    public int height(){
        if(isEmpty()){
            return -1;
        }
        else{
             return root.height();
        }
    }


    public int size(){
        if(isEmpty()){
            return 0;
        }
        return root.size();
    }


    public boolean equals(Object other){
        if(!(other instanceof BinaryTree)){
            return false;
        }
        BinaryTree otherTree = ((BinaryTree)other);
        if (isEmpty()){
            return otherTree.isEmpty();
        }
        return root.equals(otherTree.root);
    }
    public void inOrder(){
        if (!isEmpty()){
            root.inOrder();
        }

    }
    public void preOrder(){
        if (!isEmpty()){
            root.preOrder();
        }

    }
    public void postOrder(){
        if (!isEmpty()){
            root.postOrder();
        }

    }

    public int countNodesAtDepth(int depth){
        int ans = 0;
        if(!isEmpty()){
            ans = root.countNodesAtDepth(depth);
        }
        return ans;
    }

    public void mirror(){
        if(!isEmpty()){
            root.mirror();
        }
    }




    @Override
    public Iterator<T> iterator() {
        return new BinaryTreeInOrderIterator(root);
    }
    public Iterator<T> bfsIterator() {
        return new BinaryTreeBFSIterator(root);
    }
}
