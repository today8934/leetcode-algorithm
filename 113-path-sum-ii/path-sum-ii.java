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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(root, targetSum, 0, answer, new ArrayList<Integer>());
        return answer;
    }

    private void dfs(TreeNode node, int targetSum, int sum, List<List<Integer>> answer, List<Integer> pathList) {
        if (node == null) {
            return;
        }

        pathList.add(node.val);

        if (node.left == null && node.right == null) {
            if (sum + node.val == targetSum) {
                answer.add(pathList);
            }
        }
        
        dfs(node.left, targetSum, sum + node.val, answer, new ArrayList<Integer>(pathList));
        dfs(node.right, targetSum, sum + node.val, answer, new ArrayList<Integer>(pathList));
    }
}