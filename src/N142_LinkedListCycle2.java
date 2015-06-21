/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * Follow up:
 * Can you solve it without using extra space?
 */
public class N142_LinkedListCycle2 {

    public ListNode detectCycle(ListNode head) {
        ListNode s1 = head;
        ListNode s2 = head;
        if (head == null || head.next == null || head.next.next == null) return null;
        boolean hasCycle = false;
        while (s2 != null) {
            s1 = s1.next;
            s2 = s2.next.next;
            if (s1 == s2) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) return null;
        s1 = head;
        while (s1 != s2) {
            s1 = s1.next;
            s2 = s2.next;
        }
        return s1;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

