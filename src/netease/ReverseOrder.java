package netease;

import java.util.Scanner;

/**
 * 牛客地址：https://www.nowcoder.com/questionTerminal/1f59c93ecec34c8ab5f084d2ce2bd743
 * 计算逆序对个数：https://www.jianshu.com/p/628fe66d6cad
 *
 * 思路1:暴力两层for循环 超时
 * 思路2:利用归并排序可以计算逆序对个数
 * 输入的数组是一个 1 到 n 的排列，这会导致逆序对距离之和等于逆序对元素差（大的减小的）的和。
 * 输入：5
 * 1 3 4 2 5
 * Creat by GG
 * Date on 2020/8/8  11:26 上午
 */
public class ReverseOrder {
    private static long ans = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len  = sc.nextInt();
        int[] data = new int[len];
        for (int i = 0; i < len; i++){
            data[i] = sc.nextInt();
        }
        mergeSort(data,0,len-1);
        System.out.println(ans);
    }
    private static void mergeSort(int[] data, int l, int r){
        if (l >= r) return;
        int mid = l + (r-l)/2;
        mergeSort(data,l,mid);
        mergeSort(data,mid+1,r);
        if (data[mid] > data[mid+1]){
            merge(data,l,mid,r);
        }
    }
    private static void merge(int[] data, int l, int mid, int r){
        int[] temp = new int[r-l+1];
        int i = l, j = mid + 1, k = 0;
        while(i <= mid && j <= r){
            if(data[i] > data[j]){
                int t = i;
                while (t <= mid){
                    ans += (data[t++] - data[j]);
                }
                temp[k++] = data[j++];
            }else{
                temp[k++] =  data[i++];
            }
        }
        while(i <= mid){
            temp[k++] = data[i++];
        }
        while(j <= r){
            temp[k++] = data[j++];
        }
        for (int p = 0; p < temp.length; p++){
            data[l+p] = temp[p];
        }
    }
}
