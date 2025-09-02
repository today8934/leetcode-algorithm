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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((node1, node2) -> Integer.compare(node1.val, node2.val));
        if (list1 == null && list2 == null) return null;

        ListNode node = list1;

        if (list1 != null) {
            
            queue.add(node);
            node = node.next;

            while (node != null) {
                queue.add(node);
                node = node.next;
            }
        }

        node = list2;

        if (list2 != null) {
            queue.add(node);
            node = node.next;

            while (node != null) {
                queue.add(node);
                node = node.next;
            }
        }

        ListNode head = queue.poll();
        ListNode prev = head;

        while (!queue.isEmpty()) {
            ListNode next = queue.poll();
            prev.next = next;
            prev = next;
        }

        prev.next = null;

        return head;
    }
}