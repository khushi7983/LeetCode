class MyStack {

     private Queue<Integer> q1;  // main queue
     private Queue<Integer> q2;  // helper queue


    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();



    }
    
    public void push(int x) {
        while(q1.size() > 0){
            q2.offer(q1.poll());
        }
        q1.offer(x);
        while(q2.size() > 0){
            q1.offer(q2.poll());
        }
    }
    
    public int pop() {
        if(q1.size() == 0) return -1;
        else return q1.poll();
        
    }
    
    public int top() {
        if(q1.size() == 0) return -1;
        else return q1.peek();
        
    }
    
    public boolean empty() {
        return q1.size() == 0;
        
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */