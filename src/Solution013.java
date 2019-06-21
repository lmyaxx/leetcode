public class Solution013 {
    public int romanToInt(String s) {
        int len = s.length(),result = 0;
        int flag[] = {1,10,100};
        for(int i =len-1;i>=0;i--){
            switch (s.charAt(i)){
                case 'I':
                    result += flag[0];
                    break;
                case 'V':
                    result += 5;
                    flag[0] = -1;
                    break;
                case 'X':
                    result += flag[1];
                    flag[0] = -1;
                    break;
                case 'L':
                    result += 50;
                    flag[1] = -10;
                    break;
                case 'C':
                    result += flag[2];
                    flag[1] = -10;
                    break;
                case 'D':
                    result += 500;
                    flag[2] = -100;
                    break;
                case 'M':
                    result += 1000;
                    flag[2] = -100;
                    break;
            }
        }
        return result;
    }
}
