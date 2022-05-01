package com.company.Class;

import com.company.Exception.MyArrayListException;
import com.company.Interface.MyList;

import java.lang.reflect.Array;

public class MyArrayList<T> implements MyList<T> {

    private int oldSize = 10;
    private int newSize = 0;

    private T[] myArray;
    private Class<T> myClazz;


    public MyArrayList(Class<T> clazz) {        //  конструктор, в который передается тип класса

        this.myClazz = clazz;
        myArray = (T[]) Array.newInstance(myClazz, oldSize);
    }

    public MyArrayList(Class<T> clazz, int size) {    //  конструктор, в который передается тип класса + размер массива

        this.myClazz = clazz;
        this.oldSize = size;
        myArray = (T[]) Array.newInstance(myClazz, oldSize);
    }


    @Override
    public void add(T type) {           // добавление элемента

        if (myArray[myArray.length - 1] != null) {  // если последний элемент не пустой
            myArray = this.increaseArray();         // расширяем массив
        }
        for (int i = 0; i < myArray.length; i++) {  // заполняем массив
            if (myArray[i] == null) {
                myArray[i] = type;
                break;
            } else {
                continue;
            }
        }
    }

    @Override
    public void delete(T type) {
        T[] newArray = (T[]) Array.newInstance(myClazz, myArray.length);
        int i = 0;
        int j = 0;
        while (myArray[j] != null) {          // цикл работает пока не дойдем до пустого элемента массива
            if (myArray[j].equals(type)) {  // если передаваемый элемент есть в массиве
                newArray[i] = myArray[++j]; // сохраняем следующий элемент массива в новый массив
            } else {
                newArray[i] = myArray[j];   // если переданного элемента нету в массиве, сохраняя текущий элемент
            }                               // в новый массив
            i++;
            j++;
        }
        for (i = 0; i < myArray.length; i++) {   // обнуляем масси
            myArray[i] = null;
        }
        for (i = 0; i < newArray.length; i++) {   // сохраняем элементы из нового массива
            myArray[i] = newArray[i];
        }
        for (i = 0; i < newArray.length; i++) {   // обнуляем новый массив
            newArray[i] = null;
        }
    }

    @Override
    public T getElement(int index) throws MyArrayListException {        // вернуть элемент по индексу
        if (index >= oldSize) {
            throw new MyArrayListException("Полученный индекс превышает размер массива");
        }
        return myArray[index];
    }

    @Override
    public boolean isExist(T type) {            // есть ли элемент в массиве
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i].equals(type)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {           // очищаем массив
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = null;
        }
    }

    @Override
    public void printArray() {      // вывод массива
        for (T my : myArray) {
            System.out.print(my + " ");
        }
        System.out.println();
    }

    private T[] increaseArray() {           // метод по расширению массива
        newSize = ((oldSize * 3) / 2 + 1);
        T[] newArray = (T[]) Array.newInstance(myClazz, (newSize));
        for (int i = 0; i < myArray.length; i++) {
            newArray[i] = myArray[i];
        }
        oldSize = newSize;
        newSize = 0;

        return newArray;
    }
}
