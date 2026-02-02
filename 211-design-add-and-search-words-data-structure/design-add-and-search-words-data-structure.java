// class TrieNode{
//     Map<Character, TrieNode> children=new HashMap<>();
//     boolean word = false;
//     public TrieNode(){}
// }

// class WordDictionary {
//     TrieNode trie;
//     public WordDictionary() {
//         trie=new TrieNode();
//     }
    
//     public void addWord(String word) {
//         TrieNode node=trie;
//         for(char ch: word.toCharArray()){
//             if(!node.children.containsKey(ch)){
//                 node.children.put(ch, new TrieNode());
//             }
//             node=node.children.get(ch);
//         }
//         node.word=true;
//     }
//     public boolean searchInNode(String word, TrieNode node){
//         for(int i=0; i<word.length(); i++){
//             char ch=word.charAt(i);
//             if(!node.children.containsKey(ch)){
//                 if(ch=='.'){
//                     for(char x : node.children.keySet()){
//                         TrieNode child=node.children.get(x);
//                         if(searchInNode(word.substring(i+1), child)){
//                             return true;
//                         }
//                     }
//                 }else{
//                     return false;
//                 }
//             }else{
//                 node=node.children.get(ch);
//             }
//         }
//         return node.word;
//     }
//     public boolean search(String word) {
//         return searchInNode(word, trie);
//     }
// }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */


 class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean word = false;
}

class WordDictionary {
    TrieNode trie;

    public WordDictionary() {
        trie = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = trie;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.word = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, trie);
    }

    private boolean dfs(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.word;
        }

        char ch = word.charAt(index);

        // Case 1: Wildcard '.'
        if (ch == '.') {
            for (TrieNode child : node.children.values()) {
                if (dfs(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        }

        // Case 2: Normal character
        if (!node.children.containsKey(ch)) {
            return false;
        }

        return dfs(word, index + 1, node.children.get(ch));
    }
}
