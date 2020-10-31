
import java.util.Scanner;

public class Task4b {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int ans = 0;

        //---------------write your code BELOW this line only!--------------
        int n = scanner.nextInt();
        int myNum = 2;
        while (myNum <= n) {
            int p = 2;
            boolean isPrime = true;
            /*the square root of the MV is 46340.95 so any integer p>46340 multiply by it self will spin back to a negative number */
            /*this problem will cause the loop to continue until p == n and will return that n is a prime number while it's not*/
            while (p * p <= myNum && p <= 46340 && isPrime) {
                if (myNum % p == 0) {
                    isPrime = false;
                } else {
                    p = p + 1;
                }
            }
            /*in case n is bigger than than 46340*/
            if (isPrime){
                p= 46340;
                while(p <myNum && isPrime){
                    if (myNum%p == 0){
                        isPrime = false;
                    }
                    else {
                        p=p+1;
                    }
                }

            }
            if (isPrime){
                ans = ans + 1;
            }
            myNum = myNum + 1;
        }
        //---------------write your code ABOVE this line only!--------------

        System.out.println(ans);
    }
}