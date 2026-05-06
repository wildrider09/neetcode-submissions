class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<int[]> stack = new Stack<>();
        int n = heights.length;
        int area =0;

        for(int i=0; i<n; i++){
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int temp[] = stack.pop();
                area = Math.max(area, (i - temp[0]) * temp[1]);
                start = temp[0];
            }

            stack.push(new int[]{start, heights[i]});
        }

        while(!stack.isEmpty()){
            int temp[] = stack.pop();
            area = Math.max(area, (n - temp[0]) * temp[1]);
        }

        return area;
        
    }
}
