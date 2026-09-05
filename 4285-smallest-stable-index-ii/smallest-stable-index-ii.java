class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];

        prefixMax[0] = nums[0];
        for(int i=1; i<n; i++){
            prefixMax[i] = Math.max(nums[i], prefixMax[i-1]);
        }

        suffixMin[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--){
            suffixMin[i] = Math.min(suffixMin[i+1], nums[i]);
        }

        for(int i=0; i<n; i++){
            if(prefixMax[i] - suffixMin[i] <= k) return i;
        }
        return -1;
    }
}

// class Solution { 
//     public int firstStableIndex(int[] nums, int k) { 
//         int n = nums.length; 
//         int[] min = new int[n]; 
//         min[n-1] = nums[n-1]; 
//         for(int i=1; i<n; i++){ 
//             min[n-i-1] = Math.min(nums[n-i-1], min[n-i]); 
//         } 
//         int max = nums[0]; 
//         for(int i=0; i<n; i++){ 
//             max = Math.max(max, nums[i]); 
//             int num = max - min[i]; 
//             if(num <= k) return i; 
//         } 
//         return -1; 
//     } 
// }