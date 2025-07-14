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
    public int getDecimalValue(ListNode head) {
        
        int n = 0;
        ListNode temp = head;

        while(temp != null){
            temp =temp.next;
            n++;
        }

        temp = head;
        
        int sum = 0;


        for(int i=0; i<n; i++){
            if(temp.val == 1){
               sum += Math.pow(2, n - i - 1);

            }
            temp = temp.next;

            
        }
        
        return sum;
    }
}