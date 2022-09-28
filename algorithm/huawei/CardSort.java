package huawei;
import java.util.*;
class Card{
    int type;
    int num;

    public Card(int num, int type) {
        this.type = type;
        this.num = num;
    }
}
class comparator implements Comparator<Card>{
    @Override
    public int compare(Card c1, Card c2) {
        return c1.num!=c2.num?c1.num-c2.num:c1.type-c2.type;
    }
}
public class CardSort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Map<Integer,Set<Integer>>map=new HashMap<>();
        List<Card>bombs=new ArrayList<>();
        List<Card>pairs=new ArrayList<>();
        List<Card>singles=new ArrayList<>();
        Map<Integer,Integer>cnt_map=new HashMap<>();
        for(int i=0;i<n;i++){
            int type=sc.nextInt(),num=sc.nextInt();
            if(!map.containsKey(num)){
                map.put(num,new TreeSet<>());
            }
            map.get(num).add(type);
            cnt_map.put(num,cnt_map.getOrDefault(num,0)+1);
        }
        for(int i=1;i<=13;i++){
            if(map.containsKey(i)){
                int size=map.get(i).size();
                if(size==4)
                    for(Iterator<Integer>it=map.get(i).iterator();it.hasNext();){
                        bombs.add(new Card(i,it.next()));
                    }
                else if(size==2){
                    for(Iterator<Integer>it=map.get(i).iterator();it.hasNext();){
                        pairs.add(new Card(i,it.next()));
                    }
                }else if(size==1){
                    for(Iterator<Integer>it=map.get(i).iterator();it.hasNext();){
                        singles.add(new Card(i,it.next()));
                    }
                }else if(size==3){
                    int j=0;
                    for(Iterator<Integer>it=map.get(i).iterator();it.hasNext();j++){
                        if(j<2)
                            pairs.add(new Card(i,it.next()));
                        else
                            singles.add(new Card(i,it.next()));
                    }
                }
            }
        }
        Collections.sort(bombs,new comparator());
        Collections.sort(pairs,new comparator());
        Collections.sort(singles,new comparator());
        for(int i=0;i<bombs.size();i++){
            Card card=bombs.get(i);
            System.out.println(card.type+" "+card.num);
        }
        for(int i=0;i<pairs.size();i++){
            Card card=pairs.get(i);
            System.out.println(card.type+" "+card.num);
        }
        for(int i=0;i<singles.size();i++){
            Card card=singles.get(i);
            System.out.println(card.type+" "+card.num);
        }

    }
}
