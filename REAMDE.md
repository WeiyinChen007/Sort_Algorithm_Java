#十大经典排序算法
###排序算法是《数据结构与算法》中最基本的算法之一。

###排序算法可以分为内部排序和外部排序，内部排序是数据记录在内存中进行排序，而外部排序是因排序的数据很大，一次不能容纳全部的排序记录，在排序过程中需要访问外存。常见的内部排序算法有：插入排序、希尔排序、选择排序、冒泡排序、归并排序、快速排序、堆排序、基数排序等。用一张图概括：

![十大经典排序算法](images/Sort.png "十大经典排序算法")

###**关于时间复杂度**：

####1. 平方阶 (O(n2)) 排序
	各类简单排序：直接插入、直接选择和冒泡排序。
####2. 线性对数阶 (O(nlog2n)) 排序
	快速排序、堆排序和归并排序；
####3. O(n1+§)) 排序，§ 是介于 0 和 1 之间的常数。
    希尔排序
####4. 线性阶 (O(n)) 排序
	基数排序，此外还有桶、箱排序。
	
###**算法列表**

####    1. [冒泡排序](src/com/cwy/sort/BubbleSort.java)
####    2. [选择排序](src/com/cwy/sort/SelectSort.java)
####    3. [插入排序](src/com/cwy/sort/InsertSort.java)
####    4. [希尔排序](src/com/cwy/sort/ShellSort.java)
####    5. [归并排序](src/com/cwy/sort/MergeSort.java)
####    6. [快速排序](src/com/cwy/sort/QuickSort.java)
####    7. [堆排序](src/com/cwy/sort/HeapSort.java)
####    8. [计数排序](src/com/cwy/sort/CountSort.java)
####    9. [桶排序](src/com/cwy/sort/BucketSort.java)
####    10. [基数排序](src/com/cwy/sort/RadixSort.java)

----

本书内容几乎完全来源于网络。

开源项目地址：[https://github.com/WeiyinChen007/Sort_Algorithm_Java](https://github.com/WeiyinChen007/Sort_Algorithm_Java)，整理人 [WeiyinChen007](https://github.com/WeiyinChen007)。