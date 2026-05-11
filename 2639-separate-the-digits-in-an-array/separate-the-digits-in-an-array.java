class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int element: nums){
            List<Integer> num = new ArrayList<>();
            while(element > 0){
                num.add(element%10);
                element /= 10;
            }
            for(int i=num.size()-1;i>=0;i--){
                list.add(num.get(i));
            }
        }
        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }
}