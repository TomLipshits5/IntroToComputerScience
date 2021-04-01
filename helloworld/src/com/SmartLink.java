package com;
import Interfaces.Comparator;

public class SmartLink<T> extends Link<T> {
    private Comparator<T> comp;

    public SmartLink(Object x, SmartLink<T> next, Comparator<T> comp){
        super((T)x,next);
        this.comp = comp;
    }

    public SmartLink insert(Object x){
        T toInsert = (T)x;
        if (comp.compare(toInsert,this.data)<0){
            SmartLink<T> insertion = new SmartLink<T>(toInsert,this,comp);
            return insertion;
        }
        else if (comp.compare(toInsert,this.data)>0){
            if (this.next!=null &&(comp.compare(toInsert,this.next.data)<0)){
                SmartLink<T> insertion = new SmartLink<T>(toInsert, (SmartLink<T>) this.next, comp);
                this.next = insertion;
            }else if(this.next!=null &&(comp.compare(toInsert,this.next.data)>0)){
                ((SmartLink<T>)this.next).insert(toInsert);
            }else if(this.next == null){
                SmartLink<T> insertion = new SmartLink<T>(toInsert, null, comp);
                this.next = insertion;
            }
        }
         return this;

    }
}
