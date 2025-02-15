package day8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class CheapestFlightViaGraph {
    public static int minCostSrcToDest(int[][] arr, int src, int dest, int between){
        // create table to represent graph
        Map<Integer, List<int[]>> graph = new Hashtable<>();
        for(int[] each:arr){
            graph.computeIfAbsent(each[0], key->new ArrayList<>()).add(new int[]{each[1],each[2]});
            // graph.put(each[0], graph.getOrDefault(each[0], Arrays.asList(each[1],each[2])).addAll(Arrays.asList(each[1],each[2])));
        }
        // PQ to sort by cost
        PriorityQueue<int[]> pQueue = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        pQueue.offer(new int[]{0,src,0});// represent {cost,city,stops}
        Map<Integer, Integer> minCost = new HashMap<>();
        while(!pQueue.isEmpty()){
            int[] polled = pQueue.poll();
            // System.out.println(Arrays.toString(polled));
            int cost = polled[0], city = polled[1], stop = polled[2];
            if(city==dest) return cost;
            if(stop>between)continue;
            if(!graph.containsKey(city))continue;
            for(int[] next:graph.get(city)){
                int nextCity = next[0], price = next[1];
                int newCost = cost + price;

                // If a cheaper way to get to nextCity is found, push to queue
                if (!minCost.containsKey(nextCity) || minCost.get(nextCity) > newCost) {
                    minCost.put(nextCity, newCost);
                    pQueue.offer(new int[]{newCost, nextCity, stop + 1});
                    // System.out.println("Pushing to queue"+ newCost+" "+nextCity+" "+(stop + 1));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] plans = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int restStatation = 1;
        System.out.println(minCostSrcToDest(plans, 0, 3, restStatation));
    }
}
