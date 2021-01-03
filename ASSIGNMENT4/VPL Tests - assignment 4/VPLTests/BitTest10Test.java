public class BitTest10Test {

    public static void main(String[] args) {
        try{
            Bit one = Bit.ONE;
            Bit zero = Bit.ZERO;
            
            boolean testSucceeded = Bit.fullAdderCarry(one , one , zero).equals(one );
            
            assertTrue("Bit.fullAdderCarry(one , one , zero).equals(one ): expected - true, got - false",testSucceeded);
        }

        catch (Exception e) {
        	System.out.println("  runtime error in Bit.fullAdderSum(zero, zero, zero).equals(zero).");
        } catch (StackOverflowError e) {
        	System.out.println("StackOverflowError");
        }
    }
}
