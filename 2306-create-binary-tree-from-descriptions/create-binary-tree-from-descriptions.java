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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> parentSet = new HashSet<>();
        Set<Integer> childSet = new HashSet<>();
        Map<Integer, List<int[]>> parentToChildMap = new HashMap();

        for(int[] description: descriptions){
            int parent = description[0];
            int child = description[1];
            int isLeft = description[2];

            parentSet.add(parent);
            parentSet.add(child);
            childSet.add(child);
            parentToChildMap.computeIfAbsent(parent, areadyHas -> new ArrayList<>())
            .add(new int[]{child, isLeft});
        }

        parentSet.removeAll(childSet);

        TreeNode root = new TreeNode(parentSet.iterator().next());
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                TreeNode parent = q.poll();
                List<int[]> childsList = 
                    parentToChildMap.getOrDefault(parent.val, Collections.emptyList());
                for(int[] childs: childsList){
                    int childValue = childs[0];
                    boolean isLeft = childs[1] == 1;
                    TreeNode childNode = new TreeNode(childValue);
                    if(isLeft){
                        parent.left = childNode;
                    } else{
                        parent.right = childNode;
                    }
                    q.add(childNode);
                }
                --size;
            }
        }
        return root;
    }
}