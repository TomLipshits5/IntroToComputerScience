import java.sql.ResultSet;

public class Rectangle implements Shape {
    //Fields:
    private double hight;
    private double width;

    //Constructors
    public Rectangle(double hight, double width){
        this.hight = hight;
        this.width = width;
    }


    @Override
    public String name() {
        return "Rectangle";
    }

    @Override
    public double perimetre() {
        return 2*(hight+width);
    }

    @Override
    public double area() {
        return hight*width;
    }


    public double hight(){
        return hight;
    }

    public double width(){
        return width;
    }

    public String toString(){
        return "Rectangle, " + "hight: "+ hight + " " + "width:" + width;
    }

    public boolean equals(Object r){
        if(r instanceof Rectangle){
            return this.hight == ((Rectangle) r).hight&& this.width == ((Rectangle)r).width;
        }
        return false;
    }
}
