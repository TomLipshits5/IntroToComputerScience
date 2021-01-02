package com;
import Interfaces.*;
public class DoesNotDivideFilter implements Filter<Integer> {

    //Fields:
    private int divider;


    //constructors:
    public DoesNotDivideFilter(int divider){
        this.divider = divider;
    }




    //Methods




    @Override
    public boolean accept(Integer object) {
        if(!(object%divider==0)){
            return true;
        }
        return false;
    }
}
