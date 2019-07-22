public class Solution059 {
    public int[][] generateMatrix(int n) {
        int left=0,top=0,down=n-1,right=n-1,total=n*n,count=1;
        int [][]result = new int[n][n];
        int row=0,col=-1;
        while(count<=total){
            while(count<=total&&++col<=right)
                result[row][col]=count++;
            col--;top++;
            while(count<=total&&++row<=down)
                result[row][col]=count++;
            row--;right--;
            while(count<=total&&--col>=left)
                result[row][col]=count++;
            col++;down--;
            while(count<=total&&--row>=top)
                result[row][col]=count++;
            row++;left++;
        }
        return result;
    }
}
