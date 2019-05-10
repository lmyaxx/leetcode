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
}
