public class PhoneNumber {
    //Fields:
    private String phoneNumber;


    //Constructors:
    public PhoneNumber(String phoneNumber){
        if (!checkPhoneNumber(phoneNumber)){
            throw new IllegalArgumentException("Illegal Phone Number");
        }
        this.phoneNumber = phoneNumber;
    }

    //Methods:

    private boolean checkPhoneNumber(String phoneNumber) {
        if ( 10 < phoneNumber.length() || 9>phoneNumber.length()){
            return false;
        }
        for (int i = 0 ; i< phoneNumber.length() ; i++){
            char c = phoneNumber.charAt(i);
            if(0 > Character.getNumericValue(c) || Character.getNumericValue(c) > 9 ){
                return false;
            }
        }
        return true;
    }

    public String get(){
        return phoneNumber;
    }

    public String toString(){
        return phoneNumber;
    }



}
