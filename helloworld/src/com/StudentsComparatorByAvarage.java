package com;
import Interfaces.Comparator;
public class StudentsComparatorByAvarage implements Comparator {
    public int compare(Object x, Object y){
        if (!(x instanceof Student)||!(y instanceof Student)){
            throw new IllegalArgumentException();
        }
        int diff = ((Student) x).avarageGrade()-((Student)y).avarageGrade();
        if (diff>0){return 1;}
        if (diff<0){return -1;}
        else{return 0;}
    }
}
