public class Record <V>{
    //Fields
    private String key;
    private V value;

    //Constructor
    public Record(String key, V value){
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
    public V getValue(){
        return value;
    }
    public void  setValue(V value){
        this.value = value;
    }
    public boolean equalTo(Record other){
        return this.value.equals(other.value) && this.key.equals(other.key);
    }


}



