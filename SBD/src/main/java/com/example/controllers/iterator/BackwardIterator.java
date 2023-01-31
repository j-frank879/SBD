package com.example.controllers.iterator;

import java.util.Iterator;
import java.util.List;

public class BackwardIterator<T> implements Iterator<T> {
    private List<T> list;
    private int id;
    public BackwardIterator(List<T> list){
        this.list = list;
        id=list.size()-1;
    }

    @Override
    public boolean hasNext() {
        if(id >=0)
            return true;
        return false;
    }

    @Override
    public T next() {
        return list.get(id--);
    }
}
