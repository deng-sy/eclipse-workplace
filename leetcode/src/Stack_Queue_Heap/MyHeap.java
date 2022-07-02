package Stack_Queue_Heap;

import java.util.Arrays;
import java.util.Comparator;

//最小堆
public class MyHeap<E> {
    private Object[] data;
    private int size;
    private Comparator<?super E> comparator;

    public MyHeap(int init){
        this(init,null);
    }

    public MyHeap(int init,Comparator<?super E> comparator){
        if(init<1){
            throw new IllegalArgumentException("堆的大小必须大于0");
        }
        this.data=new Object[init];
        this.comparator=comparator;
    }

    public boolean add(E e){
        if(e==null){
            throw new NullPointerException();
        }
        if(size>=data.length){
            data= Arrays.copyOf(data,data.length<<1);
        }
        if(size==0){
            data[0]=e;
        }else{
//            向上调整
            siftUp(e);
        }
        size++;
        return true;
    }

    public int getSize(){
        return size;
    }


//    删除堆顶元素
    public E remove(){
        if(size==0){
            return null;
        }
        size--;
        E result=(E)data[0];
        E x=(E)data[size];
        data[size]=null;
        if(size!=0){
//            向下调整
            siftDown(x);
        }
        return result;
    }

    public E peek(){
        return(size==0)?null:(E)data[0];
    }

    public <T> T[] toArray(T[] a){
        if(a.length<size){
            return (T[])Arrays.copyOf(data,size,a.getClass());
        }
        System.arraycopy(data,0,a,0,size);
        if(a.length>size){
            a[size]=null;
        }
        return a;
    }

//    向上调整，不断与父节点比较
    private void siftUp(E e){
        int s=size;
        while(s>0){
            int parent=(s-1)>>>1;
            Object pData=data[parent];
            if(comparator!=null) {
                if (comparator.compare(e, (E) pData) >= 0) {
                    break;
                }
            }else {
                if (((Comparable<? super E>) e).compareTo((E) pData) >= 0) {
                    break;
                }
            }
            data[s]=pData;
            s=parent;
            }
            data[s]=e;


    }

//    向下调整,不断与两个子节点比较
    private void siftDown(E e){
        int half=size>>>1;
        int index=0;
        while(index<half){
            int min=(index<<1)+1;//左子节点
            Object minChild=data[min];
            int right=min+1;//右子节点
            if(right<size){
                if(comparator!=null){
                    if(comparator.compare((E)minChild,(E)data[right])>0){
                        minChild=data[min=right];
                    }
                }else{
                    if (((Comparable<? super E>) minChild).compareTo((E) data[right]) >0) {
                        minChild=data[min=right];
                    }
                }
            }
            if(comparator!=null){
                if(comparator.compare((E)e,(E)minChild)<=0){
                    break;
                }
            }else{
                if (((Comparable<? super E>) e).compareTo((E) minChild) <= 0) {
                    break;
                }
            }
            data[index]=minChild;
            index=min;

        }
        data[index]=e;

    }

    public static void main(String[] args) {
        int[] nums={10,4,8,3,5,1};
        System.out.print("数组原始值为:");
        System.out.println(Arrays.toString(nums));
        MyHeap myHeap;
        myHeap = new MyHeap(10, (Comparator<Integer>) (o1, o2) -> (o1-o2>0)?1:-1);

        for(int i=0;i<nums.length;i++){
            myHeap.add(nums[i]);
        }

        System.out.print("堆中元素的值：");
        System.out.println(Arrays.toString(myHeap.toArray(new Object[myHeap.getSize()])));
        System.out.print("堆排序后：");
        for(int i=0,length=myHeap.getSize();i<length;i++){
            System.out.print(myHeap.remove()+" ");
        }



    }




}
