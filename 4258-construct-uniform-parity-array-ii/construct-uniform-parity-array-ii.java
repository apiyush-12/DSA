// class Solution {
//     public boolean uniformArray(int[] nums1) {
//         int minOdd = Integer.MAX_VALUE;
//         for(int num : nums1){
//             if(num % 2 != 0) minOdd = Math.min(minOdd, num);
//         }
//         if(minOdd == Integer.MAX_VALUE) return true;
//         for(int num : nums1){
//             if(num % 2 == 0 && num <= minOdd) return false;
//         }
//         return true;
//     }
// }



// class Solution{
//     public boolean uniformArray(int[] nums1){
//         int min = Integer.MAX_VALUE;
//         boolean allEven = true;
//         for(int num : nums1){
//             min = Math.min(min, num);
//             if(num % 2 == 1) allEven = false;
//         }
//         return allEven || min % 2 == 1;
//     }
// }


class Solution{
    public boolean uniformArray(int[] nums1){
        int min = Integer.MAX_VALUE;
        boolean allEven = true;
        for(int num : nums1){
            min = Math.min(min, num);
            if(num % 2 == 1) allEven = false;
        }
        return allEven || min % 2 == 1;
    }
}