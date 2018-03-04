package playground.datastructures;

import java.util.Date;
import java.util.Random;
import java.util.Stack;

/*
    Create a queue using stacks.

    A queue is FIFO but a stack is LIFO. In order to make a stack to act as a queue (FIFO) we need two stacks
    where the elements to pop/peek/delete will be reversed and they will be presented as in a queue;
 */
public class Queue<T> {
    private Stack<T> input;
    private Stack<T> output;
    private int size;

    public Queue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void add(T element) {
        input.add(element);
        size++;
        checkOutput();
    }

    public T pop() {
        checkOutput();

        if (output.isEmpty()) return null;
        size--;
        return output.pop();
    }

    public T peek() {
        checkOutput();
        return output.peek();
    }

    public boolean delete(T element) {
        boolean result = output.remove(element);
        if (!result)
            result = input.remove(element);
        if (result) size--;
        return result;
    }

    private void checkOutput() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) output.add(input.pop());
        }
    }


    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        for (int i = 0; i < 10; i++) {
            queue.add(i);
            System.out.println("Adding " + i + " to queue. New size is " + queue.getSize());
        }

        int randomNumber = new Random(new Date().getTime()).nextInt() % 10;

        System.out.println("Removing " + randomNumber + " from queue: " + queue.delete(randomNumber));

        for (int i = 0; i < 10; i++) {
            Integer pop = queue.pop();
            if (pop != null) {
                System.out.println("Poping from queue " + pop + ". New size is " + queue.getSize());
            }
        }


    }
}
