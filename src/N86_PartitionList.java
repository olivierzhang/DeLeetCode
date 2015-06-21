/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */
public class N86_PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(x);
        ListNode smallIndex = smallHead;
        ListNode bigHead = new ListNode(x);
        ListNode bigIndex = bigHead;
        while (head != null) {
            ListNode tmp = head;
            if (head.val < x) {
                smallIndex.next = tmp;
                smallIndex = smallIndex.next;
            } else {
                bigIndex.next = tmp;
                bigIndex = bigIndex.next;
            }
            head = head.next;
            tmp.next = null;
        }
        smallIndex.next = bigHead.next;
        return smallHead.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
