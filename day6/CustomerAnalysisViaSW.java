package day6;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

// Minimum Window Substring

public class CustomerAnalysisViaSW {

    public static List<String> findSubString(List<String> current,List<String> required){
        // intilaize minStart, minLength, left, right
        int minStart = 0;
        int minLength = Integer.MAX_VALUE;

        // hashtable frequency of required
        Map<String, Integer> requiredTable = new Hashtable<>();

        for(int index = 0;index< required.size();index++){
            int count = requiredTable.getOrDefault(required.get(index), 0)+1;
            requiredTable.put(required.get(index), count);
        }

        // hashtable for current activity
        Map<String, Integer> currentTable = new Hashtable<>();

        int left = 0, right,matched = 0;

        for(right=0;right<current.size();right++){
            String pointed = current.get(right);
            currentTable.put(pointed, currentTable.getOrDefault(pointed, 0)+1);

            if(requiredTable.containsKey(pointed)){
                matched++;
            }

            // shrink
            while(matched==requiredTable.size()){
                if(right-left+1<=minLength){
                    minLength = right-left+1;
                    minStart = left;
                }
                String now = current.get(left);
                if(currentTable.containsKey(now)){
                    currentTable.put(now,currentTable.getOrDefault(now,0)-1);
                    if(requiredTable.containsKey(now)){
                        matched--;
                    }
                }
                left++;
            }

        }

        return current.subList(minStart, minStart+minLength);
    }

    public static void main(String[] args) {
        List<String> currentActivity = Stream.of("Browse","Search","Add to kart","Checkout","Feedback").toList();
        List<String> requiredActivity = Stream.of("Search","Checkout").toList();

        List<String> subString = findSubString(currentActivity, requiredActivity);
        System.out.println(subString);

    }
}
