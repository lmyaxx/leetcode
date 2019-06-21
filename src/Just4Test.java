import org.junit.Test;

public class Just4Test {
    @Test
    public void test_over_limit(){
        int m = -2147483648;
        int n = m-100;
        int z = m * 10 ;
        if(n+100 == m)
            System.out.println("加减法越界可逆");
        else
            System.out.println("加减法越界不可逆");
        if(z/10 == m)
            System.out.println("乘除法越界可逆");
        else
            System.out.println("乘除法越界不可逆");

    }

    @Test
    public void test_subString(){
        String s = "0123456789";
        System.out.println(s.substring(0,3));
    }

    @Test
    public void oppositeSigns(){
        int i = 0,j=-1334323;
        System.out.println(-1003 % 10);
        //符号是否相反
        System.out.println((i^j) < 0);
        //1534236469
        //乘法越位，符号不一定改变
        int n = 964632435*10 + 1;
        System.out.println(n);
    }
}
