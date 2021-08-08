package com.cwy.sort;

/**
 * @author: chenweiyin
 * @version: 1.0
 */
public class HeapSort {
    //堆排序
    public static void heapSort(int[] arr) {
        //对传入的数组进行建立堆，这里默认建立大顶堆，进行升序排列
        heapSort(arr, true);
    }

    public static void heapSort(int[] arr, boolean maxheap) {

        //1.构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            sift(arr, i, arr.length , maxheap);
        }

        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {

            //现在的数组第一个就是根结点，最小值所在，进行交换，把它放到最右边
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;

            //重新建立堆
            sift(arr, 0, j , maxheap); //重新对堆进行调整
        }
    }

    //建立堆的方法
    /**
     * 私有方法，只允许被堆排序调用
     * @param arr     要排序数组
     * @param parent  当前的双亲节点
     * @param len     数组长度
     * @param maxheap 是否建立大顶堆
     */
    private static void sift(int[] arr, int parent, int len, boolean maxheap) {

        int value = arr[parent]; //先取出当前元素i

        for (int child = 2 * parent + 1; child < len; child = child * 2 + 1) { //从parent结点的左子结点开始，也就是2*parent+1处开始

            if (child+1 < len && (maxheap ? arr[child] < arr[child + 1] : arr[child] > arr[child + 1])) { //如果左子结点小于右子结点，child指向右子结点
                child++; //右孩子如果比左孩子大，我们就将现在的孩子换到右孩子
            }

            //判断是否符合大顶堆的特性， 如果右孩子大于双亲，自然左孩子也大于双亲，符合
            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换)
            if (maxheap ? value < arr[child] : value > arr[child]) {
                arr[parent]=arr[child];
                parent = child;
            }
            else {//如果不是，说明已经符合我们的要求了。
                break;
            }
        }
        arr[parent] =value; //将value值放到最终的位置

    }
}
