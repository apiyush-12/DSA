// class Solution {
//     public String evaluate(String s, List<List<String>> knowledge) {
//         Map<String, String> map = new HashMap<>();
//         for(List<String> pair : knowledge){
//             map.put(pair.get(0), pair.get(1));
//         }
//         StringBuilder result = new StringBuilder();
//         int i = 0;
//         while(i < s.length()){
//             if(s.charAt(i) == '('){
//                 int j = i+1;
//                 while(s.charAt(j) != ')') j++;
//                 String key = s.substring(i+1, j);
//                 result.append(map.getOrDefault(key, "?"));
//                 i = j+1;
//             }else{
//                 result.append(s.charAt(i));
//                 i++;
//             }
//         }
//         return result.toString();
//     }
// }

// class Solution {
//     public String evaluate(String s, List<List<String>> knowledge) {
//         Map<String, String> map = new HashMap<>();
//         for (List<String> pair : knowledge) {
//             map.put(pair.get(0), pair.get(1));
//         }
//         StringBuilder result = new StringBuilder();
//         int i = 0;
//         while (i < s.length()) {
//             if (s.charAt(i) == '(') {
//                 int j = i + 1;
//                 while (s.charAt(j) != ')')
//                     j++;
//                 String key = s.substring(i + 1, j);
//                 result.append(map.getOrDefault(key, "?"));
//                 i = j + 1;
//             } else {
//                 result.append(s.charAt(i));
//                 i++;
//             }
//         }
//         return result.toString();
//     }
// }


class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> values = new HashMap<>();
        for (List<String> entry : knowledge) {
            values.put(entry.get(0), entry.get(1));
        }

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                int start = ++i;
                while (s.charAt(i) != ')') {
                    i++;
                }
                String key = s.substring(start, i);
                result.append(values.getOrDefault(key, "?"));
                i++;
            } else {
                result.append(s.charAt(i++));
            }
        }

        return result.toString();
    }
}