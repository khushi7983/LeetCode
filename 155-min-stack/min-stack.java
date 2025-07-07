class MinStack {
    
    int arr[];
    int i;
    Stack<Integer> st;
    public MinStack() {
        arr = new int[10000];
        i = 0;
        st = new Stack<>();
        
    }
    
    public void push(int val) {
        arr[i] = val;
        if (st.isEmpty() || val <= st.peek()) {
            st.push(val);
        }
        i++;
    }
    
    public void pop() {
        if(i == 0) return ;
        int topVal = arr[i - 1];
        if (topVal == st.peek()) {
            st.pop();
        }
        i--;
    }
    
    public int top() {
        if(i == 0) return -1;
        return arr[i-1];
    }
    
    public int getMin() {

       if (st.isEmpty()) return -1;
        return st.peek();
  
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 6 3 9 4 5 6 -->             3
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */