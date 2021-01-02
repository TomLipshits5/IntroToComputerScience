public interface Stack <T>{

    //return true if the stack is empty
    public boolean isEmpty();

    //push an item to the top of the stack
    public void push(T element);

    //return and remove top element from
    public T pop();


    //return and don't remove top element from
    public T peek();
}
