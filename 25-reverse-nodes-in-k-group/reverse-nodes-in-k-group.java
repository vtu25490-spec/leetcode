class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroup = dummy;

        while (true) {
         
            ListNode kth = prevGroup;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }
            if (kth == null) break;

          
            ListNode groupNext = kth.next;
            ListNode prev = groupNext;
            ListNode curr = prevGroup.next;

            for (int i = 0; i < k; i++) {
                ListNode nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }
            ListNode temp = prevGroup.next;
            prevGroup.next = prev;
            prevGroup = temp;
        }

        return dummy.next;
    }
}