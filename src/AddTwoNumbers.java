public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return new ListNode(0);
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            tail.next = new ListNode(carry % 10);
            tail = tail.next;
            carry /= 10;
        }
        return dummy.next;
    }
}
