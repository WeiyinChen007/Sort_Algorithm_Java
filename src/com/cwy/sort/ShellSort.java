package com.cwy.sort;

/**
 * @author: chenweiyin
 * @version: 1.0
 */
public class ShellSort {
    public static void shellSort(int[] arr) {
        shellSort(arr,true);
    }

    /**
     * 希尔排序
     * @param arr 传入的数组
     * @param ascending 升序降序标志
     */
    public static void shellSort(int[] arr,boolean ascending) {

        for(int d = arr.length/2;d>0;d/=2){

            for(int i=d;i< arr.length;i++){
                int temp = arr[i];
                int j=0;
                for(j=i-d;j>=0&&(ascending?temp<arr[j]:temp>arr[j]);j-=d){
                    arr[j+d]=arr[j];
                }
                arr[j+d] = temp;
            }
        }
    }
}
