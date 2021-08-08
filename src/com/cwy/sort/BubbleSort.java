package com.cwy.sort;

/**
 * @author: chenweiyin
 * @version: 1.0
 */
public class BubbleSort {

    /**
     * 冒泡排序
     * 包含两种排序：升序、降序，默认为升序
     * @param arr 传入的数组
     * @param ascending 升序降序标志
     */
    //冒泡排序
    public static void bubbleSort(int[] arr, boolean ascending) {   //ascending标志表示为升序排序还是降序排序
        boolean flag = true; //加一个标志位，记录上一次是否发生了交换，如果是，我们则进行下一轮，如果没有，说明已经冒泡好了
        //控制次数，第几趟排序，只需要n-1趟，有交换时进行，只有flag=false就说明上一次一个元素都没有进行交换
        for (int i = 1; i < arr.length && flag; i++) {

            flag = false; //假定未交换

            for (int j = 0; j < arr.length - i; j++) {

                if (ascending ? arr[j] > arr[j + 1] : arr[j] < arr[j + 1]) { //控制升序还是降序
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
        }
    }

    //冒泡排序 -- 默认不传参升序
    public static void bubbleSort(int[] arr) {
        bubbleSort(arr, true);
    }
}
