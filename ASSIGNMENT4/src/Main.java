import java.util.LinkedList;

public class Main {
    public static void main(String[] args){
        Bit bit1 = new Bit(1);
        Bit bit2 = new Bit(0);
        Bit bit3 = new Bit(0);
        BitList list = new BitList();
        list.addFirst(bit1);
        list.addLast(bit2);
        list.addLast(bit3);
        System.out.println(list);
        BitList list2 = new BitList(list);
        list2.addLast(Bit.ONE);
        System.out.println(list2);





    }
}
