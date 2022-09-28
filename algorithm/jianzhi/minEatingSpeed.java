package jianzhi;

import java.util.Arrays;

public class minEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1,high=piles[0];
        for(int pile:piles){
            low=Math.min(pile,low);
            high=Math.max(pile,high);
        }
        return binarySearch(piles,low,high,h);

    }
    private long calculate(int[]piles,int speed){
        long ans=0;
        for(int pile:piles){
            ans+=pile%speed==0?pile/speed:pile/speed+1;
        }
        return ans;
    }
    private int binarySearch(int[]piles,int low,int high,int h){
        while(low<high){
            int mid=(low+high)>>1;
            long time=calculate(piles,mid);
            if(time>h){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        minEatingSpeed minEatingSpeed=new minEatingSpeed();
        int[]piles={3,6,7,11};
        int h=8;
        System.out.println(minEatingSpeed.minEatingSpeed(piles,h));
    }
}
