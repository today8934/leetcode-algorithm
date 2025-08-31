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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Deque<ListNode> mainDeque = new ArrayDeque();
        Deque<ListNode> subDeque = new ArrayDeque();

        recursion(mainDeque, head);

        for (int i = 0; i < n; i++) {
            subDeque.push(mainDeque.pop());
        }

        if (mainDeque.isEmpty()) {
            return subDeque.pop().next;
        }

        ListNode nthNode = subDeque.pop();
        mainDeque.pop().next = nthNode.next;

        return head;
    }

    private void recursion(Deque deque, ListNode node) {
        if (node == null) {
            return;
        }

        deque.push(node);
        recursion(deque, node.next);
    }
}