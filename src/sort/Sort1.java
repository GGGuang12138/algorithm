package sort;

/**
 * Creat by GG
 * Date on 2020/7/29  10:26 上午
 */
public class Sort1 {
    /**
     * 选择排序
     * 不断遍历数组将最小值移到前面
     * 时间复杂度为O（N^2）空间为1
     */
    public int[] selectionSort(int[] data) {
        int min, temp;
        for (int i = 0; i < data.length - 1; i++) {
            min = i;
            for (int j = i; j < data.length; j++) {
                if (data[j] < data[min]) min = j;
            }
            temp = data[min];
            data[min] = data[i];
            data[i] = temp;
        }
        return data;
    }

    /**
     * 插入排序
     * 从前往后逐渐插入数组，要插入到数据从后往前找位置插入
     * 时间复杂度为O（N^2）最好情况为N 空间为1
     */
    public int[] insertSort(int[] data) {
        int temp;
        // 从第二个数开始插入
        for (int i = 1; i < data.length; i++) {
            //保存要插入的值
            temp = data[i];
            //将大于要插入值往后挪
            while (i >= 1 && data[i - 1] > temp) {
                data[i] = data[i - 1];
                i--;
            }
            //插入值放到遇到第一个比它小的位置
            data[i] = temp;
        }
        return data;
    }

    /**
     * 冒泡排序
     * 两两比较，逆序则交换，一轮比较可以确定一位
     * 时间复杂度O（N^2）最好情况为O（N）空间为1
     */
    public int[] bubbleSort(int[] data) {
        int temp, isChange;
        for (int i = 0; i < data.length - 1; i++) {
            isChange = 0;//标志物，一轮比较而没有进行交换，说明排序完成
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    isChange = 1;
                }
            }
            if (isChange == 0) {
                break;
            }
        }
        return data;
    }

    /**
     * 快速排序
     * 取基准pivot，小于放左大于放右，再依次方法递归左右，值到只有一个数
     * 根据主定理，时间复杂度为O（N*logN）
     * 当数组存在部分有序系列时，易导致重复排序，时间复杂度沦为O（logN）
     * 空间为复杂度为O（logN）
     */
    public int[] quickSort(int[] data) {
        int left = 0, right = data.length - 1;
        quickHelper2(data, left, right);
        return data;
    }

    private void quickHelper(int[] data, int left, int right) {
        //终止条件
        if (left >= right) return;
        //当前层,以最小为pivot，先确定小于pivot的数，用counter统计，之后pivot交换到counter到位置
        int pivot = right, counter = left, temp;
        for (int i = left; i < right; i++) {
            if (data[i] < data[pivot]) {
                temp = data[i];
                data[i] = data[counter];
                data[counter] = temp;
                counter++;
            }
        }
        temp = data[counter];
        data[counter] = data[pivot];
        data[pivot] = temp;
        //下一层
        quickHelper(data, left, counter - 1);
        quickHelper(data, counter + 1, right);
    }

    /**
     * 快速排序，以数组第一个元素为基准，和前后两种做比较
     */
    public int[] quickSort3(int[] data, int left, int right) {
        // 终止条件
        if (left >= right) return null;
        // 当前层
        int i = left, j = right, temp;
        int pivot = data[left];
        while (i < j) {
            while (data[j] >= pivot && i < j) {
                j--;
            }
            while (data[i] <= pivot && i < j) {
                i++;
            }
            if (i < j) {
                temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
        data[left] = data[i];
        data[i] = pivot;
        //下一层
        quickSort3(data, left, i-1);
        quickSort3(data, i+1,right);
        return data;

    }

    /**
     * 优化快速排序，不以第一和最好一个为基准，而取中数为基准
     */
    public int[] quickSort2(int[] data) {
        int left = 0, right = data.length - 1;
        quickHelper2(data, left, right);
        return data;
    }
    private void quickHelper2(int[] data, int left, int right) {
        int pivot = data[(left + right) >> 1];
        int i = left, j = right, temp;
        //以pivot为基准，通过ij交换，大于的往右挪，小于往左挪
        while (i <= j) {
            while (data[i] < pivot) {
                i++;
            }
            while (data[j] > pivot) {
                j--;
            }
            if (i <= j) {
                temp = data[i];
                data[i] = data[j];
                data[j] = temp;
                i++;
                j--;
            }
        }
        if (left < j) {
            quickHelper2(data, left, j);
        }
        if (i < right) {
            quickHelper2(data, i, right);
        }
        return;
    }
    /**
     * 归并排序，不断将数组分左右两组，直到一组只剩下一个元素，之后进行合并
     * 同样由主定理得，时间复杂度O（N*logN），空间为1
     * @param data
     * @return
     */
    public int[] mergeSort(int[] data) {
        mergeHelper(data, 0, data.length - 1);
        return data;
    }
    private void mergeHelper(int[] data, int left, int right) {
        if (left >= right) return;
        int mid = (right + left) >> 1;
        mergeHelper(data, left, mid);
        mergeHelper(data, mid + 1, right);
        merge(data, left, mid, right);
    }
    /**
     * 合并
     */
    private void merge(int[] data, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = data[i] <= data[j] ? data[i++] : data[j++];
        }
        while (i <= mid) {
            temp[k++] = data[i++];
        }
        while (j <= right) {
            temp[k++] = data[j++];
        }
        // 添加回原数组
        for (int p = 0; p < temp.length; p++) {
            data[left + p] = temp[p];
        }
    }

    /**
     * 希尔排序，优化版到插入排序
     * 将数组分组进行组内排序，小到往前，大的往后，同时组到个数逐渐缩小，直到组内只有一个元素
     * 时间复杂度为O（ N^1.3）
     * 空间复杂度为O（1）
     * @param data
     * @return
     */
    public int[] shellSort(int[] data){
        //每次分组，组之间元素的增量
        for (int gap = data.length >> 1; gap > 0; gap /= 2){
            //不同组别的组内进行插入排序
            for (int i = gap; i < data.length; i++){
                int j = i;
                int temp = data[j];
                while (j-gap >= 0 && data[j-gap] >= data[j]){
                    data[j] = data[j-gap];
                    j = j - gap;
                }
                data[j] = temp;
            }
        }
        return data;
    }
    /**
     * 堆排序
     * 通过建最大堆，将最大元素往第一位挪，再建身下元素递归最大值，遍历多次
     * 时间复杂度O（N*logN）
     * 空间复杂度为 O（1）
     */
    public int[] heapSort(int[] data){
        for (int i = 0; i < data.length; i++){
            maxHeapify(data,data.length-i);
            int temp = data[0];
            data[0] = data[data.length-1-i];
            data[data.length-1-i] = temp;

        }
        return data;
    }
    private void maxHeapify(int[] data, int size) {
        //要最后一个元素开始建树，从底层建起
        for (int i = size - 1; i >= 0; i--){
            heapify(data,i,size);
        }
    }
    private void heapify(int[] data, int curr, int size) {
        int l = 2 * curr + 1;
        int r = 2 * curr + 2;
        int max = curr,temp;
        if (l < size){
            if (data[l] > data[max]) max = l;
        }
        if (r < size) {
            if (data[r] > data[max]) max = r;
        }
        if (max != curr){
            temp = data[max];
            data[max] = data[curr];
            data[curr] = temp;
            // 递归子树，确保为data[curr]保存为最大值
            heapify(data,max,size);
        }
    }
    public int[] radixSort(int[] data){
        int max = findMax(data,0,data.length-1);
        //外层循环，最大数多少位循环多少次
        for (int i = 1; max / i > 0; i = i * 10){
            int[][] bucket = new int[data.length][10];
            for (int j = 0; j < data.length; j++){
                //依次取目标位上的数字,存入对应的桶
                bucket[j][(data[j] / i) % 10] = data[j];
            }
            //桶内元素放回
            int k = 0;
            for (int j = 0; j < 10; j++){
                for (int l = 0; l < data.length; l++){
                    if (bucket[l][j] != 0) data[k++] = bucket[l][j];
                }
            }
        }
        return data;

    }
    private int findMax(int[] data, int l, int r) {
        if(l == r) return data[l];
        int left = data[l];
        int right = findMax(data,l+1, r);
        return Math.max(left,right);
    }


}
