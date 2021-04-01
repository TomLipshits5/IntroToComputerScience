public class BitListTest8Test {

    public static void main(String[] args) {
        try{
            int lastTest = 0;
            
            BitList bl5 = new BitList();
            bl5.addLast(new Bit(false));
            bl5.addLast(new Bit(true));
            bl5.addLast(new Bit(true));
            BitList bl6 = new BitList(bl5);
            bl6.addLast(new Bit(true));	
            if(bl6.isNumber()){
                    bl6 = new BitList();
                    bl6.addFirst(new Bit(true));
                    BitList bl7 = new BitList(bl6);
                    bl7.addFirst(new Bit(false));
                    bl7.removeLast();
                    if(bl7.isNumber()){
                            lastTest = 1;
                    } else {
                            lastTest = 2;
                    }
            } else {
                    lastTest = 3;
            }
            
            switch(lastTest){
                case 1:
                    System.out.println("numberOfOnes incrementing works");
                    break;
                case 2:
                    System.out.println("checking numberOfOnes updates by copying BitList and using isNumber: expected - true, got - false");
                    break;
                case 3:
                    System.out.println("checking numberOfOnes updates by copying BitList and using isNumber: expected - true, got - false");
            }
        }

        catch (Exception e) {
        	System.out.println("  runtime error in Bit.fullAdderSum(zero, zero, zero).equals(zero).");
        } catch (StackOverflowError e) {
        	System.out.println("StackOverflowError");
        }
    }
}
