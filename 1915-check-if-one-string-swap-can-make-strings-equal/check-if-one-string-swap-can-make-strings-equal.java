class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        HashMap<Character,Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0;i<s1.length();i++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for(int i=0;i<s2.length();i++){
            if(!map.containsKey(s2.charAt(i)) || map.get(s2.charAt(i)) <= 0
            || count > 2){
                return false;
            } else{
                map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);
                if(s1.charAt(i) != s2.charAt(i)){
                    count += 1;
                }
            }
        }
        if(count > 2){
            return false;
        }
        return true;
    }
}