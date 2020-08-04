package solution001_200;

import Graph.Node;

import java.util.*;

public class Solution133 {
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        return clone(node, new HashMap<Node, Node>());
    }
//  dfs
    private Node clone(Node original, Map<Node, Node> clones){
       if(clones.containsKey(original)) return clones.get(original);
       clones.put(original,new Node(original.val,new ArrayList<>()));
       for(Node node:original.neighbors){
           clones.get(original).neighbors.add(clone(node,clones));
       }
       return clones.get(original);
    }

    private Node bfs(Node node){
        if(node==null) return node;
        Map<Node,Node> map = new HashMap<>();
//        map.put(node,new Node(node.val,new ArrayList<>()));
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                Node cur = queue.poll();
                if(!map.containsKey(cur)){
                    map.put(cur,new Node(cur.val,new ArrayList<>()));
                }
                for(Node one: cur.neighbors){
                    if(!map.containsKey(one)){
                        queue.offer(one);
                        map.put(one,new Node(one.val,new ArrayList<>()));
                    }
                    map.get(cur).neighbors.add(map.get(one));
                }
            }
        }
        return map.get(node);
    }
}
