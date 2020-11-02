
import java.util.Scanner;

public class Task4e {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean ans1 = true;
        int ans2 = -1;

        //---------------write your code BELOW this line only!--------------
        /*inputs*/
        int n = scanner.nextInt();
        int b = scanner.nextInt();
        int s = scanner.nextInt();
        int d = scanner.nextInt();


        /*condition 1 using the formula (a*b)%c == ((a%c)*(b%c))%c */
        int powerOfB = d;
        int condition1 = b % n;
        while (powerOfB > 1) {
            condition1 = (condition1 * (b % n)) % n;
            powerOfB--;
        }
        if (condition1 != 1) {
            ans1 = false;
            ans2 = b;
        }

        /*condition 2 will be checked only if condition1 is true*/
        if (!ans1) {
            for (int i = 0; i <= (s - 1) && !ans1; i++) {
                int powerOf2 = i;
                int base = 1;
                /*using a simple loop calculating the power of 2*/
                while (powerOf2 > 0) {
                    base = base * 2;
                    powerOf2--;

                }
                powerOfB = base * d;
                int condition2 = b % n;
                /*calculating condition2 value using the same formula as condition1*/
                while (powerOfB > 1) {
                    condition2 = (condition2 * (b % n)) % n;
                    powerOfB--;
                }
                /*checking if condition2 is true for all i*/
                if (condition2 == (n - 1)) {
                    ans1 = true;
                    ans2 = -1;
                }
            }


        }


        //---------------write your code ABOVE this line only!--------------

        System.out.println(ans1);
        System.out.println(ans2);
    }
}