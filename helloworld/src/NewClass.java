public class NewClass extends Person {
    String power;
    public NewClass(String name,int age,String job,String power) {
        super(name, age, job);
        this.power = power;
    }

    public void speakHero(){
        System.out.println("im a super person");
    }
    public static void talk(){
        System.out.println("im talking");
    }
}
