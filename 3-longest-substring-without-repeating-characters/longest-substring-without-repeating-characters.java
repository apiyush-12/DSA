class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        int left=0;
        int right=0;
        int ans=0;
        HashSet <Character> set=new HashSet<>();
        while(right<s.length()){
            char ch=s.charAt(right);
            while(set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            ans=Math.max(ans, right-left+1);
            right++;
        }
        return ans;
    }
}


// class Solution{
//     public int lengthOfLongestSubstring(String s){
//         HashMap<Character, Integer> map=new HashMap<>();
//         int left=0;
//         int ans=0;
//         for(int right=0; right<s.length(); right++){
//             char ch=s.charAt(right);
//             if(map.containsKey(ch)){
//                 left=Math.max(left, map.get(ch)+1);
//             }
//             map.put(ch, right);
//             ans=Math.max(ans, right-left+1);
//         }
//         return ans;
//     }
// }