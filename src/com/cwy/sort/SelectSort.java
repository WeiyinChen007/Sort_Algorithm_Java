package com.cwy.sort;

/**
 * @author: chenweiyin
 * @version: 1.0
 */
public class SelectSort {

    /**
     * 直接选择排序
     * 包含两种排序：升序、降序，默认为升序
     * @param arr 传入的数组
     * @param ascending 升序降序标志
     */
    //直接选择排序
    public static void selectSort(int[] arr, boolean ascending) {
        for (int i = 0; i < arr.length; i++) {
            int m = i; //最小值或最小值的下标
            for (int j = i + 1; j < arr.length; j++) {
                if (ascending ? arr[j] < arr[m] : arr[j] > arr[m]) {
                    m = j; //找到待排序的数中最小或最大的那个数，记录下标
                }
            }
            //交换位置
            int temp = arr[i];
            arr[i] = arr[m];
            arr[m] = temp;
        }
    }

    public static void selectSort(int[] arr) {
        selectSort(arr, true);
    }
}
