package com.cwy.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: chenweiyin
 * @version: 1.0
 */
public class BucketSort {
    public static void bucketSort(int[] arr){
        bucketSort(arr,true);
    }

    public static void bucketSort(int[] arr,boolean ascending){
        if(arr==null||arr.length==0){
            return;
        }
        //计算最大值与最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            max = Math.max(arr[i],max);
            min = Math.min(arr[i],min);
        }

        //计算桶的数量
        int bucketNUm = (max-min)/ arr.length+1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNUm);
        for(int i=0;i<bucketNUm;i++){
            bucketArr.add(new ArrayList<>());
        }

        //将每个元素放入桶中
        for(int i=0;i<arr.length;i++){
            int num = (arr[i]-min)/ (arr.length);
            bucketArr.get(num).add(arr[i]);
        }

        //对每个桶进行排序
        for (int i = 0; i < bucketArr.size(); i++) {
            //用系统的排序，速度肯定没话说
            Collections.sort(bucketArr.get(i));
        }

        //将桶中元素赋值到原序列
        int index;
        if(ascending){
            index=0;
        }else{
            index=arr.length-1;
        }

        for(int i=0;i<bucketArr.size();i++){
            for(int j= 0;j<bucketArr.get(i).size();j++){
                arr[index] = bucketArr.get(i).get(j);
                if(ascending){
                    index++;
                }else{
                    index--;
                }
            }

        }

    }
}
