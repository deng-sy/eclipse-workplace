package Stack_Queue_Heap;

import java.util.Arrays;
import java.util.Comparator;

//��С��
public class MyHeap<E> {
    private Object[] data;
    private int size;
    private Comparator<?super E> comparator;

    public MyHeap(int init){
        this(init,null);
    }

    public MyHeap(int init,Comparator<?super E> comparator){
        if(init<1){
            throw new IllegalArgumentException("�ѵĴ�С�������0");
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
//            ���ϵ���
            siftUp(e);
        }
        size++;
        return true;
    }

    public int getSize(){
        return size;
    }


//    ɾ���Ѷ�Ԫ��
    public E remove(){
        if(size==0){
            return null;
        }
        size--;
        E result=(E)data[0];
        E x=(E)data[size];
        data[size]=null;
        if(size!=0){
//            ���µ���
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

//    ���ϵ����������븸�ڵ�Ƚ�
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

//    ���µ���,�����������ӽڵ�Ƚ�
    private void siftDown(E e){
        int half=size>>>1;
        int index=0;
        while(index<half){
            int min=(index<<1)+1;//���ӽڵ�
            Object minChild=data[min];
            int right=min+1;//���ӽڵ�
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
        System.out.print("����ԭʼֵΪ:");
        System.out.println(Arrays.toString(nums));
        MyHeap myHeap;
        myHeap = new MyHeap(10, (Comparator<Integer>) (o1, o2) -> (o1-o2>0)?1:-1);

        for(int i=0;i<nums.length;i++){
            myHeap.add(nums[i]);
        }

        System.out.print("����Ԫ�ص�ֵ��");
        System.out.println(Arrays.toString(myHeap.toArray(new Object[myHeap.getSize()])));
        System.out.print("�������");
        for(int i=0,length=myHeap.getSize();i<length;i++){
            System.out.print(myHeap.remove()+" ");
        }



    }




}
