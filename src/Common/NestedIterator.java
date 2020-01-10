package Common;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

/**
 * @Author : Chad li
 * @Date : 2020/1/7 21:21
 * @Version 1.0
 */
public class NestedIterator implements Iterator<Integer> {

    private Stack<ListIterator<NestedInteger>> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        stack.push(nestedList.listIterator());
    }

    @Override
    public Integer next() {
        hasNext();
        return stack.peek().next().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()){
            if(!stack.peek().hasNext()){
                stack.pop();
            } else {
                NestedInteger item = stack.peek().next();
                if( item.isInteger() ){
                    stack.peek().previous();
                    return true;
                }
                stack.push(item.getList().listIterator());
            }
        }
        return false;
    }

}
