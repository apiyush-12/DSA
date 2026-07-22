// class SegmentTree{
//     private int n;
//     private int[] values;
//     private int[] tree;
//     public SegmentTree(int[] values){
//         this.values = values;
//         this.n = values.length;
//         this.tree = new int[4*n];
//         build(1, 0, n-1);
//     }
//     private void build(int node, int left, int right){
//         if(left ==  right){
//             tree[node] = values[left];
//             return;
//         }
//         int mid = (left + right) / 2;
//         build(node*2, left, mid);
//         build(node*2+1, mid + 1, right);

//         tree[node] = Math.max(tree[node*2], tree[node*2+1]);
//     }
//     public int query(int queryLeft, int queryRight){
//         if(queryLeft > queryRight) return 0;
//         return query(1, 0, n-1, queryLeft, queryRight);
//     }
//     private int query(int node, int left, int right, int queryLeft, int queryRight){
//         if(queryLeft <= left && right <= queryRight) return tree[node];
//         int mid = (left+right)/2;
//         int answer =0;
//         if(queryLeft<=mid){
//             answer = Math.max(answer, query(node*2, left, mid, queryLeft, queryRight));
//         }
//         if(queryRight > mid){
//             answer = Math.max(answer, query(node*2+1, mid+1, right, queryLeft, queryRight));
//         }
//         return answer;
//     }
// }
// class Solution {
//     public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
//         int n = s.length();
//         int totalOnes = 0;
//         for(char ch : s.toCharArray()){
//             if(ch == '1') totalOnes++;
//         }
//         List<Integer> zeroBlockLength = new ArrayList<>();
//         List<Integer> zeroBlockStart = new ArrayList<>();
//         List<Integer> zeroBlockEnd = new ArrayList<>();
//         int i=0;
//         while(i<n){
//             int start = i;
//             while(i<n && s.charAt(i) == s.charAt(start)){
//                 i++;
//             }
//             if(s.charAt(start) == '0'){
//                 zeroBlockLength.add(i-start);
//                 zeroBlockStart.add(start);
//                 zeroBlockEnd.add(i-1);
//             }
//         }
//         int blockCount = zeroBlockLength.size();
//         if(blockCount < 2){
//             List<Integer> answer = new ArrayList<>();
//             for(int[] query : queries) answer.add(totalOnes);
//             return answer;
//         }
//         int[] pairSum = new int[blockCount -1];
//         for(int j=0; j<blockCount-1; j++){
//             pairSum[j] = zeroBlockLength.get(j) + zeroBlockLength.get(j+1);
//         }
//         SegmentTree segmentTree = new SegmentTree(pairSum);
//         List<Integer> answer = new ArrayList<>();
//         for(int[] query : queries){
//             int left = query[0];
//             int right = query[1];
//             int firstBlock = lowerBound(zeroBlockEnd, left);
//             int lastBlock = upperBound(zeroBlockStart, right)-1;;
//             if(firstBlock > blockCount-1 || lastBlock < 0 || firstBlock >= lastBlock){
//                 answer.add(totalOnes);
//                 continue;
//             } 
//             int firstLength = zeroBlockEnd.get(firstBlock)-Math.max(zeroBlockStart.get(firstBlock), left)+1;
//             int lastLength = Math.min(zeroBlockEnd.get(lastBlock), right) - zeroBlockStart.get(lastBlock)+1;
//             if(firstBlock+1 == lastBlock){
//                 int bestGain = firstLength+lastLength;
//                 answer.add(totalOnes+bestGain);
//                 continue;
//             }
//             int option1 = firstLength + zeroBlockLength.get(firstBlock+1);
//             int option2 = zeroBlockLength.get(lastBlock-1) + lastLength;
//             int option3 = segmentTree.query(firstBlock+1, lastBlock-2);
//             int bestGain = Math.max(option1, Math.max(option2, option3));
//             answer.add(totalOnes+bestGain);
//         }
//         return answer;
//     }
//     private int lowerBound(List<Integer> list, int target){
//         int left = 0;
//         int right = list.size();
//         while(left < right){
//             int mid = left + (right-left)/2;
//             if(list.get(mid) < target) left = mid+1;
//             else right = mid;
//         }
//         return left;
//     }
//     private int upperBound(List<Integer> list, int target){
//         int left = 0;
//         int right = list.size();
//         while(left < right){
//             int mid = left + (right-left)/2;
//             if(list.get(mid) <= target) left = mid + 1;
//             else right = mid;
//         }
//         return left;
//     }
// }



class Group {
  public int start;
  public int length;
  public Group(int start, int length) {
    this.start = start;
    this.length = length;
  }
}

class SparseTable {
  public SparseTable(int[] nums) {
    n = nums.length;
    st = new int[bitLength(n) + 1][n + 1];
    System.arraycopy(nums, 0, st[0], 0, n);
    for (int i = 1; i <= st.length; ++i)
      for (int j = 0; j + (1 << i) <= n; ++j)
        st[i][j] = Math.max(st[i - 1][j], st[i - 1][j + (1 << (i - 1))]);
  }

  public int query(int l, int r) {
    final int i = bitLength(r - l + 1) - 1;
    return Math.max(st[i][l], st[i][r - (1 << i) + 1]);
  }

  private final int n;
  private final int[][] st; // st[i][j] := max(nums[j..j + 2^i - 1])

  private int bitLength(int n) {
    return Integer.SIZE - Integer.numberOfLeadingZeros(n);
  }
}

class Solution {
  public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
    final int n = s.length();
    final int ones = (int) s.chars().filter(c -> c == '1').count();
    final Pair<List<Group>, int[]> zeroGroupsInfo = getZeroGroups(s);
    final List<Group> zeroGroups = zeroGroupsInfo.getKey();
    final int[] zeroGroupIndex = zeroGroupsInfo.getValue();

    if (zeroGroups.isEmpty())
      return Collections.nCopies(queries.length, ones);
    final SparseTable st = new SparseTable(getZeroMergeLengths(zeroGroups));
    final List<Integer> ans = new ArrayList<>();

    for (int[] query : queries) {
      final int l = query[0];
      final int r = query[1];
      final int left = zeroGroupIndex[l] == -1 ? -1
                                               : (zeroGroups.get(zeroGroupIndex[l]).length -
                                                  (l - zeroGroups.get(zeroGroupIndex[l]).start));
      final int right =
          zeroGroupIndex[r] == -1 ? -1 : (r - zeroGroups.get(zeroGroupIndex[r]).start + 1);
      final Pair<Integer, Integer> adjacentIndices = mapToAdjacentGroupIndices(
          zeroGroupIndex[l] + 1, s.charAt(r) == '1' ? zeroGroupIndex[r] : zeroGroupIndex[r] - 1);
      final int startAdjacentGroupIndex = adjacentIndices.getKey();
      final int endAdjacentGroupIndex = adjacentIndices.getValue();

      int activeSections = ones;
      if (s.charAt(l) == '0' && s.charAt(r) == '0' && zeroGroupIndex[l] + 1 == zeroGroupIndex[r])
        activeSections = Math.max(activeSections, ones + left + right);
      else if (startAdjacentGroupIndex <= endAdjacentGroupIndex)
        activeSections = Math.max(activeSections,
                                  ones + st.query(startAdjacentGroupIndex, endAdjacentGroupIndex));
      if (s.charAt(l) == '0' &&
          zeroGroupIndex[l] + 1 <= (s.charAt(r) == '1' ? zeroGroupIndex[r] : zeroGroupIndex[r] - 1))
        activeSections =
            Math.max(activeSections, ones + left + zeroGroups.get(zeroGroupIndex[l] + 1).length);
      if (s.charAt(r) == '0' && zeroGroupIndex[l] < zeroGroupIndex[r] - 1)
        activeSections =
            Math.max(activeSections, ones + right + zeroGroups.get(zeroGroupIndex[r] - 1).length);
      ans.add(activeSections);
    }

    return ans;
  }

  private Pair<List<Group>, int[]> getZeroGroups(String s) {
    final List<Group> zeroGroups = new ArrayList<>();
    final int[] zeroGroupIndex = new int[s.length()];

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '0') {
        if (i > 0 && s.charAt(i - 1) == '0')
          zeroGroups.get(zeroGroups.size() - 1).length++;
        else
          zeroGroups.add(new Group(i, 1));
      }
      zeroGroupIndex[i] = zeroGroups.size() - 1;
    }

    return new Pair<>(zeroGroups, zeroGroupIndex);
  }

  private int[] getZeroMergeLengths(List<Group> zeroGroups) {
    final int[] zeroMergeLengths = new int[zeroGroups.size() - 1];
    for (int i = 0; i < zeroGroups.size() - 1; ++i)
      zeroMergeLengths[i] = zeroGroups.get(i).length + zeroGroups.get(i + 1).length;
    return zeroMergeLengths;
  }

  private Pair<Integer, Integer> mapToAdjacentGroupIndices(int startGroupIndex, int endGroupIndex) {
    return new Pair<>(startGroupIndex, endGroupIndex - 1);
  }
}