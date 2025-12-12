class Solution {
    // public int majorityElement(int[] nums) {
    //     int n=nums.length;
    //     HashMap<Integer, Integer> map=new HashMap<>();
    //     for(int i=0; i<n; i++){
    //         if(map.containsKey(nums[i])){
    //             map.put(nums[i], map.get(nums[i])+1);
    //         }else{
    //             map.put(nums[i], 1);
    //         }
    //     }
    //     for(Map.Entry<Integer, Integer> entry: map.entrySet()){
    //         if(entry.getValue() > n/2){
    //             return entry.getKey();
    //         }
    //     }
    //     return 0;
    // }


    // piyush
    public int majorityElement(int[] nums){
        int count=0;
        int candidate=0;
        for(int num : nums){
            if(count==0){
                candidate=num;
            }
            if(num==candidate){
                count++;
            }else{
                count--;
            }
        }
        return candidate;
    }
}

// piyush
// class Solution{
//     public int majorityElement(int[] nums){
//         int party=0;
//         int voters=0;
//         for(int num : nums){
//             if(voters==0){
//                 party=num;
//             }
//             if(num==party){
//                 voters++;
//             }else{
//                 voters--;
//             }
//         }
//         return party;
//     }
// }