package day7;

import java.util.PriorityQueue;

public class MergePOJOLinkedLists {
    public static MyNode mergeAll(MyNode[] arr){
        // head
        MyNode head = new MyNode(0);
        MyNode traverser = head;

        // priorityQueue
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(MyNode each:arr){
            while(each!=null){
                priorityQueue.add(each.data);
                each=each.next;
            }
        }
        // System.out.println(priorityQueue);

        MyNode temp = new MyNode(priorityQueue.poll());
        traverser.next = temp;

        while(!priorityQueue.isEmpty()){
            MyNode one = new MyNode(priorityQueue.poll());
            temp.next = one;
            temp=one;
        }

        return head.next;
    }
    public static void main(String[] args) {
        MyNode node1 = new MyNode(1);
        node1.next = new MyNode(5);
        node1.next.next =new MyNode(4);
        MyNode node2 = new MyNode(4);
        node2.next = new MyNode(3);
        node2.next.next =new MyNode(1);
        MyNode node3 = new MyNode(6);
        node3.next = new MyNode(2);

        // array of MyLinks(linked list)
        MyNode[] group = {node1, node2, node3};
        
        MyNode newOne = mergeAll(group);
        
        while(newOne!=null){
            System.out.print(newOne.data+" -> ");
            newOne=newOne.next;
        }
    }    
}

// pojo
class MyNode{
    int data;
    MyNode next;
    public MyNode(){}
    public MyNode(int value){this.data = value;this.next=null;}
}