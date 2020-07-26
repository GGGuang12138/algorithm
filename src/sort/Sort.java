package sort;

import java.util.ArrayList;

/**
 * 八大排序
 * Creat by GG
 * Date on 2020/7/23  9:20 下午
 */
public class Sort {

    /**
     * 选择排序
     * 遍历整个数组，每次都把最小值放到最前面
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     * @param data
     * @return int[]
     */
    public int[] selectionSort(int[] data) {
        int min = 0;
        //遍历次数确认每一个位置
        for (int i = 0; i < data.length - 1; i++) {
            min = i;
            for (int j = i; j < data.length; j++) {
                if (data[j] < data[min]) min = j; //将最小一个的下标保存
            }
            int temp = data[min]; //将最小一个和data[i]进行交换
            data[min] = data[i];
            data[i] = temp;
        }
        return data;
    }

    /**
     * 冒泡排序
     * 两两比较，逆序交换，比较完一轮可以确定一位
     * 时间复杂度 O(n^2) 最好情况为O(n)
     * 空间复杂度为O(1)
     * @param data
     * @return int[]
     */
    public int[] bubbleSort(int[] data) {
        //外层循环控制排序的躺数
        for (int i = 0; i < data.length - 1; i++) {
            //当前躺需要比较的次数
            for (int j = 0; j < data.length - 1 - i; j++) {
                // 交换
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        return data;
    }

    /**
     * 冒泡排序优化
     * 每一趟排序，如果没有发生位置的调换，左侧小于右侧，说明已经有序
     * @param data
     * @return int[]
     */
    public int[] bubbleSort2(int[] data) {
        int isChange = 0;
        //外层循环控制排序的趟数
        for (int i = 0; i < data.length - 1; i++) {
            isChange = 0;
            //当前趟需要比较的次数
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    isChange = 1;
                }
            }
            // 一趟比较之后，并没有顺序改变，说明已经排好序了
            if (isChange == 0) break;
        }
        return data;
    }

    /**
     * 插入排序
     * 遍历数组，使之从前往后有序，遍历到的数默认在当前位置，否则从后往前遍历找到合适的位置插入
     * 时间复杂度O(n^2) 最好情况为O(1)
     * 空间复杂度O(1)
     * @param data
     * @return int[]
     */
    public int[] insertionSort(int[] data) {
        int temp;
        for (int i = 1; i < data.length; i++) {
            //循环交换（遇到前面的值比自己大时）
            temp = data[i];
            while (i >= 1 && data[i - 1] > temp) {
                data[i] = data[i - 1];
                i--;
            }
            data[i] = temp;
        }
        return data;
    }

    /**
     * 快速排序 确定标点pivot，小于pivot放在左边，大于放在右边
     * 左右递归直到只有一个元素
     * 由主定理可得时间复杂度为O（N*logN) 最坏情况为O(n^2)
     * 空间复杂度为O(N*logN) 交换时需要临时变量
     * @param data
     * @return
     */
    public int[] quickSort(int[] data) {

        int l = 0, r = data.length - 1;
        quickHelper(data, l, r);
        return data;
    }

    /**
     * 快速排序的递归函数
     * 取r为标点，counter记录小于标点的个数，确定标点放在哪个位置
     * @param data
     * @param l
     * @param r
     */
    public void quickHelper(int[] data, int l, int r) {
        if (r <= l) return;
        int pivot = r, counter = l; //pivot标点位置，counter小于标点的元素个数，决定标点位置
        for (int i = l; i < r; i++) {
            if (data[i] < data[pivot]) {
                int temp = data[counter];
                data[counter] = data[i];
                data[i] = temp;
                counter++;
            }
        }
        int temp = data[pivot];
        data[pivot] = data[counter];
        data[counter] = temp;

        quickHelper(data, l, counter - 1);
        quickHelper(data, counter + 1, r);

    }

    /**
     * 快速排序，支点不是特明确版
     * @param arr
     * @param L
     * @param R
     * @return int[]
     */
    public int[] quickSort2(int[] arr, int L, int R) {
        int i = L;
        int j = R;
        int pivot = arr[(L + R) / 2];
        while (i <= j) {
            //寻找直到比支点大的数
            while (pivot > arr[i])
                i++;
            //寻找直到比支点小的数
            while (pivot < arr[j])
                j--;
            //此时已经分别找到了比支点小的数(右边)、比支点大的数(左边)，它们进行交换
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        //上一个while，保证了L～j的值小于i～R的值
        if (L < j)
            quickSort2(arr, L, j);

        if (i < R)
            quickSort2(arr, i, R);

        return arr;
    }

    /**
     * 快速排序，以第一个为支点点进行划分
     * 参考博客：https://blog.csdn.net/shujuelin/article/details/82423852
     *
     * @param data
     * @param l
     * @param r
     * @return int[]
     */
    public int[] quickSort3(int[] data, int l, int r) {
        if (l > r) return null;
        int i = l, j = r;
        int pivot = data[l];
        while (i < j) {
            //j-- 在先保证，data[i] < pivot
            while (pivot <= data[j] && i < j) {
                j--;
            }
            while (pivot >= data[i] && i < j) {
                i++;
            }
            if (i < j) {
                int temp = data[j];
                data[j] = data[i];
                data[i] = temp;
            }
        }
        //pivot 与 data[i] 交换
        data[l] = data[i];
        data[i] = pivot;
        //递归左右
        quickSort3(data, l, i - 1);
        quickSort3(data, i + 1, r);
        return data;
    }

    /**
     * 归并排序，分治思想，将数组递归分解至只有一个元素，再merge数组
     * 时间复杂度为O（N*logN）最好最坏均同
     * 空间复杂度为O（1）
     * @param data
     * @return int[]
     */
    public int[] mergeSort(int[] data) {
        mergeHelper(data, 0, data.length - 1);
        return data;
    }

    /**
     * 归并排序 分治
     * @param data
     * @param l
     * @param r
     */
    private void mergeHelper(int[] data, int l, int r) {
        if (r <= l) return;
        int mid = (l + r) >> 1;
        mergeHelper(data, l, mid);
        mergeHelper(data, mid + 1, r);
        merge(data, l, mid, r);
    }

    /**
     * 归并排序 合并
     * @param data
     * @param l
     * @param mid
     * @param r
     */
    private void merge(int[] data, int l, int mid, int r) {
        int[] temp = new int[r-l+1];
        int i = l, j = mid+1, k=0;
        //遍历左右，放入较小着
        while(i<=mid && j<=r) {
            temp[k++] = data[i] <= data[j] ? data[i++] : data[j++];
        }
        while (i <= mid) temp[k++] = data[i++];
        while (j <= r) temp[k++] = data[j++];
        //添加回原数组
        for (int p=0; p<temp.length; p++){
            data[l+p] = temp[p];
        }
    }

    /**
     * 堆排序
     * 将数据看成完全二叉树，根据完全二叉树最大堆的特性（第一个元素为树堆最大值）
     * 本质就是建堆、交换最大值、建堆、交换最大值、、、
     * 时间复杂度O（N*logN）
     * 空间复杂度 O（1）
     * @param data
     * @return data
     */
    public int[] heapSort(int[] data){
        for (int i=0; i<data.length; i++){
            // 建堆
            maxHeapify(data,data.length-i);
            // 交换
            int temp = data[0];
            data[0] = data[data.length-1-i];
            data[data.length-1-i] = temp;
        }
        return data;
    }

    /**
     * 建堆，从数组最后往前建
     */
    private void maxHeapify(int[] data, int size) {
        for (int i=size-1; i>=0; i--){
            heapify(data,i,size);
        }
    }

    /**
     * 建堆，通过元素交换确保根的位置的值大于子
     */
    private void heapify(int[] data, int curr, int size) {
        int l = 2 * curr + 1;
        int r = 2 * curr + 2;
        int max = curr;
        if (l < size){
            if (data[max] < data[l]) max = l;
        }
        if (r < size){
            if (data[max] < data[r]) max = r;
        }
        if (max != curr){
            int temp = data[max];
            data[max] = data[curr];
            data[curr] = temp;
            heapify(data, max, size);
        }
    }

    /**
     * 希尔排序
     * 进阶版的插入排序，通过分组、组内进行插入排序，尽可能把大数往后娜
     * 分组间隔逐渐缩小直到1个元素一组，即为插入排序
     * 时间复杂度 O(n^1.3)
     * 空间复杂度O（1）
     * @param data
     * @return
     */
    public int[] shellSort(int[] data){
        //  希尔增量一般为gap = length/2
        for (int gap=data.length>>1; gap>0; gap/=2){
            //从/2那一组开始插入排序
            for (int i=gap; i<data.length; i++){
                int j = i;
                int temp = data[j];
                //相差gap为同一组
                while (j-gap >= 0 && data[j-gap]>temp){
                    data[j] = data[j-gap];
                    j = j-gap;
                }
                data[j] = temp;
            }
        }
        return data;
    }

    /**
     * 基数排序
     * 新建数组0-9的数组，利用位数分多次进行比较，利用数组（桶）对同一位数内的数进行排序
     * 时间复杂度为O（n）或 最大值的位数*（桶+n）
     * 空间复杂度同
     * 基数排序 = 基数+桶排序(需要桶内排序) = 基数+函数映射+计数排序（数组够大，包括全部数）
     * @param data
     * @return
     */
    public int[] radixSort(int[] data){
        //计算最大值
        int max = findMax(data,0,data.length-1);
        //根据最大值的位数进行循环，必须从每个数到个位数开始
        for (int i=1; max/i > 0; i = i*10){
            int[][] bucket = new int[data.length][10];
            //将数放假桶里
            for(int j=0; j<data.length; j++){
                bucket[j][(data[j]/i)%10] = data[j];
            }
            //从桶取出
            int k = 0;
            for (int j=0; j<10; j++){
                for (int l=0; l < data.length; l++){
                    if (bucket[l][j] != 0) data[k++] = bucket[l][j];
                }
            }
        }
        return data;
    }

    /**
     * 递归找最大值
     */
    private int findMax(int[] data, int l, int r) {
        if (l==r) return data[l];
        int a = data[l];
        int b = findMax(data,l+1,r);
        return Math.max(a, b);
    }
}
