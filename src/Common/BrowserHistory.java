package Common;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistory {

    private List<String> history;

    private int cur;

    private int limit;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        cur = 0;
        limit = 0;
    }

    public void visit(String url) {
        cur ++;
        if(cur>=history.size()){
            history.add(url);
        }else{
            history.set(cur,url);
        }
        limit = cur;
    }

    public String back(int steps) {
        cur = Math.max(0, cur - steps);
        return history.get(cur);
    }

    public String forward(int steps) {
        cur = Math.min(cur +steps,limit);
        return history.get(cur);
    }
}
