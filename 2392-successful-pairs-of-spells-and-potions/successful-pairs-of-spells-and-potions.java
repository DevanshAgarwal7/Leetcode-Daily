class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] pairs = new int[n];

        Arrays.sort(potions);

        for(int i=0;i<n;i++){
            int low = 0;
            int high = m-1;
            int index = -1;
            while(low <= high){
                int mid = (low+high)/2;
                if((long)potions[mid] * spells[i] >= success){
                    index = mid;
                    high = mid-1;
                } else{
                    low = mid+1;
                }
            }
            if(index != -1){
                pairs[i] = m - index;
            }
        }

        return pairs;
    }
}