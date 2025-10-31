class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int[] result = new int[2];
        int index = 0;
        for(Integer num: nums){
            if (set.contains(num)) {
                result[index++] = num;
            } else {
                set.add(num);
            }
        }
        Arrays.sort(result);
        return result;
    }
}