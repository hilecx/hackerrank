package StackQueue.ATaleTwoStacks;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
//            while (stackOldestOnTop.size()>=1){
//                stackNewestOnTop.push(stackOldestOnTop.pop());
//            }
            stackNewestOnTop.push(value);
        }

        public T peek() {
            if (stackOldestOnTop.isEmpty()) {
                while (!stackNewestOnTop.isEmpty()) {
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }
            return stackOldestOnTop.peek();

        }

        public T dequeue() {
            if (stackOldestOnTop.isEmpty()) {
                while (!stackNewestOnTop.isEmpty()) {
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }
            return stackOldestOnTop.pop();

        }
    }


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long t1 = 0;
        long t2 = 0;
        long t3 = 0;

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                long a = System.currentTimeMillis();
                queue.enqueue(scan.nextInt());
                long b = System.currentTimeMillis();
                t1 += b - a;
            } else if (operation == 2) { // dequeue
                long a = System.currentTimeMillis();
                queue.dequeue();
                long b = System.currentTimeMillis();
                t2 += b - a;
            } else if (operation == 3) { // print/peek
                long a = System.currentTimeMillis();
                System.out.println(queue.peek());
//                queue.peek();
                long b = System.currentTimeMillis();
                t3 += b - a;
            }
        }

        System.out.printf("t1 %d; t2 %d; t3 %d; \n", t1, t2, t3);
        scan.close();
    }
}

