package com.bupt;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
 }
public class CopyRandomList {
    public RandomListNode copyRandomList(RandomListNode head) {

        //copy new node after orignal node
        RandomListNode ptr = head;
        while(ptr != null) {
            RandomListNode node = new RandomListNode(ptr.label);
            node.next = ptr.next;
            ptr.next = node;
            ptr = node.next;
        }
        //link new nodes to their random node
        ptr = head;
        while(ptr != null) {
            RandomListNode tar = ptr.random.next;
            RandomListNode node = ptr.next;
            node.random = tar;
            ptr = node.next;
        }
        //unweave two lists
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cp_ptr = dummy;
        ptr = head;
        while(ptr != null) {
            cp_ptr.next = ptr.next;
            cp_ptr = ptr.next;
            ptr.next = cp_ptr.next;
            ptr = cp_ptr.next;
        }
        return dummy.next;
    }
}
