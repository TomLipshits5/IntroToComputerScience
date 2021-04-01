package Test_2019_B;

import Interfaces.Filter;

public class DoesNotDivideFilter implements Filter<Integer> {
    private int divisor;

    public DoesNotDivideFilter(int divisor){
        this.divisor = divisor;
    }




    @Override
    public boolean accept(Integer object) {
        return object%divisor!=0;
    }
}
