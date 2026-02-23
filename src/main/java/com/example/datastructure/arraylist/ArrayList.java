package com.example.datastructure.arraylist;

public class ArrayList<E> implements ListInterface<E> {
    private E[] item;
    private int numItems;
    private static final int DEFAULT_CAPACITY = 64;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        // 제네릭 배열은 직접 생성이 불가능하여 Object 배열 생성 후 캐스팅합니다.
        this.item = (E[]) new Object[DEFAULT_CAPACITY];
        this.numItems = 0;
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int n) {
        this.item = (E[]) new Object[n];
        this.numItems = 0;
    }

    @Override
    public void add(int index, E item) {
        if (numItems >= this.item.length || index < 0 || index > numItems) {
            /* 에러 처리: Throw IndexOutOfBoundsException 등 */
        } else {
            for (int i = numItems - 1; i >= index; i--) {
                this.item[i + 1] = this.item[i];
            }
            this.item[index] = item;
            numItems++;
            showCurrentArray();
        }
    }

    @Override
    public void append(E item) {
        if (numItems >= this.item.length) {
            /* 에러 처리 */
        } else {
            this.item[numItems++] = item;
            showCurrentArray();
        }
    }

    @Override
    public E remove(int index) {
        if (isEmpty() || index < 0 || index > numItems - 1) {
            return null;
        } else {
            E tmp = item[index];
            for (int i = index; i <= numItems - 2; i++) {
                item[i] = item[i + 1];
            }
            item[numItems - 1] = null; // 메모리 누수 방지 (GC 대상)
            numItems--;
            showCurrentArray();
            return tmp;
        }
    }

    @Override
    public boolean removeItem(E item) {
        int k = 0;
        // 제네릭에서는 compareTo 대신 equals를 사용하는 것이 일반적입니다.
        while (k < numItems && !this.item[k].equals(item)) {
            k++;
        }

        if (k == numItems) {
            return false;
        } else {
            for (int i = k; i <= numItems - 2; i++) {
                this.item[i] = this.item[i + 1];
            }
            this.item[numItems - 1] = null; // 메모리 누수 방지
            numItems--;
            showCurrentArray();
            return true;
        }
    }

    @Override
    public E get(int index) {
        if (index >= 0 && index <= numItems - 1) {
            return item[index];
        }
        return null;
    }

    @Override
    public void set(int index, E item) {
        if (index >= 0 && index <= numItems - 1) {
            this.item[index] = item;
        }
    }

    @Override
    public int indexOf(E item) {
        for (int i = 0; i < numItems; i++) {
            if (this.item[i].equals(item)) {
                return i;
            }
        }
        return -1; // 보통 찾는 값이 없을 때 -1을 반환합니다.
    }

    @Override
    public int len() {
        return numItems;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        item = (E[]) new Object[item.length];
        numItems = 0;
    }

    private void showCurrentArray() {
        for (int i = 0; i < numItems; i++) {
            System.out.print(i+ " 번째 수 : " + item[i]);
            System.out.println();
        }
        System.out.println();
    }
}