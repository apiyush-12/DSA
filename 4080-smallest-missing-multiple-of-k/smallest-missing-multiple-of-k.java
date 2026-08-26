// class Solution {
//     public int missingMultiple(int[] nums, int k) {
//         Set<Integer> set = new HashSet<>();
//         int n = nums.length;
//         for(int i=0; i<n; i++) set.add(nums[i]);
//         int val = 1;
//         while(set.contains(val * k)) val++;
//         return val * k;
//     }
// }

// class Solution {
//     public int missingMultiple(int[] nums, int k) {
//         HashSet<Integer> set = new HashSet<>();
//         for(int i =0;i<nums.length;i++){
//             if(nums[i]%k==0){
//                 set.add(nums[i]);
//             }
//         }
//         for(int j=1;j<=set.size()+1;j++){
//             if(!set.contains(k*j)){
//                 return k*j;
//             }
//         }
//         return 0;
//     }
// }

class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] % k == 0)
                set.add(nums[i]);
        }
        for (int i = 1; i <= set.size() + 1; i++) {
            if (!set.contains(i * k))
                return k * i;
        }
        return 0;
    }
}