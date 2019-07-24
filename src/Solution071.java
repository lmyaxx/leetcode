import java.util.Stack;

public class Solution071 {
    public String simplifyPath(String path) {
        Stack<String> result=new Stack<>();
        String strs[] = path.split("/");
        for(String str:strs){
            if(!str.equals("")&&!str.equals(".")){
                if(str.equals("..")){
                    if(!result.empty())
                        result.pop();
                }else{
                    result.push(str);
                }
            }
        }
        String s = "";
        while(!result.empty())
            s = "/"+result.pop() +s;
        return s.isEmpty() ? "/":s;
    }
}
