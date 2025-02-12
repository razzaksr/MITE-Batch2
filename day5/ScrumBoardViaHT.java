package day5;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class ScrumBoardViaHT {
    public static void main(String[] args) {
        DLitheBoard dLitheBoard = new DLitheBoard();
        dLitheBoard.mapTask("todo", "coin change");
        dLitheBoard.mapTask("todo", "coin change");
        System.out.println(dLitheBoard.board);
        dLitheBoard.mapTask("progress", "coin change");
        System.out.println(dLitheBoard.board);
        dLitheBoard.mapTask("done", "coin change");
        System.out.println(dLitheBoard.board);
    }
}


class DLitheBoard{
    Map<String, List<String>> board = new Hashtable<>();
    public DLitheBoard(){
        board.put("todo", new ArrayList<>());
        board.put("progress", new ArrayList<>());
        board.put("done", new ArrayList<>());
    }

    public void mapTask(String bucket, String task){
        // if bucket is todo, then creation
        if(board.get(bucket)!=null){
            if(!board.get(bucket).contains(task)){
                List<String> existing = board.get(bucket);
                existing.add(task);
                board.put(bucket, existing);
                if(bucket.equals("progress")){removeTask("todo", task);}
                if(bucket.equals("done")){
                    removeTask("progress", task);
                    removeTask("todo", task);
                }
                System.out.println(task+" has added in the "+bucket);
            }
            else{
                System.out.println(task+" already in the "+bucket);
            }
        }
        else{
            System.out.println("Invalid bucket "+bucket);
        }
    }


    public boolean removeTask(String bucket, String task){
        if(board.get(bucket).contains(task)){
            board.get(bucket).remove(task);
            return true;
        }
        return false;
    }
}