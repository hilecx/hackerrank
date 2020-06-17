package LinkedList.Reverseadoublylinkedlist;

import javax.xml.soap.Node;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep) throws IOException {
        while (node != null) {
            System.out.printf(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                System.out.printf(sep);
            }
        }
    }

    // Complete the reverse function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */
    static DoublyLinkedListNode reverse2(DoublyLinkedListNode head) {
        DoublyLinkedListNode pre = null;
        DoublyLinkedListNode node = head;
        DoublyLinkedListNode tmp = null;

        if (head.next == null) {
            return head;
        }
        while (node != null) {
            if (pre == null) {
                node.prev = node.next;
                node.next = pre;
                pre = node;
                node = node.prev;
            } else if (node.next == null) {
                node.next = node.prev;
                node.prev = null;
                break;
            } else {
                tmp = node.prev;
                node.prev = node.next;
                node.next = tmp;
                node = node.prev;
            }
        }
        return node;

    }

    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode node = head;
        DoublyLinkedListNode tmp = null;
        while (node!=null){
            tmp = node.prev;
            node.prev = node.next;
            node.next = tmp;
            if(node.prev!=null) {
                node = node.prev;
            }else {
                break;
            }
        }
        return node;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            DoublyLinkedList llist = new DoublyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            DoublyLinkedListNode llist1 = reverse(llist.head);

            printDoublyLinkedList(llist1, " ");
        }


        scanner.close();
    }
}