
class Part1_Change {


    public static boolean Change(int[] coins, int n, int to) {
        boolean ans = false;
        if (to >= 0 && coins[to] != 0) {
            if (n - coins[to] == 0) {
                ans = true;
            } else if (n > coins[to]) {
                ans = ans || Change(coins, n - coins[to], to);
            } else if (coins[to] > n) {
                ans = ans || Change(coins, n, to - 1);
            }
        }
        return ans;
    }

    //Task 2.1
    public static boolean change(int[] coins, int n) {
        return Change(coins, n, coins.length - 1);
    }


    //Task 2.2
    public static boolean changeLimited(int[] coins, int n, int numOfCoinsToUse, int to) {
        boolean ans = false;
        if (change(coins, n)) {
            if (numOfCoinsToUse == 1) {
                if (n == coins[to]) {
                    ans = true;
                } else if (to > 0) {
                    ans = ans || changeLimited(coins, n, numOfCoinsToUse, to - 1);
                }
            } else if (coins[to] >= n && to > 0) {
                ans = ans || changeLimited(coins, n, numOfCoinsToUse, to - 1);
            }
            else if (n>coins[to]){
                ans = changeLimited(coins,n-coins[to],numOfCoinsToUse-1,to);
                if (!ans && to >0){
                    ans = changeLimited(coins,n,numOfCoinsToUse,to-1);
                }
            }
        }
        return ans;
    }
    public static boolean changeLimited(int[] coins, int n, int numOfCoinsToUse){
        return changeLimited(coins,n,numOfCoinsToUse,coins.length-1);
    }

    public static void printChangeLimited(int[] coins, int n, int numOfCoinsToUse) {
        //Task 2.3
    }

    public static void main(String[] args) {
        int[] Coins = {1, 7, 10, 12};
        int n = 12;
        int numOfCoins = 6;
        System.out.println(changeLimited(Coins, n, numOfCoins));
    }
}
