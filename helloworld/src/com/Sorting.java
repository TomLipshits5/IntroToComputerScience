package com;
public class Sorting {

    public static void main(String[] args) {
        int[] array = {};
        sort(array);
        System.out.println(binarySearch(array,19));
        printArray(array);
    }

    public static boolean isSorted(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("array = null");

        }
        boolean isSorted = true;
        for (int i = 1; i < array.length && isSorted; i++) {
            if (array[i - 1] > array[i])
                isSorted = false;

        }
        return isSorted;
    }

    public static void sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("array = null");

        }
        if (!isSorted(array)) {
            for (int i = 0; i < array.length-1; i++) {
                int minIndex = minIndex(array, i);
                swap(array, i, minIndex);
            }
        }
    }

    public static int binarySearch(int[] array, int key){
        if (array == null){
            throw new IllegalArgumentException("array == null");
        }

        /*assumes array is sorted and != null*/
        int output = -1;
        boolean found  = false;
        int low = 0, high = array.length - 1;
        while(low<=high && !found){
            int middle = (low+high)/2;
            if (array[middle]==key){
                found = true;
                output = middle;
            }
            else if(array[middle]>key){
                high = middle-1;

            }
            else low = middle+1;
        }
        return output;
    }


    // Assumes a!=null & from<a.length
    public static int minIndex(int[] array, int from) {
        int minIndex = from;
        for (int i = from + 1; i < array.length; i = i + 1)
            if (array[i] < array[minIndex])
                minIndex = i;
        return minIndex;
    }

    //swap element a[i] with a[j]
    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    //----------------------------------------------------------
    public static void printArray(int[] array) {
        if (array == null)
            System.out.print(array);
        else {
            System.out.print("{ ");
            for (int element : array)
                System.out.print(element + " ,");
            System.out.println("}");
        }
    }
}