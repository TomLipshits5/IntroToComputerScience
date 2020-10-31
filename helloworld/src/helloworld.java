class Person{
    String name;
    int age;
    String job;

    public Person(String name, int age, String job){
    this.name = name;
    this.age = age;
    this.job = job;
    }
    public void speak(){
        System.out.println("Hello I'm " + name + " and Im " + age + ", and my job is " + job);
    }


}

public class helloworld {

    static int plus(int x, int y) {
        return x+y;

    }
    public static void main(String[] args) {

        Person person1 = new Person("Tom", 25, "computer scientiest");
        NewClass superPerson = new NewClass("maor", 15, "student", "fly");
        superPerson.speakHero();
        NewClass.talk();



    }
}



