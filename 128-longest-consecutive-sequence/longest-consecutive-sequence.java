// class Solution {
    // public int longestConsecutive(int[] nums) {
    //     HashMap<Integer, Boolean> hm = new HashMap<>();
    //     for(int i=0; i<nums.length; i++){
    //         hm.put(nums[i], false);
    //     }
    //     for(int key : hm.keySet()){
    //         if(hm.containsKey(key-1)==false){
    //             hm.put(key,true);
    //         }
    //     }
    //     int max=0;
    //     for(int key : hm.keySet()){
    //         int k=1;
    //         if(hm.get(key)==true){
    //             while(hm.containsKey(key+k)==true){
    //                 k++;
    //             }
    //         }
    //         max=Math.max(max, k);
    //     }
    //     return max;
    // }

    // piyush //
//     public int longestConsecutive(int[] nums){
//         HashMap<Integer, Boolean> hm=new HashMap<>();
//         for(int i=0; i<nums.length; i++){
//             hm.put(nums[i], false);
//         }
//         for(int key : hm.keySet()){
//             if(hm.containsKey(key-1)==false){
//                 hm.put(key, true);
//             }
//         }
//         int max=0;
//         for(int key : hm.keySet()){
//             int k=1;
//             if(hm.get(key)==true){
//                 while(hm.containsKey(key+k)==true){
//                     k++;
//                 }
//             }
//             max=Math.max(max, k);
//         }
//         return max;
//     }
// }

// 2nd Sol
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int count =1;
        int lng=1;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]+1==nums[i+1]){
            count ++;
            }
            else if( nums[i]!=nums[i+1]){
              lng=Math.max(lng,count);
              count=1;
            }
        }
    lng=Math.max(lng,count);
              return lng;
    }
}