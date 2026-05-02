class Solution {
    public int[] countBits(int n) {

        int arr[] = new int[n+1];
        int offset = 1;

        for(int i =1; i<=n; i++){
            if(offset*2 == i)
                offset = i;
            arr[i] = 1 + arr[i-offset];
        }

        return arr;
        
    }
}
