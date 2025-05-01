class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            pascal.add(new ArrayList<>());
        }
        pascal.get(0).add(1);
        recursion(1, 1, pascal, numRows);
        return pascal;
    }
    private void recursion(int row, int cols, List<List<Integer>> pascal, int n){
        //base case
        if(row == n){
            return;
        }
        pascal.get(row).add(1);
        for(int col=1;col<cols;col++){
            pascal.get(row).add(pascal.get(row-1).get(col-1) + pascal.get(row-1).get(col));
        }
        pascal.get(row).add(1);
        recursion(row+1, cols+1, pascal, n);
    }
}