package zhousai;
import java.util.*;

public class mergeSimilarItems {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>>ret=new ArrayList<>();
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int[]item:items1){
            int value=item[0],weight=item[1];
            map.put(value,map.getOrDefault(value,0)+weight);
        }
        for(int[]item:items2){
            int value=item[0],weight=item[1];
            map.put(value,map.getOrDefault(value,0)+weight);
        }
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            int value=entry.getKey(),weight=entry.getValue();
            List<Integer>list=new ArrayList<>();
            list.add(value);
            list.add(weight);
            ret.add(new ArrayList<>(list));
        }
        ret.sort(Comparator.comparingInt(o -> o.get(0)));
        return ret;
    }

}
