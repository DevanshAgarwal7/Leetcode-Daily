class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        //iss loop me ye count krke rakha hai ki kitne rabbit bol rhe h mere jese aur hai
        for(int i=0;i<answers.length;i++){
            map.put(answers[i], map.getOrDefault(answers[i], 0) + 1);
        }
        int count = 0;
        for(int rabbit: map.keySet()){
            if(map.get(rabbit) == 0){
                count += 1;
            }
            else{
                int eachGroupSize = rabbit + 1;
                int membersInGroup = map.get(rabbit);
                int groups = (int)Math.ceil((double)membersInGroup / eachGroupSize);
                count += groups * eachGroupSize;
            }
        }
        return count;
    }
}