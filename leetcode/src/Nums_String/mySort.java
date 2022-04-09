package Nums_String;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

//����
public class mySort {

//    ð������:���������ȽϽ���
    public static void bubbleSort(int array[]){
        int length=array.length;
        for(int i=0;i<length-1;i++){
            for(int j=i+1;j<length;j++){
                if(array[i]>array[j])
                    swap(array,i,j);
            }

        }
    }

//    ѡ������ÿ��ѡ����Сֵ�뵱ǰ�Ľ���
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

//    ֱ�Ӳ�������������һ���ŵس��ƣ�ÿ�ΰ������������λ��
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

//    ���ֲ�������������������Ԫ��������ص㣬ֱ�Ӳ���Ļ�����ͨ�����ֲ����ҵ�Ҫ�����λ��
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

//    �������򣺶�ð������ĸĽ���ÿ��ѡ���׼������Ϊ�����֣�С��������ǰŲ��������������Ų
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

//    �鲢����ݹ�ʵ��
    public static void mergeSort1(int array[]){
        int[] tmp=new int[array.length];//Ԥ�ȶ�����ʱ���飬�����ظ����ٿռ�
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




//    �鲢����ǵݹ�ʵ��
    public static void mergeSort2(int[] array){
        int i=1;
        int[] tmp=new int[array.length];
        while(i<array.length){
            for(int j=0;j+1<array.length;j+=2*i){
//                �������ϲ������ĸ��ĸ��ϲ�������
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


//    ������(�󶥶�)
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

//    �����󶥶�
    private static void buildMaxHeap(int[] array,int heapSize){
        for(int i=(heapSize)>>1-1;i>=0;i--){
            maxHeapfy(array,i,heapSize);
        }
    }


//    Ͱ����
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

//    ��������
    public static void radixSort(int[] array){
    int digitCount=19;//��-9��9
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

//    λͼ����--���ں�������ȥ��
    public static int[] bitmapSort(int[] array){
        int []value=getMaxNumbit2(array);
        System.out.println("���ֵ����Сֵ��"+Arrays.toString(value));
        int N=(value[0]-value[1])/64+1;
        System.out.println("N��"+N);
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


//    ϣ������(��С��������)����ֱ�Ӳ�������ĸĽ������ȶ�
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


//    ��������--Ͱ��СΪ1��Ͱ����
//    �������ʽʵ�ֽ���
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
////        System.out.println("����ǰ�� "+Arrays.toString(array));
////        int tmp[]=bitmapSort(array);
////        System.out.print("����� "+Arrays.toString(tmp));
        int[]nums={5,1,1,2,0,0};
        quickSort(nums,0,nums.length);
        System.out.println(Arrays.toString(nums));
    }
}
