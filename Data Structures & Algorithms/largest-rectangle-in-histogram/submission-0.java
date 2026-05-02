class Solution {
    public int largestRectangleArea(int[] heights) {

        int pse[]= new int[heights.length];
        int nse[]= new int[heights.length];
        int area = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<heights.length; i++){

            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();      
            
            if(stack.isEmpty())
                pse[i] = -1;
            else
                pse[i] = stack.peek();
            
            stack.push(i);
        }

        stack = new Stack<>();
        for(int i=heights.length-1; i>=0; i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();      
            
            if(stack.isEmpty())
                nse[i] = heights.length;
            else
                nse[i] = stack.peek();
            
            stack.push(i);        
        }

        for(int i =0; i<heights.length; i++)
            System.out.print(pse[i] + " ");

        System.out.println();
        for(int i =0; i<heights.length; i++)
            System.out.print(nse[i] + " ");


        for(int i=0; i<heights.length; i++)
            area = Math.max(area, (nse[i]-pse[i]-1)*heights[i]);
        
        return area;
        
    }
}
