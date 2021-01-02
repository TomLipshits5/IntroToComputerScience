
public class NumberAsBits {
    //Fields:
    private Bit[] bits;


    //Constructors:
    //Task 3.4
    public NumberAsBits(Bit[] bits) {
        //Check input.
        if (bits == null){
            throw new IllegalArgumentException("NmberAsBits can't be null");

        // In case array is empty.
        }if (bits.length == 0){
            this.bits = new Bit[1];
            this.bits[0] = new Bit(false);

        }else {
            this.bits = new Bit[bits.length];
            for (int i = 0; i < bits.length; i++) {
                if (bits[i] == null) {    //Check there is no null element in the array.
                    throw new IllegalArgumentException("A bit in NumberAsBits can't be null");
                } else {
                    this.bits[i] = new Bit(bits[i].getValue());
                }
            }
        }

    }

    //Methods:
    //Task 3.5
    public String base2() {
        String ans ="";
        for (Bit bit : bits) {
            ans = ans + bit.toString();

        }

        return ans;
    }
    //Task 3.6
    // return a decimal representation of the binary number as a string.
    //  using Hint 3.5 ans two internal class function to summarise the Decimal value of the Bits array.
    public String toString(){
        String ans =bits[0].toString();
        for (int i =1; i<bits.length; i++){
            ans = add(multiply(ans,2),bits[i].toString());

        }
        return ans;
    }


    //Summarise two numbers that are represented as strings, Num must be longer or equal to S, for in class use only.
    private String add(String Num,String S){
        // Reverse the strings to make it easier to iterate throw them.
        Character[] num = reverse(Num);
        Character[] s = reverse(S);
        String ans = "";
        int carry = 0;   // Contain the carry value of each sum action.
        int tmp;        //Temporary integer value that holds the sum of two index matching numbers is num and s.
        for (int i = 0; i< num.length; i++) {
            if (i==num.length-1){               //adding the remainder to the end of the string with no carry saved.
                if (i>s.length-1) {
                    tmp = num[i] + carry - 48;
                }
                else{                       //in case num and s are the same length.
                    tmp = num[i] + s[i] + carry - 96;
                }
                ans = tmp + ans;
            }else if (i < s.length) {         //Adding indexed numbers from s to num.
                tmp = num[i] + s[i] + carry - 96;
                carry = tmp / 10;
                ans = tmp % 10 + ans;
            } else {                        //Adding the carry value for the rest of num.
                tmp = num[i]+ carry - 48;
                carry = tmp / 10;
                ans = tmp%10 + ans;
            }
        }
        return ans;
    }
    //Multiply a number represented as a string by an integer,num2 is limited by Integer.MAX.VALUE, return String.
        //Repeat the add function for num2 times.
    private String multiply(String num, int num2){
        String ans= "0";
        while(num2>0){
            if (ans.length()<num.length()) {
                ans = add(num, ans);
            }else{
                ans = add(ans,num);
            }
            num2--;
        }
        return ans;
    }

    //Reverse the order of the characters in a string and assign them in an array
    private Character[] reverse(String s){
        Character[] ans  = new Character[s.length()];
        for (int i = 0; i<ans.length;i++){
            ans[i] = s.charAt(s.length()-1-i);
        }
        return ans;
    }
}


