package zhousai;

import java.util.Arrays;

public class duplicateZeros {
    public static void duplicateZeros(int[] arr) {
        int n=arr.length;
        int i=0;
        while(i<n){
            if(arr[i]!=0){
                i++;
                continue;
            }
            int len=0;
            while(i+len<n&&arr[i+len]==0){
                len++;
            }
            i+=len;
            int j=n-1;
            while(j>=i+len){
                arr[j]=arr[j-len];
                j--;
            }
            while(i<n&&len-->0){
                arr[i++]=0;
            }
        }
    }

    public static void main(String[] args) {
        int[]arr={1,0,2,3,0,4,5};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}
