public class BitListTest12Test {

    public static void main(String[] args) {
        try{
            int lastTest = 0;
            
            BitList bl19 = new BitList();
            bl19.addLast(new Bit(0));
            BitList bl20 = new BitList(bl19);
            bl19.shiftLeft();
            bl20.shiftRight();
            BitList bl21 = new BitList();
            bl21.addLast(new Bit(1));
            bl21.addLast(new Bit(1));
            BitList bl22 = new BitList(bl21);
            bl21.shiftLeft();
            bl22.shiftRight();	
            BitList bl23 = new BitList();
            bl23.addLast(new Bit(1));
            bl23.addLast(new Bit(1));
            for(int i = 0; i < 28; i++){
                    bl23.addFirst(new Bit(0));
            }
            BitList bl24 = new BitList(bl23);
            bl23.shiftLeft();
            bl24.shiftRight();
            if(bl19.toString().equals("<00>")){
                    if(bl21.toString().equals("<110>")){
                            if(bl23.toString().equals("<1100000000000000000000000000000>")){
                                    lastTest = 1;
                            } else {
                                    lastTest = 2;
                            }
                    } else {
                            lastTest = 3;
                    }
            } else {
                    lastTest = 4;
            }
            
            switch(lastTest){
                case 1:
                    System.out.println("shiftLeft check works");
                    break;
                case 2:
                    System.out.println("checking shiftLeft on <110000000000000000000000000000> using equals: expected - true, got - false");
                    break;
                case 3:
                    System.out.println("checking shiftLeft on <11> using equals: expected - true, got - false");
                    break;
                case 4:
                    System.out.println("checking shiftLeft on <0> using equals: expected - true, got - false");
                    break;
            }
        }

        catch (Exception e) {
        	System.out.println("  runtime error in Bit.fullAdderSum(zero, zero, zero).equals(zero).");
        } catch (StackOverflowError e) {
        	System.out.println("StackOverflowError");
        }
    }
}
