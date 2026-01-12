// class Solution {
//     public int carFleet(int target, int[] position, int[] speed) {
//         int n=position.length;
//         double[][] cars=new double[n][2];
//         for(int i=0; i<n; i++){
//             cars[i][0]=position[i];
//             cars[i][1]=(double)(target-position[i])/speed[i];
//         }
//         Arrays.sort(cars, (a,b)->Double.compare(b[0], a[0]));
//         int count=0;
//         double prevTime=0;
//         for(double[] car: cars){
//             if(car[1]>prevTime){
//                 count++;
//                 prevTime=car[1];
//             }
//         }
//         return count;
//     }
// }


class Solution{
    public int carFleet(int target, int[] position, int[] speed){
        HashMap<Integer, Integer> hs=new HashMap<>();
        int n=position.length;
        Stack<Double> st=new Stack<>();
        for(int i=0; i<n; i++){
            hs.put(position[i],speed[i]);
        }
        Arrays.sort(position);
        for(int i=n-1; i>=0; i--){
            double time=((double)target-position[i])/(hs.get(position[i]));
            if(st.isEmpty() || time> st.peek()){
                st.add(time);
            }
        }
        return st.size();
    }
}
