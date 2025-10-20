class Solution {
    private static String op1 = "++X";
    private static String op2 = "X++";
    private static String op3 = "--X";
    private static String op4 = "X--";
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(String str : operations){
            if(str.equals(op1) || str.equals(op2)){
                x++;
            } else{
                x--;
            }
        }
        return x;
    }
}