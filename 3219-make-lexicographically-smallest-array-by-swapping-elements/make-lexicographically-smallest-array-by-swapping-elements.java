class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        // this question ask in microsoft
        //see viseo of sashcode
        int n = nums.length;
        int[] copy = new int[n];
        for(int i=0;i<n;i++){
            copy[i] = nums[i];
        }
        Arrays.sort(copy);

        List<Queue<Integer>> group = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        group.add(new LinkedList<>());
        int currGroupIndex = 0;
        int prev = copy[0];
        group.get(currGroupIndex).add(copy[0]);
        map.put(copy[0], currGroupIndex);
        for(int i=1;i<n;i++){
            if(Math.abs(prev - copy[i]) > limit){
                ++currGroupIndex;
                group.add(new LinkedList<>());
            }
            group.get(currGroupIndex).add(copy[i]);
            prev = copy[i];
            map.put(copy[i], currGroupIndex);
        }

        for(int i=0;i<n;i++){
            int groupIndex = map.get(nums[i]);
            nums[i] = group.get(groupIndex).remove();
        }

        return nums;
    }
}