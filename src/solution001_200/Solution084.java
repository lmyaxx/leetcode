package solution001_200;

import java.util.Stack;

public class Solution084 {
    public int largestRectangleArea(int[] heights) {
        int minIndex=0;
        int result=0;
        for(int i=0,len =heights.length;i<len;i++){
            if(heights[i]<=heights[minIndex]) minIndex=i;
            if(i+1<len&&heights[i]<=heights[i+1]){
                continue;
            }
            for(int j=i,minHeight=heights[j];j>minIndex&&heights[minIndex]<heights[j];j--){
                minHeight = Math.min(minHeight,heights[j]);
                result = Math.max((i-j+1)*minHeight,result);
            }
            result = Math.max((i+1)*heights[minIndex],result);
        }
        return result;
    }

    public int largestRectangleArea1(int[] height) {
        int n = height.length, i = 0, max = 0;

        Stack<Integer> s = new Stack<>();

        while (i < n) {
            // as long as the current bar is shorter than the last one in the stack
            // we keep popping out the stack and calculate the area based on
            // the popped bar
            while (!s.isEmpty() && height[i] < height[s.peek()]) {
                // tricky part is how to handle the index of the left bound
                max = Math.max(max, height[s.pop()] * (i - (s.isEmpty() ? 0 : s.peek() + 1)));
            }
            // put current bar's index to the stack
            s.push(i++);
        }

        // finally pop out any bar left in the stack and calculate the area based on it
        while (!s.isEmpty()) {
            max = Math.max(max, height[s.pop()] * (n - (s.isEmpty() ? 0 : s.peek() + 1)));
        }

        return max;
    }
}
