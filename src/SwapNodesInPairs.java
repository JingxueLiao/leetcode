public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode p = cur.next, q = p.next;
            p.next = q.next;
            q.next = p;
            cur.next = q;
            cur = p;
        }
        return dummy.next;
    }
}
