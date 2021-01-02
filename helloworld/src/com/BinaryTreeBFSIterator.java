import java.util.NoSuchElementException;

public class BinaryTreeBFSIterator<T> implements Iterator<T> {

    private Queue<BinaryNode<T>> q;

    public BinaryTreeBFSIterator(BinaryNode<T> root){
        q = new QueueAsLinkedList<>();
        if(root != null){
            q.enqueue(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !q.isEmpty();
    }

    @Override
    public T next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        BinaryNode<T> node = q.dequeue();
        if (node.getLeft() != null){
            q.enqueue(node.getLeft());
        }
        if(node.getRight() != null){
            q.enqueue(node.getRight());
        }
        return node.getData();
    }
}
