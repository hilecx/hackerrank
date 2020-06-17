package LinkedList.LinkedListsDetectaCycle;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as:
    class Node {
        int data;
        Node next;
    }
*/
    class Node {
        int data;
        Node next;
    }

    boolean hasCycle(Node head) {
        Set<Node> set = new HashSet<>();

        while (head!=null){
            if(set.contains(head)){
                return true;
            }else {
                set.add(head);
            }
            head=head.next;
        }

        return false;
    }
}
