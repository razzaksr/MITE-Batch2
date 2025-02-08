package day2;

public class DebitsCount {
    public static void main(String[] args) {
        int[] transactions = {1200,300,190,9100,400,120,500,7600,5600,12000};
        int size = transactions.length;
        int debits = 0;
        for(int index = 1;index<size;index++){
            if(transactions[index]<transactions[index-1])
                debits++;
        }
        System.out.println("Count of debits "+debits);
        debits-=3;// 
        if(debits>0){
            transactions[size-1]-=(debits*20);
        }
        System.out.println("Available balance "+transactions[size-1]);
    }
}
