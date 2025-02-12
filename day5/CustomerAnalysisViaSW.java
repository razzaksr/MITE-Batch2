package day5;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

// Minimum Window Substring

public class CustomerAnalysisViaSW {

    public static void findSubString(List<String> current,List<String> required){
        // intilaize minStart, minLength, left, right
        int minStart = 0;
        int minLength = Integer.MAX_VALUE;

        // hashtable frequency of required
        Map<String, Integer> requiredTable = new Hashtable<>();

        for(int index = 0;index< required.size();index++){
            int count = requiredTable.getOrDefault(required.get(index), 0)+1;
            requiredTable.put(required.get(index), count);
        }

        System.out.println(requiredTable);
    }

    public static void main(String[] args) {
        List<String> currentActivity = Stream.of("Browse","Search","Add to kart","Checkout","Feedback").toList();
        List<String> requiredActivity = Stream.of("Search","Checkout").toList();

        findSubString(currentActivity, requiredActivity);

    }
}
