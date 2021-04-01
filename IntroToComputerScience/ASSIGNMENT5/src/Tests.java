import java.util.Comparator;
import java.util.Iterator;

public class Tests {
    public static void main(String[] args) {
        ///5c tests
//        Comparator<BankAccount> c = new AccountComparatorByNumber();
//        BankAccountsBinarySearchTree t1 = new BankAccountsBinarySearchTree(c);
//        t1.insert(new BankAccount("a", 4, 200));
//        t1.insert(new BankAccount("b", 2, -90));
//        t1.insert(new BankAccount("c", 6, 59908));
//        t1.insert(new BankAccount("d", 1, 3567));
//        t1.insert(new BankAccount("f", 3, 234));
//        t1.insert(new BankAccount("g", 5, 94835698));
//        t1.insert(new BankAccount("h", 7, 565444));
//        t1.insert(new BankAccount("i", 8, 876));
//        Iterator<BankAccount> it = t1.iterator();
//        Iterator<BankAccount> Bit = new ThresholdBankAccountsIterator(t1,500);
//        System.out.println("============no threshold========"+"\n");
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
//        System.out.println("============with threshold========"+"\n");
//        while(Bit.hasNext()){
//            System.out.println(Bit.next());
//        }





        //test 6
        Bank bank = new Bank();

        bank.add(new BankAccount("a", 4, 200));
        bank.add(new BankAccount("b", 2, -90));
        bank.add(new BankAccount("c", 6, 500));
        bank.add(new BankAccount("d", 1, 3567));
        bank.add(new BankAccount("f", 3, 234));
        bank.add(new BankAccount("g", 5, 94835698));
        bank.add(new BankAccount("h", 7, 565444));
        bank.add(new BankAccount("i", 8, 800));
        System.out.println("======test add=====");
        System.out.println(bank.toStringName());
        System.out.println(bank.toStringAccountNumber());

        System.out.println("======test delite name=====");
        System.out.println("======should not have a , g=====");
        bank.delete("a");
        bank.delete("g");
        System.out.println(bank.toStringName());
        System.out.println("======test delite number=====");
        System.out.println("======should not have a , g , b, f =====");
        bank.delete("b");
        bank.delete("f");
        System.out.println(bank.toStringAccountNumber());

        System.out.println("======test deposite number=====");
        System.out.println("===========6 should have 700 =====");
        bank.depositMoney(200,6);
        System.out.println( bank.myMony(6));



        System.out.println("======test withdraw number=====");
        System.out.println("===========8 should have 600 =====");
        bank.withdrawMoney(200,8);
        System.out.println( bank.myMony(8));
    }
}
