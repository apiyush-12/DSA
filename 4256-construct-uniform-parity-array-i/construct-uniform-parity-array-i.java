// class Solution {
//     public boolean uniformArray(int[] nums1) {
//         return true;
//     }
// }



class Solution{
    public boolean uniformArray(int[] nums1){
        int odd = 0;
        int even = 0;
        for(int a : nums1){
            if(a % 2 == 0) even++ ;
            else odd++;
        }
        if(even == nums1.length || odd == nums1.length) return true;
        return true;
    }
}