public class ContactPerson extends Record {
    //Fields:
    private String relationship;



    //Constructors
    public  ContactPerson(String key, PhoneNumber value,String relationship) {
        super(key, value);
        this.relationship = relationship;
    }

    //Methods:
    public String getRelationship(){
        return relationship;
    }

    public String toSting(){
        return "["+this.getKey()+", "+this.getValue().toString()+", "+this.getRelationship()+"]";
    }

}
