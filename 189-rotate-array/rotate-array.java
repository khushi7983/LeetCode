class Solution {
         void reverse(int start , int end , int[] nums){
          int temp;
          while(start < end){
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
           }

        }
       public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        reverse(0,n-k-1,nums);
        reverse(n-k ,n-1 , nums);
        reverse(0,n-1,nums);
        
    }
}