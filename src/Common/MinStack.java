package Common;

public class MinStack {
    private int size;
    private int top;
    private int list[];
    private int min[];

    public MinStack() {
        size=100;
        list = new int[size];
        min = new int[size];
        top=0;
    }


    public void push(int x) {
        if(top==size){
            int temp1[]=new int[size+size/2];
            int temp2[]=new int[size+size/2];
            System.arraycopy(list,0,temp1,0,size);
            System.arraycopy(min,0,temp2,0,size);
            size=size+size/2;
            list=temp1;
            min=temp2;
        }
        list[top]=x;
        if(top==0)
            min[top]=x;
        else
            min[top]=Math.min(min[top-1],x);
        top++;
    }

    public void pop() {
        if(top>=0){
            top--;
        }
    }

    public int top() {
        return list[top-1];
    }

    public int getMin() {
        return min[top-1];
    }
}
