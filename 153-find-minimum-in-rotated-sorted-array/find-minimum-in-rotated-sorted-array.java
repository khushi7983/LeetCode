class Solution {
    public int findMin(int[] arr) {
        int low = 0 ;
        int n = arr.length;
        int high =  n - 1;
        int min = Integer.MAX_VALUE;

        while(low<=high){
            int mid = (low + high)/2;
            if(arr[low]<=arr[mid]){
                min = Math.min(min,arr[low]);
                   low = mid + 1;  
            }
            else{
                  min = Math.min(min,arr[mid]);
                  high = mid - 1;
            }

        }

        return min;
    

    }
}