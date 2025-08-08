class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
         
        int n = bloomDay.length;
        if (n < m * k) return -1;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num : bloomDay){
            max = Math.max(max,num);
            min = Math.min(min,num);
        }

        int ans  = -1;
        int l = min;
        int h = max;
        while(l <= h){
            int mid = l + (h -l)/2;
            if(possibleBloom(bloomDay,mid,m,k)){
                ans =  mid;
                h = mid - 1;

            }
            else {
                 l = mid + 1;
            }
        }

        return ans;

    }
    public boolean possibleBloom(int[] nums, int day , int m, int k){
        int count  = 0;
        int boq = 0;
        for(int i = 0; i <nums.length; i++){
            if(nums[i] <= day){
                count++;
            }
            else{
                boq += (count/k);
                count = 0;
            }
        }
        boq += count/k;
        if(boq >= m){
            return true;
        }
        else return false;
    }
}