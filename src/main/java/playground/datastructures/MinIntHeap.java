package playground.datastructures;

import java.util.Arrays;

public class MinIntHeap {

    // for a given index
    // its parent will be
    // (index - 2)/2

    // its left child will be:
    // index*2+1

    // its right child will be:
    // index*2+2


    private int capacity = 10;
    private int size = 0;

    private int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private int parent(int index) {
        return items[getParentIndex(index)];
    }

    private void swap(int indexOne, int indexTwo) {
        // just for fun without using a temp variable :)
        items[indexOne] += items[indexTwo];
        items[indexTwo] = items[indexOne] - items[indexTwo];
        items[indexOne] -= items[indexTwo];

        /*
            instead of:
            int tmp = items[indexOne];
            items[indexOne] = items[indexTwo];
            items[indexTwo] = tmp;
         */
    }

    private void ensureExtraCapacitance() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {

            int smallerOfChildsIndex = getLeftChildIndex(index);

            if (hasRightChild(index) && rightChild(index) < leftChild(index))
                smallerOfChildsIndex = getRightChildIndex(index);

            if (items[index] < items[smallerOfChildsIndex])
                break;
            else {
                swap(smallerOfChildsIndex, index);
            }
            index = smallerOfChildsIndex;
        }
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }

    public int poll() {
        if (size == 0) throw new IllegalStateException();
        int item = items[0];

        items[0] = items[size - 1];
        items[size-1] = 0;
        size--;

        heapifyDown();
        return item;
    }

    public void add(int item) {
        ensureExtraCapacitance();
        items[size] = item;
        size++;
        heapifyUp();
    }

    public void printHeap() {
        for (int item : items) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MinIntHeap minIntHeap = new MinIntHeap();

        minIntHeap.add(10);
        minIntHeap.add(15);
        minIntHeap.add(20);
        minIntHeap.add(17);
        minIntHeap.add(25);

        minIntHeap.printHeap();

        minIntHeap.poll();
        minIntHeap.printHeap();
    }
}
