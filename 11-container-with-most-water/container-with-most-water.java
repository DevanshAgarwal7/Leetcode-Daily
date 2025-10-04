class Solution {
    public int maxArea(int[] height) {
        int containerArea = 0;
        int i = 0;
        int j = height.length - 1;
        while(i<j){
            int area = (j-i) * Math.min(height[i], height[j]);
            containerArea = Math.max(containerArea, area);
            if(height[i] < height[j]){
                i++;
            } else{
                j--;
            }
        }
        return containerArea;
    }
}