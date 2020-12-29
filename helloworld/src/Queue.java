public interface Queue<T> {

    //return true is line is empty
    public boolean isEmpty();

    //removes and returns the first object in the queue
    public T dequeue();

    //insert a new element to the back of the queue
    public void enqueue(T element);

    //returns the first object in the queue ans dont removes it
    public T peek();

}
