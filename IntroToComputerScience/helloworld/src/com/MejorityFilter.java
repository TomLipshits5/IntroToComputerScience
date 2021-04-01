package com;

import Interfaces.Filter;

public class MejorityFilter implements Filter {
    private Filter filter1;
    private Filter filter2;
    private Filter filter3;

    public MejorityFilter(Filter filter1,Filter filter2, Filter filter3){
        this.filter1 =filter1;
        this.filter2 = filter2;
        this.filter3 = filter3;
    }


    public boolean accept(Object object){
        boolean f1 = filter1.accept(object);
        boolean f2 = filter2.accept(object);
        boolean f3 = filter3.accept(object);
        return (f1&&f2) || (f1&&f3) ||(f2&&f3);
    }
}
