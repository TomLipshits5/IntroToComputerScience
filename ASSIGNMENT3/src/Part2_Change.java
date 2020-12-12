class Part2_Change {

    //Task 2.4 //Assist function.
    //Count all possible solutions for limited chang.
    public static int countChangeLimited(int[] coins, int n, int numOfCoinsToUse, int index) {
        int ans = 0;
        if (n==0 && numOfCoinsToUse == 0){ //we redact exactly to n with the correct number of coins.
            ans = 1;
        }
        else if (n<0 || numOfCoinsToUse<0){ // we over redact n or used too many coins.
            ans = 0;
        }
        else if(index<coins.length){    //Summarise the options that contains coins[index] and those who don't.
            ans = ans + countChangeLimited(coins,n-coins[index],numOfCoinsToUse-1,index)+ countChangeLimited(coins,n,numOfCoinsToUse,index+1);
            }

        return ans;
    }


    //Task 2.4
    //Calls the countChangeLimited function and set default values.
    public static int countChangeLimited(int[] coins, int n, int numOfCoinsToUse) {
        return countChangeLimited(coins, n, numOfCoinsToUse, 0);
    }

    //Task 2.5 //Assist function.
    //Print all changing options in the array coins, the same ass 2.3 but without a break point.
    public static void printAllChangeLimited(int[] coins, int n, int numOfCoinsToUse, int index,String acc) {
        if (n == 0 && numOfCoinsToUse == 0){    //we redact exactly to n with the correct number of coins and print the accumulator.
            System.out.println(acc.substring(0,acc.length()-1)); ;
        }
        else if (n<0 || numOfCoinsToUse<0){         // we over redact n or used too many coins.
            System.out.print("");
        }

        else if (index<coins.length){           //  find the solutions that contain coins[index] or don't contain it.
            printAllChangeLimited(coins,n-coins[index],numOfCoinsToUse-1,index,acc+coins[index] + ",");
            printAllChangeLimited(coins,n,numOfCoinsToUse,index+1,acc);
        }

    }


    //Task 2.5
    //Calls the printAllChangeLimited function and set default values.
    public static void printAllChangeLimited(int[] coins, int n, int numOfCoinsToUse) {
        printAllChangeLimited(coins,n,numOfCoinsToUse,0,"");
    }


    //Task 2.6 //Assist function.
    //Count all possibilities to change n without a coin limitation.
    public static int cubaSolver(int[] coins,int nCuc,int index){
        int ans = 0;
        if (nCuc==0){           //we redact exactly to n
            ans = 1;
        }
        else if (nCuc<0){       // we over redact n
            ans =0;
        }
        else if (index<coins.length){       //Summarise the options that contains coins[index] and those who don't.
                ans = ans + cubaSolver(coins,nCuc-coins[index],index) + cubaSolver(coins , nCuc,index+1);
        }
        return ans;
    }
    //Task 2.6
    //Calls the cubaSolver function and set coins to default values of CUP and n to CUP value.
    public static int changeInCuba(int cuc) {
        int[] coins = {1,3,3,5,9,10,15,20,30,50,60,100,150,300};
        return cubaSolver(coins,cuc*3,0);
    }

    public static void main(String[] args) {
        int[] Coins = {1,3,5,10,20,50,100};
        int[] CoinsCup = {1,3,3,5,9,10,15,20,30,50,60,100,150,300};
        int n = 2;
        int ans = cubaSolver(CoinsCup,150,0);
        System.out.println(changeInCuba(20));




    }

}
