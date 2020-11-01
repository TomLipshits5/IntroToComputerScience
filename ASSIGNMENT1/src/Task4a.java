
import java.util.Scanner;

public class Task4a {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean ans = true;

        //---------------write your code BELOW this line only!--------------
        int n = scanner.nextInt();
        int p = 2;
        /*the square root of the MV is 46340.95 so any integer p>46340 multiply by it self will spin back to a negative number */
        /*this problem will cause the loop to continue until p == n and will return that n is a prime number while it's not*/
        while (p * p <= n && p <= 46340 && ans) {
            if (n % p == 0) {
                ans = false;

            } else {
                p = p + 1;
            }

        }
        /*in case p is bigger than than 46340*/
        if (ans)
            p= 46340;
            while(p <n && ans){
                if (n%p == 0){
                    ans = false;
                }
                else {
                    p=p+1;
                }
            }




        //---------------write your code ABOVE this line only!--------------

        System.out.println(ans);
    }
}