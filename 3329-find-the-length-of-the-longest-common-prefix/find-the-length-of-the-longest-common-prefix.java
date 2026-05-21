class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int longestPrefix = 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int element: arr1){
            while(!set.contains(element) && element > 0){
                set.add(element);
                element /= 10;
            }
        }

        for(int element: arr2){
            while(!set.contains(element) && element > 0){
                element /= 10;
            }
            if(element > 0){
                longestPrefix = Math.max(longestPrefix, (int) Math.log10(element) + 1);
            }
        }

        return longestPrefix;
    }
}