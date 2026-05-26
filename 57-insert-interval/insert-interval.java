// class Solution {
//     public int[][] insert(int[][] intervals, int[] newInterval) {
//         int newStart = newInterval[0];
//         int newEnd = newInterval[1];
//         int left = 0, right = intervals.length;
//         LinkedList<int[]> output = new LinkedList<int[]>();
//         while(left < right && newStart > intervals[left][0]){
//             output.add(intervals[left]);
//             left++;
//         }
//         int[] interval = new int[2];
//         if(output.isEmpty() || output.getLast()[1] < newStart){
//             output.add(newInterval);
//         }else{
//             interval = output.removeLast();
//             interval[1] = Math.max(interval[1], newEnd);
//             output.add(interval);
//         }
//         while(left < right){
//             interval = intervals[left];
//             left++;
//             int start = interval[0], end = interval[1];
//             if(output.getLast()[1] <  start){
//                 output.add(interval);
//             }else{
//                 interval = output.removeLast();
//                 interval[1] = Math.max(interval[1], end);
//                 output.add(interval);
//             }
//         }
//         return output.toArray(new int[output.size()][2]);
//     }
// }


// class Solution{
//     public int[][] insert(int[][] intervals, int[] newInterval){
//         List<int[]> merge = new ArrayList<>();
//         int i = 0;
//         int l = intervals.length;
//         while(i < l && intervals[i][1] < newInterval[0]){
//             merge.add(intervals[i]);
//             i++;
//         }
//         while(i < l && intervals[i][0] <= newInterval[1]){
//             newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
//             newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
//             i++;
//         }
//         merge.add(newInterval);
//         while(i < l){
//             merge.add(intervals[i]);
//             i++;
//         }
//         return merge.toArray(new int[][]{});
//     }
// }

class Solution{
    public int[][] insert(int[][] intervals, int[] newInterval){
        List<int[]> merge = new ArrayList<>();
        int i = 0;
        int j = intervals.length;
        while(i < j && intervals[i][1] < newInterval[0]){
            merge.add(intervals[i]);
            i++;
        }
        while(i<j && intervals[i][0] <= newInterval[1]){
            newInterval[0]=Math.min(intervals[i][0], newInterval[0]);
            newInterval[1]= Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        merge.add(newInterval);
        while(i < j){
            merge.add(intervals[i]);
            i++;
        }
        return merge.toArray(new int[][]{});
    }
}
