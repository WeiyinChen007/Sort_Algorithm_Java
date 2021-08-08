package com.cwy.sort;

/**
 * @author: chenweiyin
 * @version: 1.0
 */
public class CountSort {
    public static void countSort(int[]arr){
        countSort(arr,true);
    }

    public static void countSort(int[]arr,boolean ascending){
        int d,min=arr[0],max=arr[0];

        //找出最大、最小值
        for(int i=0;i< arr.length;i++){
            if(arr[i]<min){
                min =arr[i];
            }
            if(arr[i]>max){
                max = arr[i];
            }
        }

        //建立一个用于计数的数组
        d = min;
        int[] count_map = new int[max-min+1];
        for(int i=0;i< arr.length;i++){
            count_map[arr[i]-d]++;
        }

        int k =0;
        if(ascending){
            for(int i=0;i< arr.length;){
                if(count_map[k]>0){
                    arr[i] = k+d;
                    i++;
                    count_map[k]--;
                }else
                    k++;
            }
        }else {
            for(int i=arr.length-1;i>=0;){
                if(count_map[k]>0){
                    arr[i] = k+d;
                    i--;
                    count_map[k]--;
                }else
                    k++;
            }
        }

    }
}
