
class Part2_Change {

    //Task 2.4
    public static int countChangeLimited(int[] coins, int n, int numOfCoinsToUse, int to) {
        int ans = 0;
        if (to == 0 && Part1_Change.changeLimited(coins, n, numOfCoinsToUse, to))
            ans = 1;
        else if (Part1_Change.changeLimited(coins, n, numOfCoinsToUse, to)) {
            if (coins[to] <= n){
                ans++;
            }
            ans = ans + countChangeLimited(coins, n, numOfCoinsToUse, to - 1);
        }
        return ans;
    }

    public static int countChangeLimited(int[] coins, int n, int numOfCoinsToUse) {
        int to = coins.length - 1;
        return countChangeLimited(coins, n, numOfCoinsToUse, to);
    }

    //Task 2.5
    public static String printAllChangeLimited1(int[] coins, int n, int numOfCoinsToUse, int to) {
        String s = "";
        if (to == 0 && Part1_Change.changeLimited(coins, n, numOfCoinsToUse, to)) {
            s = s + coins[to];
        } else if (Part1_Change.changeLimited(coins, n, numOfCoinsToUse, to) && n >= coins[to]) {
            s = s + coins[to] + printAllChangeLimited1(coins, n - coins[to], numOfCoinsToUse - 1, to);

        } else if (n < coins[to] && to > 0) {
            s = s + printAllChangeLimited1(coins, n, numOfCoinsToUse, to - 1);

        }
        return s;
    }

    public static void printAllChangeLimited(int[] coins, int n, int numOfCoinsToUse) {
        int to = coins.length - 1;
        for (int i = 0; i < coins.length; i++) {
            if (coins[to-i] <= n) {
                String s = printAllChangeLimited1(coins, n, numOfCoinsToUse, to-i);
                for (int j = 0; j < s.length(); j++) {
                    if (j == 0) {
                        System.out.print(s.charAt(j));
                    } else {
                        System.out.println("," + s.charAt(j));
                    }
                }
            }
        }

    }

    public static int changeInCuba(int cuc) {
        int ans = 0;
        //Task 2.6
        return ans;
    }

    public static void main(String[] args) {
        int[] Coins = {1,2,3,4,5,6};
        int n = 4;
        int numOfCoinsToUse = 1;
        System.out.println(countChangeLimited(Coins,n,numOfCoinsToUse));
        printAllChangeLimited(Coins, n, numOfCoinsToUse);
    }
}
