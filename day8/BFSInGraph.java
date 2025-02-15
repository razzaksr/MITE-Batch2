package day8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;

public class BFSInGraph {
    public static void bredthFirst(Map<Integer,List<Integer>> graph){
        TreeSet<Integer> traversed = new TreeSet<>();
        Queue<Integer> vertex = new LinkedList<>();

        traversed.add(0);vertex.add(0);

        while(!vertex.isEmpty()){
            int polled = vertex.poll();
            System.out.print(polled+" -> ");
            for(int current:graph.getOrDefault(polled, Collections.emptyList())){
                if(!traversed.contains(current)){
                    traversed.add(current);
                    vertex.offer(current);
                }
            }
        }
        System.out.println("reached");
    }
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new Hashtable<>();
        graph.put(0, Arrays.asList(1,3));
        graph.put(1, Arrays.asList(2,0));
        graph.put(2, Arrays.asList(1,4));
        graph.put(3, Arrays.asList(4,0));
        graph.put(4, Arrays.asList(2,3));
        bredthFirst(graph);
    }
}
