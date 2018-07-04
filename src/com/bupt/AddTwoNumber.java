package com.bupt;


/*
*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order

and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*
*
*
* */


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;
        int carry = 0;
        while(l1 != null && l2 != null) {

            int cur = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;

            ptr.next = new ListNode(cur);
            ptr = ptr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 == null) {
            while(l2 != null) {
                ptr.next = new ListNode((l2.val + carry) % 10);
                carry = (l2.val + carry) / 10;
                l2 = l2.next;
                ptr = ptr.next;
            }
        } else {
            while(l1 != null) {
                ptr.next = new ListNode((l1.val + carry) % 10);
                carry = (l1.val + carry) / 10;
                l1 = l1.next;
                ptr = ptr.next;
            }
        }
        if(carry != 0)
            ptr.next = new ListNode(carry);
        return dummy.next;
    }

}
