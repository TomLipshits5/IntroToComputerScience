
class Part1_Change {

    //Assist function.
    // Finds if there is a way to split the value n to any sum of the given instances in the array coins.
    public static boolean Change(int[] coins, int n, int index) {
        boolean ans = false;
        //Base case
        if (n == 0) { //we redact exactly to n.
            ans = true;
        } else if (n < 0) { // we over redact.
            ans = false;
            //State change to base case
        } else if (index < coins.length) { //  find the solutions that contain coins[index] or don't contain it.
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
        if (n == 0 && numOfCoinsToUse == 0) {     //we redact exactly to n with the correct number of coins.
            ans = true;
        } else if (n<0 || numOfCoinsToUse<0){    // we over redact n or used too many coins.
            ans = false;

            //state change to base case.
        } else if (index< coins.length) {       //  find the solutions that contain coins[index] or don't contain it.
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
    //using an accumulator "acc" to build the string of the solution.
    public static String printChangeLimited(int[] coins,int n, int numOfCoinsToUse,int index,String acc){
        String s ="";
        //Base case
        if (n==0 && numOfCoinsToUse == 0){          //we redact exactly to n with the correct number of coins.
            s =  s+acc;
        }
        else if(n<0 || numOfCoinsToUse < 0){        // we over redact n or used too many coins.
            s = "";
        }
        //State change to base case
        else if(index < coins.length ){         //  find the solutions that contain coins[index] or don't contain it.
            s = s + printChangeLimited(coins,n-coins[index],numOfCoinsToUse-1,index,acc+coins[index]+",");
            if(s.equals(""))        //break the recursive call if there is a solution ans continue if not.
                s= s+ printChangeLimited(coins,n,numOfCoinsToUse,index+1,acc);
        }


        return s;
    }


    //Task 2.3
    //calls the printChangeLimited function to create a substring  and print it in the required way.
    public static void printChangeLimited(int[] coins, int n, int numOfCoinsToUse) {
        String s = printChangeLimited(coins, n, numOfCoinsToUse, 0,"");
        if (s.length() > 0) // make sure there is a valid solution.
            System.out.println(s.substring(0, s.length() - 1));    //Trim the last ",".
    }


    public static void main(String[] args) {
        int[] Coins = {1,2,3,4,5,6,7};
        int n =6;
        int numOfCoins = 3;
//        System.out.println(printChangeLimited(Coins, n, numOfCoins,0,""));
        printChangeLimited(Coins,n,numOfCoins);
    }
}
