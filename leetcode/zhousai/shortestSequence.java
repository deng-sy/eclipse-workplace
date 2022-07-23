package zhousai;
import java.util.*;
public class shortestSequence {
    public int shortestSequence(int[] rolls, int k) {
        Set<Integer>set=new HashSet<>();
        int ans=0;
        for(int roll:rolls){
            set.add(roll);
            if(set.size()==k){
                set.clear();
                ans++;
            }
        }
        return ans+1;
    }
}
