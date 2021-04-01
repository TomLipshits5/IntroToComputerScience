package Test_2018_B;

import Graphs.Graph;
import Graphs.GraphAlgorithm;
import Graphs.GraphAsAdjacencyMatrix;
import com.Iterator;
import com.LinkedList;

import java.util.Arrays;


public class Test_2018_B {
    public static void main(String[] args) {
        Graph gr = new GraphAsAdjacencyMatrix(5);
        gr.addEdge(0,1);
        gr.addEdge(2,1);
        gr.addEdge(2,3);
        gr.addEdge(4,3);
        gr.addEdge(4,0);
        GraphAlgorithm bfa = new BreathFirstAlgorithm(gr,1);
        System.out.println(Arrays.toString((int[])bfa.runAlgorithm()));

    }


    public static boolean partition(int[] arr){
        return partition(arr,0,0,0);
    }

    public static boolean partition(int[] arr , int i, int sum1,int sum2){
        if (i == arr.length && sum1 == sum2){
            return true;
        }
        if (i>=arr.length){
            return false;
        }
        else{
            return partition(arr,i+1,sum1+arr[i],sum2) || partition(arr,i+1,sum1,sum2+arr[i]);
        }
    }


    public static boolean isLegal(String s){
        if (s.length()>0){
            if (s.length()>1&&s.charAt(0) == '0'){
                return false;
            }for (int i = 0; i<s.length();i++){
                if (s.charAt(i)<'0'||s.charAt(i)>'9'){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
