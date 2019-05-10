package com.xiaomi.Iterator;

public class ArrayContainer<T> implements Container<T>{

    private T array[];

    public ArrayContainer(T []array) {
        // TODO Auto-generated constructor stub
        this.array=array;
    }
    @Override
    public Iterator<T> getIterator() {
        // TODO Auto-generated method stub
        return new ArrayIterator<T>();
    }

    private class ArrayIterator<T1 extends T> implements Iterator<T>{

        private int index=0;

        @Override
        public T next() {
            // TODO Auto-generated method stub
            if(index<array.length){
                return  array[index++];
            }
            return null;
        }

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            if(index<array.length){
                return true;
            }
            return false;
        }
        
    }
}
