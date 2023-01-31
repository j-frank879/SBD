package com.example.controllers.iterator;

import java.util.Iterator;
import java.util.List;

public class ForwardIterator<T> implements Iterator<T> {
    private List<T> list;
    private int id;
    public ForwardIterator(List<T> list){
        this.list = list;
        id=0;
    }

    @Override
    public boolean hasNext() {
        if(id < list.size())
            return true;
        return false;
    }

    @Override
    public T next() {
        return list.get(id++);
    }
}
