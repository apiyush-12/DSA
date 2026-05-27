// class Solution {
//     public int eraseOverlapIntervals(int[][] intervals) {
//         int size = intervals.length;
//         if(size == 0) return 0;
//         Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
//         int prev = 0, count = 0;
//         for(int i = 1; i<size; i++){
//             if(intervals[prev][1] > intervals[i][0]){
//                 if(intervals[prev][1] > intervals[i][1]) prev = i;
//                 count++;
//             }else prev = i;
//         }
//         return count;
//     }
// }

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int result = 0;
        Arrays.sort(intervals, (a,b)->{
            return a[1] - b[1];
        });
        int[] prev = intervals[0];
        for(int i = 1;i<intervals.length;i++) {
            int[] curr = intervals[i];
            if(prev[1] > curr[0]) {
                result++; 
            } else {
                prev = curr;
            }
        }
        return result;
    }
}