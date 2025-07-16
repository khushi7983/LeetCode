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
    public ListNode partition(ListNode head, int x) {

        ListNode a = new ListNode(-1);
        ListNode b = new ListNode(-1);
        ListNode temp1 = a;
        ListNode temp2 = b;
        ListNode temp = head;


        while( temp != null){
            if(temp.val < x){
                temp1.next =temp;
                temp = temp.next;
                temp1 = temp1.next;
            }
            else{
                temp2.next = temp;
                temp = temp.next;
                temp2 = temp2.next;
            }
        }

        temp2.next = null;
        temp1.next = b.next;

        return a.next;

    }
}