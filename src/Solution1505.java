import java.util.LinkedList;
import java.util.Queue;

public class Solution1505 {
    public String minInteger(String num, int k) {
        Queue<Integer>[] pos = new Queue[10];
        for (int i = 0; i < pos.length; i++) {
            pos[i] = new LinkedList<>();
        }
        for(int i=0;i<num.length();i++){
            pos[num.charAt(i)-'0'].offer(i);
        }
        StringBuilder ans = new StringBuilder();
        SegementTree segementTree = new SegementTree(num.length());
        for(int i = 0; i<num.length();i++){
            for(int j=0;j<10;j++){
                if(!pos[j].isEmpty()){
                    int idx = pos[j].peek();
                    int digit =  segementTree.onTheLeftOf(idx);
                    if(idx-digit<=k){
                        k -= idx - digit;
                        ans.append((char)('0'+j));
                        segementTree.add(idx);
                        pos[j].poll();
                        break;
                    }
                }
            }
        }
        return ans.toString();

    }

    class SegementTree {
        int[] nodes;
        int n;
        public SegementTree(int size){
            nodes = new int[1<<((int)(Math.ceil(Math.log(size)/Math.log(2)))+1)];
            n = size;
        }

        public void add(int pos){
            addUtil(0,n-1,pos,0);
        }

        private void addUtil(int left, int right, int pos, int index){
            if(pos<left||pos>right){
                return;
            }
            if(left==right){
                nodes[index] = 1;
                return;
            }
            int mid = (left + right) / 2;
            addUtil(left,mid,pos,2*index+1);
            addUtil(mid+1,right,pos,2*index+2);
            nodes[index] = nodes[2*index+1] + nodes[2*index+2];
        }
        public int onTheLeftOf(int pos){
            return queryUtil(0,n-1,0,pos-1, 0);
        }
        private int queryUtil(int left,int right, int ql,int qr,int index){
            if(ql>right||qr<left){
                return 0;
            }
            if(ql<=left&&qr>=right){
                return nodes[index];
            }
            int  mid = (left+right) / 2;
            return queryUtil(left,mid,ql,qr,index*2+1) + queryUtil(mid+1,right,ql,qr,index*2+2);
        }
    }
}
