class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || right == left) return head;

        ListNode a = null, b = null, c = null, d = null;
        ListNode temp = head;
        int pos = 1;

        while(temp != null) {
            if(pos == left - 1) a = temp;
            if(pos == left) b = temp;
            if(pos == right) c = temp;
            if(pos == right + 1) d = temp;
            temp = temp.next;
            pos++;
        }

        
        if(c != null) c.next = null;

       
        ListNode reversedHead = reverseList(b);

        
        if(a != null) {
            a.next = reversedHead;
        } else {
            head = reversedHead; 
        }

        
        b.next = d;

        return head;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
