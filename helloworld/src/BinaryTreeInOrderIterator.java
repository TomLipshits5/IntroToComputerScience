import java.util.NoSuchElementException;

public class BinaryTreeInOrderIterator<T> implements Iterator<T> {

    private Stack<BinaryNode<T>> stack;

    public BinaryTreeInOrderIterator(BinaryNode<T> root){
        stack = new StackAsLinkedList<BinaryNode<T>>();
        prepareNext(root);
    }

    private void prepareNext(BinaryNode<T> node){
        while(node!= null){
            stack.push(node);
            node = node.getLeft();
        }
    }
    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public T next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        BinaryNode node = stack.pop();
        prepareNext(node.getRight());
        return (T)node.getData();
    }
}
