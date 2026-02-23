package com.example.datastructure.arraylist;

public class IntegerArrayList implements IntegerListInterface {

    private Integer[] item;
    private int numItems;
    private static final int DEFAULT_CAPACITY = 64;

    public IntegerArrayList() {
        this.item = new Integer[DEFAULT_CAPACITY];
        this.numItems = 0;
    }

    public IntegerArrayList(int n) {
        item = new Integer[n];
        numItems = 0;
    }

    @Override
    public void add(int index, Integer x) {
        if (numItems >= item.length || index < 0 || index > numItems) {
            /*에러처리*/
        } else {
            for (int i = numItems - 1; i >= index; i--) {
                item[i + 1] = item[i];
            }
            item[index] = x;
            numItems++;
            showCurrentArray();
        }

    }

    @Override
    public void append(Integer x) {
        if (numItems >= item.length) {
            /* 에러 처리 */
        } else {
            item[numItems++] = x;
            showCurrentArray();
        }
    }

    @Override
    public Integer remove(int index) {
        if (isEmpty() || index < 0 || index > numItems - 1) {
            return null;
        } else {
            Integer tmp = item[index];
            for (int i = index; i <= numItems - 2; i++) {
                item[i] = item[i + 1];
            }
            numItems--;
            showCurrentArray();
            return tmp;
        }
    }

    @Override
    public boolean removeItem(Integer x) {
        int k = 0;
        while (k < numItems && item[k].compareTo(x) != 0) {
            k++;
        }

        if (k == numItems) {
            return false;
        } else {
            for (int i = k; i <= numItems - 2; i++) {
                item[i] = item[i + 1];
            }

            numItems--;
            showCurrentArray();
            return true;
        }

    }

    @Override
    public Integer get(int i) {
        return 0;
    }

    @Override
    public void set(int index, Integer x) {
        if (index >= 0 && index <= numItems -1) {
            item[index] = x;
        } else {
            /* 에러 처리 */
        }
    }

    private final int NOT_FOUND = -12345;
    @Override
    public int indexOf(Integer x) {
        for (int i = 0; i < numItems; i++) {
            if(item[i].compareTo(x) == 0)
                return i;
        }

        return NOT_FOUND;
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
    public void clear() {
        item = new Integer[item.length];
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
