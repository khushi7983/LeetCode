class Solution {
    public int splitArray(int[] nums, int k) {
       return findPages(nums,k); 
    }
    public int findPages(int[] arr, int k) {
        
        
        if(k > arr.length) return -1;
        
        int l = Integer.MIN_VALUE;
        int h = 0;
        int ans = -1;
        
        for(int num : arr){
            l =  Math.max(num,l);
            h += num;
        }
        
        while( l <= h){
            int mid = l + (h - l)/2;
            if( Students(arr,mid) <= k) {
                ans = mid;
                h = mid - 1;
            } 
            else{
                l = mid + 1;
            }
        }
        return ans;
        
    }
    public int Students(int[] arr, int pages){
        int student = 1;
        int pageStudent = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(pageStudent + arr[i] > pages){
                student++;
                pageStudent = arr[i];
            }
            else{
                pageStudent += arr[i];
            }
        }
        return student;
    }
}