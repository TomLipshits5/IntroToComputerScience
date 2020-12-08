
public class Bit {
    //Fields:
    private boolean value;

    //Constructors:
    //Task 3.1
    public Bit(boolean value){
        this.value = value;
    }
    public Bit(){
        this.value = true;
    }


    //Methods:
    //Return the value off Bit
    public boolean getValue(){
        return value;
    }
    //Task 3.2
    //Return int representation of Bit
    public int toInt(){ 
        int ans = 0;
        if (value)
            ans=1;
        return ans;

    }
    //Task 3.3
    //Return string representation of Bit
    public String toString(){
        String ans = "";
        return ans + this.toInt();
    }
}

