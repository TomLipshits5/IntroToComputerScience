public class Midterm1{
	public static void main(String[] args){
		int[] array1 = {7, 8, 9, 10, 9, 8, 7};
		int[] array2 = {7, 8, 9, 10};
		int[] array3 = {10, 9, 8, 7};
		int[] array4 = {7};
		System.out.println(findPeakPoint(array1)); //3
		System.out.println(findPeakPoint(array2)); //3
		System.out.println(findPeakPoint(array3)); //0
		System.out.println(findPeakPoint(array4)); //0


	}

	public static int maxIndex(int[] array, int to){
		int maxIndex = 0;
		for (int i =1 ; i<=to; i++){
			if (array[i]>array[maxIndex]) {
				maxIndex =i ;
				
			}

		}
		return maxIndex;
	}


	public static void swap(int[] array, int i, int j) {
		 int tmp = array [i];
		 array [i] = array [j];
		 array [j] = tmp;
	}

	public static void sort(int[] array){
		int to = array.length -1;
		for(int i =0; i<array.length; i++){
			int maxIndex = maxIndex(array,to);
			swap(array,maxIndex,to);
			to--;
		}
		
	}

	//quastion 2 a

	public static boolean hasFlights(int[][] flights, int i, int j){
		for (int index =0;index<flights[i].length ;index++ ) {
			if (flights[i][index]==j) {
				return true;
				
			}

			
		}
		return false;
	}

	//quastion 2 b

	public static boolean stopOver(int[][] flights,int i, int j){
		if(i==j){
			return false;
		}
		for(int index1 = 0; index1<flights[i].length; index1++){
			for(int index2 = 0; index2<flights[j].length; index2++){
				if(flights[i][index1]==flights[j][index2]){
					return true;
				}
			}
		}

		return false;
	}


	//quastion 2 c

	public static boolean isHub(int[][] flights, int i){
		for(int index1 = 0 ; index1<flights.length; index1++){
			if ((i!=index1) && (!(hasFlights(flights,i,index1) || stopOver(flights,i,index1)))){
				return false;
				
			}

		}
		return true;
	}




	//question 3 a
	public static boolean increasing(int[] array, int k){
		if ((k == array.length-1) || (array[k]<array[k+1])){
			return true;
			
		}
		else return false;
	}



	//question 3 b
	public static boolean decreasing(int[] array, int k){
		if ((k == array.length-1) || (array[k]>array[k+1])) {

			return true;
		}

		else return false;
	}



	//question 3 c

	public static boolean peak(int[] array,int k){
		if (array.length<2) {
			return true;
			
		}
		if ((k == array.length-1 && increasing(array,k-1)) || (k==0 && decreasing(array,k)) || (decreasing(array,k) && increasing(array,k-1))){
			return true;
			
		}
		
		else return false;
		
	}


	//question 3 d
	public static int findPeakPoint(int[] array){
		int start = 0;
		int end = array.length - 1;
		int value = 0;
		boolean isPeak = false;
		while(!isPeak && end>=start){
			int mid = (start + end)/2;
			// System.out.println(mid);
			if (peak(array,mid)) {
				value = mid;
				isPeak = true;
				
			}
			else if(increasing(array,mid)){
				start = mid+1;
			}
			else{
				end = mid-1;
			}
		}
		return value;

	}

	


	
}

