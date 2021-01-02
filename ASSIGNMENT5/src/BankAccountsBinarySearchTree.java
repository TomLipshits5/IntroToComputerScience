/*---------------------------------------
Genuine author: Tom Lipshits, I.D.: 316005370
 Date: 29-12-2020
---------------------------------------*/
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;


public class BankAccountsBinarySearchTree extends BinarySearchTree<BankAccount>{

	//Constructor:
	public BankAccountsBinarySearchTree(Comparator<BankAccount> myComparator) {
		super(myComparator);
	}



	//Methods:
	// Complete the following methods

	//Balance the calling tree while keeping its in order structure.
	public void balance(){
		// task 5b
		if (!isEmpty()){
			Iterator<BankAccount> it =iterator();
			List<BankAccount> list = new DynamicArray<>();		//Creating an in order list representation of the tree.
			while(it.hasNext()){
				list.add(it.next());
			}
			BankAccountsBinarySearchTree tr = new BankAccountsBinarySearchTree(getComparator());
			tr.buildBalancedTree(list,0,size()-1);		//Building a new balanced tree by the list.
			root=tr.root;				//Refactor the original root to the new balanced tree.
		}
	}

	//Builds a balanced tree based on an in order list representation.
	private void buildBalancedTree(List<BankAccount> list, int low, int high) {
		// task 5b
		int mid = (high + low) / 2 ;			//Finds middle value to insert first.
		insert(list.get(mid));
		if (low < high) {
			buildBalancedTree(list, low, mid - 1);		//Build left side.
			buildBalancedTree(list, mid + 1, high);	//Build right side.

		}
	}





}
