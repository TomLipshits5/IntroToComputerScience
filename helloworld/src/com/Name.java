package com;

import Interfaces.List;

public class Name {
    private String surname;
    private List givenNames;


    public Name(String input){
        if (input==null){
            throw new IllegalArgumentException();
        }
        givenNames = new DynamicArray();
        StringScanner myScanner = new StringScanner(input);
        while(myScanner.hasNextWord()){
            givenNames.add(myScanner.nextWord());
        }
        if (givenNames.size()<2){
            throw new IllegalArgumentException();
        }
        surname = (String)givenNames.get(givenNames.size()-1);
        givenNames.remove(surname);
    }

    public List getGivenNames(){
        return givenNames;
    }
    public String getSurname(){
        return surname;
    }




}
