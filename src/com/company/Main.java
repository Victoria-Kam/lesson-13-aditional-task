package com.company;

import com.company.Class.MyArrayList;
import com.company.Exception.MyArrayListException;
import com.company.Interface.MyList;


public class Main {

    public static void main(String[] args) throws InterruptedException, MyArrayListException {

        MyList<Integer> str = new MyArrayList<>(Integer.class);

        Integer count = 0;

        while (count != 10) {
            str.add(count);
            count++;
        }
        System.out.println("Заполненный массив: ");
        str.printArray();
        System.out.println("Добавляем новый элемент в массив.");
        str.add(99);
        System.out.println("Вывод массива с новым элементом: ");
        str.printArray();
        System.out.println("существует элемент ли элемент 5 в массиве?: " + str.isExist(5));
        System.out.println("Что хранится с массиве под индексом 11?: " + str.getElement(11));
        System.out.println("Что хранится с массиве под индексом 10?: " + str.getElement(10));
        System.out.println("Удаляем элемент 6 из массива. ");
        str.delete(6);
        System.out.println("Вывод массива с удаленным элементом: ");
        str.printArray();
        System.out.println("Очищаем массив. ");
        str.printArray();
        str.clear();
        System.out.println("Вывод массива: ");
        str.printArray();

    }
}
