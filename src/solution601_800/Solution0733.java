package solution601_800;

public class Solution0733 {

    int[] xd = new int[]{1,0,-1, 0};
    int[] yd = new int[]{0,-1,0,1};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        helper(image,sr,sc,newColor, image[sr][sc]);
        return image;
    }

    private void helper(int[][] image, int x, int y, int newColor, int oldColor){
        if(newColor == oldColor){
            return;
        }
        image[x][y] = newColor;
        for(int i=0; i< 4; i++){
            int nx = x + xd[i], ny = y + yd[i];
            if(nx>=0 && nx< image.length && ny >=0 && ny<image[0].length&& image[nx][ny]==oldColor){
                helper(image,nx,ny, newColor, oldColor);
            }
        }
    }
}
