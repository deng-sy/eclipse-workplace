package jianzhi;
import java.util.*;
public class findMinDifference {
    public int findMinDifference(List<String> timePoints) {
        List<Integer>minutes=new ArrayList<>();
        for(String str:timePoints){
            String[]strs=str.split(":");
            int minute=Integer.valueOf(strs[0])*60+Integer.valueOf(strs[1]);
            minutes.add(minute);
        }
        Collections.sort(minutes, Comparator.comparingInt(o -> o));
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<minutes.size();i++){
            int gap=minutes.get(i)-minutes.get(i-1);
            ans=Math.min(ans,Math.min(gap,Math.abs(gap-1440)));
        }
        return ans;
    }
}
