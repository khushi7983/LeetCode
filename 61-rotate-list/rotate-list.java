/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int len = 1;
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
            len++;
        }

        k = k % len;
        if(k == 0) return head;
        temp.next = head;
        
        ListNode newTail = head;
        for(int i=1; i<=len - k - 1; i++){
            newTail = newTail.next;

        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;

        
    }
}