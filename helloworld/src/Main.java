
public class Main {
    public static void main(String[] args) {
        SetAsDynamicArray<Integer> set = new SetAsDynamicArray<Integer>();
        LinkedList<String> list = new LinkedList<>();
        set.add(1);
        set.add(3);
        set.add(1);
        set.add(5);
        list.add("tom");
        list.add("gefen");
        list.add("amit");
        list.add("omer");
        list.add("maor");
        list.add("dvir");

        Iterator<Integer> setIterator = set.iterator();
        while(setIterator.hasNext()) {
            System.out.println(setIterator.next());
        }
        int counter =0;
        Iterator<String> listIterator = list.iterator();
        while(listIterator.hasNext()){
            System.out.println(counter + " " + listIterator.next());
            counter++;
        }



    }
}
