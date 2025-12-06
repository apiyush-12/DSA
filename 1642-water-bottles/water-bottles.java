class Solution {
    // public int numWaterBottles(int numBottles, int numExchange) {
    //     int Total= numBottles;
    //     while(numBottles>=numExchange){
    //         int newBottles=numBottles/numExchange;
    //         int remBottles=numBottles%numExchange;
    //         Total=Total+newBottles;
    //         numBottles=newBottles+remBottles;
    //     }
    //     return Total;
    // }

    // piyush
    public int numWaterBottles(int numBottles, int numExchange){
        int Total=numBottles;
        while(numBottles>=numExchange){
            int newBottles=numBottles/numExchange;
            int remBottles=numBottles%numExchange;
            Total=Total+newBottles;
            numBottles=newBottles+remBottles;
        }
        return Total;
    }
}