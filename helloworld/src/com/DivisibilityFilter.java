package com;

import Interfaces.Filter;

public class DivisibilityFilter implements Filter {
    private Integer d;

    public DivisibilityFilter(Integer d){
        this.d =d;
    }

    @Override
    public boolean accept(Object object) {
        if (!(object instanceof Integer)){
            return false;
        }
        return (Integer)object%d == 0;
    }
}
