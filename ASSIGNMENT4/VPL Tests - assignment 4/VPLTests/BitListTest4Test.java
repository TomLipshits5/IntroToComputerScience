public class BitListTest4Test {

    public static void main(String[] args) {
        try{
            boolean testSucceeded;
            
            testSucceeded = new BitList(new BitList()).equals(new BitList());
            
            if(!testSucceeded) {
            	System.out.println("new BitList(new BitList()).equals(new BitList()): expected - true, got - false");
            }
        }

        catch (Exception e) {
        	System.out.println("  runtime error in Bit.fullAdderSum(zero, zero, zero).equals(zero).");
        } catch (StackOverflowError e) {
        	System.out.println("StackOverflowError");
        }
    }
}
