// class Solution {
//     public int[] resultArray(int[] nums) {
//         int n = nums.length;
//         List<Integer> list1 = new ArrayList<>();
//         List<Integer> list2 = new ArrayList<>();
//         list1.add(nums[0]);
//         list2.add(nums[1]);
//         for(int i=2; i<n; i++){
//             if(list1.get(list1.size()-1) > list2.get(list2.size()-1)) list1.add(nums[i]);
//             else list2.add(nums[i]);
//         }
//         int[] res = new int[n];
//         int index = 0;
//         for(int num : list1) res[index++] = num;
//         for(int num : list2) res[index++] = num;
//         return res;
//     }
// }


// class Solution {
//     public int[] resultArray(int[] nums) {
//         ArrayList<Integer> a=new ArrayList<>();
//         ArrayList<Integer> b=new ArrayList<>();
//         a.add(nums[0]);
//         b.add(nums[1]);
//         for(int i=2;i<nums.length;i++){
//             if(a.get(a.size()-1)>b.get(b.size()-1)) a.add(nums[i]);
//             else b.add(nums[i]);
//         }
//         int i=0;
//         for(int k=0;k<a.size();k++) {
//             nums[i]=a.get(k);
//             i++;
//         }
//         for(int k=0;k<b.size();k++){
//             nums[i]=b.get(k);
//             i++;
//         }
//         return nums;

//     }
// }


class Solution{
    public int[] resultArray(int[] nums){
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        int n = nums.length;
        a.add(nums[0]);
        b.add(nums[1]);
        for(int i=2; i<n; i++){
            if(a.get(a.size()-1) > b.get(b.size()-1)) a.add(nums[i]);
            else b.add(nums[i]);
        }
        int i=0;
        int[] ans = new int[n];
        for(int k=0; k<a.size(); k++){ 
            ans[i++] = a.get(k);
        }
        for(int k=0; k<b.size(); k++){
            ans[i++] = b.get(k);
        }
        return ans;
    }
}