/*---------------------------------------
 Genuine author: <name>, I.D.: <id number>
 Date: xx-xx-2020 
---------------------------------------*/
import java.util.Comparator;

public class AccountComparatorByNumber implements Comparator<BankAccount>{

	//Compare two Accounts by their account number value;
	@Override
	public int compare(BankAccount account1, BankAccount account2) {
		// task 2b
		Integer num1 = account1.getAccountNumber();
		Integer num2 = account2.getAccountNumber();
		return num1.compareTo(num2);
	}

}
