package solution401_600;

public class Solution0557 {
    public String reverseWords(String s) {
        char[] str = s.toCharArray();
        int start = 0, end = 0;
        for(int i =0; i<str.length;i++){
            if(str[i]==' '){

            }else{
                start = i;
                while(i<str.length && str[i] != ' '){
                    i++;
                }
                end = i - 1;
                reverse(str,start,end);
            }
        }
        return new String(str);
    }

    private void reverse(char[] str, int begin, int end){
        char ch;
        while(begin<end){
            ch = str[begin];
            str[begin] = str[end];
            str[end] = ch;
            begin++;
            end--;
        }
    }
}
