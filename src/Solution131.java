import java.util.ArrayList;
import java.util.List;

public class Solution131 {
    public List<List<String>> partition(String s) {
        boolean memo[][] = getMemo(s);
        List<List<String>> res = new ArrayList<>();
        dfs(0,s,memo,new ArrayList<>(),res);
        return res;
    }

    private void dfs(int start,String s,boolean memo[][],List<String> out,List<List<String>> res){
        if(start==s.length()){
            res.add(new ArrayList<>(out));
            return;
        }
        for(int i=start,len=s.length();i<len;i++){
            if(memo[start][i]){
                out.add(s.substring(start,i+1));
                dfs(i+1,s,memo,out,res);
                out.remove(out.size()-1);
            }
        }
    }

    private boolean[][] getMemo(String s){
        char str[] = s.toCharArray();
        int size = str.length;
        boolean memo[][] = new boolean[size][size];
        for(int i=size-1;i>=0;i--){
            for(int j=i;j<size;j++){
                if(i==j){
                    memo[i][j]=true;
                    continue;
                }
                if(i==j-1&&str[i]==str[j]){
                    memo[i][j]=true;
                    continue;
                }
                if(str[i]==str[j]&&memo[i+1][j-1])
                    memo[i][j]=true;
            }
        }
        return memo;
    }
}
