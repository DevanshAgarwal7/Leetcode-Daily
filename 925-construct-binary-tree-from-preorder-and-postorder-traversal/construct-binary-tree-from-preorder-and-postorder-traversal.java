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
    Map<Integer, Integer> postorderMap;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        postorderMap = new HashMap<>();
        for(int i=0;i<postorder.length;i++){
            postorderMap.put(postorder[i], i);
        }
        return construct(preorder, 0, preorder.length-1, postorder, 0, postorder.length-1);
    }
    private TreeNode construct(int[] preorder, int preStart, int preEnd, int[] postorder,
    int postStart, int postEnd){
        //base case
        //System.out.println("prestrat: " + preStart + ", preend: " + preEnd);
        if(preStart > preEnd || postStart > postEnd){
            return null;
        }
        if(preStart == preEnd){
            //only one element is remaining so return the element by making it as a node;
            return new TreeNode(preorder[preStart]);
            //note: iss if condition me mene preorder ki value match kre ye ,
            //ye same chiz postorder se bhi kr sakte h kyuki usme bhi iss time ek hee element hoga
        }
        TreeNode node = new TreeNode(preorder[preStart]);
        int nextLeftOfNode = preorder[preStart+1];
        int positionOfNextLeftInPostorderArray = postorderMap.get(nextLeftOfNode);
        //ye islie kiya kyuki postorder array me nextLeftOfNode jo hoga uski position ke left me jitne
        //element hai vo left me lagaeneg tho usnka count calculate krne ke liye ye kiya h
        int NumberOfLeftChild = positionOfNextLeftInPostorderArray - postStart + 1;
        node.left = construct(preorder, preStart+1, preStart+NumberOfLeftChild, postorder, postStart, positionOfNextLeftInPostorderArray);
        node.right = construct(preorder, preStart+NumberOfLeftChild+1, preEnd, postorder, positionOfNextLeftInPostorderArray+1, postEnd-1);
        return node; 
    }
}