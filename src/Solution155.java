import Common.MinStack;
import org.junit.Test;

public class Solution155 {
    @Test
    public void test_MinStack(){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }
}
