
public class NumberAsBits {
    //Fields:
    private Bit[] bits;


    //Constructors:
    //Task 3.4
    public NumberAsBits(Bit[] bits) {
        //Check input.
        if (bits == null){
            throw new IllegalArgumentException("NmberAsBits can't be null");
        }if (bits.length == 0){
            this.bits = new Bit[1];
            this.bits[0] = new Bit(false);
        }else {
            this.bits = new Bit[bits.length];
            for (int i = 0; i < bits.length; i++) {
                if (bits[i] == null) {
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
    public String toString(){
        String ans =bits[0].toString();
        for (int i =1; i<bits.length; i++){
            ans = add(multiply(ans,2),bits[i].toString());

        }
        return ans;
    }

    private String add(String Num,String S){
        Character[] num = reverse(Num);
        Character[] s = reverse(S);
        String ans = "";
        int carry = 0;
        int tmp;
        for (int i = 0; i< num.length; i++) {
            if (i==num.length-1){
                if (i>s.length-1) {
                    tmp = num[i] + carry - 48;
                    ans = tmp + ans;
                }
                else{
                    tmp = num[i] + s[i] + carry - 96;
                    ans = tmp + ans;
                }
            }else if (i < s.length) {
                tmp = num[i] + s[i] + carry - 96;
                carry = tmp / 10;
                ans = tmp % 10 + ans;
            } else {
                tmp = num[i]+ carry - 48;
                carry = tmp / 10;
                ans = tmp%10 +ans;
            }
        }
        return ans;

    }

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

    private Character[] reverse(String s){
        Character[] ans  = new Character[s.length()];
        Character tmp;
        for (int i = 0; i<ans.length;i++){
            ans[i] = s.charAt(s.length()-1-i);
        }
        return ans;
    }
}


