import java.util.Arrays;

public class Assignment2 {


    /*-----------------------
     *| Part A - tasks 1-11 |
     * ----------------------*/

    // task 1
    // Check if the matrix has n rows and n variables in each row.
    public static boolean isSquareMatrix(boolean[][] matrix) {
        boolean isSquareMatrix = true;
        if (matrix == null || matrix.length == 0) {
            isSquareMatrix = false;
        }

        int numPar = matrix.length;
        for (int index = 0; index < numPar && isSquareMatrix; index++) {
            if (matrix[index].length != numPar) {
                isSquareMatrix = false;
            }
        }
        return isSquareMatrix;
    }

    // task 2
    //Check if the value of matrix[i][j] is equal to matrix[j][i].
    public static boolean isSymmetricMatrix(boolean[][] matrix) {
        boolean isSymmetricMatrix = true;
        int numPar = matrix.length;
        for (int i = 0; i < numPar && isSymmetricMatrix; i++) {
            for (int j = 0; j < numPar && isSymmetricMatrix; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    isSymmetricMatrix = false;
                }
            }
        }

        return isSymmetricMatrix;
    }

    // task 3
    // Check if the value of the matrix[i][i] is always false.
    public static boolean isAntiReflexiveMatrix(boolean[][] matrix) {
        boolean isAntiReflexivMatrix = true;
        int numPar = matrix.length;
        for(int i = 0; i<numPar && isAntiReflexivMatrix; i++){
            if(matrix[i][i] != false){
                isAntiReflexivMatrix = false;
            }
        }
        return isAntiReflexivMatrix;
    }

    // task 4
    // applay all three checks to make sure the matrix is a valid appearance.
    public static boolean isLegalInstance(boolean[][] matrix) {
        boolean isLegalInstance = false;
        if (isSquareMatrix(matrix) && isAntiReflexiveMatrix(matrix) && isSymmetricMatrix(matrix)){
            isLegalInstance = true;
        }
        return isLegalInstance;
    }

    // task 5
    //check that an int array of n objects will contain 0<= i < n with no repetitions or exceptions,
    // regardless to order.
    public static boolean isPermutation(int[] array) {
        boolean isPermutauion = true;
        for (int i = 0 ; i<array.length && isPermutauion ; i++){
            boolean isInArray = false;
            for (int j = 0; j<array.length&& !isInArray; j++){
                if (array[j] == i){
                    isInArray = true;
                }
            }
            if (!isInArray){
                isPermutauion = false;
            }
        }

        return isPermutauion;
    }

    // task 6
    //Check if the steps in the array tour is legal according to the flights array,
    // and ensuring that there is a rout between the last and the first city.
    public static boolean hasLegalSteps(boolean[][] flights, int[] tour) {
        boolean hasLegalSteps = true;
        if (!flights[tour[0]][tour[tour.length-1]]){
            hasLegalSteps=false;
        }
        for(int i = 0 ; i< tour.length-1 && hasLegalSteps; i++){
            if (!flights[tour[i]][tour[i + 1]]){
                hasLegalSteps = false;
            }
        }


        return hasLegalSteps;
    }

    // task 7
    //applay the prior two checks to make sure the solution is valid.

    public static boolean isSolution(boolean[][] flights, int[] tour) {
        boolean isSolution = true;
        if (tour.length != flights.length){
            throw new IllegalArgumentException("tour is shorter than n");
        }
        if (tour[0]!=0){
            return false;
        }
        else if (!isPermutation(tour)){
            return false;
        }
        else return hasLegalSteps(flights, tour);
    }

    // task 8
    //Checks if an assign is a valid solution for a given cnf formula.
    public static boolean evaluate(int[][] cnf, boolean[] assign) {
        boolean evaluate = true;
        for (int[] var : cnf){
            boolean value = false;
            for(int i : var){
                if(i<0){
                    value = value || !assign[-i];
                }
                else{
                    value = value || assign[i];
                }
            }
            if (!value){
                return value;
            }
        }


        return evaluate;

    }

    // task 9
    // Creates a clause that represents: at least one of the literals is true.
    public static int[][] atLeastOne(int[] lits) {
        return new int[][]{lits};
    }

    // task 10
    // Creates a clause that represents: at most one of the literals is true.
    public static int[][] atMostOne(int[] lits) {
        int[][] atMostOne = new int[lits.length + 1][lits.length];
        for (int i = 0; i<atMostOne.length; i++){
            for (int j = 0 ; j<lits.length; j++){
                if (j!=i){
                    atMostOne[i][j] = -lits[j];
                }
                else{
                    atMostOne[i][j]= lits[j];
                }
            }

        }
        return atMostOne;
    }

    // task 11
    //Join the two prior functions to create a clause that represents: exactly one of the literals.
    public static int[][] exactlyOne(int[] lits) {
        int[][] exactlyOne = new int[lits.length+2][lits.length];
        int[][] atMostOne = atMostOne(lits);
        for(int i =0; i <atMostOne.length ; i++){
            exactlyOne[i] = atMostOne[i];
        }
        exactlyOne[atMostOne.length] = lits;
        return exactlyOne;

    }

    /*------------------------
     *| Part B - tasks 12-20 |
     * -----------------------*/

    // task 12a
    public static int map(int i, int j, int n) {
        return (i%n)*n+j+1;
    }

    // task 12b
    public static int[] reverseMap(int k, int n) {
        return new int[] {(k-1)/n,(k-1)%n};
    }

    // task 13
    public static int[][] oneCityInEachStep(int n) {
        int[][] cnf = new int[n*(n+2)][n];
        int step = 0;
        for (int i = 0; i<n; i++){
            int[] var = new int[n];
            for (int j = 0 ; j<n ; j++){
                var[j] = map(i,j,n);
            }
            int[][] myStepCnf = exactlyOne(var);
            for(int t = 0 ; t<myStepCnf.length ; t++){
                cnf[t+step] = myStepCnf[t];
            }
            step = step + (n+2);
        }
        return cnf;
    }

    // task 14
    public static int[][] eachCityIsVisitedOnce(int n) {
        throw new UnsupportedOperationException("Not Implemented yet.");
    }

    // task 15
    public static int[][] fixSourceCity(int n) {
        throw new UnsupportedOperationException("Not Implemented yet.");
    }

    // task 16
    public static int[][] noIllegalSteps(boolean[][] flights) {
        throw new UnsupportedOperationException("Not Implemented yet.");
    }

    // task 17
    public static int[][] encode(boolean[][] flights) {
        throw new UnsupportedOperationException("Not Implemented yet.");
    }

    // task 18
    public static int[] decode(boolean[] assignment, int n) {
        throw new UnsupportedOperationException("Not Implemented yet.");
    }

    // task19
    public static int[] solve(boolean[][] flights) {
        throw new UnsupportedOperationException("Not Implemented yet.");
    }

    // task20
    public static boolean solve2(boolean[][] flights) {
        throw new UnsupportedOperationException("Not Implemented yet.");
    }


    public static void main(String[] args) {

        int[] lits1 = {7,8,9};
        int[] lits2 = {1,3,2,0};
        boolean[][] cnf1 = {{false, true, true, false}, {true, false, true, true}, {true, true, false, true}, {false, true, true, false}};
        int[][] cnf2 = exactlyOne(lits2);
        boolean[] assign1 = {false,false, false,  false};
        boolean[] assign2 = {false, false, true, true};
        boolean[] assign3 = {false, true, false, false};
        int[][] test = oneCityInEachStep(4);
        for (int[] i :test){
            System.out.println(Arrays.toString(i));
        }

//        int k = map(1,0,4);
//        System.out.println(k);
//        System.out.println(Arrays.toString(reverseMap(k,4)));





    }
}
