package Common;

import java.util.Iterator;

/**
 * @Author : Chad li
 * @Date : 2020/3/21 8:04
 * @Version 1.0
 */
public class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iter;
    private Integer num;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iter = iterator;
        num = iter.hasNext()?iter.next():null;

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return this.num;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer temp = num;
        num = iter.hasNext()?iter.next():null;
        return temp;
    }

    @Override
    public boolean hasNext() {
        return num!=null;
    }
}
