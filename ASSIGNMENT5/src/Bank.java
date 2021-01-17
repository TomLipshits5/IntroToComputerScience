/*---------------------------------------
 Genuine author: Tom Lipshits, I.D.: 316005370
 Date: 29-12-2020
---------------------------------------*/
/**
 * This class represents a bank management system,
 * it has two data data structures that store and organize accounts by name and by account number..
 *
 * @author Tom Lipshits.
 */
public class Bank {

	private BankAccountsBinarySearchTree namesTree;
	private BankAccountsBinarySearchTree accountNumbersTree;
	
	public Bank() {
		namesTree = new BankAccountsBinarySearchTree(new AccountComparatorByName());
		accountNumbersTree = new BankAccountsBinarySearchTree(new AccountComparatorByNumber());
	}

	public BankAccount lookUp(String name){
		// create an Entry with the given name, a "dummy" accountNumber (1) and zero balance
		// This "dummy" accountNumber will be ignored when executing getData
		BankAccount lookFor = new BankAccount(name, 1, 0);
		return (BankAccount)namesTree.findData(lookFor);
	}
	
	public BankAccount lookUp(int accountNumber){
		// create an Entry with a "dummy" name, zero balance and the given accountNumber
		// This "dummy" name will be ignored when executing getData
		BankAccount lookFor = new BankAccount("dummy", accountNumber,0);
		return (BankAccount)accountNumbersTree.findData(lookFor);
	}
	
	// END OF Given code -----------------------------------
	
	// Complete the methods from here on
	//Add new account to both trees.
	public boolean add(BankAccount newAccount) {
		// task 6a
		if(lookUp(newAccount.getName()) == null && lookUp(newAccount.getAccountNumber()) == null){	//Check if the account exists in the system.
			namesTree.insert(newAccount);
			accountNumbersTree.insert(newAccount);
			return true;
		}
		return false;
	}
	// task 6b
	public boolean delete(String name){
		// this first line is given in the assignment file
		BankAccount toRemove = lookUp(name);
		// complete this:
		if(toRemove!= null){			//Check if the account exists in the system.
			namesTree.remove(toRemove);
			accountNumbersTree.remove(toRemove);
			return true;
		}
		return false;
	}
	
	public boolean delete(int accountNumber){
		// this first line is given in the assignment file
		BankAccount toRemove = lookUp(accountNumber);
		// complete this:
		if(toRemove!=null){				//Check if the account exists in the system.
			namesTree.remove(toRemove);
			accountNumbersTree.remove(toRemove);
			return true;
		}
		return false;
	}

	public boolean depositMoney(int amount, int accountNumber){
		// task 6d
		boolean isValidTransaction = false;
		BankAccount toDeposit = lookUp(accountNumber);
		if (toDeposit != null) {		//Check if the account exists in the system.
			isValidTransaction = toDeposit.depositMoney(amount);

		}
		return isValidTransaction;			//Returns whether the transaction was committed.
	}

	public boolean withdrawMoney(int amount, int accountNumber){
		// task 6e
		BankAccount toWithdraw = lookUp(accountNumber);
		boolean isValidTransaction = false;
		if (toWithdraw != null) {			//Check if the account exists in the system.
			isValidTransaction = toWithdraw.withdrawMoney(amount);

		}
		return isValidTransaction;				//Returns whether the transaction was committed.
	}

}
