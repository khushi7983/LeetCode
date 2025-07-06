class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int pSum[][] = new int[n][m];

        for(int j=0; j<m; j++){
            int sum = 0;
            for(int i=0; i<n; i++){
                if (matrix[i][j] == '1') {
                  sum += 1;
                } else {
                 sum = 0;
                }
                pSum[i][j] = sum;
            }
        }
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, histogram(pSum[i]));
        }

        return maxArea;
    }
    private int histogram(int heights[]){
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

         for(int i=0; i<n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if (st.isEmpty()) {
                left.add(-1);  // No smaller element to the left
            } else {
                left.add(st.peek());  // Index of the smaller element
            }

            st.push(i);
          }

          st.clear();

         for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if (st.isEmpty()) {
                right.add(n); 
            } else {
                right.add(st.peek());  
            }

            st.push(i);
          }

          Collections.reverse(right);

          int maxArea = 0; 
          for(int i=0; i<n; i++){
            int width = right.get(i) - left.get(i) - 1;
            int area = width*heights[i];
            maxArea = Math.max(area,maxArea);
          }

        return maxArea;

    }
}