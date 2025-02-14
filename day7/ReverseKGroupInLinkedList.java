package day7;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseKGroupInLinkedList {

    public static LinkedList<Integer> reverse(List<Integer> src, int swap){
        LinkedList<Integer> dest = new LinkedList<>();

        for(int index = 0, count=1;index<src.size();index++){
            if(count==swap){
                int currentValue = src.get(index);
                int prevousValue = src.get(index-1);
                src.set(index, prevousValue);
                src.set(index-1, currentValue);
                count-=swap;
            }
            count++;
        }
        dest.addAll(src);
        return dest;
    }

    public static void main(String[] args) {
        List<Integer> head = Stream.of(1,2,3,4,5).collect(Collectors.toList());
        int window = 2;
        System.out.println(reverse(head, window));
    }
}
