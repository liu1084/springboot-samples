package com.jim.generic.container;

/**
 * 范型接口
 * @param <T>
 */
public interface SimpleStack<T> {
    boolean empty();
    void push(T obj);
    T pop();
    T peek();
    boolean hasNext();
    boolean hasRoom();
    int getStackDepth();
}
