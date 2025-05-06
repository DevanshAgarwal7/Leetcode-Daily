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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            TreeNode curr = null;
            while(size > 0){
                curr = q.poll();
                if(curr!= null && curr.left != null) q.add(curr.left);
                if(curr != null && curr.right != null) q.add(curr.right);
                --size;
            }
            if(curr!= null) list.add(curr.val);
        }
        return list;
    }
}