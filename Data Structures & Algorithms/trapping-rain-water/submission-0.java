public class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int left[]= new int[n];
        int right[]= new int[n];
        int total = 0;

        int maxLeft = -1, maxRight = -1;

        for(int i = 1; i<n ; i++){
            maxLeft = Math.max(maxLeft, arr[i-1]);
            left[i] = maxLeft;
        }

        for(int i = n-2; i>=0 ; i--){
            maxRight = Math.max(maxRight, arr[i+1]);
            right[i] = maxRight;
        }

         for(int i = 0; i<n ; i++){
            if(Math.min(left[i], right[i]) - arr[i] > 0)
                total += Math.min(left[i], right[i]) - arr[i];
        }
        
        
        return total;
    }
}