class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        boolean[] inMST= new boolean[n];
        pq.offer(new Point(0, 0));

        int minCost=0;
        int pointsConnected=0;
        while(pointsConnected < n){
            Point current = pq.poll();
            if(inMST[current.index]){
                continue;
            }
            inMST[current.index]=true;
            minCost += current.distance;
            pointsConnected++;

            for(int i=0; i<n; i++){
                if(!inMST[i]){
                    int distance=Math.abs(points[current.index][0]-points[i][0]) + Math.abs(points[current.index][1] - points[i][1]);
                    pq.offer(new Point(i, distance));
                }
            }
        }
        return minCost;
    }

    static class Point{
        int index;
        int distance;
        Point(int index, int distance){
            this.index=index;
            this.distance=distance;
        }
    }
}