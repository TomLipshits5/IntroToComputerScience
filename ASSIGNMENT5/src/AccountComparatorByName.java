/*---------------------------------------
Genuine author: Tom Lipshits, I.D.: 316005370
 Date: 29-12-2020
---------------------------------------*/
import java.util.Comparator;

public class AccountComparatorByName implements Comparator<BankAccount>{

	//Compare two Accounts by their names lexicographical value;
	@Override
	public int compare(BankAccount account1, BankAccount account2) {
		if (account1 == null || account2 == null){					//Input check.
			throw new IllegalArgumentException("cant compare null");
		}
		// task 2a
		String name1 = account1.getName();
		String name2 = account2.getName();
		return name1.compareTo(name2);
	}




}
