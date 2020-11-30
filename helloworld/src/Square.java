public class Square extends Rectangle implements Shape{
    //Constructor:
    public Square(double hight){
        super(hight,hight);
    }
    public String name(){
        return "Square";
    }

    public String toString(){
        return "Square, " +"Side: "+ this.hight();
    }

}
