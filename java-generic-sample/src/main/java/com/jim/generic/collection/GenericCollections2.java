package com.jim.generic.collection;

public class GenericCollections2 {

    /**
     * 冒泡算法
     * @param array
     * @param <T>
     * @return
     */
    public static <T extends Comparable> T[] sortArray(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
            }
        }

        return array;
    }
}
