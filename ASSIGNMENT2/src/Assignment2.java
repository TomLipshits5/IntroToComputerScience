
public class Assignment2 {


    /*-----------------------
     *| Part A - tasks 1-11 |
     * ----------------------*/

    // task 1
    public static boolean isSquareMatrix(boolean[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        boolean isSquareMatrix = true;
        int numPar = matrix.length;
        for (int index = 0; index < numPar && isSquareMatrix; index++) {
            if (matrix[index].length != numPar) {
                isSquareMatrix = false;
            }
        }
        return isSquareMatrix;
    }

    // task 2
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
    public static boolean isLegalInstance(boolean[][] matrix) {
        boolean isLegalInstance = false;
        if (isSquareMatrix(matrix) && isAntiReflexiveMatrix(matrix) && isSymmetricMatrix(matrix)){
            isLegalInstance = true;
        }
        return isLegalInstance;
    }

    // task 5
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
    public static boolean hasLegalSteps(boolean[][] flights, int[] tour) {
        boolean hasLegalSteps = true;
        if (!flights[0][tour[tour.length-1]]){
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
    public static boolean isSolution(boolean[][] flights, int[] tour) {
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
    public static boolean evaluate(int[][] cnf, boolean[] assign) {
        throw new UnsupportedOperationException("Not Implemented yet.");
    }

    // task 9
    public static int[][] atLeastOne(int[] lits) {
        throw new UnsupportedOperationException("Not Implemented yet.");
    }

    // task 10
    public static int[][] atMostOne(int[] lits) {
        throw new UnsupportedOperationException("Not Implemented yet.");
    }

    // task 11
    public static int[][] exactlyOne(int[] lits) {
        throw new UnsupportedOperationException("Not Implemented yet.");
    }


    public static void main(String[] args) {
        boolean[][] matrix =  {{false, false, true, true },
                                {false, false, true, true },
                                    {true, true, false, true },
                                        {true, true, true, false}};
        ;
        int[] array = {0,2,1};
        boolean test = isSolution(matrix,array);
        System.out.println(test);
    }
}
