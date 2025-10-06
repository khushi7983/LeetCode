class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        
        int count = 0;
        for(int i = 0; i < n; i++){

            if(!visited[i]) {
                bfs(isConnected, visited , i);
                count++; 
            }
        }
      return count;  
    }
    public void bfs(int[][] isConnected,boolean[] visited, int start){
       
        Queue<Integer> q = new LinkedList<>();
        
        q.add(start);
        visited[start] = true;


        while(!q.isEmpty()){
            int node = q.poll();

            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[node][j] == 1 && !visited[j]) {
                    q.add(j);
                    visited[j] = true;
                }
            }
        }

    }
}