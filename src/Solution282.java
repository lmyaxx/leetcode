import java.util.LinkedList;
import java.util.List;

/**
 * @Author : Chad li
 * @Date : 2020/3/20 14:17
 * @Version 1.0
 */
public class Solution282 {
    public List<String> addOperators(String num, int target) {
        List<String> res = new LinkedList<>();
        if(num==null||num.equals("")){
            return res;
        }
        traverse(res,"",num,target,0,0,0);
        return res;
    }

    private void traverse(List<String> res,String path,String num,int target,int pos, long eval,long multed){
        if(pos==num.length()){
            if(eval==target){
                res.add(path);
            }
            return;
        }
        for(int i=pos;i<num.length();i++){
            if(i!=pos&&num.charAt(pos)=='0') {
                break;
            }
            long cur = Long.valueOf(num.substring(pos,i+1));
            if(pos==0){
                traverse(res,num.substring(pos,i+1),num,target,i+1,cur,cur);
            }else{
                traverse(res,path+"+"+cur,num,target,i+1,eval + cur,cur);
                traverse(res,path+"-"+cur,num,target,i+1,eval-cur,-cur);
                traverse(res,path+"*"+cur,num,target,i+1,eval - multed + multed*cur,multed*cur);
            }

        }

    }
}
