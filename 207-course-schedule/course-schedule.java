// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         HashMap<Integer, List<Integer>> courseGraph = new HashMap<>();
//         for(int[] pre : prerequisites){
//             if(courseGraph.containsKey(pre[1])){
//                 courseGraph.get(pre[1]).add(pre[0]);
//             }else{
//                 List<Integer> nextCourses=new LinkedList<>();
//                 nextCourses.add(pre[0]);
//                 courseGraph.put(pre[1],nextCourses);
//             }
//         }
//         HashSet<Integer> visited = new HashSet<>();
//         for(int currCourse=0; currCourse<numCourses; currCourse++){
//             if(courseSchedule(currCourse, visited, courseGraph)==false){
//                 return false;
//             }
//         }
//         return true;
//     }
//     public boolean courseSchedule(int course, HashSet<Integer> visited, HashMap<Integer, List<Integer>> courseGraph){
//         if(visited.contains(course)){
//             return false;
//         }
//         if(courseGraph.get(course)==null){
//             return true;
//         }
//         visited.add(course);
//         for(int pre : courseGraph.get(course)){
//             if(courseSchedule(pre, visited, courseGraph)==false){
//                 return false;
//             }
//         }
//         visited.remove(course);
//         courseGraph.put(course, null);
//         return true;
//     }
// }


// piyush
// class Solution{
//     public boolean canFinish(int numCourses, int[][] prerequisites){
//         ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
//         for(int i=0; i<numCourses; i++){
//             adj.add(new ArrayList<>());
//         }
//         for(int[] e : prerequisites){
//             adj.get(e[1]).add(e[0]);
//         }
//         int[] state = new int[numCourses];
//         for(int i=0; i<numCourses; i++){
//             if(state[i]==0){
//                 if(dfs(i, adj, state)){
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
//     public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] state){
//         if(state[node]==1) return true;
//         if(state[node]==2) return false;
//         state[node]=1;
//         for(int neigh : adj.get(node)){
//             if(dfs(neigh, adj, state)) return true;
//         }
//         state[node]=2;
//         return false;
//     }
// }

class Solution{
    public boolean canFinish(int numCourses, int[][] prerequisites){
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : prerequisites){
            adj.get(e[1]).add(e[0]);
        }
        int[] state=new int[numCourses];
        for(int i=0; i<numCourses; i++){
            if(state[i]==0){
                if(dfs(i, adj, state)) return false;
            }
        }
        return true;
    }
    private boolean dfs(int index, ArrayList<ArrayList<Integer>> adj, int[] state){
        if(state[index]==1) return true;
        if(state[index]==2) return false;
        state[index]=1;
        for(int neigh : adj.get(index)){
            if(dfs(neigh, adj, state)) return true;
        }
        state[index]=2;
        return false;
    }
}