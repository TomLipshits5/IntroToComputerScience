import java.util.NoSuchElementException;

public class IntegerIterator implements Iterator<Integer> {
    //Fields:
    private Integer[] elements;
    private int index;

    //Constructors:
    public IntegerIterator(List<Integer> list){
        if (list == null) {
            throw new IllegalArgumentException("input can't be null");
        }
        elements =new Integer[list.size()];
        int counter = 0;
        Iterator<Integer> itList = list.iterator();
        while(itList.hasNext()){
            elements[counter] = itList.next();
            counter++;
        }
        index = 0;
    }

    public IntegerIterator(){
        elements = new Integer[] {};
        index = 0;
    }

    //Methods:
    public boolean hasNext(){
        return index<elements.length;
    }

    public Integer next(){
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        int minIndex = findMinIndex(elements,index);
        int min = elements[minIndex];
        elements[minIndex] = elements[index];
        elements[index] = min;
        index++;
        return min;
    }

    private Integer findMinIndex(Integer[] arr, int index){
        int minIndex = index;
        for(int j =index; j<arr.length; j++){
            if(arr[j] < arr[minIndex]){
                minIndex = j;
            }
        }
        return minIndex;
    }
}
