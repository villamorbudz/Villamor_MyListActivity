package MyList;

import ListExceptions.ArrayFullException;
import ListExceptions.InvalidPositionException;

public class MyList {

    int[] array;
    static int capacity = 5;
    int size;

    public MyList() {
        this.array = new int[5];
        this.size = 0;
    }

    public void add(int num) throws ArrayFullException {
        try {
            array[size++] = num;
        } catch (Exception e) {
            size--;
            throw new ArrayFullException("The array is full and " + num + " cannot be inserted.");
        }
    }
    public void addAt(int pos, int num) throws ArrayFullException, InvalidPositionException {
        if(size >= 5) {
            throw new ArrayFullException("The array is full and " + num + " cannot be inserted.");
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
    public boolean remove(int num) {
        for(int i = 0; i < size; i++) {
            if(array[i] == num) {
                array[i] = 0;
                for(int j = i + 1; j < size; j++) {
                    array[j] = array[j + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }
    public int removeAt(int pos) throws InvalidPositionException {
        if(pos < 1 || pos > size) {
            throw new InvalidPositionException("Position must be between 1 and " + size);
        }

        int removed = array[pos - 1];
        array[pos - 1] = 0;

        for(int i = pos - 1; i < size; i++) {
            for(int j = i; j < size; j++) {
                array[j] = array[j + 1];
            }
            size--;
        }

        return removed;
    }
    public boolean contains(int num) {
        for(int i : array) {
            if(i == num) {
                return true;
            }
        }
        return false;
    }
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    public int get(int pos) throws InvalidPositionException {
        if(pos < 1 || pos > size) {
            throw new InvalidPositionException("Position must be between 1 and " + size);
        }
        return array[pos - 1];
    }
    public int set(int pos, int num) throws InvalidPositionException {
        if(pos < 1 || pos > size) {
            throw new InvalidPositionException("Position must be between 1 and " + size);
        }
        int replaced = array[pos - 1];
        array[pos - 1] = num;
        return replaced;
    }
}
