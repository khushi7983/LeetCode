class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n  = rooms.size();

        boolean[] visited = new boolean[n];
        
        visited[0] = true;
        bfs(0,rooms,visited);

        for(int i = 0; i < n ; i++){
            if(!visited[i]){
                return false;
            }
        } 
        
        return true;



    }
    public void bfs(int i,List<List<Integer>> rooms,boolean[] visited){

        Queue<Integer> q = new LinkedList<>();
        q.add(i);

        while(!q.isEmpty()){
            int node = q.poll();

            for(int neighbour : rooms.get(node)){
                if(!visited[neighbour]){
                q.add(neighbour);
                visited[neighbour] = true;
                }
            }
        }


    }
}