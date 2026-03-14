// class Solution {
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         int L=beginWord.length();
//         Map<String, List<String>> allComboDict=new HashMap();
//         wordList.forEach(word -> {
//             for(int i=0; i<L; i++){
//                 String newWord=word.substring(0,i)+'*'+ word.substring(i+1, L);
//                 List<String> transformations=allComboDict.getOrDefault(newWord, new ArrayList<>());
//                 transformations.add(word);
//                 allComboDict.put(newWord, transformations);
//             }
//         });
//         Queue<Pair<String, Integer>> Q =new LinkedList<>();
//         Q.add(new Pair(beginWord, 1));
//         Map<String, Boolean> visited = new HashMap<>();
//         visited.put(beginWord, true);
//         while(!Q.isEmpty()){
//             Pair<String, Integer> node = Q.remove();
//             String word=node.getKey();
//             int level=node.getValue();
//             for(int i=0; i< L; i++){
//                 String newWord=word.substring(0,i)+'*'+ word.substring(i+1, L);
//                 for(String adjacentWord: allComboDict.getOrDefault(newWord, new ArrayList<>())){
//                     if(adjacentWord.equals(endWord)){
//                         return level+1;
//                     }
//                     if(!visited.containsKey(adjacentWord)){
//                         visited.put(adjacentWord, true);
//                         Q.add(new Pair(adjacentWord, level+1));
//                     }
//                 }
//             }
//         }
//         return 0;
//     }
// }

class Solution{
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        Set<String> wordSet=new HashSet<>(wordList);
        if(!wordSet.contains(endWord)){return 0;}
        Set<String> beginSet=new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet=new HashSet<>();
        endSet.add(endWord);
        int level=1;
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            if(beginSet.size()>endSet.size()){
                Set<String> temp=beginSet;
                beginSet=endSet;
                endSet=temp;
            }
            Set<String> nextLevel=new HashSet<>();
            for(String word : beginSet){
                char[] chars=word.toCharArray();
                for(int i=0; i<chars.length; i++){
                    char original=chars[i];
                    for(char c='a'; c<='z' ; c++){
                        if(c==original) continue;
                        chars[i]=c;
                        String candidate=new String(chars);
                        if(endSet.contains(candidate)){
                            return level+1;
                        }
                        if(wordSet.contains(candidate)){
                            wordSet.remove(candidate);
                            nextLevel.add(candidate);
                        }
                    }
                    chars[i]=original;
                }
            }
            beginSet=nextLevel;
            level++;
        }
        return 0;
    }
}