package Nums_String;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

//排序
public class mySort {

//    冒泡排序:相邻两两比较交换
    public static void bubbleSort(int array[]){
        int length=array.length;
        for(int i=0;i<length-1;i++){
            for(int j=i+1;j<length;j++){
                if(array[i]>array[j])
                    swap(array,i,j);
            }

        }
    }

//    选择排序：每次选择最小值与当前的交换
    public static void selectSort(int[] array){
        for(int i=0;i<array.length;i++){
            int index=i;
            for(int j=i+1;j<array.length;j++){
                if(array[index]>array[j]){
                    index=j;
                }
            }
            if(i!=index){
                swap(array,i,index);
            }
        }
    }

//    直接插入排序：类似于一张张地抽牌，每次把新数插入合适位置
    public static void insertSort(int[] array){
        for(int i=0;i<array.length;i++){
            int j=i;
            int tmp=array[i];
            for(;j>0;j--){
                if(array[j-1]>tmp){
                    array[j]=array[j-1];
                }else{
                    break;
                }
            }
            array[j]=tmp;
        }
    }

//    二分插入排序：利用了已排序元素有序的特点，直接插入的基础上通过二分查找找到要插入的位置
    public static void halfSort(int array[]){
        for(int i=1;i<array.length;i++){
            if(array[i-1]>array[i]){
                int key=array[i];
                int low=0;
                int high=i-1;
                while(low<=high){
                    int mid=(low+high)>>1;
                    if(array[mid]>key){
                        high=mid-1;
                    }else{
                        low=mid+1;
                    }
                }
                for(int j=i;j>low;j--){
                    array[j]=array[j-1];
                }
                array[low]=key;
            }
        }
    }

//    快速排序：对冒泡排序的改进，每次选择基准并划分为两部分，小于它的往前挪，大于他的往后挪
    public static void quickSort(int array[],int start,int end){
        if(start<end){
            int key=array[start];
            int i=start;
            for(int j=start+1;j<end;j++){
                if(key>array[j]){
                    swap(array,j,++i);
//                    System.out.print(array[i]+" ");
                }
            }
            array[start]=array[i];
            array[i]=key;
            quickSort(array,start,i);
            quickSort(array,i+1,end);
        }

    }

//    归并排序递归实现
    public static void mergeSort1(int array[]){
        int[] tmp=new int[array.length];//预先定义临时数组，避免重复开辟空间
        mergeSortHelper(array,0,array.length-1,tmp);
    }
    public static void mergeSortHelper(int array[],int left,int right,int[] tmp){
        if(left<right){
            int center=(left+right)>>1;
            mergeSortHelper(array,left,center,tmp);
            mergeSortHelper(array,center+1,right,tmp);
            merge(array,left,center,right,tmp);
//            System.out.print(Arrays.toString(array));
        }
    }




//    归并排序非递归实现
    public static void mergeSort2(int[] array){
        int i=1;
        int[] tmp=new int[array.length];
        while(i<array.length){
            for(int j=0;j+1<array.length;j+=2*i){
//                先两两合并，再四个四个合并。。。
                merge(array,j,j+i-1,Math.min(j+2*i-1,array.length-1),tmp);
            }
            i=i<<1;
        }
    }

    public static void merge(int[] data,int left,int center,int right,int[] tmp){
        int tmpindex=left;
        int _left=left;
        int _right=center+1;
        while(_left<=center&&_right<=right){
            if(data[_left]<=data[_right])
                tmp[tmpindex++]=data[_left++];
            else
                tmp[tmpindex++]=data[_right++];
        }
        while(_right<=right)
            tmp[tmpindex++]=data[_right++];
        while(_left<=center)
            tmp[tmpindex++]=data[_left++];
        while(left<=right){
            data[left]=tmp[left++];
        }


    }


//    堆排序(大顶堆)
    public static void heapSort(int []array){
        int length=array.length;
        buildMaxHeap(array,length);
        for(int i=0;i<length;i++){
            swap(array,0,length-i-1);
            maxHeapfy(array,0,length-1-i);
        }
    }

    public static void maxHeapfy(int[] array,int i,int heapSize){
        int left=i*2+1,right=i*2+2;
        int largest=i;
        if(left<heapSize&&array[left]>array[largest]){
            largest=left;
        }
        if(right<heapSize&&array[right]>array[largest]){
            largest=right;
        }
        if(largest!=i){
            swap(array,largest,i);
            maxHeapfy(array,largest,heapSize);
        }
    }

//    构建大顶堆
    private static void buildMaxHeap(int[] array,int heapSize){
        for(int i=(heapSize)>>1-1;i>=0;i--){
            maxHeapfy(array,i,heapSize);
        }
    }


//    桶排序
    public static void bucketSort(int array[],int bucketSize){
        int length=array.length;
        int max=array[0];
        int min=array[0];
        for(int i=0;i<length;i++){
            if(array[i]>max)
                max=array[i];
            else if(array[i]<min)
                min=array[i];
        }
        int bucketCount=(max-min)/bucketSize+1;
        List<List<Integer>> buckets=new ArrayList<>(bucketCount);

        for(int i=0;i<bucketCount;i++)
            buckets.add(new ArrayList<Integer>());
        for(int i=0;i<length;i++)
            buckets.get((array[i]-min)/bucketSize).add(array[i]);
        int currentIndex=0;
        for(int i=0;i<buckets.size();i++){
            Integer[] bucketArray=new Integer[buckets.get(i).size()];
            bucketArray=buckets.get(i).toArray(bucketArray);
            Arrays.sort(bucketArray);
            for(int j=0;j<bucketArray.length;j++)
                array[currentIndex++]=bucketArray[j];
        }

    }

//    基数排序
    public static void radixSort(int[] array){
    int digitCount=19;//从-9到9
    int maxCount=getBitCount(getMaxNumbit(array));
    int radix=1;
    int[][] tmpArray=new int[digitCount][array.length];
    for(int i=0;i<maxCount;i++){
        int cnt[]=new int[digitCount];
        for(int j=0;j<array.length;j++){
            int tmp=((array[j]/radix)%10)+9;
            tmpArray[tmp][cnt[tmp]++]=array[j];
        }

        System.out.println(Arrays.toString(cnt));
        int index=0;
        for(int j=0;j<digitCount;j++){
            if(cnt[j]==0)
                continue;
            for(int k=0;k<cnt[j];k++)
                array[index++]=tmpArray[j][k];
            System.out.println(Arrays.toString(array));
        }
        radix*=10;
    }

//        System.out.println(Arrays.deepToString(tmpArray));

}

    private static int getMaxNumbit(int array[]){
        int max=array[0];
        int min=array[0];
        for(int i=1,length=array.length;i<length;i++){
            if(array[i]>max)
                max=array[i];
            else if(array[i]<min)
                min=array[i];

        }
        return max<-min?-min:max;
    }

    private static int getBitCount(int num){
        int cnt=1;
        int tmp=num/10;
        while(tmp!=0){
            cnt++;
            tmp/=10;
        }
        return cnt;
    }

//    位图排序--用于海量数据去重
    public static int[] bitmapSort(int[] array){
        int []value=getMaxNumbit2(array);
        System.out.println("最大值和最小值："+Arrays.toString(value));
        int N=(value[0]-value[1])/64+1;
        System.out.println("N："+N);
        long[] bitmap=new long[N];
        for(int i=0;i<array.length;i++)
            bitmap[(array[i]-value[1])/64]|=1L<<((array[i]-value[1])%64);
        System.out.println(Arrays.toString(bitmap));
        int k=0;
        int []tmp=new int[array.length];
        for(int i=0;i<N;i++){
            for(int j=0;j<64;j++){
                if((bitmap[i]&(1L<<j))!=0)
                    tmp[k++]=i*64+j+value[1];
            }
        }
        if(k<tmp.length)
            return Arrays.copyOfRange(tmp,0,k);
        return tmp;

    }
    private static int[] getMaxNumbit2(int[] array){
        int max=array[0];
        int min=array[0];
        for(int i=1,length=array.length;i<length;i++){
            if(array[i]>max)
                max=array[i];
            else if(array[i]<min)
                min=array[i];
        }

        return new int[]{max,min};
    }


//    希尔排序(缩小增量排序)，对直接插入排序的改进，不稳定
    public static void shellSort(int []array){
        int length=array.length;
        int step=length>>1;
        while(step>=1){
            for(int i=step;i<length;i++){
                for(int j=i;j>=step;j-=step){
                    if(array[j]<array[j-step])
                        swap(array,j,j-step);
                    else
                        break;
                }
            }
            step>>=1;
        }
    }


//    计数排序--桶大小为1的桶排序
//    采用异或方式实现交换
    public static void swap(int[]array,int i,int j){
        if(i!=j){
            array[i]^=array[j];
            array[j]^=array[i];
            array[i]^=array[j];
        }
    }

    public static void main(String[] args) {
//        int[] array=new int[20];
////        Random random=new Random();
////        for(int i=0;i<array.length;i++)
////            array[i]=random.nextInt(1000)-500;
////        System.out.println("排序前： "+Arrays.toString(array));
////        int tmp[]=bitmapSort(array);
////        System.out.print("排序后： "+Arrays.toString(tmp));
        int[]nums={5,1,1,2,0,0};
        quickSort(nums,0,nums.length);
        System.out.println(Arrays.toString(nums));
    }
}
