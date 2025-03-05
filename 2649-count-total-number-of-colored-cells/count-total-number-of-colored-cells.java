class Solution {
    public long coloredCells(int n) {
        //see sashcode video
        long ans = 1;
        long x = 4;
        n--;
        while(n>0){
            ans += x;
            x += 4;
            n--;
        }
        return ans;
    }
}