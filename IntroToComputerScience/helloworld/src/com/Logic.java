package com;
import java.lang.Math;
import java.util.Arrays;

public class Logic {
    public static void main(String[] args) {
        boolean[][] table = table(3);
        boolean[] x = table[0];
        boolean[] y = table[1];
        boolean[] z = table[2];
        boolean[] truthValues = new boolean[8];
        for (int i =0 ;i<(int)Math.pow(2,3);i++){
            boolean expression = (x[i]&&y[i])||z[i];
            truthValues[i]=expression;
        }

        System.out.println(Arrays.toString(truthValues));
    }






    /*create a 3d array of each paramiter in the table*/
    public static boolean[][] table(int numPar) {
        int lines = (int) Math.pow(2, numPar);
        boolean[][] table = new boolean[numPar][lines];
        int module = 1;
        for (boolean[] par : table) {
            boolean value = false;
            for (int i = 0; i < lines; i++) {
                if (i % module == 0)
                    value = !value;
                par[i] = value;

            }
            module = module *  2;
        }
        return table;
    }







    /*calculate the value of each line in the table according to the operator*/
    public static boolean[] truthTable(boolean[][] table, String logicOper) {
        int lines = table[0].length;
        boolean[] truthTable = new boolean[lines];
        int index = 0;
        while (index < lines) {
            boolean value = table[0][index];
            if (logicOper.equals("&") || logicOper.equals("&&")) {
                for (boolean[] par : table) {
                    value = value && par[index];
                }
                truthTable[index] = value;
            }
            else if (logicOper.equals("|") || logicOper.equals("||")){
                for (boolean[] par : table) {
                    value = value || par[index];
                }
                truthTable[index]= value;
            }
            index++;

        }

        return truthTable;
    }

}
