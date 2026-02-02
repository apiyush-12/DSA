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


//  class TrieNode {
//     Map<Character, TrieNode> children = new HashMap<>();
//     boolean word = false;
// }

// class WordDictionary {
//     TrieNode trie;

//     public WordDictionary() {
//         trie = new TrieNode();
//     }

//     public void addWord(String word) {
//         TrieNode node = trie;
//         for (char ch : word.toCharArray()) {
//             node.children.putIfAbsent(ch, new TrieNode());
//             node = node.children.get(ch);
//         }
//         node.word = true;
//     }

//     public boolean search(String word) {
//         return dfs(word, 0, trie);
//     }

//     private boolean dfs(String word, int index, TrieNode node) {
//         if (index == word.length()) {
//             return node.word;
//         }

//         char ch = word.charAt(index);

//         // Case 1: Wildcard '.'
//         if (ch == '.') {
//             for (TrieNode child : node.children.values()) {
//                 if (dfs(word, index + 1, child)) {
//                     return true;
//                 }
//             }
//             return false;
//         }

//         // Case 2: Normal character
//         if (!node.children.containsKey(ch)) {
//             return false;
//         }

//         return dfs(word, index + 1, node.children.get(ch));
//     }
// }


class WordDictionary {
    private class Trie{
        Trie links[];
        boolean flag;
        Trie(){
            links = new Trie[26];
            flag = false;
        }
        boolean containsChar(char c){
            return links[c-'a']!=null;
        }
        void put(char c,Trie node){
            links[c-'a'] = node;
        }
        Trie get(char c){
            return links[c-'a'];
        }
    }
    Trie solve;
    String search;
    public WordDictionary() {
        solve = new Trie();
        search = "";
    }
    
    public void addWord(String word) {
        Trie node = solve;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!node.containsChar(c))
                node.put(c,new Trie());
            node = node.get(c);
        }
        node.flag = true;
    }
    
    public boolean search(String word) {
        search = word;
        return searchWord(solve,0);
    }

    private boolean searchWord(Trie node, int indx) {
        if (indx == search.length())
            return node.flag;

        char c = search.charAt(indx);

        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.links[i] != null) {
                    if (searchWord(node.links[i], indx + 1))
                        return true;
                }
            }
            return false;
        }
        if (!node.containsChar(c))
            return false;
            
        return searchWord(node.get(c), indx + 1);
    }
}