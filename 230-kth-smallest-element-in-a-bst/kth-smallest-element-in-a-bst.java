/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<TreeNode> queue = new PriorityQueue<>((m, n) -> Integer.compare(m.val, n.val));
        dfs(root, queue);

        int answer = 0;
        for (int i = 0; i < k; i++) {
            answer = queue.poll().val;
        }

        return answer;
    }

    private void dfs(TreeNode node, PriorityQueue<TreeNode> queue) {
        if (node == null) {
            return;
        }

        queue.offer(node);
        dfs(node.left, queue);
        dfs(node.right, queue);
    }
}