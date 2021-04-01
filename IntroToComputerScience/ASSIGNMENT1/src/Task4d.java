
import java.util.Scanner;

public class Task4d {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int ans1 = 0;
        int ans2 = 0;

        //---------------write your code BELOW this line only!--------------
        /*Comparing ans2%2 to 0 will tell ass the power of 2
         once the module is different then 0 we stop the loop and print ans1 and ans2*/
        int n = scanner.nextInt();
        ans2 = n - 1;
        while (ans2 % 2 == 0) {
            ans2 = ans2 / 2;
            ans1++;
        }
        //---------------write your code ABOVE this line only!--------------

        System.out.println(ans1);
        System.out.println(ans2);
    }
}