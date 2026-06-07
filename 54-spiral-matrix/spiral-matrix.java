// class Solution {
//     public List<Integer> spiralOrder(int[][] matrix) {
//         int visited = 101;
//         int rows = matrix.length;
//         int columns = matrix[0].length;

//         int row = 0, col = 0;
//         int[][] dir = {{0,1}, {1, 0}, {0, -1}, {-1, 0}};
//         int currentdirection = 0, changedirection = 0;
//         List<Integer> ans = new ArrayList<>();
//         ans.add(matrix[0][0]);
//         matrix[0][0] = visited;
//         while(changedirection < 2){
//             while(row + dir[currentdirection][0] >= 0 &&
//                   col + dir[currentdirection][1] >= 0 &&
//                   row + dir[currentdirection][0] < rows &&
//                   col + dir[currentdirection][1] < columns &&
//                   matrix[row + dir[currentdirection][0]][col + dir[currentdirection][1]] != visited){

//                 changedirection = 0;
//                 row = row + dir[currentdirection][0];
//                 col = col + dir[currentdirection][1];
//                 ans.add(matrix[row][col]);
//                 matrix[row][col] = visited;
//             }
//             currentdirection = (currentdirection + 1) % 4;
//             changedirection++;
//         }
//         return ans;
//     }
// }


// piyush
class Solution{
    public List<Integer> spiralOrder(int[][] matrix){
        int visited = 101;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = 0, col = 0;
        int[][] dir = {{0,1}, {1, 0}, {0, -1}, {-1, 0}};
        int currentdirection = 0, changedirection = 0;
        List<Integer> ans = new ArrayList<>();
        ans.add(matrix[0][0]);
        matrix[0][0] = visited;
        while(changedirection < 2){
            while(row + dir[currentdirection][0] >= 0 &&
                  col + dir[currentdirection][1] >= 0 &&
                  row + dir[currentdirection][0] < rows &&
                  col + dir[currentdirection][1] < columns &&
                  matrix[row + dir[currentdirection][0]][col + dir[currentdirection][1]] != visited){
                
                changedirection = 0;
                row = row + dir[currentdirection][0];
                col = col + dir[currentdirection][1];
                ans.add(matrix[row][col]);
                matrix[row][col] = visited;
            }
            currentdirection = (currentdirection + 1) % 4;
            changedirection++;
        }
        return ans;
    }
}