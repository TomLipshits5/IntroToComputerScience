
import java.util.Scanner;

public class Task4c {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int ans = 0;

        //---------------write your code BELOW this line only!--------------
        /*I have learned about the Math.random() Method on -https://www.geeksforgeeks.org/java-math-random-method-examples/*/
        /*by generating a number 0<= x <1 and multiplying it by the difference + 1(diff) i will have a number 0<=randomGen<=diff*/
        /*adding randomGen to '2' will generate a number  2<= ans <= n-1*/
        int n = scanner.nextInt();
        int diff = n - 2;
        double randomGen = Math.random() * diff;
        int roundRandomGen = (int) randomGen;
        ans = 2 + roundRandomGen;

        //---------------write your code ABOVE this line only!--------------

        System.out.println(ans);
    }
}