import java.util.Arrays;

public class Midterm2{
	public static void main(String[] args){
		System.out.println(toInt("0"));
		System.out.println(toInt("00"));
		System.out.println(toInt("0x0"));
		System.out.println(toInt("10"));
		System.out.println(toInt("012"));
		System.out.println(toInt("0xA"));
		System.out.println(toInt("65"));
		System.out.println(toInt("0101"));
		System.out.println(toInt("0x41"));
		

	}



	//question 1
	public static int factorialModulo(int n, int k){
		int modulo = 1;
		for(int i=2 ; i<=n; i++){
			modulo = ((modulo%k)*(i%k))%k; 
		}
		return modulo;

	}


	//quwstion 2 a

	public static boolean between(int[] array, int min, int max){
		for(int i = 0; i< array.length; i++){
			if(!(array[i]<min | array[i] > max))
				return false;
		}
		return true;
	}


	//quwstion 2 b

	public static int[] histogram(int[] array){
		int[] histogram = new int[array.length];
		for(int i = 0; i<array.length; i++){
			int counter = 0;
			for(int j = 0 ; j<array.length; j++){
				if(i==array[j])
					counter++;
			}
			histogram[i] = counter;
		}
		return histogram;

	}


	//quwstion 2 c

	public static boolean noDuplicates(int[] array){
		for(int i = 0; i<array.length; i++){
			for(int j = 0; j<array.length; j++){
				if((i!=j) & array[i] == array[j]){
					return false;
				}
			}
		}
		return true;
	}



	public static boolean isPermutation(int[] array){
		for(int i=0; i<array.length;i++){
			int counter = 0;
			for(int j = 0; j<array.length; j++){
				if (array[j]==i) {
					counter++;
					
				}
			}
			if(counter!=1){
				return false;
			}
			
		}
		return true;
	}


	//question 3 a

	public static int toInt(char c){
		return "0123456789ABCDEF".indexOf(c);
	}


	//question 3 b

	public static int findBase(String s){
		int base = 10;
		if(s.length()!=1&&s.charAt(0)=='0'){
			base = 8;
			if(s.charAt(1)=='x'){
				base = 16;
			}
		}
		return base;
	}

	//question 3 c

	public static  int toInt(String s, int base){
		int power = 1;
		int myInt = 0;
		for(int i = s.length()-1; i>=0; i--){
			int myChar = toInt(s.charAt(i));
			myInt = myInt + myChar*power;
			power = power*base;
		}
		return myInt;
	}

	public static int toInt(String s){
		int base = findBase(s);
		if(base == 8){
			s = s.substring(1);
		}
		else if (base == 16){
			s = s.substring(2);
		}
		return toInt(s,base);

	}









}