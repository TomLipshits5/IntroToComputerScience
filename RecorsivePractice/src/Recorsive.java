public class Recorsive {
    public static void main(String[] args) {
        int[] arr = {1,2,5};

        System.out.println(distanceMemo("amit","tom"));


    }

    public static int distanceMemo(String source, String target){
        int[][] memo = new int[source.length()+1][target.length()+1];
        for (int i =0; i<memo.length;i++){
            for (int j = 0; j<=target.length();j++){
                memo[i][j] =-1;
            }
        }
        return distanceMemo(source,target,memo);
    }

    public static int distanceMemo(String source,String target,int[][] memo){
        if (source.length()==0){
            return target.length();
        }
        if (target.length()== 0){
            return source.length();
        }
        if(memo[source.length()][target.length()] ==-1){
            if (source.charAt(0)== target.charAt(0)){
                memo[source.length()][target.length()] = distanceMemo(source.substring(1),target.substring(1),memo);
                return memo[source.length()][target.length()];
            }
            else{
                int d1 = distanceMemo(source.substring(1),target.substring(1));
                int d2 = distanceMemo(source.substring(1),target,memo);
                int d3 = distanceMemo(source,target.substring(1),memo);
                memo[source.length()][target.length()] =1+ Math.min(d1,Math.min(d2,d3));
                return memo[source.length()][target.length()];
            }
        }
        return memo[source.length()][target.length()];
    }



    public static int editDistance(String s1, String s2){
        if (s1.equals("")){
            return s2.length();
        }
        else if (s2.equals("")){
            return s1.length();
        }
        else{
            if (s1.charAt(0)==s2.charAt(0)){
                return editDistance(s1.substring(1),s2.substring(1));
            }else{
                int d1 = 1+ editDistance(s1.substring(1),s2.substring(1));
                int d2 = 1+ editDistance(s1.substring(1),s2);
                int d3 = 1+ editDistance(s1,s2.substring(1));
                return Math.min(d3,Math.min(d1,d2));
            }
        }
    }


    public static int change(int[] arr, int sum){

        return change(arr,sum,0);
    }

    public static int change(int[] arr, int sum, int index){

        if(sum ==0){
            return 1;
        }
        if (sum<0 || index>= arr.length){
            return 0;
        }
        else {
            return change(arr, sum - arr[index], index) +
                    change(arr, sum, index + 1);
        }
    }

    public static int changeMemo(int[] arr,int sum){
        int[][] memo = new int[sum+1][arr.length];
        for (int i =0;i<memo.length;i++){
            for (int j=0;j<arr.length;j++){
                memo[i][j] = -1;
            }
        }
        return changeMemo(arr,sum,0,memo);
    }

    public static int changeMemo(int[] arr, int sum,int i, int[][] memo){
        if (sum==0){
            return 1;
        }
        if (sum<0 || i>=arr.length){
            return 0;
        }
        if (memo[sum][i]==-1){
            memo[sum][i] = changeMemo(arr,sum-arr[i],i,memo) +
                            changeMemo(arr,sum,i+1,memo);
        }
        return memo[sum][i];
    }








    public static int frog(int n){
        return frog(n,n);
    }

    public static int frog(int n,int m){

        if (n==1 && m==1){
            return 1;
        }
        if (n<1 || m<1){
            return 0;
        }
        else {
            return frog(n-1,m)+frog(n,m-1)+frog(n-2,m)+frog(n,m-2);
        }

    }

    public static int frogMemo(int n){
        int[][] memo = new int[n+1][n+1];
        for (int i =0;i<memo.length;i++){
            for (int j=0;j<memo.length;j++){
                memo[i][j] = -1;
            }
        }
        return frogMemo(n,n,memo);
    }
    public static int frogMemo(int n,int m ,int[][] memo){
        if(n==1&& m==1){
            return 1;
        }
        if(n<1||m<1){
            return 0;
        }
        if(memo[n][m]==-1){
            memo[n][m]= frogMemo(n-1,m,memo)+
                        frogMemo(n-2,m,memo)+
                        frogMemo(n,m-1,memo)+
                        frogMemo(n,m-2,memo);
            memo[m][n] = memo[n][m];
        }
        return memo[n][m];
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
    public static int[] nPawens(int n, int d){
        int [] board = new int[n];
        if(nPawens(n,d,0,0,board)){
            return board;
        }
        else{
            return new int[]{};
        }
    }

    public static boolean nPawens(int n, int d, int row, int col, int[] pawens){
        boolean ans = false;

        if(row == n-1 && addPawen(pawens,d,row,col)){
            ans = true;
        }
        else if(col>=n || row>=n){
            ans = false;
        }
        else if(addPawen(pawens,d,row,col)){
            ans =nPawens(n,d,row+1,0,pawens) ;
        }
        else if(!addPawen(pawens,d,row,col )){
            ans =nPawens(n,d,row,col+1,pawens);
        }

        return ans;
    }

    public static boolean addPawen(int[] board, int d, int row, int col){
        for(int i =0 ; i<board.length; i++){
            if(i< row && distance(i,board[i],row,col)<=d){
                return false;
            }
        }
        board[row] = col;
        return true;
    }





    public static int distance(int row1, int col1, int row2, int col2){
        int horizentalD = Math.abs(col2-col1);
        int verticalD = Math.abs(row2-row1);
        return (horizentalD + verticalD);
    }
}

