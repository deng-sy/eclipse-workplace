package meituan;

import Stack_Queue.medianSlidingWindow;

import java.util.*;

//С�ź�ϲ����λ�������ڸ���һ�����У����䳤��Ϊ��������ô����λ���ǽ������е�����С���������λ�����м�λ�õ��������䳤��Ϊż������ô����λ���ǽ������е�����С���������λ�����м����������ƽ��ֵ��
//
//���ڸ���һ������Ϊn�����У�С����֪�����г���Ϊ�������������λ��֮��Ϊ����

class DualHeap {
    // ����ѣ�ά����С��һ��Ԫ��
    private PriorityQueue<Integer> small;
    // С���ѣ�ά���ϴ��һ��Ԫ��
    private PriorityQueue<Integer> large;
    // ��ϣ����¼���ӳ�ɾ������Ԫ�أ�key ΪԪ�أ�value Ϊ��Ҫɾ���Ĵ���
    private Map<Integer, Integer> delayed;

    private int k;
    // small �� large ��ǰ������Ԫ�ظ�������Ҫ�۳������ӳ�ɾ������Ԫ��
    private int smallSize, largeSize;

    public DualHeap(int k) {
        this.small = new PriorityQueue<>(Comparator.reverseOrder());
        this.large = new PriorityQueue<>(Comparator.naturalOrder());
        this.delayed = new HashMap<>();
        this.k = k;
        this.smallSize = 0;
        this.largeSize = 0;
    }

    public double getMedian() {
        return (k & 1) == 1 ? small.peek() : ((double) small.peek() + large.peek()) / 2;
    }

    public void insert(int num) {
        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
            ++smallSize;
        } else {
            large.offer(num);
            ++largeSize;
        }
        makeBalance();
    }

    public void erase(int num) {
        delayed.put(num, delayed.getOrDefault(num, 0) + 1);
        if (num <= small.peek()) {
            --smallSize;
            if (num == small.peek()) {
                prune(small);
            }
        } else {
            --largeSize;
            if (num == large.peek()) {
                prune(large);
            }
        }
        makeBalance();
    }

    // ���ϵص��� heap �ĶѶ�Ԫ�أ����Ҹ��¹�ϣ��
    private void prune(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            int num = heap.peek();
            if (delayed.containsKey(num)) {
                delayed.put(num, delayed.get(num) - 1);
                if (delayed.get(num) == 0) {
                    delayed.remove(num);
                }
                heap.poll();
            } else {
                break;
            }
        }
    }

    // ���� small �� large �е�Ԫ�ظ�����ʹ�ö��ߵ�Ԫ�ظ�������Ҫ��
    private void makeBalance() {
        if (smallSize > largeSize + 1) {
            // small �� large Ԫ�ض� 2 ��
            large.offer(small.poll());
            --smallSize;
            ++largeSize;
            // small �Ѷ�Ԫ�ر��Ƴ�����Ҫ���� prune
            prune(small);
        } else if (smallSize < largeSize) {
            // large �� small Ԫ�ض� 1 ��
            small.offer(large.poll());
            ++smallSize;
            --largeSize;
            // large �Ѷ�Ԫ�ر��Ƴ�����Ҫ���� prune
            prune(large);
        }
    }

    public static void main(String[] args) {
        medianSlidingWindow med=new medianSlidingWindow();
        System.out.println(Arrays.toString(med.medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)));
    }
}
public class Medium {
    public double[] medianSlidingWindow(int[] nums, int k) {
        DualHeap dh = new DualHeap(k);
        for (int i = 0; i < k; ++i) {
            dh.insert(nums[i]);
        }
        double[] ans = new double[nums.length - k + 1];
        ans[0] = dh.getMedian();
        for (int i = k; i < nums.length; ++i) {
            dh.insert(nums[i]);
            dh.erase(nums[i - k]);
            ans[i - k + 1] = dh.getMedian();
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            Medium medium=new Medium();
            int n=sc.nextInt();
            int[]nums=new int[n];
            for(int i=0;i<n;i++)
                nums[i]=sc.nextInt();
            int sum=0;
            for(int size=1;size<=n;size+=2){
                double[]med_nums=medium.medianSlidingWindow(nums,size);
                for(double med_num:med_nums)
                    sum+=med_num;
            }
            System.out.println(sum);

        }
    }
}
