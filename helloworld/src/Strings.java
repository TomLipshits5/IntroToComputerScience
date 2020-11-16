

public class Strings {
    public static String cieserCode(String str, int k){
        String output = "";
        for(int i = 0; i<str.length(); i++ ){
            if (str.charAt(i) >= 'A' && str.charAt(i)<= 'Z') {
                int newChar = ((str.charAt(i) - 'A' + k) % 26) +'A' ;
                output = output + (char)newChar;
            }
            else{
                output = output + str.charAt(i);
            }
        }
        return output;
    }

    public static String decodeCode(String str, int k){
        String output = "";
        for(int i = 0; i<str.length(); i++ ){
            if (str.charAt(i) >= 'A' && str.charAt(i)<= 'Z') {
                int newChar = ((str.charAt(i) - 'A' - k) % 26) +'A' ;
                output = output + (char)newChar;
            }
            else{
                output = output + str.charAt(i);
            }
        }
        return output;
    }


    public static int longestCommonSubstring(String str1, String str2){
        int longestSubstring = 0;
        int i = 0;
        int counter = 0;
        while( i < str1.length()){
            for (int j = 0; j<str2.length() && i<str1.length(); j++){
                if (str1.charAt(i) == str2.charAt(j)){
                    counter ++;
                    i++;
                    if(longestSubstring < counter){
                        longestSubstring = counter;
                    }
                }
                else {
                    counter =0;
                }

            }
            i++;
        }
        return longestSubstring;
    }




    public static void main(String[] args){
        System.out.println(longestCommonSubstring("srewfabcdefghtyertertu","dfnartnmabcdefghdfghvbxtuuil;p"));

    }

}
