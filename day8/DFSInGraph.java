package day8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class DFSInGraph {

    public static void depthFirst(Map<Integer,List<Integer>> graph, int begin, TreeSet<Integer> visted){
        if(visted.contains(begin))
            return;
        visted.add(begin);
        System.out.print(begin+" -> ");
        for(int each:graph.getOrDefault(begin, Collections.emptyList())){
            depthFirst(graph, each, visted);
        }
    }
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new Hashtable<>();
        graph.put(0, Arrays.asList(1,3));
        graph.put(1, Arrays.asList(2,0));
        graph.put(2, Arrays.asList(1,4));
        graph.put(3, Arrays.asList(4,0));
        graph.put(4, Arrays.asList(2,3));
        depthFirst(graph, 0, new TreeSet<>());
        System.out.println("reached");
    }
}
