public class Record{
    //Fields
    private String key;
    private String value;

    //Constructor
    public Record(String key, String value){
        this.key = key;
        this.value = value;
    }


    //Methods
    public String toString(){
        return "["+key+", "+value+"]";
    }
    public String getKey(){
        return key;
    }
    public void setKey(String key){
        this.key = key;
    }
    public String getValue(){
        return value;
    }
    public void  setValue(String value){
        this.value = value;
    }
}



