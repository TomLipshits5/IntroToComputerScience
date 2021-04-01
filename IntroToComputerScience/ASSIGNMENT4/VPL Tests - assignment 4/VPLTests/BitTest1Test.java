public class BitTest1Test {

    public static void main(String[] args) {
        try{
            Bit one = Bit.ONE;
            Bit zero = Bit.ZERO;
            
            boolean testSucceeded = Bit.fullAdderSum(zero, zero, zero).equals(zero);
            
			if (!testSucceeded) {
				System.out.println("Bit.fullAdderSum(zero, zero, zero).equals(zero): expected - true, got - false");
			}
        }

        catch (Exception e) {
        	System.out.println("  runtime error in Bit.fullAdderSum(zero, zero, zero).equals(zero).");
        } catch (StackOverflowError e) {
        	System.out.println("StackOverflowError");
        }
    }
}
