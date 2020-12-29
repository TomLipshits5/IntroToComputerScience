/*---------------------------------------
 Genuine author: <name>, I.D.: <id number>
 Date: xx-xx-2020 
---------------------------------------*/
import java.util.Comparator;

public class AccountComparatorByName implements Comparator<BankAccount>{

	//Compare two Accounts by their names lexicographical value;
	@Override
	public int compare(BankAccount account1, BankAccount account2) {
		// task 2a
		String name1 = account1.getName();
		String name2 = account2.getName();
		return name1.compareTo(name2);
	}




}
