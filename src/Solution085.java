public class Solution085 {
    public int maximalRectangle(char[][] matrix) {
         if(matrix==null||matrix.length==0) return 0;
         int result=0,cols=matrix[0].length,rows=matrix.length;
         int [] heights =new int[cols];
         for(int i=0;i<rows;i++){
             for(int j=0;j<cols;j++){
                 if(matrix[i][j]=='0')
                     heights[j]=0;
                 else
                     heights[j]++;
             }
             result = Math.max(result,getMaxRectangle(heights));
         }
         return result;
    }

    private int getMaxRectangle(int [] heights){
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
