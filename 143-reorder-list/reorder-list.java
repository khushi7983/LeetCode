class Solution {
    public void reorderList(ListNode head) {
          if (head == null || head.next == null) return;

         ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second Half
        ListNode prev = null;
        ListNode secHalf = slow.next;
        slow.next = null;
        while (secHalf != null){
            ListNode next = secHalf.next;
            secHalf.next = prev;
            prev = secHalf;
            secHalf = next;
        }

        ListNode first = head;
        ListNode second = prev; // head of reversed second half
        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;

        
        }
    }
}