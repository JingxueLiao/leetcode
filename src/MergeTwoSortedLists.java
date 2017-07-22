public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode r = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                r.next = l1;
                l1 = l1.next;
            } else {
                r.next = l2;
                l2 = l2.next;
            }
            r = r.next;
        }
        if (l1 != null) {
            r.next = l1;
        } else {
            r.next = l2;
        }
        return dummy.next;
    }
}
