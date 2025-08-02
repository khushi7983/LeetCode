class Solution {
    public List<List<Integer>> generate(int n) {

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<n; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j<=i; j++ ){
                if(j == 0 || j == i) list.add(1);
                else {
                      list.add( ans.get(i-1).get(j) +  ans.get(i-1).get(j-1));
                } 
            }
            ans.add(list);
        }
        

        return ans;

    }
}