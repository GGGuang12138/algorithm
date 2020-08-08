package netease;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 牛客地址：https://www.nowcoder.com/discuss/470989?type=0&order=3&pos=7&page=0&channel=-2&source_id=discuss_center_0
 * 字典序介绍： https://www.nowcoder.com/discuss/471086?type=1&order=7&pos=17&page=1&channel=1013&source_id=discuss_center_1
 * Creat by GG
 * Date on 2020/8/8  6:41 下午
 */
public class DictionatryOrder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ansl = in.nextInt();
        int datal = in.nextInt();
        ArrayList<Integer> data = new ArrayList<>();
        for(int i = 0; i < datal; i ++){
            int temp = in.nextInt();
            data.add(temp);
        }

        int[] ans = new int[ansl];
        int count = 0, min = 1;
        // 将原数组移到新数组，移到之前插入小于该位置的数，不能重复
        for (int i = 0; i < datal; i++){
            int curr = data.get(i);
            while(min < curr && (datal-1-i) + count <= ansl){ //子序列数加填充数不能超
                if(!data.contains(min)) {
                    ans[count++] = min;
                }
                min++;
            }
            ans[count++] = curr;
        }
        //原数组移完，没有达到目标长度，继续填充
        while (count < ansl){
            if(!data.contains(min)) {
                ans[count++] = min;
            }
            min ++;
        }
        for (int i = 0; i < ansl; i++){
            System.out.print(ans[i]+ " ");
        }
    }
}
