public class Main {
    public static void main(String[] args) {



        SetAsDynamicArray<Integer> set1 = new SetAsDynamicArray<Integer>();
        SetAsDynamicArray<Integer> set2 = new SetAsDynamicArray<Integer>();

        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set2.add(2);
        set2.add(3);
        set2.add(4);
        set2.add(5);
        System.out.println(SetOperations.subset(set1,set2));
        Set<Integer> inter = SetOperations.intersection(set1,set2);
        System.out.println(inter);
        Set<Integer> union = SetOperations.union(set1,set2);
        System.out.println(union);
        Set<Integer> sub = SetOperations.subtrction(set1,set2);
        System.out.println(sub);
        





    }
}
