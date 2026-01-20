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
    private static final int mod = 1000000007;
    public int maxProduct(TreeNode root) {
        long total = dfs(root);
        return findMaxProduct(root, total);
    }

    private long dfs(TreeNode root){
        //base case
        if(root == null){
            return 0;
        }

        root.val += dfs(root.left) + dfs(root.right);
        return root.val;
    }

    private int findMaxProduct(TreeNode root, long total){
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        long maxProduct = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            long currProduct = 0;
            TreeNode curr = q.poll();
            currProduct = (total - curr.val) * curr.val;
            maxProduct = Math.max(maxProduct, currProduct);
            if(curr.left != null){
                 q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
        }
        return (int)(maxProduct % mod);
    }
}