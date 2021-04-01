package com;

import java.util.NoSuchElementException;

public class StringScanner {
    public String words;


    public StringScanner(String words){
        this.words = trim(words);
    }

    private static String trim(String str){
        int indexFirst=0;
        int indexLast=str.length()-1;
        boolean foundFirst = false;
        boolean foundLast = false;
        for( int i =0 ;i<str.length()&&!foundFirst;i++){
            if (str.charAt(i)!=' '){
                indexFirst =i;
                foundFirst = true;
            }
        }
        for (int i = 1 ; i<str.length()&&!foundLast;i++){
            if (str.charAt(str.length()-i)!=' '){
                indexLast = str.length()-i;
                foundLast = true;
            }
        }
        return str.substring(indexFirst,indexLast+1);
    }

    public boolean hasNextWord(){
        return words.length()>0;
    }

    public Object nextWord(){
        if(!hasNextWord()){
            throw new NoSuchElementException();
        }
        int index = 0;
        for (int i =1 ;i<words.length() && index==0;i++){
            if (words.charAt(i)==' '){
                index = i;
            }
        }
        String next;
        if (index == 0){
            next = words;
            words = "";
        }else{
            next = words.substring(0,index);
            words = trim(words.substring(index));
        }

        return next;
    }
}
