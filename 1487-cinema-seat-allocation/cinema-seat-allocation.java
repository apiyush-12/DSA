// class Solution {
//     public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
//         int LEFT_MASK = 0b0000011110;
//         int MIDDLE_MASK = 0b0001111000;
//         int LAST_MASK = 0b0111100000;
//         Map<Integer, Integer> reserved = new HashMap<>();
//         for(int[] seat : reservedSeats){
//             int row = seat[0];
//             int seatNum = seat[1];
//             reserved.put(row, reserved.getOrDefault(row, 0)|(1 << (seatNum -1)));
//         }
//         int result = (n - reserved.size())*2;
//         for(int mask : reserved.values()){
//             boolean canLeft = (mask & LEFT_MASK) == 0;
//             boolean canMiddle = (mask & MIDDLE_MASK) == 0;
//             boolean canRight = (mask & LAST_MASK) == 0;
//             if(canLeft && canRight) result += 2;
//             else if(canLeft || canMiddle || canRight) result += 1;
//         }
//         return result;
//     }
// }


class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> reserved = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            if (col >= 2 && col <= 9) {
                reserved.put(row, reserved.getOrDefault(row, 0) | (1 << col));
            }
        }
        int answer = (n - reserved.size()) * 2;
        for (int mask : reserved.values()) {
            boolean left = true;   // seats 2-5
            boolean middle = true; // seats 4-7
            boolean right = true;  // seats 6-9
            // Check seats 2,3,4,5
            for (int seat = 2; seat <= 5; seat++) {
                if ((mask & (1 << seat)) != 0) {
                    left = false;
                    break;
                }
            }
            // Check seats 4,5,6,7
            for (int seat = 4; seat <= 7; seat++) {
                if ((mask & (1 << seat)) != 0) {
                    middle = false;
                    break;
                }
            }
            // Check seats 6,7,8,9
            for (int seat = 6; seat <= 9; seat++) {
                if ((mask & (1 << seat)) != 0) {
                    right = false;
                    break;
                }
            }

            if (left && right) {
                answer += 2;
            } else if (left || middle || right) {
                answer += 1;
            }
        }

        return answer;
    }
}