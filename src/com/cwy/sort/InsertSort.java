package com.cwy.sort;

/**
 * @author: chenweiyin
 * @version: 1.0
 */
public class InsertSort {
    //插入排序
    public static void insertSort(int[] arr) {
        insertSort(arr, true);//默认进行升序
    }

    /**
     * 插入排序
     * @param arr 传入的数组
     * @param ascending 升序降序标志
     */
    public static void insertSort(int[] arr, boolean ascending) {

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j=0; //这就是那个合适的位置
            for (j = i - 1; j >= 0 && (ascending ? temp < arr[j] : temp > arr[j]); j--) {
                arr[j + 1] = arr[j];
            }
            //把牌放下，为啥是j+1，
            //是因为上面的循环遍历到不符合情况的时候 j是合适的位置的前面的那个数的位置
            //有点拗口，但是就是这个意思，看图方便理解下
            arr[j + 1] = temp;
        }
    }
}
