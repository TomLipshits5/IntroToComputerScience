package com;

public class MultiSetPair {
    private Object element;
    private int cardinality;


    public MultiSetPair(Object element){
        this.element = element;
        cardinality = 1;
    }

    public Object getElement(){
        return element;
    }

    public int getCardinality(){
        return cardinality;
    }
    public void setCardinality(int cardinality){
        if (cardinality <1){
            throw new IllegalArgumentException();
        }
        this.cardinality = cardinality;
    }
    public String toString(){
        return "<" + element.toString() +" ," + cardinality + ">";
    }
}
