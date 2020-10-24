package solution801_1000;

public class Solution0925 {
    public boolean isLongPressedName(String name, String typed) {
        int i = name.length()-1, j = typed.length() -1;
        char last = '.';
        while(i>=0&&j>=0){
            if(name.charAt(i)==typed.charAt(j)){
                last = name.charAt(i);
                i--;j--;
            }else if(typed.charAt(j)==last){
                j--;
            }else{
                return false;
            }
        }
        while(j>=0&&typed.charAt(j)==last){
            j--;
        }
        return i == -1 && j == -1;
    }
}
