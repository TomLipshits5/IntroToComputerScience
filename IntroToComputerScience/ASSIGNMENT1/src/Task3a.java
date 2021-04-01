
import java.util.Scanner;

public class Task3a {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int ans = 1;

        //---------------write your code BELOW this line only!--------------
        int power = scanner.nextInt();
        while (power > 0) {
            ans = ans * 2;
            power = power - 1;


        }

        //---------------write your code ABOVE this line only!--------------

        System.out.println(ans);
    }
}