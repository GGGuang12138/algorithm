package netease;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/546b22232fd14997a10a8d2a7a158cbc
 * 完美序列，求最长完美子序列
 * 双指针/迭代
 * Creat by GG
 * Date on 2020/8/8  6:56 下午
 */
public class PerfectOrder {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        for (int i = 0; i < count; i++){
            int len = sc.nextInt();
            int[] data = new int[len];
            for (int j = 0; j < len; j++){
                data[j] = sc.nextInt();
            }
            System.out.println(helper(data,len));
        }
    }
    public static int helper(int[] data,int len){
        int sum = data[0];
        int count = 1, max = 0;
        for (int i = 1; i < len; i++){
            if(data[i] >= sum){
                count ++;
                sum += data[i];
            }else{
                max = Math.max(count,max);
                count = 1;
                sum = data[i];
            }
        }
        return max;
    }
}
