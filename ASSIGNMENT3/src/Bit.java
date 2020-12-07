
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
    public boolean getValue(){
        return value;
    }
    //Task 3.2
    public int toInt(){ 
        int ans = 0;
        if (value)
            ans=1;
        return ans;

    }
    //Task 3.3
    public String toString(){
        String ans = "";
        return ans + this.toInt();
    }
}

