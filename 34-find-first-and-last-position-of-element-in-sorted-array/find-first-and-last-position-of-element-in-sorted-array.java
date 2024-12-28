class Solution {
    public int[] searchRange(int[] arr, int target) {

        int[] result = new int[2];
        result[0] = findFirstOccurrence(arr, target);
        result[1] = findLastOccurrence(arr, target);
        return result;
    }
    
    public int findLastOccurrence(int[] arr, int target){
         int n = arr.length;
         int low = 0;
         int high = n -1 ;
         int last = -1;
         while(low<= high){
              int mid = (low + high)/2;

              if(arr[mid] == target){
                last = mid;
                low = mid + 1;
              }else if(arr[mid]< target){
                low = mid + 1;
              }
              else {
                high = mid -1 ;
              }
        }
        return last;
    }

      public int findFirstOccurrence(int[] arr, int target){
         int n = arr.length;
         int low = 0;
         int high = n -1 ;
         int first = -1;
         while(low<= high){
              int mid = (low + high)/2;

              if(arr[mid] == target){
                first = mid;
                high = mid - 1;
              }else if(arr[mid]< target){
                low = mid + 1;
              }
              else {
                high = mid -1 ;
              }
        }
        return first;
    }
}