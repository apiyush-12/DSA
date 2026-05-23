class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastOcc = new int[26];
        for(int i=0; i<s.length(); i++){
            lastOcc[s.charAt(i)-'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int partitionStart = 0, partitionEnd = 0;
        for(int i=0; i<s.length(); i++){
            partitionEnd = Math.max(partitionEnd, lastOcc[s.charAt(i)-'a']);

            if(i == partitionEnd){
                result.add(partitionEnd-partitionStart + 1);
                partitionStart = i+1;
            }
        }
        return result;
    }
}