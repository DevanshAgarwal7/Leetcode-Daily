class Solution {
    public int countLargestGroup(int n) {
        int max = 0;
        int ans = 0;
        int[] map = new int[40];
        for(int i = 1;i<=n;i++){
            int key = 0,i0=i;
            while(i0!=0){
                key+=(i0%10);
                i0/=10;
            }
            map[key]++;
            if(max<map[key]){
                max=map[key];
                ans=1;
            }else if(map[key]==max){
                ans++;
            }
        }
        return ans;
    }
}