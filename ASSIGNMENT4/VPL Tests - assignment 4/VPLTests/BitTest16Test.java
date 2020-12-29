public class BitTest16Test {

    public static void main(String[] args) {
        try{
            Bit one = Bit.ONE;
            Bit zero = Bit.ZERO;
            
            boolean testSucceeded = Bit.fullAdderCarry(zero, zero, one ).equals(zero);
            
            assertTrue("Bit.fullAdderCarry(zero, zero, one ).equals(zero): expected - true, got - false",testSucceeded);
        }

        catch (Exception e) {
        	System.out.println("  runtime error in Bit.fullAdderSum(zero, zero, zero).equals(zero).");
        } catch (StackOverflowError e) {
        	System.out.println("StackOverflowError");
        }
    }
}
