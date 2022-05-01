package com.company.Interface;

import com.company.Exception.MyArrayListException;

public interface MyList<T> {

    void add(T str);
    void delete(T type);
    T getElement(int index) throws MyArrayListException;
    boolean isExist(T type);
    void clear();
    void printArray();
}
