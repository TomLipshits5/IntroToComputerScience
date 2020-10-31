
import java.util.Scanner;

public class Task4f {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean ans = true;

        //---------------write your code BELOW this line only!--------------
        /*inputs*/
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int d = scanner.nextInt();
        int k = scanner.nextInt();

        while (k > 0 && ans) {
            int diff = n - 2;
            double randomGen = Math.random() * diff;
            int roundRandomGen = (int) randomGen;
            int b = 2 + roundRandomGen;

            /*condition 1*/
            int powerOfB = d;
            int condition1 = b % n;
            while (powerOfB > 1) {
                condition1 = (condition1 * (b % n)) % n;
                powerOfB--;
            }
            if (condition1 != 1) {
                ans = false;
            }

            /*condition 2*/
            if (!ans) {
                for (int i = 0; i <= (s - 1) && !ans; i++) {
                    int powerOf2 = i;
                    int base = 1;
                    while (powerOf2 > 0) {
                        base = base * 2;
                        powerOf2--;

                    }
                    powerOfB = base * d;
                    int condition2 = b % n;
                    while (powerOfB > 1) {
                        condition2 = (condition2 * (b % n)) % n;
                        powerOfB--;
                    }
                    if (condition2 == (n-1)){
                        ans = true;
                    }

                }


            }

            k--;
        }


        //---------------write your code ABOVE this line only!--------------

        System.out.println(ans);
    }
}