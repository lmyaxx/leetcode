public class Solution042 {
    public int trap(int[] height) {
        return getWater(height,0,height.length-1);
    }

    public int getWater(int []height,int left,int right){
        if(right-left<=1) return 0;
        int i=left,j=right,low=left,high=right;
        while(left<right-1){
            if(height[left]<height[right]){
                left++;
                if(height[left]>height[i])
                    i=left;
            }else{
                right--;
                if(height[right]>height[j])
                    j=right;
            }
        }
        int area = (j-i-1)*Math.min(height[i],height[j]);
        for(left=i+1;left<j;left++){
            area -= height[left];
        }
        return getWater(height,low,i)+getWater(height,j,high)+area;
    }
}
