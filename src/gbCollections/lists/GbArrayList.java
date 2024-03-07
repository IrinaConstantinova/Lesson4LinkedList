package gbCollections.lists;

import gbCollections.GbList;
import gbCollections.lists.util.ArrayIterator;

import java.util.Iterator;

public class GbArrayList<T> implements GbList<T> {

    private T[] values;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public GbArrayList() {
        this.size = 0;
        this.capacity = 10;
        try {
            this.values = (T[]) new Object[capacity];
        } catch (ClassCastException e){
            System.out.println(e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    private void addCapacity(){
        capacity = capacity + capacity / 2;
        try{
            T[] array = (T[]) new Object[capacity];
            System.arraycopy(values, 0, array, 0, values.length );
            this.values = array;
        } catch (ClassCastException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void add(T value) {
        if (size == capacity){
            addCapacity();
        }
        values[size++] = value;
    }

    @Override
    public void add(int index, T value) {

    }

    @Override
    public T get(int index) {
        return values[index];
    }

    @Override
    public void remove(T value) {
        for (int i = 0; i < values.length; i++){
            if (values[i].equals(value)){
                removeByIndex(i);
                return;
            }
        }
        throw new RuntimeException("Element was not found.");
    }
    @Override
    @SuppressWarnings("unchecked")
    public void removeByIndex(int index) {
        try {
            T[] temp = values;
            values = (T[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            int amountElementsAfterIndex = temp.length - index - 1;
            System.arraycopy(temp, index + 1, values, index, amountElementsAfterIndex);
        } catch (ClassCastException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(values);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        int i = 0;
        while (values[i] != null) {
            builder.append(values[i]).append(", ");
            i++;
        }
        if (builder.length() == 1)
            return "[]";
        builder.deleteCharAt(builder.length() - 1).deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }
}
