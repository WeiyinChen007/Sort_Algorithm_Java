package com.cwy.sort;

/**
 * @author: chenweiyin
 * @version: 1.0
 */
public class RadixSort {
    public static void radixSort(int[] arr){
        radixSort(arr,true);
    }
    public static void radixSort(int[]arr,boolean ascending){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        //求出最大值、最小值
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        if (min<0) {	//如果最小值小于0，那么把每个数都减去最小值，这样可以保证最小的数是0
            for (int i = 0; i < arr.length; i++) {
                arr[i] -= min;
            }
            max -= min; //max也要处理！
        }
        //很巧妙求出最大的数有多少位
        int maxLength = (max+"").length();
        int[][] bucket = new int[10][arr.length]; //一个二维数组，一维代表0到9，二维存放符合数
        int[] bucketElementCount = new int[10]; // 用于记录0到9某位存在数字的个数
        for (int i = 0 ,n = 1 ; i < maxLength ; i++,n*=10) { //个位 十位 百位 这样遍历
            for (int j = 0; j < arr.length ; j++) {
                int value = arr[j]/n % 10;
                bucket[value][bucketElementCount[value]] = arr[j];
                bucketElementCount[value]++;
            }

            //升序
            if(ascending) {
                int index = 0;
                //从左到右，从下到上取出每个数
                for (int j = 0; j < bucketElementCount.length; j++) {
                    if (bucketElementCount[j] != 0) {
                        for (int k = 0; k < bucketElementCount[j]; k++) {
                            arr[index] = bucket[j][k];
                            index++;
                        }
                    }
                    bucketElementCount[j] = 0;
                }
            }else { // 降序
                int index=0;
                //从右到左，从下到上取出每个数
                for (int j = bucketElementCount.length-1; j >=0; j--) {
                    if (bucketElementCount[j] != 0) {
                        for (int k = 0; k <bucketElementCount[j]; k++) {
                            arr[index] = bucket[j][k];
                            index++;
                        }
                    }
                    bucketElementCount[j] = 0;
                }
            }

        }
        if (min<0){
            for (int i = 0; i < arr.length ; i++) {
                arr[i] += min;
            }
        }

    }
}
