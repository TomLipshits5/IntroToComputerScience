import java.util.Iterator;
import java.util.NoSuchElementException;


public class ThresholdBankAccountsIterator implements Iterator<BankAccount> {
    //Fields:
    private BinaryTreeInOrderIterator<BankAccount> iterator;
    private BankAccount current;
    private int balanceThreshold;

    //Constructors:
    public ThresholdBankAccountsIterator(BankAccountsBinarySearchTree bankAccountsTree, int balanceThreshold) {
        // task 5c
        iterator = (BinaryTreeInOrderIterator<BankAccount>) bankAccountsTree.iterator();
        this.balanceThreshold = balanceThreshold;
        if (iterator.hasNext()) {
            current = prepareNext();
        }


    }


    //Complete the following method
    //Returns true if there is an other number that fits the threshold.
    @Override
    public boolean hasNext() {
        // task 5c
        return current != null;

    }

    //Prepare next number and store it in current.
    private BankAccount prepareNext(){
        if (!iterator.hasNext()){               //Input check.
            return null;
        }

        BankAccount next = iterator.next();;
        boolean isFound = next.getBalance()>= balanceThreshold;
        while(iterator.hasNext() && !isFound){          //Iterate through next BankAccounts and find the next one that fits the threshold.
            if (next.getBalance()>= balanceThreshold){
                isFound =true;
            }else{
                next = iterator.next();
            }
        }
        if (!isFound){
            return null;
        }
        return next;
    }

    //Complete the following method
    @Override
    public BankAccount next() {
        // task 5c
        if (!hasNext()) {                   //Check for invalid next calls/
            throw new NoSuchElementException();
        }
        BankAccount next = current;
        current = prepareNext();            //Prepare next BankAccount.
        return next;
    }






}
