// class Solution {
//     public int[][] kClosest(int[][] points, int k) {
//         PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->Integer.compare(b[0]*b[0]+b[1]*b[1], a[0]*a[0]+a[1]*a[1]));
//         for(int[] point: points){
//             pq.add(point);
//             if(pq.size()>k){
//                 pq.poll();
//             }
//         }
//         int[][] result=new int[k][2];
//         for(int i=0; i<k; i++){
//             result[i]=pq.poll();
//         }
//         return result;
//     }
// }

class Solution{
    public int[][] kClosest(int[][] points, int k){
        PriorityQueue<int[]> pq=new PriorityQueue<>(k,new Comparator<int[]>(){
        public int compare(int[]a, int[]b){
            return ((b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]));
        }
        });
        for(int[] point: points){
            pq.add(point);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.toArray(new int[0][0]);
    }
}