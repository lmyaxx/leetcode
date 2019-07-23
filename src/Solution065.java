public class Solution065 {
    public boolean isNumber(String s) {
        return s.matches(" *[+\\-]?(([0-9]*\\.?[0-9]+)|([0-9]+\\.?[0-9]*))(e?[+\\-]?[0-9]+(\\.?[0-9]+)?)? *");
    }

    public boolean isNumber1(String s){
        int left=0,right=s.length()-1;
        boolean allowHasE=true,leftEmpty = true;
        while(left<right&&s.charAt(left)==' ') left++;
        if(left<right&&(s.charAt(left)=='+'||s.charAt(left)=='-')) left++;
        while(left<right&&s.charAt(right)==' ') right--;
        if(left==right&&s.charAt(left)=='.') return false;
        while(left<=right&&s.charAt(left)>='0'&&s.charAt(left)<='9') {left++;leftEmpty=false;}
        if(left<=right&&s.charAt(left)=='.') {
            left++;
        }
        while(left<=right&&s.charAt(left)>='0'&&s.charAt(left)<='9') {left++;leftEmpty=false;}
        if(left<right&&s.charAt(left)=='e'){
            if(leftEmpty) return false;
            allowHasE=false;
            left++;
        }
        if(!allowHasE){
            if(left<right&&(s.charAt(left)=='+'||s.charAt(left)=='-')) left++;
            while(left<=right&&s.charAt(left)>='0'&&s.charAt(left)<='9') left++;
        }
        return left>right;
    }

}
