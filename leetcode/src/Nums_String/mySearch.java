package Nums_String;

import java.util.Arrays;

public class mySearch {
//    顺序查找
    public static int ordSearch(int[]array ,int key){
        for(int i=0;i<array.length;i++){
            if(array[i]==key)
                return i;
        }
        return -1;
    }

//    二分查找--有序数组
    public static int binaraySearch(int[] array,int value){
        int low=0,high=array.length-1;
        while(low<=high){
            int mid=low+(high-low)>>1;//不用（high+low）/2是为了防止溢出
            if(value==array[mid])
                return mid;
            if(value>array[mid])
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }

//    插值查找--有序数组

    public static int insertSearch(int[] array,int key){
        return search(array,key,0,array.length-1);
    }

    public static int search(int []array,int key,int left,int right){
        while(left<=right){
            if(array[right]==array[left]){
                if(array[right]==key)
                    return right;
                else
                    return -1;
            }
            int mid=left+((key-array[left])/(array[right]-array[left]))*(right-left);
            if(array[mid]==key)
                return mid;
            else if(array[mid]>key)
                right=mid-1;
            else
                left=mid+1;
        }
        return -1;
    }

//    斐波那契查找

    public static int fibonacciSearch(int[] array,int key){
        if(array==null||array.length==0)
            return -1;
        int length=array.length;
        int k=0;
        while(length>fibonacci(k)-1||fibonacci(k)-1<5)
            k++;

        System.out.println(k);
        int[] fb=makeFbArray(fibonacci(k)-1);
//        int[] tmp= Arrays.copyOf(array,fb[k]-1);
        System.out.println(Arrays.toString(fb));

//        for(int i=length;i<tmp.length;i++)
//            tmp[i]=array[length-1];
//        System.out.println(Arrays.toString(tmp));
        int low=0,high=length-1;
        while(low<=high){
            int mid=low+fb[k-1]-1;
            int midValue=array[Math.min(mid,length)];
            if(midValue>key){
                high=mid-1;
                k-=1;
            }else if(midValue<key){
                low=mid+1;
                k-=2;
            }else
                return Math.min(mid,high);
        }
        return -1;
    }

    private static int fibonacci(int n){
        if(n==0||n==1)
            return n;
        return fibonacci(n-1)+fibonacci(n-2);
    }

    private static int[] makeFbArray(int length){
        int[] array=new int[length];
        array[0]=0;
        array[1]=1;
        for(int i=2;i<length;i++){
            array[i]=array[i-1]+array[i-2];
        }
        return array;
    }

//    分块查找--二分查找和顺序查找的改进，只要求索引表有序，对内节点没有排序要求，适合节点动态变化
    public static int blockSearch(int[] index,int[] array,int key,int m){
        int i=blockLocate(index,key);
        if(i<0)
            return -1;
        for(int j=m*i,length=j+m;j<length;j++){
            if(array[j]==key)
                return j;
        }
        return -1;
    }
    private static int blockLocate(int[] index,int key){
        int start=0,end=index.length-1;
        if(key>index[end])
            return -1;
        while(start<=end){
            int mid=start+((end-start)>>1);
            if(index[mid]>=key)
                end=mid-1;
            else
                start=mid+1;
        }
        System.out.println("start为："+start);
        return start;
    }

//    哈希查找--只返回有无，不返回位置
    public static int searchHash(int[] hash,int hashLength,int key){
        int index=key%hashLength;
        while(hash[index]!=0&&hash[index]!=key)
            index=(++index)%hashLength;

        if(hash[index]==0)
            return -1;
        return index;
    }

    public static void insertHash(int[] hash,int data){
        int index=data%hash.length;
        while(hash[index]!=0)
            index=(++index)%hash.length;
        hash[index]=data;
        System.out.println(Arrays.toString(hash));
    }


    public static void main(String[] args) {
//        int []array={1,2,7,8,9,15,26,46};
////        int key=15;
////        System.out.println(fibonacciSearch(array,key));
//        int index[]={22,48,86};
//        int st2[]={22,12,13,8,9,20,33,42,44,38,24,48,60,58,74,49,86,53};
//        for(int i=0;i<100;i++) {
//            System.out.println(blockSearch(index,st2,i,6));
//        }
//        System.out.println("end");

        int []array={2,6,3,7,1,21,36,17};
        int hashLength=30;
        int hash[]=new int[hashLength];
        for(int i=0;i<array.length;i++){
            insertHash(hash,array[i]);
        }
        for(int i=0;i<50;i++){
            int index=searchHash(hash,hashLength,i);
            if(index!=-1)
                System.out.println("数组中有"+i+"这个元素");
        }
    }
}
