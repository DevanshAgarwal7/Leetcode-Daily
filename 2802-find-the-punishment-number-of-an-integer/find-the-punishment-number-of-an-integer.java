class Solution {
    public int punishmentNumber(int n) {
        int result = 0;
        for(int i=1;i<=n;i++){
            String str = Integer.toString(i*i);
            if(isPartition(0, str, i, 0)){
                result += (i*i);
            }
        }
        return result;
    }
    private boolean isPartition(int index, String str, int target, int currSum){
        //base case
        int n = str.length();
        if(index == n){
            return currSum == target;
        }
        if(currSum > target){
            return false;
        }
        for(int i=index;i<n;i++){
            int val = Integer.parseInt(str.substring(index, i+1));
            if(isPartition(i+1, str, target, currSum + val)){
                return true;
            }
        }
        return false;
    }
}