public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (true) {
            int i = k;
            ListNode p = cur.next, q = null;
            while (p != null && i != 0) {
                ListNode t = p.next;
                p.next = q;
                q = p;
                p = t;
                --i;
            }
            if (i == 0) {
                ListNode next = cur.next;
                next.next = p;
                cur.next = q;
                cur = next;
            } else {
                while (q != null) {
                    ListNode t = q.next;
                    q.next = p;
                    p = q;
                    q = t;
                }
                break;
            }
        }
        return dummy.next;
    }
}
