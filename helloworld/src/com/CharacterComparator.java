package com;
import Interfaces.Comparator;



public class CharacterComparator implements Comparator<Character>{
    @Override
    public int compare(Character e1, Character e2) {
        double diff = e1-e2;
        if (diff>0){return 1; }
        if (diff<0){return -1;}
        else return 0;
    }
}
