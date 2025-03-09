class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int[] extendedColorsArray = new int[n+k-1];
        for(int i=0;i<n;i++){
            extendedColorsArray[i] = colors[i];
        }
        for(int i=0;i<k-1;i++){
            extendedColorsArray[n+i] = colors[i];
        }
        int result = 0;
        int left = 0;
        int right = 1;
        while(right < extendedColorsArray.length){
            if(extendedColorsArray[right] == extendedColorsArray[right - 1]){
                left = right;
                ++right;
                continue;
            }
            if(right - left + 1 < k){
                ++right;
            } else{
                ++result;
                ++left;
            }
        }
        return result;
    }
}