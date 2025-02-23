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
import java.util.Iterator;

class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        //ye mene khud code kiya h
        Map<Integer, Stack<TreeNode>> levelMap = new HashMap<>();
        int lastIndexWhereValuePresent = 0;
        int n = traversal.length();
        int nodeValue = 0;
        while(lastIndexWhereValuePresent < n && traversal.charAt(lastIndexWhereValuePresent) != '-'){
            nodeValue = nodeValue * 10 + (traversal.charAt(lastIndexWhereValuePresent) - '0');
            ++lastIndexWhereValuePresent;
        }
        //System.out.println(value);
        int currentIndex = lastIndexWhereValuePresent;
        //ye minus islie kra kyuki while loop ke ye '-' ko point kr raha tha aur hame chaia last nodeVlaue ki last digit ki position.
        --lastIndexWhereValuePresent;
        TreeNode root = new TreeNode(nodeValue);
        levelMap.put(0, new Stack<>());
        levelMap.get(0).push(root);

        while(currentIndex < n){
            if(traversal.charAt(currentIndex) != '-'){
                nodeValue = 0;
                int startIndex = currentIndex;
                while(startIndex < n && traversal.charAt(startIndex) != '-'){
                    nodeValue = (nodeValue *= 10) + (traversal.charAt(startIndex) - '0');
                    ++startIndex;
                }
                //System.out.println(nodeValue);
                int levelAtWhichNodeWillInsert = currentIndex - lastIndexWhereValuePresent - 1;
                TreeNode node = new TreeNode(nodeValue);
                insertNodeInTree(node, levelAtWhichNodeWillInsert-1, levelMap);
                levelMap.putIfAbsent(levelAtWhichNodeWillInsert, new Stack<>());
                levelMap.get(levelAtWhichNodeWillInsert).push(node);
                lastIndexWhereValuePresent = startIndex-1;
                currentIndex = startIndex;
            } else{
                ++currentIndex;
            }
        }
        return root;
    }
    private void insertNodeInTree(TreeNode node, int parentLevelOfNewNode, Map<Integer, Stack<TreeNode>> levelMap){
        Stack<TreeNode> nodesAtPerticularLevel = levelMap.get(parentLevelOfNewNode);
        //System.out.println(node.val);
        while (!nodesAtPerticularLevel.isEmpty()) {
            TreeNode toBeParent = nodesAtPerticularLevel.peek();
            //System.out.println(toBeParent.val);
            if(canBeParentOfNode(toBeParent)){
                if(toBeParent.left == null){
                    toBeParent.left = node;
                } else{
                    toBeParent.right = node;
                }
                return;
            } else{
                nodesAtPerticularLevel.pop();
            }
            // if(isBothChildExistOfToBeParent(toBeParent)){
            // }
        }
    }
    private boolean canBeParentOfNode(TreeNode parent){
        return parent.left == null || parent.right == null;
    }
    private boolean isBothChildExistOfToBeParent(TreeNode parent){
        return parent.left != null && parent.right != null;
    }
}