package com.alevel.Module2.Task1;

import java.util.Arrays;

class ArrayList<E> {
    private E[] data;
    private int currentPosition;

    ArrayList() {
        this(10);
    }

    private ArrayList(int amount) {
        this.data = (E[]) new Object[amount];
        this.currentPosition = 0;
    }

    int add(E element) {
        if (currentPosition == size()) {
            this.data = Arrays.copyOf(this.data, size() + (size() / 2) + 1);
        }
        this.data[currentPosition] = element;
        currentPosition++;
        return currentPosition - 1;
    }

    int size() {
        return currentPosition;
    }

    void add(E element, int index) {
        rangeCheckForAdd(index);
        if (index > data.length) {
            resize(data.length * 2 + 1);
        }
        data[index] = element;
        currentPosition++;
    }

    private void resize(int newSize) {
        E[] old = data;
        data = (E[]) new Object[newSize];
        System.arraycopy(old, 0, data, 0, currentPosition);
    }


    E get(int index) {
        return data[index];
    }

    E remove(int index) {
        E removeElement = get(index);
        System.arraycopy(data, index + 1, data, index, currentPosition - 1 - index);
        currentPosition--;
        return removeElement;
    }

    public void printList() {
        for (E element : this.data) {
            if (element == null) {
                break;
            }
            System.out.println(element.toString());
        }

    }
    private void rangeCheckForAdd(int index) {
        if (index > currentPosition || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+currentPosition;
    }


}

