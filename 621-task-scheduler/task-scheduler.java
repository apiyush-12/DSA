class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap=new HashMap<>();
        for(char task : tasks){
            freqMap.put(task, freqMap.getOrDefault(task, 0) +1);
        }

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        pq.addAll(freqMap.values());
        int time=0;
        while(!pq.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<n+1; i++){
                if(!pq.isEmpty()){
                    temp.add(pq.poll());
                }
            }
            for(int freq : temp){
                if(--freq>0){
                    pq.add(freq);
                }
            }
            time +=pq.isEmpty() ? temp.size() : n+1;
        }
        return time;
    }
}