class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones){
            pq.add(stone);
        }
        while(pq.size()>1){
            int max=pq.remove();
            int smax=pq.remove();
            int nStone=max-smax;
            if(nStone!=0){
                pq.add(nStone);
            }
        }    
        if(pq.size()==0){
            return 0;
        }
        else{
           return pq.remove();
        }   
    }
}