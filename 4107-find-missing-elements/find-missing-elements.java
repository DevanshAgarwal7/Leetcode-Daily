class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        List<Integer> result = new ArrayList<>();
        for(int i=min+1; i<max; i++){
            if(!set.contains(i)){
                result.add(i);
            }
        }
        return result;
    }
}