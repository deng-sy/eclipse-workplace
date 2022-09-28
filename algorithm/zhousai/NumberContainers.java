package zhousai;
import java.util.*;
class NumberContainers {
    Map<Integer,Integer> idx2num;
    Map<Integer,TreeSet<Integer>>num2idx;

    public NumberContainers() {
        idx2num =new HashMap<>();
        num2idx=new HashMap<>();
    }

    public void change(int index, int number) {
        if(num2idx.get(number)==null){
            num2idx.put(number,new TreeSet<>());
        }
        if(idx2num.get(index)!=null){
            int num=idx2num.get(index);
            TreeSet<Integer>set=num2idx.get(num);
            set.remove(index);
        }
        idx2num.put(index,number);
        TreeSet<Integer>set=num2idx.get(number);
        set.add(index);
    }

    public int find(int number) {
        if(num2idx.get(number)==null||num2idx.get(number).size()==0)
            return -1;
        return num2idx.get(number).first();
    }
}
