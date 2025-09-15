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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode();
        dfs(l1, l2, answer, 0);
        return answer;
    }

    private void dfs(ListNode l1, ListNode l2, ListNode answer, int carry) {
        if (l1 == null && l2 == null) {
            return;
        }
        
        int l1Val = 0;
        int l2Val = 0;
        ListNode l1Next = null;
        ListNode l2Next = null;
        
        if (l1 != null) {
            l1Val = l1.val;
            l1Next = l1.next;
        }
        
        if (l2 != null) {
            l2Val = l2.val;
            l2Next = l2.next;
        }
        
        int sum = l1Val + l2Val + carry;
        int nextCarry = 0;
        if (sum > 9) {
            answer.val = sum - 10;
            nextCarry = 1;
        } else {
            answer.val = sum;
        }
        
        if ((l1 != null && l1.next != null) || (l2 != null && l2.next != null)) {
            ListNode next = new ListNode();
            answer.next = next;
            dfs(l1Next, l2Next, next, nextCarry);    
        } else {
            if (nextCarry != 0) {
                ListNode next = new ListNode(nextCarry);
                answer.next = next;
            }
            return;
        }
    }   
}