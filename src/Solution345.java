public class Solution345 {
    public String reverseVowels(String s) {
        if(s==null||s.length()==0){
            return s;
        }
        char[] str = s.toCharArray();
        int left = 0, right = str.length-1;
        while(left<right){
            if(!isVowel(str[left])){
                left++;
                continue;
            }
            if(!isVowel(str[right])){
                right--;
                continue;
            }
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }
        return new String(str);
    }

    private boolean isVowel(char ch){
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
            return true;
        }else{
            return false;
        }
    }
}
