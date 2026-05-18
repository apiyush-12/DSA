// class Solution {
//     public boolean isNStraightHand(int[] hand, int groupSize) {
//         if(hand.length % groupSize != 0) return false;
//         TreeMap <Integer, Integer> cardCounts = new TreeMap<>();
//         for(int card : hand){
//             cardCounts.put(card, cardCounts.getOrDefault(card, 0) + 1);
//         }
//         while(!cardCounts.isEmpty()){
//             int first = cardCounts.firstKey();
//             for(int i=0; i<groupSize; i++){
//                 int currCard = first + i;
//                 if(!cardCounts.containsKey(currCard)) return false;
//                 int count = cardCounts.get(currCard);
//                 if(count == 1){
//                     cardCounts.remove(currCard);
//                 }else{
//                     cardCounts.put(currCard, count-1);
//                 }
//             }
//         }
//         return true;
//     }
// }


// class Solution {
//     public boolean isNStraightHand(int[] hand, int groupSize) {
//         int n = hand.length;
//         if(n%groupSize!=0){
//             return false;
//         }
//         HashMap<Integer,Integer> freq = new HashMap<>();
//         for(int num : hand){
//             freq.put(num,freq.getOrDefault(num,0)+1);
//         }
//         Arrays.sort(hand);
//         for(int num : hand){
//             if(freq.get(num)==0){
//                 continue;
//             }
//             for(int j=0;j<groupSize;j++){
//                 int cur =  num + j;
//                 if(freq.getOrDefault(cur,0)==0){
//                     return false;
//                 }
//                 freq.put(cur,freq.get(cur)-1);
//             }
//         }
//         return true;
//     }
// }

// piyush
class Solution{
    public boolean isNStraightHand(int[] hand, int groupSize){
        int n = hand.length;
        if(n % groupSize != 0) return false;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num : hand){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(hand);
        for(int num : hand){
            if(freq.get(num) == 0) continue;
            for(int j=0; j<groupSize; j++){
                int curr = num + j;
                if(freq.getOrDefault(curr, 0) == 0) return false;
                freq.put(curr, freq.get(curr)-1);
            }
        }
        return true;
    }
}