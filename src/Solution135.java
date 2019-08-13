public class Solution135 {
    public int candy(int[] ratings) {
        if(ratings.length==0) return 0;
        if(ratings.length==1) return 1;
        int sum=0,left,right,i=0;
        while(true){
            boolean two = false;
            left=right=0;
            while(i+1<ratings.length&&ratings[i]<ratings[i+1]) {
                left++;i++;
            }
            if(i+1<ratings.length&&ratings[i]==ratings[i+1]){
                two=true;
                left++;
                right++;
                i++;
            }
            while(i+1<ratings.length&&ratings[i]>ratings[i+1]){
                i++;
                right++;
            }
            if(!two){
                if(left>right) left++;
                else right++;
            }
            sum+=getSum(left)+getSum(right)-1;
            if(i==ratings.length-1)
                break;
        }
        return sum+1;
    }

    private int getSum(int n){
        return n*(n+1)/2;
    }
}
