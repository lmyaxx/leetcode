public class Solution011 {
    public int maxArea(int[] height) {
        int leftBorder=1,rightBorder=height.length;
        int area=0;
        while(leftBorder<rightBorder){
            if(height[leftBorder-1]<=height[rightBorder-1]){
                area=Math.max(area,(rightBorder-leftBorder)*Math.min(height[rightBorder-1],height[leftBorder-1]));
                leftBorder++;
            }else{
                area=Math.max(area,(rightBorder-leftBorder)*Math.min(height[rightBorder-1],height[leftBorder-1]));
                rightBorder--;
            }
        }
        return area;
    }
}
