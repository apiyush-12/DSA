class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int LEFT_MASK = 0b0000011110;
        int MIDDLE_MASK = 0b0001111000;
        int LAST_MASK = 0b0111100000;
        Map<Integer, Integer> reserved = new HashMap<>();
        for(int[] seat : reservedSeats){
            int row = seat[0];
            int seatNum = seat[1];
            reserved.put(row, reserved.getOrDefault(row, 0)|(1 << (seatNum -1)));
        }
        int result = (n - reserved.size())*2;
        for(int mask : reserved.values()){
            boolean canLeft = (mask & LEFT_MASK) == 0;
            boolean canMiddle = (mask & MIDDLE_MASK) == 0;
            boolean canRight = (mask & LAST_MASK) == 0;
            if(canLeft && canRight) result += 2;
            else if(canLeft || canMiddle || canRight) result += 1;
        }
        return result;
    }
}
