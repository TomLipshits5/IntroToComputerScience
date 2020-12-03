
class Part1_Change {

    //Assist function.
    // Finds if there is a way to split to value n to any sum of the given instances in the array coins.
    public static boolean Change(int[] coins, int n, int to) {
        boolean ans = false;
        if (to >= 0 && coins[to] != 0) {
            //recursive base case.
            if (n - coins[to] == 0) {
                ans = true;
            //state change to base case.
            } else if (n > coins[to]) {
                ans = ans || Change(coins, n - coins[to], to);
            } else if (coins[to] > n) {
                ans = ans || Change(coins, n, to - 1);
            }
        }
        return ans;
    }

    //Task 2.1
    //Calls the change recursive method return boolean value.
    public static boolean change(int[] coins, int n) {
        return Change(coins, n, coins.length - 1);
    }


    //Assist function.
    //Finds if there is a way to sum a specific number of instances from the array coins to n.
    public static boolean changeLimited(int[] coins, int n, int numOfCoinsToUse, int to) {
        boolean ans = false;
        //must have a possible split.
        if (change(coins, n)) {
            //recursive base case.
            if (numOfCoinsToUse == 1) {
                if (n == coins[to]) {
                    ans = true;
                } else if (to > 0) {
                    ans = ans || changeLimited(coins, n, numOfCoinsToUse, to - 1);
                }
            //state change to base case.
            } else if (coins[to] >= n && to > 0) {
                ans = ans || changeLimited(coins, n, numOfCoinsToUse, to - 1);
            } else if (n > coins[to]) {
                ans = changeLimited(coins, n - coins[to], numOfCoinsToUse - 1, to);
                if (!ans && to > 0) {
                    ans = changeLimited(coins, n, numOfCoinsToUse, to - 1);
                }
            }
        }
        return ans;
    }

    //Task 2.2
    //Calls the changeLimited recursive method return boolean value.
    public static boolean changeLimited(int[] coins, int n, int numOfCoinsToUse) {
        return changeLimited(coins, n, numOfCoinsToUse, coins.length - 1);
    }


    //Assist function.
    ////Finds the specific  instances from the array coins that sums up to n.
    public static String printChangeLimited(int[] coins, int n, int numOfCoinsToUse, int to) {
        String s = "";
        boolean ans = false;
        //make sure that there is a way to split n to the specific number of instances from coins.
        if (changeLimited(coins, n, numOfCoinsToUse)) {
            //base case.
            if (numOfCoinsToUse == 1) {
                if (n == coins[to]) {
                    ans = true;
                    s = s + coins[to];
                } else if (to > 0) {
                    s = s + printChangeLimited(coins, n, numOfCoinsToUse, to - 1);
                }
            ////state change to base case.
            } else if (coins[to] >= n && to > 0) {
                s = s + printChangeLimited(coins, n, numOfCoinsToUse, to - 1);
            } else if (n > coins[to]) {
                ans = ans || changeLimited(coins, n - coins[to], numOfCoinsToUse - 1, to);
                s = s + printChangeLimited(coins, n - coins[to], numOfCoinsToUse - 1, to);
                if (!ans && to > 0) {
                    s = s + printChangeLimited(coins, n, numOfCoinsToUse, to - 1);
                }
                if (ans) {
                    s = s + coins[to];
                }

            }
        }
        return s;

    }

    //Task 2.3
    //calls the printChangeLimited function to create a String and print its chas in the required way.
    public static void printChangeLimited(int[] coins, int n, int numOfCoinsToUse) {
        int to = coins.length - 1;
        String s = printChangeLimited(coins, n, numOfCoinsToUse, to);
        if (s.length() > 0) {
            for (int i = 0; i < s.length() - 1; i++) {
                System.out.print(s.charAt(i) + ",");
            }
            System.out.print(s.charAt(s.length() - 1));
        }
    }

    public static void main(String[] args) {
        int[] Coins = {0, 7, 12};
        int n = 10;
        int numOfCoins = 1;
//        System.out.println(changeLimited(Coins,n,numOfCoins));
        System.out.println(changeLimited(Coins, n, numOfCoins));
    }
}
