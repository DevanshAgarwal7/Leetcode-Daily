class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastOccurance = new int[26];
        for(int i=0;i<s.length();i++){
            lastOccurance[s.charAt(i) - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int partitionStart = 0;
        int partitionEnd = 0;
        for(int i=0;i<s.length();i++){
            partitionEnd = Math.max(partitionEnd, lastOccurance[s.charAt(i) - 'a']);
            if(i==partitionEnd){
                int length = partitionEnd - partitionStart + 1;
                result.add(length);
                partitionStart = i+1;
                partitionEnd = 0;
            }
        }
        return result;
    }
}