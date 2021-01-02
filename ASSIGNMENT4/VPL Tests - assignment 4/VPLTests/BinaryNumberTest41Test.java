public class BinaryNumberTest41Test {

    private static BinaryNumber getZero() {
        return new BinaryNumber('0');
    }
    private static BinaryNumber getOne() {
        return new BinaryNumber('1');
    }

    
    private static BinaryNumber fib(int n) {
    	BinaryNumber ans;
    	if(n == 0) {
    		ans = getOne();
    	}
    	else {
    		ans = getOne();
    		BinaryNumber prev = getZero();
    		while(n >= 2) {
    			ans = ans.add(prev); // fib(n) = fib(n-1) + fib(n-2)
    			prev = ans.subtract(prev); // fib(n-1) = fib(n) - fib(n-2)
    			n = n - 1;
    		}
    	}
    	return ans;
    }

    public static void main(String[] args) {
        try{
            int lastTest = 2;
            
            BinaryNumber n0 = new BinaryNumber('0');
            BinaryNumber n1 = new BinaryNumber('1');
            BinaryNumber n2 = new BinaryNumber('2');
            BinaryNumber n3 = new BinaryNumber('3');
            BinaryNumber n4 = new BinaryNumber('4');
            BinaryNumber n5 = new BinaryNumber('5');
            BinaryNumber n6 = new BinaryNumber('6');
            BinaryNumber n7 = new BinaryNumber('7');
            BinaryNumber n8 = new BinaryNumber('8');
            BinaryNumber n9 = new BinaryNumber('9');
            
            try {
                    if(fib(11).toIntString().equals("89")){
                        lastTest = 1;
                    }
            } catch(Exception e){
                    lastTest = 2;
            }
            
            switch(lastTest){
                case 1:
                    System.out.println("fib(11).toIntString().equals(\"89\") works");
                    break;
                case 2:
                    System.out.println("fib(11).toIntString().equals(\"89\"): expected - true, got - false");
                    break;
            }
        }

		catch (Exception e) {
        	System.out.println("  runtime error in Bit.fullAdderSum(zero, zero, zero).equals(zero).");
        } catch (StackOverflowError e) {
        	System.out.println("StackOverflowError");
        } catch(ExceptionInInitializerError e) {
			System.out.println("Failed to initialize!");
		}
    }
}
