class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
         int n = gas.length;
        //cost array ka sum barabar ya kam hona chaia gas array ke sum se tabhi tho 
        //journey complete ho payegi jha se shuru kri hogi
        int totalGas = 0;
        int totalCost = 0;
        for(int i=0;i<n;i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if(totalGas < totalCost){
            return -1;
        }
        
        int currGas = 0;
        int startingPoint = 0;
        for(int index=0;index<n;index++){
            // jitni gas hai "-" kitna gas lagegi agle station tak jane me "+" curr station se kitni gas mili
            currGas = currGas - cost[index] + gas[index];
            //agar -ve hui value tho matlab next station se pochne se phle hee gas khatam hojayegi tho se starting point tho ho hee nhi sakta
            if(currGas < 0){
                currGas = 0;
                startingPoint = index+1;
            }
        }
        //kyuki question me given hai hamesha ek hee starting point hoga
        //tho agar curr gas +ve hua tho vo vha se hamesah hum journey start krkte hue
        //complete kr payenge circular way m
        return startingPoint;
    }
}