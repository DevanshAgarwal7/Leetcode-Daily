class Solution {
    private Set<String> set;
    private String result = null;
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        set = Arrays.stream(nums).collect(Collectors.toSet());
        solve("", "01", n);
        return result;
    }
    private void solve(String str, String sequence, int n){
        if(str.length() == n && set.contains(str)){
            return;
        }
        if(str.length() == n && !set.contains(str)){
            result = str;
            return;
        }
        for(int i=0;i<2;i++){
            solve(str+sequence.charAt(i), sequence, n);
            if(result != null){
                return;
            }
        }
    }
}