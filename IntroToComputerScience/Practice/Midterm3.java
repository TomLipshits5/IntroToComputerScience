import java.util.Arrays;


public class Midterm3{
	public static void main(String[] args){
		boolean[] assignment1 = {false,true,true,true,true};
		boolean[] assignment2 = {false,true,false,true,false};
		boolean[] assignment3 = {false,false,true,false,true};
		boolean[] assignment4 = {false,false,false,false,false};
		int[][] cnf1 = {{1,3,4}, {2,4,-3},{-4,3,-2}};// true
		int[][] cnf2 = {{1,-3,4}, {2,-4,-3},{-4,-3,-2}};//true
		int[][] cnf3 = {{-1,3,4}, {2,-4,3},{4,3,2}};//false
		int[][] cnf4 = {{-1,-3,4}, {2,4,3},{-4,3,2}};//false

		System.out.println(satisfies(cnf4,assignment1));
		System.out.println(satisfies(cnf2,assignment2));
		System.out.println(satisfies(cnf3,assignment3));
		System.out.println(satisfies(cnf4,assignment4));
		System.out.println(satisfies(cnf1,assignment4));
		System.out.println(satisfies(cnf2,assignment4));

	}


	//question 1 a
	public static int primeFactorsMult(int n){
        int output = 1;
        int divisor = 2;
        while (divisor<=n){
            if (n%divisor==0) {
                output = output*divisor;
                while (n%divisor==0)
                    n=n/divisor;
            }
            divisor=divisor+1;
        }
        return output;
    }

    public static int[] charHistogram(String str) {
    	int[] histogram = new int[26];
    	
    	String abc = "abcdefghijklmnopqrstuvwxyz";

    	for(int i = 0; i<abc.length(); i++){
    		int counter = 0;
    		for (int j = 0;j<str.length() ;j++ ) {
    			char char1= str.charAt(j);
    			char char2 = abc.charAt(i);
    			if(char1 ==char2){
    				counter++;
    			}
    			
    		}
    		histogram[i] = counter;
    		    			
    		
    	}
    	return histogram;


    }


    public static boolean satisfies(int literal,boolean[] assignment){
    	boolean value;
    	if(literal<0){
    		value = !assignment[-literal];
    	}
    	else{
    		value = assignment[literal];
    	}
    	return value;
    }


    public static boolean satisfies(int[] clause, boolean[] assignment){
    	boolean value = false;
    	for(int i = 0; i<clause.length; i++){
    		value = value || satisfies(clause[i],assignment);
    	}
    	return value;

    }



    public static boolean satisfies(int[][] cnf, boolean[] assignment){
    	boolean value = true;
    	for (int i = 0;i<cnf.length && value ;i++ ) {
    		value = value && satisfies(cnf[i],assignment);

    		
    	}
    	return value;
    }







}