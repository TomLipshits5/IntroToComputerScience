/*---------------------------------------
 Genuine author: Tom Lipshits, I.D.: 316005370
 Date: 29-12-2020
---------------------------------------*/
import java.util.Comparator;

public class AccountComparatorByNumber implements Comparator<BankAccount>{

	//Compare two Accounts by their account number value;
	@Override
	public int compare(BankAccount account1, BankAccount account2) {
		if (account1 == null || account2 == null){						//Input check.
			throw new IllegalArgumentException("cant compare null");
		}
		// task 2b
		Integer num1 = account1.getAccountNumber();
		Integer num2 = account2.getAccountNumber();
		return num1.compareTo(num2);
	}

}
