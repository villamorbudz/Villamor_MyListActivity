package MyCat;

import ListExceptions.ArrayFullException;
import ListExceptions.InvalidPositionException;

public class MyCatList {

    Cat[] array;
    static int capacity = 5;
    int size;

    public MyCatList() {
        this.array = new Cat[5];
        this.size = 0;
    }

    public void add(Cat num) throws ArrayFullException {
        try {
            array[size++] = num;
        } catch (Exception e) {
            size--;
            throw new ArrayFullException("The array is full and " + num + " cannot be inserted.");
        }
    }
    public void addAt(int pos, Cat num) throws ArrayFullException, InvalidPositionException {
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
    public boolean remove(String num) {
        for(int i = 0; i < size; i++) {
            if(num.equals(array[i].name)) {
                for(int j = i + 1; j < size; j++) {
                    array[j] = array[j + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }
    public Cat removeAt(int pos) throws InvalidPositionException {
        if(pos < 1 || pos > size) {
            throw new InvalidPositionException("Position must be between 1 and " + size);
        }

        Cat removed = array[pos - 1];

        for(int i = pos - 1; i < size; i++) {
            for(int j = i; j < size; j++) {
                array[j] = array[j + 1];
            }
            size--;
        }

        return removed;
    }
    public boolean contains(String num) {
        for(Cat i : array) {
            if(num.equals(i.name)) {
                return true;
            }
        }
        return false;
    }
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    public Cat get(int pos) throws InvalidPositionException {
        if(pos < 1 || pos > size) {
            throw new InvalidPositionException("Position must be between 1 and " + size);
        }
        return array[pos - 1];
    }
    public Cat set(int pos, Cat num) throws InvalidPositionException {
        if(pos < 1 || pos > size) {
            throw new InvalidPositionException("Position must be between 1 and " + size);
        }
        Cat replaced = array[pos - 1];
        array[pos - 1] = num;
        return replaced;
    }
}
