package solution001_200;

public class Solution060 {
    public String getPermutation(int n, int k) {
        char result[] = new char[n];
        int total = 1;
        for(int i=0;i<n;i++){
            result[i] = (char)('1' + i);
            total*=(i+1);
        }
        k=k-1;
        for(int i=0;i<n;i++){
            total=total/(n-i);
            int pos =i+ k/total;
            k = k%total;
            while(pos>i){
                swap(result,pos,pos-1);
                pos--;
            }
        }
        return String.valueOf(result);
    }

    private void swap(char []result,int i,int j){
        result[i]^=result[j];
        result[j]^=result[i];
        result[i]^=result[j];
    }
}
