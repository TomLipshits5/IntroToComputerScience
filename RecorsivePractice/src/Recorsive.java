public class Recorsive {
    public static void main(String[] args){
        String num = "010";
        System.out.println(toInt(num));
    }
    public static boolean isPalindrome(char[] a, int from, int to){
        boolean isPalindrome = false;
        if (from == to) {
            isPalindrome = true;
        }
        if (a[from] == a[to]) {
            isPalindrome = isPalindrome || isPalindrome(a, from + 1, to - 1);
        }
        return isPalindrome;
    }
    public static boolean isPalindrome(char[] a){
        if (a.length == 0)
            return true;
        else
            return isPalindrome(a,0,a.length-1);
    }

    public static String reverse(String s){
        String answer;
        if (s.length() <= 1){
            answer = s;
        }
        else{
            answer = reverse(s.substring(1)) + s.charAt(0) ;
        }
        return answer;
    }

    public static int countCharInString(String s, char c){
        int counter = 0;
        if (s.length() == 0)
             counter=0;

        else if (s.charAt(0)==c)
            counter =1 + countCharInString(s.substring(1),c);
        else
            counter = countCharInString(s.substring(1),c);

        return counter;
    }

    public static int binarySearch(int[] a, int key,int from, int to){
        int answer = -1;
        int mid = (from+to)/2;
        if (from > to){
            return answer;
        }
        else if (a[mid] == key)
            answer = mid;
        else if (a[mid] > key)
            answer = binarySearch(a,key,from,mid+1);
        else if(a[mid]<key)
            answer = binarySearch(a,key,mid-1,to);

        return answer;
    }

    public static int binarySearch(int[] a,int key){
        return binarySearch(a,key,0,a.length-1);

    }

    public static int toInt(char c){
        return "0123456789ABCDEF".indexOf(c);
    }

    public static int toInt(String s, int base){
        int answer = 0;
        int reps = s.length() -1;
        int power = 1;
        while(reps > 0){
            power = power*base;
            reps--;
        }

        if (s.length() <= 1){
            answer = toInt(s.charAt(0)) * power ;

        }
        else{
            answer = toInt(s.charAt(0))*power +toInt(s.substring(1),base);
        }
        return answer;
    }


    public static int toInt(String s){
        int num = 0;
        if (toInt(s.charAt(0)) != 0){
            num = toInt(s,10);
        }
        else if (toInt(s.charAt(0)) == 0){
            if (s.charAt(1) == 'x'){
                num = toInt(s.substring(2),16);
            }
            else
                num =toInt(s.substring(1),8);
        }
        return num;
    }



}

