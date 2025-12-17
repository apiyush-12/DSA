// class Solution {
//     public List<List<Integer>> generate(int numRows) {
//         List<List<Integer>> ans= new ArrayList<>();
//         ans.add(new ArrayList<>());
//         ans.get(0).add(1);
//         for(int i=1; i<numRows; i++){
//             List<Integer> r= new ArrayList<>();
//             List<Integer> prevList= ans.get(i-1);
//             r.add(1);
//             for(int j=1; j<i; j++){
//                 r.add(prevList.get(j-1)+prevList.get(j));
//             }
//             r.add(1);
//             ans.add(r);
//         }
//         return ans;
//     }
// }

class Solution{
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> ans=new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.get(0).add(1);
        for(int i=1; i<numRows; i++){
            List<Integer> curr=new ArrayList<>();
            List<Integer> prevList=ans.get(i-1);
            curr.add(1);
            for(int j=1; j<i; j++){
                curr.add(prevList.get(j-1)+prevList.get(j));
            }
            curr.add(1);
            ans.add(curr);
        }
        return ans;
    }
}
