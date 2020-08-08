package netease;

import java.util.Scanner;

/**
 * 牛客地址：https://www.nowcoder.com/questionTerminal/4fc97c45a69241e992b3e705e817909c?answerType=1&f=discussion
 * 输入 2 7 9 输出 7 9
 * 输入 2 13 18 输出 49 99
 * 思路1：暴力遍历所有结果
 * 思路2：尽量讲小位数赋值为9，让更高位数尽可能小
 * Creat by GG
 * Date on 2020/8/7  11:27 上午
 */
public class MinDigitSum {
    public static void main(String[] args){
        //获取数据
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int curr;
        for (int i = 0; i < len; i++){
            curr = scanner.nextInt();
            if (curr < 10) System.out.println(curr);
            else{
                StringBuilder str = new StringBuilder();
                while(curr-9>0){
                    str.append("9");
                    curr -= 9;
                }
                System.out.println(String.valueOf(curr)+str.toString());
            }
        }

    }
}
