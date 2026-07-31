// class Solution {
//     public int minimumPushes(String word) {
//         int n = word.length();
//         Map<Character, Integer> map = new HashMap<>();
//         for(char c : word.toCharArray()) map.put(c, map.getOrDefault(c, 0)+1);
//         List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
//         list.sort((entry1, entry2)->entry2.getValue().compareTo(entry1.getValue()));
//         int result = 0;
//         int count = 0;
//         int freq = 1;
//         for(int i=0; i<list.size(); i++){
//             result = result + freq*list.get(i).getValue();
//             count++;
//             if(count % 8 == 0) freq++;
//         }
//         return result;
//     }
// }


class Solution {
    public int minimumPushes(String word) {
        int ans=0;
        int[] freq=new int[26];
        int n=word.length();
        for(int ch : word.toCharArray()) freq[ch-'a']++;
        Arrays.sort(freq);
        for(int i=25;i>=0;i--){
            ans+=freq[i]*((25-i)/8+1);
        }
        return ans;
    }
}