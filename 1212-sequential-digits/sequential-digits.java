class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<9; i++){
            int k = i+1;
            int n = i*10 + k;
            if(n>=low && n<=high) list.add(n);
            k++;
            while(n<=high && k<10){
                n = n*10 + k;
                if(n>=low && n<=high) list.add(n);
                k++;
            }
        }
        Collections.sort(list);
        return list;
    }
}