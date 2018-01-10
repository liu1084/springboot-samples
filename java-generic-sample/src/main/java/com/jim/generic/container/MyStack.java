package com.jim.generic.container;

/**
 * 使用泛型类
 * 好处：不需要强转类型
 * @param <T>
 */
public class MyStack<T> implements SimpleStack<T> {

    //元素类型T（泛型），定义一个数组来存放容器元素
    T [] stack;

    //定义数组的大小为10
    public static final int DEFAULT_INITIAL = 10;

    //定义数组的初始大小为0
    private int depth = 0;

    public MyStack(){
        this(DEFAULT_INITIAL);
    }

    public MyStack(int depth){
        if (depth < 0){
            throw new IllegalArgumentException(depth + "must be positive, but was " + depth);
        }

        stack = (T[]) new Object[depth];
    }


    @Override
    public boolean empty() {
        return depth == 0;
    }

    @Override
    public void push(T obj) {
        stack[depth++] = obj;
    }

    @Override
    public T pop() {
        --depth;
        T temp = stack[depth];
        stack[depth] = null;
        return temp;
    }

    @Override
    public T peek() {
        if (depth == 0){
            return null;
        }

        return stack[depth - 1];
    }

    @Override
    public boolean hasNext() {
        return depth > 0;
    }

    @Override
    public boolean hasRoom() {
        return depth < stack.length;
    }

    @Override
    public int getStackDepth() {
        return depth;
    }
}
