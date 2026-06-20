// class Solution {
//     public int maxBuilding(int n, int[][] restrictions) {
//         List<int[]> list = new ArrayList<>();
//         list.add(new int[]{1, 0});
//         for(int[] r : restrictions){
//             list.add(new int[]{r[0], r[1]});
//         }
//         boolean hasN = false;
//         for(int[] r : restrictions){
//             if(r[0] == n){
//                 hasN = true;
//                 break;
//             }
//         }

//         if(!hasN) list.add(new int[]{n, Integer.MAX_VALUE});
//         list.sort((a, b) -> a[0]-b[0]);
//         int m = list.size();

//         // left -> right
//         for(int i=1; i<m; i++){
//             int d = list.get(i)[0] - list.get(i-1)[0];
//             list.get(i)[1] = Math.min(list.get(i)[1], list.get(i-1)[1] + d);
//         }

//         // right -> left
//         for(int i = m-2; i>=0; i--){
//             int d = list.get(i+1)[0] - list.get(i)[0];
//             list.get(i)[1] = Math.min(list.get(i)[1], list.get(i+1)[1] + d);
//         }
//         long ans = 0;
//         for(int i=1; i<m; i++){
//             long x1 = list.get(i-1)[0];
//             long h1 = list.get(i-1)[1];
//             long x2 = list.get(i)[0];
//             long h2 = list.get(i)[1];
//             long d = x2 - x1;
//             long peak = (h1 + h2 + d) / 2;
//             ans = Math.max(ans, peak);
//         }
//         return (int)ans;
//     }
// }

class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        Arrays.sort(restrictions, (a, b) -> a[0] - b[0]);
        int len = restrictions.length + 2;
        int[][] arr = new int[len][2];
        arr[0][0] = 1;
        arr[0][1] = 0;
        arr[len-1][0] = n;
        arr[len-1][1] = n-1;
        for(int i = 1; i<len-1; ++i){
            arr[i] = restrictions[i-1];
        }
        
        for(int i = 0; i<len-1; ++i){
            arr[i+1][1] = Math.min(arr[i+1][1], arr[i][1] + (arr[i+1][0] - arr[i][0]));
        }
        
        for(int i = len-1; i>0; --i){
            arr[i-1][1] = Math.min(arr[i-1][1], arr[i][1] + (arr[i][0] - arr[i-1][0]));
        }
        int max = 0;
        for(int i = 0; i<len-1; ++i){
            int x1 = arr[i][0], h1 = arr[i][1], x2 = arr[i+1][0], h2 = arr[i+1][1];            
            int diff = Math.max(h1, h2) - Math.min(h1, h2);
            x1 += diff;
            max = Math.max(max, Math.max(h1, h2) + (x2 - x1)/2);
        }
        
        return max;
    }
}