package solution001_200;

public class Solution007 {
    public int reverse(int x) {
        int result=0;
        while(x!=0){
            int rest = x %10;
            int  newResult = result * 10 + rest;
            /*
            加减法越界可逆
            乘除法越界不可逆
            用if((newResult - rest)/10 != result)判断是否越界
            输入参数范围2147483647 到 -2147483648，若逆置该数字后，
            1.其前9位数值*10已经越界，即便还原/10，值已发生改变，判断语句中值不相等
            2.其前9位数值*10未越界，对余数进行加减的过程中越界，则可以还原值，判断语句中值相等，判定为未越界，不符合实际情况。
            而2中，要是前9位数值*10未越界，对余数进行加减的过程中越界，则其数值必须满足214748364X的值，即输入值为X463847412，
            又因为输入值不能越界，故X只能为1，2147483641不可能越界，
            注意因为输入值不能越界的限制导致第二种情况是不能存在的。
            若是以字符串的形式输入10位数，则X的值可能为9导致第二种类型越界，则不能仅用以上语句判断否越界，
            此时除了判定乘除法越界，还需要对加减法越界进行鉴定，即判定进行加减法时数值的正负是否发生变化
             */
            if((newResult - rest)/10 != result)
                return 0;
            x/=10;
            result = newResult;
        }
        return result;
    }
}