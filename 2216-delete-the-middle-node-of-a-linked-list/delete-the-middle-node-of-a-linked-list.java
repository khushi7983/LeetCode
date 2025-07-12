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
    public ListNode deleteMiddle(ListNode head) {
    
        ListNode slow = head;
        ListNode fast = head;
        int len = 0;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            len ++;
        }
        if(len == 0) return null;
        
        ListNode temp = head;
        for(int i=0; i<len-1;i++){
            temp = temp.next;
        }

        temp.next = temp.next.next;

        
        return head;
    }

}