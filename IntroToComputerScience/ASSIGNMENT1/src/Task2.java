
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int ans = 0;

        //---------------write your code BELOW this line only!--------------
        /*I have learned about the Math.random() Method on -https://www.geeksforgeeks.org/java-math-random-method-examples/*/
        /*by generating a number 0<= x <1 and multiplying it by the difference + 1(diff) i will have a number 0<=randomGen<=diff*/
        /*adding randomGen to 'a' will generate a number  a<= ans <= b*/
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int diff = b - a + 1;
        double randomGen = Math.random() * diff;
        int roundRandomGen = (int) randomGen;
        ans = a + roundRandomGen;


        //---------------write your code ABOVE this line only!--------------

        System.out.println(ans);
    }
}