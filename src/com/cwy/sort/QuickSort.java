package com.cwy.sort;

/**
 * @author: chenweiyin
 * @version: 1.0
 */
public class QuickSort {
    //快速排序
    public static void quickSort(int[] arr) {
        quickSort(arr, true);
    }

    public static void quickSort(int[] arr, boolean ascending) {
        if (ascending) {
            quickSort(arr, 0, arr.length - 1, true);
        } else {
            quickSort(arr, 0, arr.length - 1, false);
        }
    }

    public static void quickSort(int[] arr, int begin, int end, boolean ascending) {
        if (ascending)
            quickSort(arr, begin, end);
        else
            quickSortDescending(arr, begin, end);
    }

    //快排序升序 -- 默认
    public static void quickSort(int[] arr, int begin, int end) {
        if (begin > end) { //结束条件
            return;
        }
        int base = arr[begin];
        int i = begin, j = end;
        while (i < j) { // 两个哨兵（i左边，j右边）没有相遇
            while (arr[j] >= base && i < j) { //哨兵j没找到比base小的
                j--;
            }
            while (arr[i] <= base && i < j) { //哨兵i没找到比base大的
                i++;
            }
            if (i < j) { //如果满足条件则交换
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[begin] = arr[i];
        arr[i] = base;
        quickSort(arr, begin, i - 1); //递归调用左半数组
        quickSort(arr, i + 1, end); //递归调用右半数组

    }

    //快排序降序
    public static void quickSortDescending(int[] arr, int begin, int end) {
        if (begin > end) { //结束条件
            return;
        }
        int base = arr[begin];
        int i = begin, j = end;
        while (i < j) { // 两个哨兵（i左边，j右边）没有相遇
            while (arr[j] <= base && i < j) { //哨兵j没找到比base大的
                j--;
            }
            while (arr[i] >= base && i < j) { //哨兵i没找到比base小的
                i++;
            }
            if (i < j) { //如果满足条件则交换
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[begin] = arr[i];
        arr[i] = base;
        quickSortDescending(arr, begin, i - 1); //递归调用左半数组
        quickSortDescending(arr, i + 1, end); //递归调用右半数组

    }
}
