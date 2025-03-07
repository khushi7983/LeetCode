class Solution {
    public int singleNonDuplicate(int[] arr) {
        int n = arr.length;
        int low = 1;
        int high =  n-2 ;
        
        if(n == 1){
            return arr[0];
        }
        if(arr[0]!= arr[1]){
            return arr[0];
        }
        if(arr[n-2]!=arr[n-1]){
            return arr[n-1];
        }
        while(low<=high){

            int mid = (low + high)/2 ;

            if(arr[mid]!= arr[mid+1] && arr[mid-1]!= arr[mid]){
                return arr[mid];
            }

            if((mid%2 == 1 && arr[mid-1] == arr[mid]) || (mid%2 == 0 && arr[mid] == arr[mid + 1])){
                  low = mid + 1 ;
            }
            else {
                high = mid - 1 ;
            }
        }
        return -1;
    }
}