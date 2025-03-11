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
    private static final String seperator = "->";
    List<String> result;
    public List<String> binaryTreePaths(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, new StringBuilder());
        return result;
    }
    private void dfs(TreeNode root, StringBuilder str){
        //base case
        if(root == null){
            return;
        }
        int len = str.length();
        str.append(Integer.toString(root.val));
        if(root.left == null && root.right == null){
            result.add(str.toString());
        } else{
            str.append(seperator);
            dfs(root.left, str);
            dfs(root.right, str);
        }
        str.setLength(len);
    }
}