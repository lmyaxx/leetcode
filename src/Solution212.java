import Common.TrieNode;

import java.util.ArrayList;
import java.util.List;

public class Solution212 {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(String word:words){
            TrieNode cur = root;
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                if(cur.children[ch-'a']==null){
                    cur.children[ch-'a'] = new TrieNode();
                }
                cur = cur.children[ch-'a'];
            }
            cur.isWord = true;
        }
        List<String> result =new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(sb,i,j,root,result,board);
            }
        }
        return result;
    }
    private void dfs(StringBuilder sb,int i,int j,TrieNode root,List<String> res,char[][]board){
        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]=='#'||root.children[board[i][j]-'a']==null) return;
        sb.append(board[i][j]);
        root = root.children[board[i][j]-'a'];
        board[i][j]='#';
        if(root.isWord){
            res.add(sb.toString());
            root.isWord = false;
        }
        dfs(sb,i+1,j,root,res,board);
        dfs(sb,i-1,j,root,res,board);
        dfs(sb,i,j-1,root,res,board);
        dfs(sb,i,j+1,root,res,board);
        board[i][j] = sb.charAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
    }


}
