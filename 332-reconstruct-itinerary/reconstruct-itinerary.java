// class Solution {
//     public List<String> findItinerary(List<List<String>> tickets) {
//         Map<String, List<String>> graph=new HashMap<>();
//         for(List<String> ticket : tickets){
//             String from=ticket.get(0);
//             String to=ticket.get(1);
//             graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
//         }

//         for(List<String> destination : graph.values()){
//             Collections.sort(destination);
//         }
//         LinkedList<String> itinery=new LinkedList<>();
//         dfs("JFK", graph, itinery);
//         return itinery;
//     }

//     private static void dfs(String airport, Map<String, List<String>> graph, LinkedList<String> itinery){
//         List<String> destinations= graph.get(airport);
//         while(destinations!=null && !destinations.isEmpty()){
//             String next=destinations.remove(0);
//             dfs(next, graph, itinery);
//         }
//         itinery.addFirst(airport);
//     }
// }


// piyush
// class Solution{
//     Map<String, PriorityQueue<String>> map = new HashMap<>();
//     LinkedList<String> result = new LinkedList<>();
//     public List<String> findItinerary(List<List<String>> tickets){
//         for(List<String> t : tickets){
//             map.computeIfAbsent(t.get(0), k -> new PriorityQueue<>()).add(t.get(1));
//         }
//         dfs("JFK");
//         return result;
//     }
    
//     private void dfs(String src){
//         PriorityQueue<String> pq=map.get(src);
//         while(pq!=null && !pq.isEmpty()){
//             dfs(pq.poll());
//         }
//         result.addFirst(src);
//     }
// }


class Solution{
    Map<String, PriorityQueue<String>> graph=new HashMap<>();
    LinkedList<String> result=new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets){
        for(List<String> t : tickets){
            graph.computeIfAbsent(t.get(0), k -> new PriorityQueue<>()).add(t.get(1));
        }
        dfs("JFK");
        return result;
    }
    private void dfs(String src){
        PriorityQueue<String> pq = graph.get(src);
        while(pq != null && !pq.isEmpty()){
            dfs(pq.poll());
        }
        result.addFirst(src);
    }
}