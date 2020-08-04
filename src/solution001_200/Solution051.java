package solution001_200;

import java.util.ArrayList;
import java.util.List;

public class Solution051 {
    public List<List<String>> solveNQueens(int n) {
        int rows[] = new int [n];
        char str[] = new char[n];
        for(int i=0;i<n;i++){
            rows[i]=i;
            str[i]='.';
        }
        List<List<String>> result = new ArrayList<>();
        getNQueens(0,rows,n,result,str);
        return result;
    }

    private void getNQueens(int start,int []row,int n,List<List<String>> result,char []str){
        if(start==n){
            List<String> one = new ArrayList<>();
            for(int i=0;i<n;i++){
                str[row[i]] = 'Q';
                one.add(String.valueOf(str));
                str[row[i]] = '.';
            }
            result.add(one);
        }
        for(int i=start;i<n;i++){
            int j =start -1;
            while(j>=0&&!isDiagonal(start,row[i],j,row[j])) j--;
            if(j!=-1) continue;
            swap(row,start,i);
            getNQueens(start+1,row,n,result,str);
            swap(row,start,i);
        }
    }

    private void swap(int []row,int x,int y){
        int temp = row[x];
        row[x] = row[y];
        row[y] = temp;
    }

    private boolean isDiagonal(int x,int y,int m,int n){
        return Math.abs((x-m)*1.0/(y-n))==1;
    }


    public List<List<String>> solveNQueens1(int n) {

        int rows[] = new int [n];
        boolean judge1[] = new boolean [2*n-1];
        boolean judge2[] = new boolean [2*n-1];
        char str[] = new char[n];
        for(int i=0;i<n;i++){
            rows[i]=i;
            str[i]='.';
        }
        List<List<String>> result = new ArrayList<>();
        getQueens(0,n,rows,result,str,judge1,judge2);
        return result;
    }

    private void getQueens(int start,int n,int [] row,List<List<String>> result,char []str,boolean [] judge1,boolean [] judge2){
        if(start==n){
            List<String> one = new ArrayList<>();
            for(int i=0;i<n;i++){
                str[row[i]] = 'Q';
                one.add(String.valueOf(str));
                str[row[i]] = '.';
            }
            result.add(one);
        }
        for(int i=start;i<n;i++){
            int x =start-row[i]+n-1,y=row[i]+start;
            if(judge1[x]||judge2[y])
                continue;
            judge1[x]=judge2[y] =true;
            swap(row,start,i);
            getQueens(start+1,n,row,result,str,judge1,judge2);
            swap(row,start,i);
            judge1[x]=judge2[y] =false;
        }
    }
}
