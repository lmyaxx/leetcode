package solution201_400;

import Common.MyStack;
import org.junit.Test;

/**
 * @Author : Chad li
 * @Date : 2020/3/13 15:20
 * @Version 1.0
 */
public class Solution225 {

    @Test
    public void test(){
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.pop();
        myStack.empty();
        myStack.top();
    }
}
