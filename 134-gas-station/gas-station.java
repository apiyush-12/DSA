// class Solution {
//     public int canCompleteCircuit(int[] gas, int[] cost) {
//         int totalGas = 0, totalCost = 0, startIndex = 0, tank = 0;
//         for(int i =0; i<gas.length; i++){
//             totalGas += gas[i];
//             totalCost += cost[i];
//             tank += gas[i] - cost[i];
//             if(tank < 0){
//                 tank = 0;
//                 startIndex = i+1;
//             }
//         }
//         if(totalGas < totalCost) return -1;
//         return startIndex;
//     }
// }

// class Solution{
//     public int canCompleteCircuit(int[] gas, int[] cost){
//         int totalGas = 0, totalCost = 0, tank = 0, startInd = 0;
//         for(int i = 0; i< gas.length; i++){
//             totalGas += gas[i];
//             totalCost += cost[i];
//             tank += gas[i] - cost[i];
//             if(tank < 0){
//                 tank = 0;
//                 startInd = i + 1;
//             }
//         }
//         if(totalCost > totalGas) return -1;
//         return startInd;
//     }
// }

// piyush
class Solution{
    public int canCompleteCircuit(int[] gas, int[] cost){
        int totalCost = 0, totalGas =0, tank =0, startInd = 0;
        for(int i=0; i<gas.length; i++){
            totalCost += cost[i];
            totalGas += gas[i];
            tank += gas[i]-cost[i];
            if(tank < 0){
                tank = 0;
                startInd = i + 1;
            }
        }
        if(totalGas < totalCost) return -1;
        return startInd;
    }
}