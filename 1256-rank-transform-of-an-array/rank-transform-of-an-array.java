// class Solution {
//     public int[] arrayRankTransform(int[] arr) {
//         int n = arr.length;
//         if(n==0) return new int[]{};
//         int[][] temp = new int[n][2];
//         for(int i=0; i<n; i++){
//             temp[i][0] = arr[i];
//             temp[i][1] = i;
//         }
//         Arrays.sort(temp, (a, b) -> Integer.compare(a[0], b[0]));
//         int[] ans = new int[n];
//         int rank = 1, prev = temp[0][0], ind = temp[0][1];
//         ans[ind] = 1;
//         for(int i=1; i<n; i++){
//             int idx = temp[i][1], val = temp[i][0];
//             if(prev != val) rank++;
//             ans[idx] = rank;
//             prev = val;
//         }
//         return ans;
//     }
// }


class Solution{
    public int[] arrayRankTransform(int[] arr){
        int n = arr.length;
        int[] sort = new int[n];
        for(int i=0; i<n; i++){
            sort[i] = arr[i];
        }

        Arrays.sort(sort);
        HashMap<Integer, Integer> map = new HashMap<>();
        int i=1;
        
        for(int e : sort){
            if(!map.containsKey(e)) map.put(e, i++);
        }

        for(int k=0; k<n; k++) arr[k] = map.get(arr[k]);
        return arr;
    }
}