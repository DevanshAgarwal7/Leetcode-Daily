class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int result = 0;
        int costToPush = 1;
        int characterPushed = 8;
        while(characterPushed <= n){
            result += (8 * costToPush);
            characterPushed += 8;
            costToPush++;
        }
        if(characterPushed - 8 < n){
            characterPushed -= 8;
            result += ((n-characterPushed) * costToPush);
        }
        return result;
    }
}