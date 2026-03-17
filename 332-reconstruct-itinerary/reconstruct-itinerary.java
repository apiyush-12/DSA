class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> graph=new HashMap<>();
        for(List<String> ticket : tickets){
            String from=ticket.get(0);
            String to=ticket.get(1);
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        }

        for(List<String> destination : graph.values()){
            Collections.sort(destination);
        }
        LinkedList<String> itinery=new LinkedList<>();
        dfs("JFK", graph, itinery);
        return itinery;
    }

    private static void dfs(String airport, Map<String, List<String>> graph, LinkedList<String> itinery){
        List<String> destinations= graph.get(airport);
        while(destinations!=null && !destinations.isEmpty()){
            String next=destinations.remove(0);
            dfs(next, graph, itinery);
        }
        itinery.addFirst(airport);
    }
}