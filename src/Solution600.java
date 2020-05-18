public class Solution600 {
    //end with zero
    private int[] zero;
    //end with one
    private int[] one;

    public Solution600(){
        int size = 33;
        zero = new int[size];
        one = new int[size];
        zero[0] = 1;
        one[0] = 0;
        for(int i=1;i<size;i++){
            zero[i] = zero[i-1] + one[i-1];
            one[i] = zero[i-1];
        }
    }
    public int findIntegers(int num) {
        String str = Integer.toString(num,2);
        System.out.println(str);
        int len = str.length();
        int res = 0;
        boolean isValid = true;
        for(int i=0;i<len;i++){
            if(str.charAt(i)=='1'){
                System.out.println((len-i-1)+" "+(zero[len-i-1]+one[len-i-1]));
                res += zero[len-i-1]+one[len-i-1];
            }
            if(i>0&&str.charAt(i)=='1'&&str.charAt(i-1)=='1'){
                return res;
            }
        }
        return res+1;
    }
}
