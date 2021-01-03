public class BitListTest6Test {

    public static void main(String[] args) {
        try{
            boolean testSucceeded;
            
            BitList bl1 = new BitList();
            bl1.addFirst(new Bit(true));
            bl1.addFirst(new Bit(true));
            bl1.removeFirst();
            bl1.addFirst(new Bit(false));
            bl1.addFirst(new Bit(true));
            bl1.addFirst(new Bit(true));
            bl1.addFirst(new Bit(false));
            bl1.removeFirst();
            bl1.addFirst(new Bit(false));
            bl1.addFirst(new Bit(false));
            bl1.addFirst(new Bit(true));
            bl1.addLast(new Bit(true));
            bl1.removeFirst();
            bl1.addFirst(new Bit(true));
            bl1.addFirst(new Bit(true));
            bl1.addLast(new Bit(false));
            bl1.removeLast();
            bl1.addFirst(new Bit(false));
            bl1.addFirst(new Bit(false));
            bl1.addFirst(new Bit(false));
            bl1.addLast(new Bit(false));
            bl1.addLast(new Bit(false));
            bl1.removeFirst();
            bl1.removeLast();
            bl1.removeLast();
            bl1.removeFirst();
            
            BitList bl3 = new BitList();
            bl3.addLast(new Bit(false));
            if(bl3.toString().equals("<0>") && new BitList(bl1).toString().equals("<1101100110>")){
                    testSucceeded = true;
            } else {
                    testSucceeded = false;
            }
            
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
