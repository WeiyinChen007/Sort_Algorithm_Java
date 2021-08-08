package com.cwy.sort;

/**
 * @author: chenweiyin
 * @version: 1.0
 */
public class MergeSort {
    //归并排序
    public static void mergeSort(int []arr ,boolean ascending){
        int[] temp = new int[arr.length]; //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        mergeSort(arr,0,arr.length-1,temp,ascending);
    }
    public static void mergeSort(int []arr){
        mergeSort(arr,true);
    }

    /**
     * 归并排序
     * @param arr 传入的数组
     * @param left 当前子数组的起始下标
     * @param right 当前子数组的结束下标
     * @param temp 拷贝暂存数组
     */
    public static void mergeSort(int []arr,int left,int right,int[] temp,boolean ascending){
        if(left<right){ //这里是递归结束的条件，我们是对半分，那当left==right的时候肯定大家都是只有一个元素了。

            //对半分，比如总长度是10，left=0，right=9，mid=4确实是中间分了，0~4，5~9
            //当长度9，left=0，right=8，mid=4，0~4，5~8
            int mid = left + (right-left)/2; // 防止越界的写法
            //int mid = (left+right)/2;

            mergeSort(arr,left,mid,temp,ascending); //左边归并排序，使得左子序列有序
            mergeSort(arr,mid+1,right,temp,ascending); //右边归并排序，使得右子序列有序

            merge(arr,left,mid,right,temp,ascending); //将两个有序子数组合并操作
        }
    }

    private static void merge(int[] arr,int left,int mid,int right,int[] temp,boolean ascending){
        int i = left; //左序列起始下标
        int j = mid+1; //右序列起始下标
        int t = 0; //临时数组指针
        while(i<=mid&&j<=right){
            if(ascending?arr[i]<arr[j]:arr[i]>arr[j]){ //比较两个序列第一个元素谁小，谁小先拷贝谁到temp，然后对应子序列下标加1
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }

        while(i<=mid){ //将左边剩余元素填充进temp中——左序列有一些数总是比右边的大的数
            temp[t++] = arr[i++];
        }

        while(j<=right){ //将右序列剩余元素填充进temp中——右序列有一些数总是比左边的大的数
            temp[t++] = arr[j++];
        }

        t = 0;

        //将temp中的元素全部拷贝到原数组中
        while(left<=right){
            arr[left++] = temp[t++];
        }

    }
}
