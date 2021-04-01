
import java.util.Scanner;

public class Task3b {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int ans = 1;

        //---------------write your code BELOW this line only!--------------
        /*because we are using a number that is the power of 2 we can use the formula provided and repeat for as many time as n-1 */
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        if (n != 0) {
            ans = 2 % k;

            while (n > 1) {
                ans = (ans * (2 % k)) % k;
                n = n - 1;
            }
        }
        //---------------write your code ABOVE this line only!--------------

        System.out.println(ans);
    }
}