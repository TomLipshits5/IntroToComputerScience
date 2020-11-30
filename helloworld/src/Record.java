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
    public boolean equals(Object other){
        boolean equals = false;
        if (other instanceof Record<?>){
            equals = key.equals(((Record<?>)other).key) && value.equals(((Record<?>)other).value);
        }


        return equals;
    }


}



