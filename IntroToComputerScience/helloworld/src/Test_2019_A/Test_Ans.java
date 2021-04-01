package Test_2019_A;


import Graphs.Graph;
import Graphs.GraphAlgorithm;
import Graphs.GraphAsAdjacencyMatrix;
import com.*;

import java.util.Arrays;

public class Test_Ans {
    public static void main(String[] args) {
        Object[] exp = {1,2,"*",3,"+"};
        ExpressionAsBinaryTree tr = new ExpressionAsBinaryTree(exp);
        System.out.println(tr);
        System.out.println(tr.evaluate());

    }

    public static int count(int[] number){
        return count(number,0,0);
    }

    public static int count(int[] number, int index,int sum){
        int counter = 0;
        if (sum == 0 && index == number.length){
            counter =1;
        }
        if (index<number.length){
            counter = count(number,index+1,sum-number[index]) + count(number,index+1,sum+number[index]);
        }
        return counter;
    }

    public static int[] solve(int[] number){
        int[] signs = new int[number.length];
        if (solve(number,signs,0,0)){
            return signs;
        }
        return null;
    }


    public static boolean solve(int[] number, int[] signs,int index, int sum){
        boolean exists = false;
        if (index == number.length && sum ==0){
            return true;
        }
        if (index<number.length){
            signs[index] = 1;
            exists = solve(number,signs,index+1,sum+number[index]);
            if (!exists){
                signs[index] = -1;
                exists = solve(number,signs,index+1,sum-number[index]);
            }
        }
        return exists;

    }


    public static void encode(int n){
        for (int i =1; i<n+1;i++){
            for (int j=i+1;j<n+1;j++){
                for (int l= j+1;l<n+1;l++){
                    if (l-j == j - i){
                        int[] clouse1 = {-i,-j,-l};
                        int[] clouse2 = {i,j,l};
                        System.out.println(Arrays.toString(clouse1));
                        System.out.println(Arrays.toString(clouse2));
                    }
                }
            }
        }
    }








}
