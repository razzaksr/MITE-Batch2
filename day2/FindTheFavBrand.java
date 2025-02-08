package day2;
// Binary Search
public class FindTheFavBrand {
    public static int binarySearch(String[] brands, int start, int end, String fav){
        if(start<end){
            int mid = start+(end-start)/2;
            if(brands[mid].compareTo(fav)==0)
                return mid;
            else if(brands[mid].compareTo(fav)<0)
                return binarySearch(brands, mid+1, end, fav);
            else
                return binarySearch(brands, start, mid, fav);
        }
        return -1;
    }
    public static void main(String[] args) {
        String[] mobiles = {"Sony","Vivo","iQoo","mi","realme"};
        System.out.println(binarySearch(mobiles, 0, mobiles.length-1, "mi"));
    }
}
