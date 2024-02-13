package MyGenList;

import ListExceptions.ArrayFullException;
import ListExceptions.InvalidPositionException;

public class MyGenList<T> {

    T[] array;
    static int capacity = 5;
    int size;

    public MyGenList() {
        this.array = (T[]) new Object[5];
        this.size = 0;
    }

    public void add(T num) throws ArrayFullException {
        try {
            array[size++] = num;
        } catch (Exception e) {
            size--;
            throw new ArrayFullException("The array is full and " + num.toString() + " cannot be inserted.");
        }
    }
    public void addAt(int pos, T num) throws ArrayFullException, InvalidPositionException {
        if(size >= 5) {
            throw new ArrayFullException("The array is full and " + num.toString() + " cannot be inserted.");
        }

        if(pos > (size + 1) || pos < 0) {
            throw new InvalidPositionException("Position must be between 1 and " + (size + 1));
        }

        for(int i = (size - 1); i >= (pos - 1); i--) {
            array[i + 1] = array[i];
        }
        array[pos - 1] = num;
        size++;
    }
    public boolean remove(Object num) {
        for(int i = 0; i < size; i++) {
            if(array[i].equals(num)) {
                for(int j = i + 1; j < size; j++) {
                    array[j] = array[j + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }
    public T removeAt(int pos) throws InvalidPositionException {
        if(pos < 1 || pos > size) {
            throw new InvalidPositionException("Position must be between 1 and " + size);
        }

        T removed = array[pos - 1];

        for(int i = pos - 1; i < size; i++) {
            for(int j = i; j < size; j++) {
                array[j] = array[j + 1];
            }
            size--;
        }

        return removed;
    }
    public boolean contains(Object num) {
        for(T i : array) {
            if(i.equals(num)) {
                return true;
            }
        }
        return false;
    }
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    public T get(int pos) throws InvalidPositionException {
        if(pos < 1 || pos > size) {
            throw new InvalidPositionException("Position must be between 1 and " + size);
        }
        return array[pos - 1];
    }
    public T set(int pos, T num) throws InvalidPositionException {
        if(pos < 1 || pos > size) {
            throw new InvalidPositionException("Position must be between 1 and " + size);
        }
        T replaced = array[pos - 1];
        array[pos - 1] = num;
        return replaced;
    }
}
