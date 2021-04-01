package Test_2019_B;

import Interfaces.Comparator;
import Interfaces.List;
import com.BinarySearchTree;
import com.BinaryTree;
import com.DynamicArray;
import com.Iterator;



public class Test_2019_B {
    public static void main(String[] args) {
        Comparator<Integer> co = new Comparator<Integer>() {
            @Override
            public int compare(Integer e1, Integer e2) {
                return e1.compareTo(e2);
            }
        };
        BinarySearchTree<Integer> tr = new BinarySearchTree<>(co);
        tr.insert(6);
        tr.insert(4);
        tr.insert(5);
        tr.insert(7);
        tr.insert(8);
        tr.insert(1);
        System.out.println(tr);
        tr.mirror();
        System.out.println(tr.isFullLevel(2));
        System.out.println(tr.isFullLevel(1));

    }



    //Q2
    public static boolean canChange(int[] coins, int k , int sum){
        return canChange(coins,k,sum,0);
    }

    public static boolean canChange(int[] coins, int k ,int sum, int i){
        if (k==0 && sum == 0){
            return true;
        }
        if (k<0 || sum<0 || i>= coins.length){
            return false;
        }
        else{
            return canChange(coins,k-1,sum-coins[i],i) || canChange(coins,k,sum,i+1);
        }
    }

    //Q2 Memo
    public static boolean canChangeMemo(int[] coins, int k , int sum){
        Boolean[][][] memo = new Boolean[k+1][sum+1][coins.length];
        for (int i = 0; i<k+1;i++){
            for(int j = 0 ; j<sum+1; j++){
                for (int l = 0;l<coins.length;l++){
                    memo[i][j][l] = null;
                }
            }
        }
        return canChangeMemo(coins,k,sum,0,memo);
    }

    public static boolean canChangeMemo(int[] coins, int k , int sum,int i,Boolean[][][] memo){
        if (k==0 && sum==0){
            return true;
        }
        if (k<=0||sum<=0||i>=coins.length){
            return false;
        }
        else if (memo[k][sum][i] == null){
            memo[k][sum][i] = canChangeMemo(coins,k-1,sum-coins[i],i,memo) || canChangeMemo(coins,k,sum,i+1,memo);
        }
        return memo[k][sum][i];
    }
}
