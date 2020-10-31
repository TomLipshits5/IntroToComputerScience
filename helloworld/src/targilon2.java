import java.util.Arrays;

public class targilon2 {
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {0,10,20,30,40};

        swap(a, 0,5);
        System.out.println(Arrays.toString(a));
//
    }
}
