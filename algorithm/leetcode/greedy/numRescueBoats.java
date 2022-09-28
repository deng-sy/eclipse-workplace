package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//第i个人的体重为people[i]，每艘船可以承载的最大重量为l imit。每艘船最多可同时载两人，但条件是这些人的重量之和最多为l imit。
public class numRescueBoats {
    public static List<List<Integer>> numRescueBoats(int[]people, int limit){
        int cnt=0,left=0,right=people.length-1;
        List<List<Integer>>res=new ArrayList<>();

        Arrays.sort(people);
        while(left<=right){
            List<Integer>boat=new ArrayList<>();
            if(people[right]+people[left]<=limit)
                boat.add(people[left++]);
            boat.add(people[right--]);
            res.add(boat);
            cnt++;


        }
        return res;
    }
    public static void main(String[] args) {
        int[]people={3,2,2,1};
        int limit=3;
        System.out.println(numRescueBoats(people,limit));
    }
}
