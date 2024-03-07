package gbCollections.lists;

import gbCollections.GbList;

import java.util.Iterator;

public class GbLinkedList<E> implements GbList<E> {

    private Node<E> head;
    private int size;

    public GbLinkedList() {
        this.size = 0;
    }

    public Node<E> getHead() {
        return head;
    }

    @Override
    public void add(E value) {
        if (head == null){
            this.head = new Node<>(value);
        } else {
            Node<E> temp = head;
            while(temp.getNextElem() != null){
                temp = temp.getNextElem();
            }
            temp.setNextElem(new Node<>(value));
        }
        size++;
    }

    @Override
    public void add(int index, E value) {

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        Node<E> temp = head;
        while (temp != null) {
            builder.append(temp.getValue()).append(", ");
            temp = temp.getNextElem();
        }
        if (builder.length() == 1)
            return "[]";
        builder.deleteCharAt(builder.length() - 1).deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public E get(int index) {
        int currentIndex = 0;
        Node<E> temp = head;
        while (temp != null){
            if (currentIndex == index){
                return temp.getValue();
            }else {
                temp = temp.getNextElem();
                currentIndex++;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void remove(E value) {

    }

    @Override
    public void removeByIndex(int index) {
        int currentIndex = 0;
        Node<E> temp = head;
        while (temp != null){
            if ((currentIndex + 1) == index){
                temp.setNextElem(temp.getNextElem().getNextElem());
                size--;
                return;
            } else {
                temp = temp.getNextElem();
                currentIndex++;
            }
        }

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator<>();
    }


    private class Node<E>{

        private E value;
        private Node<E> nextElement;

        public Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<E> getNextElem() {
            return nextElement;
        }

        public void setNextElem(Node<E> nextElement) {
            this.nextElement = nextElement;
        }
    }

    private class LinkedListIterator<E> implements Iterator<E>{

        private GbLinkedList<E>.Node<E> current;

        @SuppressWarnings("unchecked")
        public LinkedListIterator() {
            try {
                this.current = (GbLinkedList<E>.Node<E>) head;
            } catch (ClassCastException e){
                System.out.println(e.getMessage());
            }
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E value = current.getValue();
            current = current.getNextElem();
            return value;
        }
    }

}
