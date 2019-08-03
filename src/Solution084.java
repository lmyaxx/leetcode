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
}
