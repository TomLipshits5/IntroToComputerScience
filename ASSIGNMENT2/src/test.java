public class test {
    public static void main(String[] args) {
//        int nVars = 19;
//        SATSolver.init(nVars);
////        int[] clause = {1};
////        SATSolver.addClause(clause);
//        int[][] clauses = {{2,6,8,9,16,17,-10,-13,-14},
//                {3,7,13,14,-3,-16,-17},
//                {-4,-9},
//                {8,15,-1,-16},
//                {7,12,16,18,-2},
//                {-9,-16,-17},
//                {-10,-18,-19},
//                {16},
//                {-15,-19},
//                {4,9,-1,-2,-7,14,15,18},
//                {15,-13},
//                {1},
//                {6,10,14,-1,-3,-7,-19},{2,6,11,15,18,-6,-9,-18},
//                {17,18,-9,-15,-18},
//                {17},
//                {4,6,7,-6,-9,-10,-15},
//                {16,19,-7,-17},
//                {9},
//                {4,7,15,18,19,-12,-14,-18},
//                {11},
//                {2,6,8,14,18,-12,-13,-16}};
//        SATSolver.addClauses(clauses);
//        boolean[] assignment = SATSolver.getSolution();
//        if(assignment ==null)
//            System.out.println("TIMEOUT");
//        else if(assignment.length ==nVars+1)
//            System.out.println("SAT");
//        else
//            System.out.println("UNSAT");
        int[] array ={};
        System.out.println(find(array));
    }
    public static int primeFactorsMult(int n){
        int output = 0;
        int divisor = 2;
        int counter = 0;
        while (divisor<=n){
            while(n%divisor==0) {
                n=n/divisor;
                counter++;
            }
            if (counter>output){
                output = counter
            }

            divisor=divisor+1;
        }
        return output;
    }


}
