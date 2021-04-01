public class BinaryNumberTest37Test {

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
                    if((new BinaryNumber("12")).toInt() == 12){
                        lastTest = 1;
                    }
            } catch(Exception e){
                    lastTest = 2;
            }
            
            switch(lastTest){
                case 1:
                    System.out.println("(new BinaryNumber(\"12\")).toInt() == 12 works");
                    break;
                case 2:
                    System.out.println("(new BinaryNumber(\"12\")).toInt() == 12: expected - true, got - false");
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
