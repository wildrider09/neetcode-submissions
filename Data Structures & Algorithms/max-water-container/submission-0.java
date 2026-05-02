class Solution {
    public int maxArea(int[] arr) {

        int l = 0 , r = arr.length - 1;
        int area = 0;

        while (l < r){
            int temp = Math.min(arr[l], arr[r]);
            area = Math.max(area, temp * (r-l));

            if(arr[l] > arr[r])
                r--;
            else 
                l++;
        }
        
        return area;
    }
}
