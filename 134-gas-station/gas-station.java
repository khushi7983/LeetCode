class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int gasSum  = 0;
        int costSum = 0;
        for(int i = 0; i < n ; i++){
            gasSum +=  gas[i];
            costSum += cost[i];

        }
        if(gasSum < costSum) return -1;
        
        int tank = 0;
        int j = 0;
        for(int i = 0; i<n; i++){
            tank += gas[i] - cost[i];
            if(tank < 0) {
                j = i+1;
                tank = 0;
            }


        }
        return j;
    }
}