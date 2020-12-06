
class Part1_Change {

    //Assist function.
    // Finds if there is a way to split to value n to any sum of the given instances in the array coins.
    public static boolean Change(int[] coins, int n, int index) {
        boolean ans = false;
        //Base case
        if (n == 0) {
            ans = true;
        } else if (n < 0) {
            ans = false;
            //State change to base case
        } else if (index < coins.length) {
            ans = Change(coins, n - coins[index], index) || Change(coins, n, index + 1);
        }
        return ans;
    }

    //Task 2.1
    //Calls the change recursive method return boolean value.
    public static boolean change(int[] coins, int n) {
        return Change(coins, n, 0);
    }


    //Assist function.
    //Finds if there is a way to sum a specific number of instances from the array coins to n.
    public static boolean changeLimited(int[] coins, int n, int numOfCoinsToUse, int index) {
        boolean ans = false;
        //must have a possible split.
        //recursive base case.
        if (n == 0 && numOfCoinsToUse == 0) {
            ans = true;
        } else if (n<0 || numOfCoinsToUse<0){
            ans = false;

            //state change to base case.
        } else if (index< coins.length) {
            ans = changeLimited(coins,n-coins[index],numOfCoinsToUse-1,index) || changeLimited(coins,n,numOfCoinsToUse,index+1);
        }

        return ans;
    }

    //Task 2.2
    //Calls the changeLimited recursive method return boolean value.
    public static boolean changeLimited(int[] coins, int n, int numOfCoinsToUse) {
        return changeLimited(coins, n, numOfCoinsToUse, 0);
    }


   //Creates a string of one of the possible solutions.
    public static String printChangeLimited(int[] coins,int n, int numOfCoinsToUse,int index,String build){
        String s ="";
        //Base case
        if (n==0 && numOfCoinsToUse == 0){
            s =  s+build;
        }
        else if(n<0 || numOfCoinsToUse < 0){
            s = "";
        }
        //State change to base case
        else if(index < coins.length ){
            s = s + printChangeLimited(coins,n-coins[index],numOfCoinsToUse-1,index,build+coins[index]+",");
            if(s.equals(""))
                s= s+ printChangeLimited(coins,n,numOfCoinsToUse,index+1,build);
        }


        return s;
    }

    //Task 2.3
    //calls the printChangeLimited function to create a substring  and print it in the required way.
    public static void printChangeLimited(int[] coins, int n, int numOfCoinsToUse) {
        String s = printChangeLimited(coins, n, numOfCoinsToUse, 0,"");
        if (s.length() > 0)
            System.out.println(s.substring(0, s.length() - 1));
    }


    public static void main(String[] args) {
        int[] Coins = {1,2,3,4,5,6,7};
        int n =6;
        int numOfCoins = 3;
//        System.out.println(printChangeLimited(Coins, n, numOfCoins,0,""));
        printChangeLimited(Coins,n,numOfCoins);
    }
}
