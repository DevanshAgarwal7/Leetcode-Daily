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
    int count = 0;
    List<Integer> list = new ArrayList<>();
    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return count;
    }
    private void dfs(TreeNode root, int targetSum){
        if(root == null){
            return;
        }
        list.add(root.val);
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);

        long sum = 0;
        for(int i=list.size() - 1; i>=0; i--){
            sum += list.get(i);
            if(sum == targetSum) ++count;
        }
        list.remove(list.size() - 1);
    }
}