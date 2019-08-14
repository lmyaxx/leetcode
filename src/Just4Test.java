import org.junit.Test;

import javax.jws.Oneway;
import java.lang.reflect.Array;
import java.util.*;

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

    @Test
    public void test_construct_new_Array(){
        List<Integer> li = Arrays.asList(1,2,3);
        String strs[] = new String[10];
        System.out.println(li);
        System.out.println(Arrays.asList(li));
    }

    @Test
    public void test_empty_Stack(){
        Stack<Character> stack = new Stack<>();
        Map<Integer,Integer> map = new TreeMap<>();
        map.put(10,1);
        map.put(1,3);
        map.put(5,5);
        map.put(100,1);
//        Set<Integer> s =map.keySet();
//
//        System.out.println(map.values());
        int []next= Solution028.getNext("ababaca");
        for(int i=0;i<next.length;i++)
            System.out.println(next[i]);
//        char s = stack.;
//        System.out.println(s);
    }

    @Test
    public void test_indexof(){
        int []nums = new int[2];
        System.out.println(nums[0]);
        String s = "foo,foo,abc";
        System.out.println(s.indexOf("fool",1));
        System.out.println(s.substring(0,3));
    }

    @Test
    public void test_compare_object(){
        Map<String,Integer> map1 = new HashMap<>();
        map1.put("1",2);
        map1.put("23",3);
        map1.put("32",32);
        map1.put("-1",-1);
        System.out.println(map1.keySet());
        Map<String,Integer> map2 = new HashMap<>();
        map2.put("23",3);
        map2.put("-1",-1);
        map2.put("32",32);
        map2.put("1",2);
        System.out.println(map2.keySet());
        System.out.println(map1.equals(map2));
        ;
    }
//"barfoothefoobarman"
//["foo","bar"]
    @Test
    public void test_solution030(){
        Solution030 s = new Solution030();
        String wrods[] =  {"word","good","best","good"};
        String ss="wordgoodgoodgoodbestword";
        List<Integer> li = s.findSubstring(ss,wrods);
        System.out.println(li);
    }

    @Test
    public void test_swap(){
        int x=2,y=3,i=2,j=3;
        x=x^y;
        y=x^y;
        x=x^y;
        i^=j^=i^=j;
        System.out.println(x);//3
        System.out.println(y);//2
        System.out.println(i);//0
        System.out.println(j);//2
    }

    @Test
    public void test_Stringbuilder(){
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        System.out.println(sb+"1");
    }

    @Test
    public void test_contain(){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> stack = new ArrayList<>();
        stack.add(1);
        stack.add(2);
        List<Integer> stack1 = new ArrayList<>(stack);
        stack1.add(3);
        result.add(stack);
        System.out.println(result.contains(stack1));
    }

    @Test
    public void test_equal(){

        Solution043 s = new Solution043();
        char [] ss = new char[3];
        System.out.println(ss[0]);
//        System.out.println(s.multiply("123","0"));
    }

    @Test
    public void test_for_outer(){
        outer1:for(int i=0;i<5;i++){
            for(int j=i;j<4;j++){
                System.out.print(j);
                if(j==2){
                    continue outer1;
                }
            }
            System.out.println();
        }
    }

    @Test
    public void test_regex(){
        String s=".0";
//        (e?[+\-]?[0-9]+(\.?[0-9]+)?)?
        System.out.println("6e6.5".matches(" *[+\\-]?(([0-9]*\\.?[0-9]+)|([0-9]+\\.?[0-9]*))(e[+\\-]?[0-9]+) *"));
        System.out.println("6e6.5".matches(" *[+\\-]?(([0-9]*\\.?[0-9]+)|([0-9]+\\.?[0-9]*))(e[+\\-]?[0-9]+)? *"));
    }

    @Test
    public void test_queens(){
        char str[] = {'a','b','\0','f'};
        System.out.println(String.valueOf(str));
//        Solution071 s = new Solution071();
//        s.simplifyPath("/a//bcd////c/d//././/..");
        String strs[] = "/a/bcd/c/d/././..".split("/");
        for(String one:strs){
            System.out.println(one);
        }
        System.out.println(strs.length);
    }

    @Test
    public void test_sulution(){
        int nums[] = {2,5,6,0,0,1,2};
        System.out.print(search(nums,3));
    }

    public boolean search(int[] nums, int target) {
        char [] ones = {'1','2'};
        char [] two = {'1','2'};
        System.out.println(ones.equals(two));
        return true;
    }

    @Test
    public void test_copy_List(){
        List<Integer> two = new ArrayList<>();
        two.add(1);
        List<Integer> one = new ArrayList<Integer>(two);
        System.out.println(one==two);
    }

    @Test
    public void test_Solution127(){
        Solution127 res = new Solution127();
        res.ladderLength("hit","cog",Arrays.asList(new String []{"hot","dot","dog","lot","log","cog"}));
    }
}
