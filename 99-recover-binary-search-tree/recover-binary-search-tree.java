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
    List<TreeNode> list;
    public void recoverTree(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
        TreeNode first = null;
        TreeNode mid = null;
        TreeNode last = null;
        for(int i=1;i<list.size();i++){
            if(list.get(i-1).val > list.get(i).val){
                if(first == null){
                    first = list.get(i-1);
                    mid = list.get(i);
                } else{
                    last = list.get(i);
                }
            }
        }
        if(last == null){
            last = mid;
        }
        int i = first.val;
        int j = last.val;
        findAndSwap(root, first, -1);
        findAndSwap(root, last, i);
        findAndSwap(root, first, j);
    }
    private void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
    private void findAndSwap(TreeNode root, TreeNode find, int value){
        if(root == null){
            return;
        }
        if(root.val == find.val){
            root.val = value;
            return;
        }
        findAndSwap(root.left, find, value);
        findAndSwap(root.right, find, value);
    }
}