public class Recorsive {
    public static void main(String[] args) {
        String num = "010";
        int[] weghit =   {3, 17, 26, 7, 9, 21, 6, 12, 13, 19, 8, 38};
        binarysubset(weghit,165,0);
    }

    public static boolean isPalindrome(char[] a, int from, int to) {
        boolean isPalindrome = false;
        if (from == to) {
            isPalindrome = true;
        }
        if (a[from] == a[to]) {
            isPalindrome = isPalindrome || isPalindrome(a, from + 1, to - 1);
        }
        return isPalindrome;
    }

    public static boolean isPalindrome(char[] a) {
        if (a.length == 0)
            return true;
        else
            return isPalindrome(a, 0, a.length - 1);
    }

    public static String reverse(String s) {
        String answer;
        if (s.length() <= 1) {
            answer = s;
        } else {
            answer = reverse(s.substring(1)) + s.charAt(0);
        }
        return answer;
    }

    public static int countCharInString(String s, char c) {
        int counter = 0;
        if (s.length() == 0)
            counter = 0;

        else if (s.charAt(0) == c)
            counter = 1 + countCharInString(s.substring(1), c);
        else
            counter = countCharInString(s.substring(1), c);

        return counter;
    }

    public static int binarySearch(int[] a, int key, int from, int to) {
        int answer = -1;
        int mid = (from + to) / 2;
        if (from > to) {
            return answer;
        } else if (a[mid] == key)
            answer = mid;
        else if (a[mid] > key)
            answer = binarySearch(a, key, from, mid + 1);
        else if (a[mid] < key)
            answer = binarySearch(a, key, mid - 1, to);

        return answer;
    }

    public static int binarySearch(int[] a, int key) {
        return binarySearch(a, key, 0, a.length - 1);

    }

    public static int toInt(char c) {
        return "0123456789ABCDEF".indexOf(c);
    }

    public static int toInt(String s, int base) {
        int answer = 0;
        int reps = s.length() - 1;
        int power = 1;
        while (reps > 0) {
            power = power * base;
            reps--;
        }

        if (s.length() <= 1) {
            answer = toInt(s.charAt(0)) * power;

        } else {
            answer = toInt(s.charAt(0)) * power + toInt(s.substring(1), base);
        }
        return answer;
    }


    public static int toInt(String s) {
        int num = 0;
        if (toInt(s.charAt(0)) != 0) {
            num = toInt(s, 10);
        } else if (toInt(s.charAt(0)) == 0) {
            if (s.charAt(1) == 'x') {
                num = toInt(s.substring(2), 16);
            } else
                num = toInt(s.substring(1), 8);
        }
        return num;
    }


<<<<<<< HEAD
    public static boolean subSetSum(int [] wegihts, int sum, int i){
        boolean ans = false;
        if(sum == 0){
            ans = true;
        }
        else if (sum < 0 | i>=wegihts.length){
            ans = false;
        }
        else{
            ans = subSetSum(wegihts,sum-wegihts[i],i+1) || subSetSum(wegihts,sum,i+1);
        }
        return ans;
    }


    public static void binarysubset(int[] weights,int sum,int i){
        int[] newArray = new int[weights.length];
        for (int j = 0; j< weights.length; j++){
            int tmp = weights[j];
            weights[j] = 0;
            if (!subSetSum(weights,sum,i)){
                weights[j] = tmp;
            }
        }
        for (int item : weights ){
            if (item != 0 ){
                System.out.print(1);
            }
            else
                System.out.print(item);
        }

    }
    //{3,  7, 9, 1 };
=======
>>>>>>> 45e2abcb5246ef19cefff5d6898c6d877a86426b
}

