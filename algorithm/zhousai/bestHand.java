package zhousai;
import java.util.*;
public class bestHand {
    public static String bestHand(int[] ranks, char[] suits) {
        Set<Integer>rank_set=new HashSet<>(),suit_set=new HashSet<>();
        String[]ret={"Flush","Three of a Kind","Pair","High Card"};
        int[]nums=new int[13];
        for(int rank:ranks){
            rank_set.add(rank);
            nums[rank-1]++;
            if(nums[rank-1]==3)
                return ret[1];
        }
        for(int suit:suits){
            suit_set.add(suit);
        }
        int rank_size=rank_set.size();
        int suit_size=suit_set.size();

        if(suit_size==1)
            return ret[0];
        if(rank_size<5)
            return ret[2];
        return ret[3];


    }

    public static void main(String[] args) {
        int[]ranks={4,4,2,4,4};
        String str="daabc";
        char[]suits=str.toCharArray();
        System.out.println(bestHand(ranks,suits));
    }
}
