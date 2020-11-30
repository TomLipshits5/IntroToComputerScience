public class Circle implements Shape{
    //fields
    double radius;

    //connstuctors
    public Circle(double radius){
        this.radius = radius;
    }

    public Circle(){
        this.radius = 1;
    }



    //methods
    @Override
    public String name() {
        return "Circle";
    }

    @Override
    public double perimetre() {
        return 2*Math.PI*radius;
    }

    @Override
    public double area() {
        return Math.PI * radius*radius;
    }

    //Circle specifics
    public double getRadius(){
        return this.radius;
    }

    public String toString(){
        return "Circle, " +  "Radius: " + this.radius;
    }

    public boolean equals(Object c){
        if (c instanceof Circle){
            return ((Circle) c).getRadius() == this.radius;
        }
        return false;
    }
}
