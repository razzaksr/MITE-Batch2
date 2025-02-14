package day7;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class MergeLinkedList {

    public static LinkedList<Integer> merge(List<List<Integer>> group){
        LinkedList<Integer> finalOne = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(List each:group){
            priorityQueue.addAll(each);
        }

        while(!priorityQueue.isEmpty()){
            finalOne.add(priorityQueue.poll());
        }

        return finalOne;
    }

    public static void main(String[] args) {
        List<List<Integer>> myLinks = Stream.of(
            Arrays.asList(1,5,4),
            Arrays.asList(4,3,1),
            Arrays.asList(6,2)
        ).toList();
        System.out.println(merge(myLinks));
    }
}
