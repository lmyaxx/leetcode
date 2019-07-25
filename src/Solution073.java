public class Solution073 {
    public void setZeroes(int[][] matrix) {
        boolean col=false,row=false;
        for(int i=0;i<matrix[0].length;i++)
            if(matrix[0][i]==0)
                row=true;
        for(int j=0;j<matrix.length;j++)
            if(matrix[j][0]==0)
                col=true;
        for(int j=1;j<matrix.length;j++){
            for(int i=1;i<matrix[0].length;i++){
                if(matrix[j][i]==0)
                    matrix[0][i] = matrix[j][0] = 0;
            }
        }
        for(int i=1;i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                for(int j=1;j<matrix.length;j++)
                    matrix[j][i]=0;
            }
        }

        for(int j=1;j<matrix.length;j++){
            if(matrix[j][0]==0){
                for(int i=1;i<matrix[0].length;i++)
                    matrix[j][i]=0;
            }
        }
        if(row){
            for(int i=0;i<matrix[0].length;i++)
                matrix[0][i]=0;
        }
        if(col){
            for(int j=0;j<matrix.length;j++)
                matrix[j][0]=0;
        }
    }
}
