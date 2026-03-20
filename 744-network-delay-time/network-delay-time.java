// class Solution {
//     public int networkDelayTime(int[][] times, int n, int k) {
//         Map<Integer, List<int[]>> graph = new HashMap<>();
//         for(int[] edge : times){
//             graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
//         }
//         PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
//         pq.offer(new int[]{k, 0});
//         int[] distances = new int[n+1];
//         Arrays.fill(distances, Integer.MAX_VALUE);
//         distances[k]=0;
//         while(!pq.isEmpty()){
//             int[] current = pq.poll();
//             int currentNode = current[0];
//             int currentDist = current[1];
//             if(currentDist > distances[currentNode]){
//                 continue;
//             }
//             if(graph.containsKey(currentNode)){
//                 for(int[] neighbor : graph.get(currentNode)){
//                     int nextNode = neighbor[0];
//                     int nextDist = currentDist + neighbor[1];
//                     if(nextDist < distances[nextNode]){
//                         distances[nextNode]=nextDist;
//                         pq.offer(new int[]{nextNode, nextDist});
//                     }
//                 }
//             }
//         }
//         int maxDist = Arrays.stream(distances).skip(1).max().getAsInt();
//         return maxDist==Integer.MAX_VALUE ? -1 : maxDist;
//     }
// }


//piyush
// class Solution{
//     static class Pair{
//         int node, weight;
//         Pair(int node, int weight){
//             this.node=node;
//             this.weight=weight;
//         }
//     }
//     public int networkDelayTime(int[][] times, int n, int k){
//         ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
//         for(int i=0; i<=n; i++){
//             adj.add(new ArrayList<>());
//         }
//         for(int[] t : times){
//             int u=t[0], v=t[1], w=t[2];
//             adj.get(u).add(new Pair(v, w));
//         }
//         PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
//         int[] dist = new int[n+1];
//         Arrays.fill(dist, Integer.MAX_VALUE);
//         dist[k]=0;

//         pq.offer(new Pair(k, 0));
//         boolean[] visited = new boolean[n+1];

//         while(!pq.isEmpty()){
//             Pair curr = pq.poll();
//             int u = curr.node;

//             if(visited[u]) continue;
//             visited[u]=true;
//             for(Pair neigh : adj.get(u)){
//                 int v = neigh.node;
//                 int w = neigh.weight;
//                 if(dist[u] + w < dist[v]){
//                     dist[v]= dist[u]+w;
//                     pq.offer(new Pair(v, dist[v]));
//                 }
//             }
//         }
//         int ans=0; 
//         for(int i=1; i<=n; i++){
//             if(dist[i] == Integer.MAX_VALUE) return -1;
//             ans=Math.max(ans, dist[i]);
//         }
//         return ans;
//     }
// }



// piyush
class Solution{
    static class Pair{
        int node, weight;
        Pair(int node, int weight){
            this.node=node;
            this.weight=weight;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] t : times){
            int u=t[0], v=t[1], w=t[2];
            adj.get(u).add(new Pair(v, w));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k]=0;
        pq.offer(new Pair(k, 0));
        boolean[] visited = new boolean[n+1];
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int u=curr.node;
            if(visited[u]) continue;
            visited[u]=true;
            for(Pair neigh : adj.get(u)){
                int v = neigh.node;
                int w = neigh.weight;
                if(dist[u] + w < dist[v]){
                    dist[v]=dist[u]+w;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }
        int ans=0; 
        for(int i=1; i<=n; i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            ans= Math.max(ans, dist[i]);
        }
        return ans;
    }
}