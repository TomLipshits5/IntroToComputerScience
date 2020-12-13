import org.sat4j.minisat.restarts.ArminRestarts;

import java.util.Arrays;

public class Assignment2 {


    /*-----------------------
     *| Part A - tasks 1-11 |
     * ----------------------*/

    // task 1
    // Check if the matrix has n rows and n elements in each row.
    public static boolean isSquareMatrix(boolean[][] matrix) {
        boolean isSquareMatrix = true;
        if (matrix == null || matrix.length == 0) {
            return false;
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
    // apply all three checks to make sure the matrix is a valid appearance.
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
    //apply the prior two checks to make sure the solution is valid.
    public static boolean isSolution(boolean[][] flights, int[] tour) {
        boolean isSolution = true;

        if (tour == null || tour.length != flights.length){
            throw new IllegalArgumentException("Tour is not correct");
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
                return false;
            }
        }
        return true;
    }

    // task 9
    // Creates a clause that represents: at least one of the literals is true.
    public static int[][] atLeastOne(int[] lits) {
        return new int[][]{lits};
    }

    // task 10
    // Creates a clause that represents: at most one of the literals is true.
    public static int[][] atMostOne(int[] lits) {
        int numOfLits = lits.length;
        int numOfClauses = numOfLits * (numOfLits-1)/2;
        int currIndex =0;
        int[][] cnf= new int[numOfClauses][numOfLits];
        for(int i=0; i<lits.length; i++){

            for(int j=i+1; j<lits.length; j++, currIndex ++){
                int[] clause = {-lits[i], -lits[j]};
                cnf[currIndex] = clause;
            }
        }
        return cnf;
    }


    // task 11
    //Join the two prior functions to create a clause that represents: exactly one of the literals.
    public static int[][] exactlyOne(int[] lits) {
        int[][] atMostOne = atMostOne(lits);
        int[][] exactlyOne = new int[atMostOne.length+1][lits.length];
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
    // Convert a city and a step to a unique indexed value.
    public static int map(int i, int j, int n) {
        return (i%n)*n+j+1;
    }

    // task 12b
    //Reverse a mapped value to its step and city.
    public static int[] reverseMap(int k, int n) {
        return new int[] {(k-1)/n,(k-1)%n};
    }

    // task 13
    // Create a CNF that make sure that one city is visited each step.
    public static int[][] oneCityInEachStep(int n) {
        int[] literalsZeroArray = new int [n];
        int numOfRowsForStep = exactlyOne(literalsZeroArray).length;
        int[][] cnf = new int[n*numOfRowsForStep][];
        int step = 0;
        for (int i = 0; i<n; i++){
            int[] literals = new int[n];
            for (int j = 0 ; j<n ; j++){
                literals[j] = map(i,j,n);
            }
            int[][] myStepCnf = exactlyOne(literals);
            for(int t = 0 ; t<myStepCnf.length ; t++){
                cnf[t+step] = myStepCnf[t];
            }
            step = step + numOfRowsForStep;
        }
        return cnf;
    }

    // task 14
    // Create a CNF that make sure that each city is visited once.
    public static int[][] eachCityIsVisitedOnce(int n) {
        int[] literalsZeroArray = new int [n];
        int numRowsForCity = exactlyOne(literalsZeroArray).length;
        int[][] cnf = new int[n*numRowsForCity][];
        int step =0;
        for (int i = 0; i<n; i++){
            int[] literals = new int[n];
            for (int j = 0; j<n; j++){
                literals[j] = map(j,i,n);
            }
            int[][] myCityCnf = exactlyOne(literals);
            for (int t = 0; t<myCityCnf.length; t++){
                cnf[t+step] = myCityCnf[t];
            }
            step = step + numRowsForCity;


        }
        return cnf;
    }

    // task 15
    // Create a CNF that ensure that the first city is 0.
    public static int[][] fixSourceCity(int n) {
        return new int[][]{{map(0,0,n)}};
    }

    // task 16
    //Create a CNF that make sure there is no illegal steps between cities.
    public static int[][] noIllegalSteps(boolean[][] flights) {
        int step = 0;
        int clouseCounter = 0;
        int counter = 0;
        for (int j = 0; j < flights.length; j++) {
            for (int i = 0; i < flights.length; i++) {
                if (!flights[j][i] && i != j) {
                    counter++;
                }
            }
        }
        int[][] cnf = new int[flights.length* counter][2];
        while(step< flights.length) {
            for (int city = 0; city < flights.length; city++) {
                for (int i = 0; i < flights[step].length; i++) {
                    if (!flights[city][i]&& i != city){
                        int[] clouse = {-map(step,city, flights.length),-map(step+1,i,flights.length)};
                        cnf[clouseCounter]= clouse;
                        clouseCounter++;
                    }
                }
            }
            step++;
        }

        return cnf;
    }

    // task 17
    // Convert a flight array to a CNF by the three conditions above.
    public static int[][] encode(boolean[][] flights) {
        int[][]firstCon = oneCityInEachStep(flights.length);
        int[][]secondCon = eachCityIsVisitedOnce(flights.length);
        int[][]thirdCon = noIllegalSteps(flights);
        int[][]fourthCon = fixSourceCity(flights.length);
        int cnfClouses = firstCon.length+secondCon.length+thirdCon.length+fourthCon.length;
        int[][] cnf = new int[cnfClouses][];
        for (int i = 0; i<firstCon.length;i++){
            cnf[i] = firstCon[i];
        }
        for (int i = 0; i<secondCon.length;i++){
            cnf[firstCon.length+i] = secondCon[i];
        }
        for (int i = 0; i< thirdCon.length; i++){
            cnf[firstCon.length+secondCon.length+i] = thirdCon[i];
        }
        cnf[cnfClouses-1] = fourthCon[0];
        return cnf;
    }

    // task 18
    // decode an assignment to a tour array.
    public static int[] decode(boolean[] assignment, int n) {
        if (assignment == null || assignment.length != (n*n)+1){
            throw new IllegalArgumentException("Assignment is illegal.");
        }
        int[] tour = new int[n];
        for (int i =1; i<assignment.length; i++){
            if(assignment[i]){
                int[] myStep = reverseMap(i,n);
                tour[myStep[0]] = myStep[1];
            }
        }
        return tour;
    }

    // task19
    // Creates and find a solution for the big trip problem.
    public static int[] solve(boolean[][] flights) {
        if (!isLegalInstance(flights)){
            throw new IllegalArgumentException("Illegal flights array.");
        }

        int nVars = flights.length* flights.length;
        SATSolver.init(nVars);
        int[][] cnf = encode(flights);
        SATSolver.addClauses(cnf);
        boolean[] assignment = SATSolver.getSolution();
        if (assignment.length == nVars +1){
            int[] tour = decode(assignment, flights.length);
            if (isSolution(flights,tour)){
                return tour;
            }
            else{
                throw new IllegalArgumentException("Tour is not a legal solution.");
            }
        }
        else if(assignment == null){
            throw new IllegalArgumentException("Solution timeout.");
        }
        else{
            return null;
        }
    }

    // task20
    //Checks if there is more than one solution.
    public static boolean solve2(boolean[][] flights) {
        int nVars = flights.length * flights.length;
        int[] tour1 = solve(flights);
        if (tour1 == null){
            return false;
        }
        int[] tour2 = new int[tour1.length];
        int start = 1;
        int end = tour1.length-1;
        while (start <= end){
            tour2[start] = tour1[end];
            tour2[end] = tour1[start];
            start++;
            end--;
        }
        int[] literals1 = new int[tour1.length];
        int[] literals2 = new int[tour2.length];
        for (int i =0; i<tour1.length; i++){
            literals1[i] = -map(i,tour1[i], tour1.length);
            literals2[i] = -map(i,tour2[i], tour2.length);
        }
        SATSolver.init(nVars);
        SATSolver.addClause(literals1);
        SATSolver.addClause(literals2);
        int[][] cnf = encode(flights);
        SATSolver.addClauses(cnf);
        boolean[] assignment = SATSolver.getSolution();
        if (assignment.length == tour2.length*tour1.length +1){
            int[] tour = decode(assignment, flights.length);
            if (isSolution(flights,tour)){
                return true;
            }
            else{
                throw new IllegalArgumentException("Tour is not a legal solution.");
            }
        }
        else if(assignment == null){
            throw new IllegalArgumentException("Solution timeout.");
        }
        else{
            return false;
        }
    }


    public static void main(String[] args) {

        boolean[][] flights1 = {{false, false, false,true},
                                {false, false, true,true },
                                {false, true, false,true },
                                {true,true,true,false}};

        boolean[][] flights = {{false, true, true },
                                 {true, false, true },
                                 {true, true, false }};
        boolean[][] flights2 = {{}};
        boolean[] assignment = {true, true, false, false, false,
                false,false, false, true, false};
        System.out.println(Arrays.toString(solve(flights1)));
        System.out.println((solve2(flights1)));
        int[] cnf = decode(assignment, 3);
//        System.out.println(Arrays.toString(cnf));
//        System.out.println((map(0,-1,3)));







    }
}
